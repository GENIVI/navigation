/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2015, 2016 TomTom International B.V.
* \copyright Copyright (C) 2016, PCA Peugeot Citroen
* \author Peter Goedegebure (Peter.Goedegebure@tomtom.com)
* \author Philippe Colliot <philippe.colliot@mpsa.com>
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
#include <unistd.h>

#include <CommonAPI/CommonAPI.hpp>
#include <org/genivi/CommonTypes.hpp>
#include <org/genivi/navigation/NavigationTypes.hpp>
#include <v0/org/genivi/navigation/freetextsearchservice/FreeTextSearchProxy.hpp>

using namespace org::genivi;
using namespace org::genivi::navigation;
using namespace v0::org::genivi::navigation::freetextsearchservice;

// Sequence:
// - get version info synchronous
// - start asynchronous request
//   - when done is received (pageDone), request next page.
//     - when done is received (pageDone), cancel the request and free the locationHandles.
//       - when responses are received (cancelDone, freeHandleDone), we're done.
//
bool pageDone = false;
bool cancelDone = false;
bool freeHandlesDone = false;

FreeTextSearch::Addresses resultAddresses;
FreeTextSearch::POIs resultPois;

void printAddress(FreeTextSearch::Address address) {
    std::cout << "Address: ";
    std::cout << "score=" << address.getScore();
    std::cout << ", countryCode=" << address.getCountryCode();
    std::cout << ", stateCode=" << address.getStateCode();
    std::cout << ", mapCode=" << address.getMapCode();
    std::cout << ", places=";
    FreeTextSearch::FtsStringList places = address.getPlaces();
    bool first = true;
    for (unsigned int index = 0; index < places.size(); index++) {
    	if (first) {
    		first = false;
    	} else {
    		std::cout << ",";
    	}
    	std::cout << places.at(index);
    }
    FreeTextSearch::AddressDetails addressDetails = address.getAddressDetails();
    if (addressDetails.isType<FreeTextSearch::StreetDetails>()) {
    	FreeTextSearch::StreetDetails streetDetails = addressDetails.get<FreeTextSearch::StreetDetails>();
    	std::cout << ", streetName=" << streetDetails.getStreetName();
    	std::cout << ", houseNumber=" << streetDetails.getHouseNumber();
    	std::cout << ", (fromInput=" << streetDetails.getHouseNumberFromInput() << ")";
    }

    std::cout << ", postalCodes=";
    FreeTextSearch::FtsStringList postalCodes = address.getPostalCodes();
    first = true;
    for (unsigned int index = 0; index < postalCodes.size(); index++) {
    	if (first) {
    		first = false;
    	} else {
    		std::cout << ",";
    	}
    	std::cout << postalCodes.at(index);
    }

    NavigationTypes::Coordinate2D coordinate = address.getCoordinate();
    std::cout << ", coordinate=(" << coordinate.getLatitude() << "," << coordinate.getLongitude() << ")";
    std::cout << ", distance=" << address.getDistance();
    if (address.getFuzzyMatch()) {
    	std::cout << ", fuzzy";
    }
    std::cout << ", locationHandle=" << address.getLocationHandle();
    std::cout << std::endl;
}

void printPoi(FreeTextSearch::POI poi) {
    std::cout << "POI: ";
    std::cout << "poiName=" << poi.getPoiName();
    std::cout << ", brandNames=";
    FreeTextSearch::FtsStringList brandNames = poi.getBrandNames();
    bool first = true;
    for (unsigned int index = 0; index < brandNames.size(); index++) {
    	if (first) {
    		first = false;
    	} else {
    		std::cout << ",";
    	}
    	std::cout << brandNames.at(index);
    }
    std::cout << ", categoryCode=" << poi.getCategoryCode();
    std::cout << ", countryCode=" << poi.getCountryCode();
    std::cout << ", stateCode=" << poi.getStateCode();
    std::cout << ", mapCode=" << poi.getMapCode();
    std::cout << ", places=";
    FreeTextSearch::FtsStringList places = poi.getPlace();
    first = true;
    for (unsigned int index = 0; index < places.size(); index++) {
    	if (first) {
    		first = false;
    	} else {
    		std::cout << ",";
    	}
    	std::cout << places.at(index);
    }
    std::cout << ", postalCodes=";
    FreeTextSearch::FtsStringList postalCodes = poi.getPostalCode();
    first = true;
    for (unsigned int index = 0; index < postalCodes.size(); index++) {
    	if (first) {
    		first = false;
    	} else {
    		std::cout << ",";
    	}
    	std::cout << postalCodes.at(index);
    }
    std::cout << ", address=" << poi.getAddress();
    std::cout << ", telephone=" << poi.getTelephone();

    NavigationTypes::Coordinate2D coordinate = poi.getCoordinate();
    std::cout << ", coordinate=(" << coordinate.getLatitude() << "," << coordinate.getLongitude() << ")";
    std::cout << ", locationHandle=" << poi.getLocationHandle();
    std::cout << std::endl;
}

