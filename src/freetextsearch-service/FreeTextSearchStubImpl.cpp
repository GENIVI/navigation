/**
 * @licence app begin@
 * SPDX-License-Identifier: MPL-2.0
 *
 * \copyright Copyright (C) 2015, 2016 TomTom International B.V.
 * \copyright Copyright (C) 2016, PCA Peugeot Citroen
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
#include "FreeTextSearchStubImpl.hpp"

NavigationTypes::Handle nextHandle = 1;

void FreeTextSearchStubImpl::getVersion(
    const std::shared_ptr<CommonAPI::ClientId> _client,
    getVersionReply_t _reply)
{
  std::cout << "getVersion called." << std::endl;

  CommonTypes::Version* version = new CommonTypes::Version(0, 1, 0, "today");
  _reply(*version);
}

void FreeTextSearchStubImpl::ftsRequest(
    const std::shared_ptr<CommonAPI::ClientId> _client,
    FreeTextSearch::FtsString _inputString,
    NavigationTypes::Coordinate2D _searchLocation,
    FreeTextSearch::ShapeList _searchShapes, FreeTextSearch::PageSize _pageSize,
    FreeTextSearch::SearchOptions _searchOptions,
    FreeTextSearch::FtsString _searchConditions,
    FreeTextSearch::FuzzyLevel _fuzzyLevel, ftsRequestReply_t _reply)
{
  std::cout << "ftsRequest called." << std::endl;
  iSearchIsInProgress = true;

  // Create new session handle.
  iSessionHandle++;

  // Start from first page
  iPageId = 0;

  _reply(FreeTextSearch::ftsRequestError::OK, iSessionHandle, iPageId);

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

  fireFtsResultAddressesSelective(iSessionHandle, iPageId, addresses, true);

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
  poiPtr->setDistance(1000);
  poiPtr->setScore(1);
  poiPtr->setFuzzyMatch(false);
  poiPtr->setHasParents(false);
  poiPtr->setHasChildren(false);
  poiPtr->setDetourDistance(100);
  poiPtr->setDetourTime(200);

  pois.push_back(*poiPtr);
  fireFtsResultPoisSelective(iSessionHandle, iPageId, pois, false);

  FreeTextSearch::POICategories poiCategories;
  fireFtsResultPoiSuggestionsSelective(iSessionHandle, iPageId, poiCategories);

  fireFtsDoneSelective(iSessionHandle, iPageId, FreeTextSearch::FtsStatus::OK);
  iSearchIsInProgress = false;
}

void FreeTextSearchStubImpl::ftsNextPage(
    const std::shared_ptr<CommonAPI::ClientId> _client,
    NavigationTypes::Handle _sessionHandle,
    FreeTextSearch::SearchOptions _searchOptions, ftsNextPageReply_t _reply)
{
  std::cout << "ftsNextPage called." << std::endl;
  if (iSearchIsInProgress)
  {
    std::cout << "There is a search in progress" << std::endl;
    _reply(FreeTextSearch::ftsNextPageError::Literal::AlreadyInProgress, -1);
    return;
  }

  iSearchIsInProgress = true;
  // Note: searchOptions are ignored; always 1 address returned.

  // Get the next page.
  iPageId++;
  _reply(FreeTextSearch::ftsNextPageError::Literal::OK, iPageId);

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
  fireFtsResultAddressesSelective(iSessionHandle, iPageId, addresses, false);

  fireFtsDoneSelective(iSessionHandle, iPageId, FreeTextSearch::FtsStatus::OK);
  iSearchIsInProgress = false;
}

void FreeTextSearchStubImpl::ftsCancel(
    const std::shared_ptr<CommonAPI::ClientId> _client,
    NavigationTypes::Handle _sessionHandle, ftsCancelReply_t _reply)
{
  std::cout << "ftsCancel called." << std::endl;
  _reply(FreeTextSearch::ftsCancelError::Literal::OK);
}

void FreeTextSearchStubImpl::deleteLocationHandles(
    const std::shared_ptr<CommonAPI::ClientId> _client,
    FreeTextSearch::LocationHandleList _locationHandleList,
    deleteLocationHandlesReply_t _reply)
{
  std::cout << "deleteLocationHandles called." << std::endl;
  _reply();
}

