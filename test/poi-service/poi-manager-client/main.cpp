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
#include <iostream>
#include <thread>
#include <CommonAPI/CommonAPI.h> //Defined in the Common API Runtime library
#include "org/genivi/navigation/poiservice/POIContentManagerProxy.h"

using namespace org::genivi::navigation::poiservice;

int main()
{
    // Common API data init
    std::shared_ptr<CommonAPI::Runtime> runtime = CommonAPI::Runtime::load();
    std::shared_ptr<CommonAPI::Factory> factory = runtime->createFactory();

    const std::string& serviceAddress = "local:org.genivi.poiservice.POIContentManager:org.genivi.poiservice.POIContentManager";
    std::shared_ptr<POIContentManagerProxyDefault> myProxy = factory->buildProxy<POIContentManagerProxy>(serviceAddress);


    while (!myProxy->isAvailable()) {
        usleep(10);
    }


    while (true) {
        std::this_thread::sleep_for(std::chrono::seconds(5));
    }

    return 0;
}