void printAllResults(std::string title) {
	std::cout << std::endl;
	std::cout << title << " - current results:" << std::endl;

	// TODO merge Addresses and POIs based on score. For first print all addresses and then all POIs.
	for (unsigned int index=0; index < resultAddresses.size(); ++index) {
		printAddress(resultAddresses.at(index));
	}

	for (unsigned int index=0; index < resultPois.size(); ++index) {
		printPoi(resultPois.at(index));
	}

	std::cout << std::endl;
}

void ftsRequestCallback(const CommonAPI::CallStatus& callStatus,
		const FreeTextSearch::ftsRequestError& error, const FreeTextSearch::RequestId& responseId,
		const NavigationTypes::Handle& freeTextSearchHandle) {
    std::cout << "   Result of ftsRequest (asynchronous)" << error << std::endl;
    std::cout << "   callStatus: " << ((callStatus == CommonAPI::CallStatus::SUCCESS) ? "SUCCESS" : "NO_SUCCESS")
              << std::endl;
    std::cout << "   error = " << error << std::endl;
    std::cout << "   responseId = " << responseId << std::endl;
    std::cout << "   freeTextSearchHandle = " << freeTextSearchHandle << std::endl;
}

void ftsNextPageCallback(const CommonAPI::CallStatus& callStatus,
		const FreeTextSearch::RequestId& responseId) {
    std::cout << "   Result of ftsNextPage (asynchronous)" << std::endl;
    std::cout << "   callStatus: " << ((callStatus == CommonAPI::CallStatus::SUCCESS) ? "SUCCESS" : "NO_SUCCESS")
              << std::endl;
    std::cout << "   responseId = " << responseId << std::endl;
}

void ftsCancelCallback(const CommonAPI::CallStatus& callStatus,
		const FreeTextSearch::RequestId& responseId) {
    std::cout << "   Result of ftsCancel (asynchronous)" << std::endl;
    std::cout << "   callStatus: " << ((callStatus == CommonAPI::CallStatus::SUCCESS) ? "SUCCESS" : "NO_SUCCESS")
              << std::endl;
    std::cout << "   responseId = " << responseId << std::endl;

    cancelDone = true;
}

void deleteLocationHandlesCallback(const CommonAPI::CallStatus& callStatus,
		const FreeTextSearch::RequestId& responseId) {
    std::cout << "   Result of deleteLocationHandles (asynchronous)" << std::endl;
    std::cout << "   callStatus: " << ((callStatus == CommonAPI::CallStatus::SUCCESS) ? "SUCCESS" : "NO_SUCCESS")
              << std::endl;
    std::cout << "   responseId = " << responseId << std::endl;

    freeHandlesDone = true;
}

