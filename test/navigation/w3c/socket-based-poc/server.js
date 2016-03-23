/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2016, PCA Peugeot Citroen
*
* \file main.cpp
*
* \brief This file is part of the Navigation Web API proof of concept.
*
* \author Philippe Colliot <philippe.colliot@mpsa.com>
*
* \version 0.1
*
* This Source Code Form is subject to the terms of the
* Mozilla Public License (MPL), v. 2.0.
* If a copy of the MPL was not distributed with this file,
* You can obtain one at http://mozilla.org/MPL/2.0/.
*
* For further information see http://www.genivi.org/.
*
* List of changes:
* <date>, <name>, <description of change>
*
* @licence end@
*/
// Requirement of external JS files
var resource = require('./js/resource.js');

// Requirements of nodejs modules
var http = require('http');
var url = require('url');
var fs = require('fs');
var path = require('path');
var webidl2 = require('webidl2');
var escodegen = require('escodegen');
var events = require('events');

// Parse the web idl files
var file = fs.readFileSync("./NavigationCoreConfiguration.widl");
var tree = webidl2.parse(file.toString());
//console.log(tree);
//console.log(escodegen.generate(tree));

// Requirements of LBS add-on modules
var navigationCoreConfigurationWrapper = require(resource.generatedNodejsModulePath+'/NavigationCoreConfigurationWrapper');
var positioningEnhancedPositionWrapper = require(resource.generatedNodejsModulePath+'/PositioningEnhancedPositionWrapper');

// Create instances
var i_navigationCoreConfigurationWrapper = new navigationCoreConfigurationWrapper.NavigationCoreConfigurationWrapper();
var i_positioningEnhancedPositionWrapper = new positioningEnhancedPositionWrapper.PositioningEnhancedPositionWrapper();

// Create and init server
var port = 8080;
var hostname = '127.0.0.1';
var server = http.createServer(function(req, res) {
	var page = url.parse(req.url).pathname;
	var full_path = path.join(process.cwd(),page);
	// Check if page exists (for the moment only index.html)
	fs.exists(full_path,function(exists){
        if(!exists){
            res.writeHeader(404, {"Content-Type": "text/plain"}); 
            res.write("404 Not Found\n"); 
            res.end();
        }
        else{
			fs.readFile(full_path, "binary", function(err, file) { 
				 if(err) { 
				     res.writeHeader(500, {"Content-Type": "text/plain"}); 
				     res.write(err + "\n"); 
				     res.end(); 
				
				 } 
				 else{
				    res.writeHeader(200); 
				    res.write(file, "binary"); 
				    res.end();
				}
			});
		}
	});
});

// Launch server
server.listen(port); 

// Load socket.io and connect it to the server
var io = require('socket.io').listen(server);

// Connect signal gateways
var socket_navigationcore = io.of('/navigationcore');
function configurationChanged(changedSettings) {
    console.log('configurationChanged: ' + changedSettings);
    socket_navigationcore.emit('navigationcore_signal', {signal: 'configurationChanged', data: changedSettings});
}
var data = i_navigationCoreConfigurationWrapper.setConfigurationChangedListener(configurationChanged);

// For the time being, signal are not caught, so use timer
setInterval(function(){
    socket_navigationcore.emit('navigationcore_signal', {signal: 'configurationChanged', data: 42});
}, 1000);

// On connection
socket_navigationcore.on('connection', function (client) {
    console.log('Client connected');
    client.on('navigationcore_request', function (message) {
        switch(message.interface) {
        case "NavigationCoreConfiguration":
            console.log('Message received: Interface-->' + message.interface +' Method-->', message.method +' Parameters-->' + message.parameters);
            if (message.method in i_navigationCoreConfigurationWrapper && typeof i_navigationCoreConfigurationWrapper[message.method] === "function") {
                var data = i_navigationCoreConfigurationWrapper[message.method](message.parameters);
                if(data) {
                    client.emit('navigationcore_answer', {request: message.method, answer: data});
                }
            }
            else {
                console.log("Could not find " + message.method + " function");
                client.emit('feedback', "Could not find " + message.method + " function");
            }
            break;
        default:
            console.log("Could not find " + message.interface);
            client.emit('feedback', "Could not find " + message.interface);
        }
    });
});

// Log info
console.log('Server listening at: %s', server.address().port);

