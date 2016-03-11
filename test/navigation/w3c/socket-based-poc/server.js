// Requirement of external JS files
var resource = require('./js/resource.js');

// Requirements of nodejs modules
var http = require('http');
var url = require('url');
var fs = require('fs');
var path = require('path');
var webidl2 = require('webidl2');
var escodegen = require('escodegen');

// Parse the web idl files
var file = fs.readFileSync("./NavigationCoreConfiguration.widl");
var tree = webidl2.parse(file.toString());
//console.log(tree);
//console.log(escodegen.generate(tree));

// Requirements of LBS add-on modules
var navigationCoreConfigurationWrapper = require(resource.generatedNodejsModulePath+'/NavigationCoreConfigurationWrapper');

// Create instances
var i_navigationCoreConfiguration = new navigationCoreConfigurationWrapper.NavigationCoreConfigurationWrapper();

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

// Load socket.io 
var io = require('socket.io').listen(server);

// On connection
io.sockets.on('connection', function (socket) {
console.log('Client connected');

socket.on('navigationcore_request', function (message) {
	if (message.method in i_navigationCoreConfiguration && typeof i_navigationCoreConfiguration[message.method] === "function") {
		console.log('Message received: Interface-->' + message.interface +' Method-->', message.method +' Parameters-->' + message.parameters);
		var data = i_navigationCoreConfiguration[message.method](message.parameters);
		if(data) {	
			socket.emit('navigationcore_answer', {request: message.method, answer: data}); 
		}
	}
	else {
		console.log("Could not find " + message.method + " function");
		socket.emit('feedback', "Could not find " + message.method + " function");
	}
}); 
});

// Log info
console.log('Server listening at: %s', server.address().port);
