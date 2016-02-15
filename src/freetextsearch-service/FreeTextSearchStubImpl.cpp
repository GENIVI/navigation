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
#include "FreeTextSearchStubImpl.hpp"

NavigationTypes::Handle nextHandle = 1;

FreeTextSearchStubImpl::FreeTextSearchStubImpl() {
}

FreeTextSearchStubImpl::~FreeTextSearchStubImpl() {
}

void FreeTextSearchStubImpl::getVersion(const std::shared_ptr<CommonAPI::ClientId> _client,
		FreeTextSearch::RequestId _requestId, getVersionReply_t _reply) {
    std::cout << "getVersion called." << std::endl;

    FreeTextSearch::RequestId responseId = _requestId;
    CommonTypes::Version* version = new CommonTypes::Version(0, 1, 0, "today");
    _reply(responseId, *version);
}

void FreeTextSearchStubImpl::ftsRequest(const std::shared_ptr<CommonAPI::ClientId> _client, FreeTextSearch::RequestId _requestId,
		                FreeTextSearch::FtsString _inputString, ::org::genivi::navigation::NavigationTypes::Coordinate2D _searchLocation,
						FreeTextSearch::ShapeList _searchShapes, FreeTextSearch::PageSize _pageSize,
						FreeTextSearch::SearchOptions _searchOptions, FreeTextSearch::FtsString _searchConditions,
						FreeTextSearch::FuzzyLevel _fuzzyLevel, ftsRequestReply_t _reply) {
	// TODO: introduce ftsRequestError value for OK.
	FreeTextSearch::ftsRequestError error = FreeTextSearch::ftsRequestError::NoMoreFtsHandles;

    FreeTextSearch::RequestId responseId = _requestId;


	// Note: No administration of freeTextSearchHandles, just increment a number.
    NavigationTypes::Handle freeTextSearchHandle = nextHandle++;
	_reply(error, responseId, freeTextSearchHandle);

    // Note: inputString is ignored, use fixed results.
	// Note: searchLocation is ignored, use fixed results.
	// TODO: introduce a value for 'not specified' for searchLocation (Coordinate2D).
	// Note: searchShapes is ignored, use fixed results.
	// Note: pageSize is ignored, use fixed size of 2. First page: 2 addresses (moreAvailable), 1 POI (no moreAvailable).
	// Note: searchOptions is ignored, use fixed results.
	// Note: searchConditions is ignored, use fixed results,
	// Note: fuzzyLevel is ignored, used fixed results.

	FreeTextSearch::Addresses addresses;
	FreeTextSearch::Address* addressPtr;
	FreeTextSearch::FtsStringList* places;
	FreeTextSearch::FtsStringList* postalCodes;
	FreeTextSearch::StreetDetails* streetDetailsPtr;

	addressPtr = new FreeTextSearch::Address();
	NavigationTypes::LocationHandle locationHandle1 = 1234;
	addressPtr->setLocationHandle(locationHandle1);
	addressPtr->setCountryCode("NLD");
	addressPtr->setStateCode("");
	places = new FreeTextSearch::FtsStringList();
	places->push_back("Eindhoven");
	addressPtr->setPlaces(*places);
	postalCodes = new FreeTextSearch::FtsStringList();
	postalCodes->push_back("5657 EB");
	addressPtr->setPostalCodes(*postalCodes);
	streetDetailsPtr = new FreeTextSearch::StreetDetails();
	streetDetailsPtr->setStreetName("Luchthavenweg");
	streetDetailsPtr->setHouseNumber("48");
	streetDetailsPtr->setHouseNumberFromInput("");
	FreeTextSearch::AddressDetails addressDetails(*streetDetailsPtr);
	addressPtr->setAddressDetails(addressDetails);
	addressPtr->setMapCode("L2D.3Z");
    NavigationTypes::Coordinate2D* coordinate1 = new NavigationTypes::Coordinate2D(51.455664, 5.396336);
    addressPtr->setCoordinate(*coordinate1);
    addressPtr->setDistance(4566);
    addressPtr->setScore(1000);
    addressPtr->setFuzzyMatch(false);
	addresses.push_back(*addressPtr);

	addressPtr = new FreeTextSearch::Address();
	NavigationTypes::LocationHandle locationHandle2 = 9876;
	addressPtr->setLocationHandle(locationHandle2);
	addressPtr->setCountryCode("NLD");
	addressPtr->setStateCode("");
	places = new FreeTextSearch::FtsStringList();
	places->push_back("'s Hertogenbosch");
	addressPtr->setPlaces(*places);
	postalCodes = new FreeTextSearch::FtsStringList();
	postalCodes->push_back("<postal code>");
	addressPtr->setPostalCodes(*postalCodes);
	streetDetailsPtr = new FreeTextSearch::StreetDetails();
	streetDetailsPtr->setStreetName("<street>");
	streetDetailsPtr->setHouseNumber("<housenumber>");
	streetDetailsPtr->setHouseNumberFromInput("");
	FreeTextSearch::AddressDetails addressDetails2(*streetDetailsPtr);
	addressPtr->setAddressDetails(addressDetails2);
	addressPtr->setMapCode("<map code>");
    NavigationTypes::Coordinate2D* coordinate2 = new NavigationTypes::Coordinate2D(52.434356, 17.555336);
    addressPtr->setCoordinate(*coordinate2);
    addressPtr->setDistance(196534);
    addressPtr->setScore(578);
    addressPtr->setFuzzyMatch(true);
	addresses.push_back(*addressPtr);

	fireFtsResultAddressesSelective(responseId, addresses, true);

	FreeTextSearch::POIs pois;
	FreeTextSearch::POI* poiPtr;
	poiPtr = new FreeTextSearch::POI();
	NavigationTypes::LocationHandle locationHandle3 = 102934;
	poiPtr->setLocationHandle(locationHandle3);
	FreeTextSearch::POICategoryCode poiCategoryCode = 754;
	poiPtr->setCategoryCode(poiCategoryCode);
	FreeTextSearch::FtsStringList* brandNames;
	brandNames = new FreeTextSearch::FtsStringList();
	brandNames->push_back("TomTom");
	brandNames->push_back("Bandit");
	poiPtr->setBrandNames(*brandNames);
	poiPtr->setPoiName("TomTom Eindhoven");
	poiPtr->setAddress("Luchthavenweg 48, 5657 EB Eindhoven");
	places = new FreeTextSearch::FtsStringList();
	places->push_back("Eindhoven");
	poiPtr->setPlace(*places);
	postalCodes = new FreeTextSearch::FtsStringList();
	postalCodes->push_back("5657 EB");
	poiPtr->setPostalCode(*postalCodes);
	poiPtr->setMapCode("L2D.3Z");
	poiPtr->setCountryCode("NLD");
	poiPtr->setStateCode("");
	poiPtr->setTelephone("+31 40 84 44899");
	poiPtr->setCoordinate(*coordinate1);
	pois.push_back(*poiPtr);
	fireFtsResultPoisSelective(responseId, pois, false);
	// TODO why is there no score for a POI?

	FreeTextSearch::FtsStatus ftsStatus = FreeTextSearch::FtsStatus::OK;
    fireFtsDoneSelective(responseId, ftsStatus);
}

