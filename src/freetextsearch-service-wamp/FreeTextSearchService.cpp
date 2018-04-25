/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2015, 2016 TomTom International B.V.
* \copyright Copyright (C) 2018, PSA GROUPE
* \author Peter Goedegebure (Peter.Goedegebure@tomtom.com)
* \author Philippe Colliot <philippe.colliot@mpsa.com>
* \author Morteza Damavandpeyma <Morteza.Damavandpeyma@tomtom.com>
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

#include <thread>
#include <iostream>

#include <CommonAPI/CommonAPI.hpp>

#include "FreeTextSearchStubImpl.hpp"

#define REGISTER_COUNTER 10
#define REGISTER_SLEEP 50
#define LOOP 500

using namespace v1::org::genivi::navigation::freetextsearchservice;

int main(int argc, const char * const argv[])
{
    CommonAPI::Runtime::setProperty("LibraryBase", "FreeTextSearch");

    std::shared_ptr<CommonAPI::Runtime> runtime = CommonAPI::Runtime::get();

    std::string domain = "local";
    std::string instanceFrts = "FRTS";

    // create service and register it at runtime
    std::shared_ptr<FreeTextSearchStubImpl> serviceFrts = std::make_shared<FreeTextSearchStubImpl>();
    uint8_t counter=0;
    bool successfullyRegistered = runtime->registerService(domain, instanceFrts, serviceFrts);
    while (!successfullyRegistered) {
        if(++counter>REGISTER_COUNTER){
            std::cout << "unable to register service: "<< instanceEnhp << std::endl;
            return EXIT_FAILURE;
        }
        std::this_thread::sleep_for(std::chrono::milliseconds(REGISTER_SLEEP));
        successfullyRegistered = runtime->registerService(domain, instanceFrts, serviceFrts);
    }

    std::cout << "Waiting for calls... (Abort with CTRL+C)" << std::endl;
    while (true) {
        std::this_thread::sleep_for(std::chrono::milliseconds(LOOP));
    }

    return 0;
}

