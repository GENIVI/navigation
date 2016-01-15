/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2015, PCA Peugeot Citroen
*
* \file main.cpp
*
* \brief This file is part of the poi proof of concept.
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
#include <stdbool.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <sys/types.h>
#include <iostream>
#include <fstream>
#include <cmath>
#include <thread>
#include <typeinfo>
#include <glib.h>

#include <CommonAPI/CommonAPI.hpp> //Defined in the Common API Runtime library
#include "configuration-server-plugin-stub.h"

int main(int  argc , char**  argv )
{
    // Set the global C and C++ locale to the user-configured locale,
    // so we can use std::cout with UTF-8, via Glib::ustring, without exceptions.
    std::locale::global(std::locale(""));

    // Common API data init
    std::shared_ptr < CommonAPI::Runtime > runtime = CommonAPI::Runtime::get();

    const std::string &domain = "local";
    const std::string &instance = "Configuration";

    std::string connection = "Configuration";

    std::shared_ptr<NavigationCoreConfigurationServerStub> myServiceConfiguration = std::make_shared<NavigationCoreConfigurationServerStub>();

    bool successfullyRegistered = runtime->registerService(domain, instance, myServiceConfiguration, connection);
    while (!successfullyRegistered) {
        std::this_thread::sleep_for(std::chrono::milliseconds(100));
        successfullyRegistered = runtime->registerService(domain, instance, myServiceConfiguration, connection);
    }

    GMainLoop * mainloop ;

    // Create a new GMainLoop with default context and initial state of "not running "
    mainloop = g_main_loop_new (g_main_context_default() , FALSE );

    // Send a feedback to the user
    cout << "configuration server started" << endl;

    g_main_loop_run ( mainloop );

    return EXIT_SUCCESS;
}