void FreeTextSearchStubImpl::ftsNextPage(const std::shared_ptr<CommonAPI::ClientId> _client, FreeTextSearch::RequestId _requestId,
		                NavigationTypes::Handle _freeTextSearchHandle, FreeTextSearch::SearchOptions _searchOptions,
						ftsNextPageReply_t _reply) {
	// Note: No administration of freeTextSearchHandles, parameter is ignored.
	// Note: searchOptions are ignored; always 1 address returned.
    FreeTextSearch::RequestId responseId = _requestId;

    _reply(responseId);

	FreeTextSearch::FtsStatus ftsStatus = FreeTextSearch::FtsStatus::OK;

	FreeTextSearch::Addresses addresses;
	FreeTextSearch::Address* addressPtr;
	addressPtr = new FreeTextSearch::Address();
	NavigationTypes::LocationHandle locationHandle = 74658;
	addressPtr->setLocationHandle(locationHandle);
	addressPtr->setCountryCode("NLD");
	addressPtr->setStateCode("");
	FreeTextSearch::FtsStringList* places;
	places = new FreeTextSearch::FtsStringList();
	places->push_back("Amsterdam");
	addressPtr->setPlaces(*places);
	FreeTextSearch::FtsStringList* postalCodes;
	postalCodes = new FreeTextSearch::FtsStringList();
	postalCodes->push_back("<postal code>");
	addressPtr->setPostalCodes(*postalCodes);
	addressPtr->setMapCode("<map code>");
	FreeTextSearch::StreetDetails* streetDetailsPtr;
	streetDetailsPtr = new FreeTextSearch::StreetDetails();
	streetDetailsPtr->setStreetName("<a street in Amsterdam>");
	streetDetailsPtr->setHouseNumber("<housenumber>");
	streetDetailsPtr->setHouseNumberFromInput("");
	FreeTextSearch::AddressDetails addressDetails(*streetDetailsPtr);
	addressPtr->setAddressDetails(addressDetails);
    NavigationTypes::Coordinate2D* coordinate = new NavigationTypes::Coordinate2D(50.123456, 9.838374);
    addressPtr->setCoordinate(*coordinate);
    addressPtr->setDistance(3009);
    addressPtr->setScore(33);
    addressPtr->setFuzzyMatch(false);
	addresses.push_back(*addressPtr);
	fireFtsResultAddressesSelective(responseId, addresses, false);

    fireFtsDoneSelective(responseId, ftsStatus);
}

void FreeTextSearchStubImpl::ftsCancel(const std::shared_ptr<CommonAPI::ClientId> _client, FreeTextSearch::RequestId _requestId,
		               NavigationTypes::Handle _freeTextSearchHandle, ftsCancelReply_t _reply) {
    FreeTextSearch::RequestId responseId = _requestId;

    _reply(responseId);
}

void FreeTextSearchStubImpl::deleteLocationHandles(const std::shared_ptr<CommonAPI::ClientId> _client, FreeTextSearch::RequestId _requestId,
		               FreeTextSearch::LocationHandleList _locationHandleList, deleteLocationHandlesReply_t _reply) {
    FreeTextSearch::RequestId responseId = _requestId;

    _reply(responseId);
}