int main() {
    std::shared_ptr<CommonAPI::Runtime> runtime = CommonAPI::Runtime::get();

    std::string domain = "local";
	std::string instance = "org.genivi.navigation.freetextsearchservice";

    std::shared_ptr<FreeTextSearchProxyDefault> myProxy = runtime->buildProxy < FreeTextSearchProxy > (domain, instance);

    while (!myProxy->isAvailable()) {
        usleep(10);
    }

    /*
     * Subscribe to broadcasts
     */
    myProxy->getFtsResultAddressesSelectiveEvent().subscribe([&](FreeTextSearch::RequestId responseId, FreeTextSearch::Addresses addresses, bool moreAvailable){
        std::cout << "Received ftsResultAddresses, responseId = " << responseId << std::endl;
        std::cout << "moreAvailable = " << moreAvailable << std::endl;

        for (unsigned int index=0; index < addresses.size(); ++index) {
        	resultAddresses.push_back(addresses.at(index));
        }

        printAllResults("New addresses received");
    });

    myProxy->getFtsResultPoisSelectiveEvent().subscribe([&](FreeTextSearch::RequestId responseId, FreeTextSearch::POIs pois, bool moreAvailable){
        std::cout << "Received ftsResultPois, responseId = " << responseId << std::endl;
        std::cout << "moreAvailable = " << moreAvailable << std::endl;

        for (unsigned int index=0; index < pois.size(); ++index) {
        	resultPois.push_back(pois.at(index));
        }

        printAllResults("New POIs received");
    });

    myProxy->getFtsDoneSelectiveEvent().subscribe([&](FreeTextSearch::RequestId responseId, FreeTextSearch::FtsStatus ftsStatus) {
        std::cout << "Received ftsDone, responseId = " << responseId << std::endl;
        std::cout << "ftsStatus = " << ftsStatus << std::endl;

        pageDone = true;
    });

    FreeTextSearch::RequestId requestId = 0;
    FreeTextSearch::RequestId responseId;
    CommonAPI::CallStatus callStatus;

    // Get the API version info.
    CommonTypes::Version version;
    std::cout << "Call getVersion (synchronous), requesId = " << requestId << std::endl;
    myProxy->getVersion(requestId, callStatus, responseId, version);
    std::cout << "   callStatus: " << ((callStatus == CommonAPI::CallStatus::SUCCESS) ? "SUCCESS" : "NO_SUCCESS")
              << std::endl;
    std::cout << "   responseId = " << responseId << std::endl;
    std::cout << "   version = " << version.getVersionMajor() << "." << version.getVersionMinor()
    		  << "." << version.getVersionMicro() << " (" << version.getDate() << ")" << std::endl;

    requestId++;

    // Clear results
    resultAddresses.clear();
    resultPois.clear();

    // Search parameters
    FreeTextSearch::FtsString inputString = "lucht";
    NavigationTypes::Coordinate2D* searchLocation = new NavigationTypes::Coordinate2D(48.053250, 8.324500);
    FreeTextSearch::ShapeList searchShapes;
    FreeTextSearch::PageSize pageSize = 20;
    FreeTextSearch::SearchOptions searchOptions = FreeTextSearch::SearchOption::ADDRESS;
    FreeTextSearch::FtsString searchConditions = "";
    FreeTextSearch::FuzzyLevel fuzzyLevel = 5;
    // TODO At least the synchronous call always has the 'error' parameter. So there has to be a 'NO ERROR' value defined.
    FreeTextSearch::ftsRequestError error;
    NavigationTypes::Handle freeTextSearchHandle;

    pageDone = false;
    std::cout << "Call ftsRequest (asynchronous), requesId = " << requestId << std::endl;
    std::function<void(const CommonAPI::CallStatus&,
    		           const FreeTextSearch::ftsRequestError&, const FreeTextSearch::RequestId&,
    		    		const NavigationTypes::Handle&)> ftsRequestCallbackFunction = ftsRequestCallback;
    myProxy->ftsRequestAsync(requestId, inputString, *searchLocation, searchShapes, pageSize, searchOptions, searchConditions, fuzzyLevel,
    		                 ftsRequestCallbackFunction);

    while (!pageDone) {
        std::cout << "Waiting for first page results." << std::endl;
        usleep(50000);
    }

    requestId++;
    pageDone = false;
    std::cout << "Call ftsNext (asynchronous), requesId = " << requestId << std::endl;
    std::function<void(const CommonAPI::CallStatus&,
    		           const FreeTextSearch::RequestId&)> ftsNextPageCallbackFunction = ftsNextPageCallback;
    myProxy->ftsNextPageAsync(requestId, freeTextSearchHandle, searchOptions, ftsNextPageCallbackFunction);

    while (!pageDone) {
        std::cout << "Waiting for second page results." << std::endl;
        usleep(50000);
    }

    requestId++;
    cancelDone = false;
    freeHandlesDone = false;
    std::cout << "Call ftsCancel (asynchronous), requesId = " << requestId << std::endl;
    std::function<void(const CommonAPI::CallStatus&,
    		           const FreeTextSearch::RequestId&)> ftsCancelCallbackFunction = ftsCancelCallback;
    myProxy->ftsCancelAsync(requestId, freeTextSearchHandle, ftsCancelCallbackFunction);

    requestId++;
    std::cout << "Call deleteLocationHandles (asynchronous), requesId = " << requestId << std::endl;
    std::function<void(const CommonAPI::CallStatus&,
    		           const FreeTextSearch::RequestId&)> deleteLocationHandlesCallbackFunction = deleteLocationHandlesCallback;
    FreeTextSearch::LocationHandleList locationHandleList;
    myProxy->deleteLocationHandlesAsync(requestId, locationHandleList, deleteLocationHandlesCallbackFunction);


    while (!(cancelDone && freeHandlesDone)) {
        std::cout << "Waiting for cancel and deleteHandles to finish." << std::endl;
        usleep(50000);
    }


//    while (true) {
//        std::this_thread::sleep_for(std::chrono::seconds(5));
//    }

    return 0;
}
