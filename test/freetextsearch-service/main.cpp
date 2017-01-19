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
#include <thread>
#include <iostream>
#include <sstream>
#include <iterator>
#include <algorithm>
#include <unistd.h>
#include <CommonAPI/CommonAPI.hpp>
#include <v0/org/genivi/navigation/freetextsearchservice/FreeTextSearch.hpp> 
#include <v0/org/genivi/navigation/freetextsearchservice/FreeTextSearchProxy.hpp>

using namespace v0::org::genivi::navigation::freetextsearchservice;
using namespace v4::org::genivi::navigation;
using namespace v4::org::genivi;

bool ftsDoneIsReceived = false;

void printCommaSeperated(const std::vector<std::string>& strings)
{
  std::ostringstream ss;
  std::copy(strings.begin(), strings.end() - 1, std::ostream_iterator<std::string>(ss, ", "));
  ss << strings.back();
  std::cout << ss.str();
}

void printAddress(const FreeTextSearch::Address& address) {
    std::cout << "Address: ";
    std::cout << "score=" << address.getScore();
    std::cout << ", countryCode=" << address.getCountryCode();
    std::cout << ", stateCode=" << address.getStateCode();
    std::cout << ", mapCode=" << address.getMapCode();
    std::cout << ", places=";
    printCommaSeperated(address.getPlaces());

    FreeTextSearch::AddressDetails addressDetails = address.getAddressDetails();
    if (addressDetails.isType<FreeTextSearch::StreetDetails>()) {
      FreeTextSearch::StreetDetails streetDetails = addressDetails.get<FreeTextSearch::StreetDetails>();
      std::cout << ", streetName=" << streetDetails.getStreetName();
      std::cout << ", houseNumber=" << streetDetails.getHouseNumber();
      std::cout << ", (fromInput=" << streetDetails.getHouseNumberFromInput() << ")";
    }

    std::cout << ", postalCodes=";
    printCommaSeperated(address.getPostalCodes());
    NavigationTypes::Coordinate2D coordinate = address.getCoordinate();
    std::cout << ", coordinate=(" << coordinate.getLatitude() << "," << coordinate.getLongitude() << ")";
    std::cout << ", distance=" << address.getDistance();
    std::cout << ", fuzzy=" << address.getFuzzyMatch();
    std::cout << ", locationHandle=" << address.getLocationHandle();
    std::cout << std::endl;
}

void printPoi(const FreeTextSearch::POI& poi) {
    std::cout << "POI: ";
    std::cout << "poiName=" << poi.getPoiName();
    std::cout << ", brandNames=";
    printCommaSeperated(poi.getBrandNames());
    std::cout << ", categoryCode=" << poi.getCategoryCode();
    std::cout << ", countryCode=" << poi.getCountryCode();
    std::cout << ", stateCode=" << poi.getStateCode();
    std::cout << ", mapCode=" << poi.getMapCode();
    std::cout << ", places=";
    printCommaSeperated(poi.getPlace());
    std::cout << ", postalCodes=";
    printCommaSeperated(poi.getPostalCode());
    std::cout << ", address=" << poi.getAddress();
    std::cout << ", telephone=" << poi.getTelephone();
    NavigationTypes::Coordinate2D coordinate = poi.getCoordinate();
    std::cout << ", coordinate=(" << coordinate.getLatitude() << "," << coordinate.getLongitude() << ")";
    std::cout << ", locationHandle=" << poi.getLocationHandle();
    std::cout << std::endl;
}

void RegisterCallbacks(std::shared_ptr<FreeTextSearchProxy<> > fts)
{
  fts->getFtsResultAddressesSelectiveEvent().subscribe(
      [&](NavigationTypes::Handle sessionHandle, FreeTextSearch::PageId pageId, FreeTextSearch::Addresses addresses, bool moreAvailable)
      {
        std::cout << std::endl << "FtsResultAddressesses"
            << "\n\tsessionHandle = " << sessionHandle
            << "\n\tpageId = " << pageId
            << "\n\tmoreAvailable = " << moreAvailable
            << std::endl;
        std::for_each(addresses.begin(), addresses.end(), &printAddress);

      });
  fts->getFtsResultPoisSelectiveEvent().subscribe(
      [&](NavigationTypes::Handle sessionHandle, FreeTextSearch::PageId pageId, FreeTextSearch::POIs pois, bool moreAvailable)
      {
        std::cout << std::endl << "FtsResultPOIs"
            << "\n\tsessionHandle = " << sessionHandle
            << "\n\tpageId = " << pageId
            << "\n\tmoreAvailable = " << moreAvailable
            << std::endl;
        std::for_each(pois.begin(), pois.end(), &printPoi);
      });
  fts->getFtsResultPoiSuggestionsSelectiveEvent().subscribe(
      [&](NavigationTypes::Handle sessionHandle, FreeTextSearch::PageId pageId, FreeTextSearch::POICategories poiCategories)
      {
        std::cout << std::endl << "PoiSuggestions"
            << "\n\tsessionHandle = " << sessionHandle
            << "\n\tpageId = " << pageId
            << std::endl;
      });
  fts->getFtsDoneSelectiveEvent().subscribe(
      [&](NavigationTypes::Handle sessionHandle, FreeTextSearch::PageId pageId, FreeTextSearch::FtsStatus status)
      {
        std::cout << std::endl << "FtsDone"
            << "\n\tsessionHandle = " << sessionHandle
            << "\n\tpageId = " << pageId
            << "\n\tstatus = " << status
            << std::endl;
        ftsDoneIsReceived = true;
      });
}

void WaitForFtsDoneSignal()
{
  std::cout << "Waiting for page results ...";
  while (!ftsDoneIsReceived)
  {
    usleep(1000);
  }
  std::cout << std::endl;
}

int main()
{
  std::shared_ptr <CommonAPI::Runtime> runtime = CommonAPI::Runtime::get();
  std::shared_ptr<FreeTextSearchProxy<>> fts = runtime->buildProxy<FreeTextSearchProxy>("local", "test");

  while (!fts->isAvailable())
  {
    usleep(10);
  }

  RegisterCallbacks(fts);

  CommonAPI::CallStatus callStatus;
  CommonTypes::Version version;
  FreeTextSearch::FtsString inputString = "TomTom Eindhoven";
  NavigationTypes::Coordinate2D searchLocation(0, 0);
  FreeTextSearch::ShapeList searchShapes;
  FreeTextSearch::PageSize pageSize = 1;
  FreeTextSearch::SearchOptions searchOptions = FreeTextSearch::SearchOption::ADDRESS || FreeTextSearch::SearchOption::POI;
  FreeTextSearch::FtsString searchConditions = "";
  FreeTextSearch::FuzzyLevel fuzzyLevel = 0;

  FreeTextSearch::ftsRequestError errorFtsRequest;
  FreeTextSearch::ftsNextPageError errorFtsNextPage;
  FreeTextSearch::ftsCancelError errorFtsCancel;
  FreeTextSearch::LocationHandleList locationHandleList;
  NavigationTypes::Handle sessionHandle;
  FreeTextSearch::PageId pageId;


  std::cout << "Call getVersion (synchronous) *****************************************************"<< std::endl;
  fts->getVersion(callStatus, version);
  std::cout << "\tcallStatus = " << ((callStatus == CommonAPI::CallStatus::SUCCESS) ? "SUCCESS" : "NO_SUCCESS") << std::endl;
  std::cout << "\tversion = " << version.getVersionMajor() << "." << version.getVersionMinor();
  std::cout << "." << version.getVersionMicro() << " (" << version.getDate() << ")" << std::endl;


  ftsDoneIsReceived = false;
  fts->ftsRequest(inputString, searchLocation, searchShapes, pageSize, searchOptions, searchConditions, fuzzyLevel, callStatus, errorFtsRequest, sessionHandle, pageId);
  std::cout << "Call ftsRequest (synchronous) *****************************************************" << std::endl;
  std::cout << "\tcallStatus = " << ((callStatus == CommonAPI::CallStatus::SUCCESS) ? "SUCCESS" : "NO_SUCCESS") << std::endl;
  std::cout << "\terror = " << errorFtsRequest << std::endl;
  std::cout << "\tsessionHandle = " << sessionHandle << std::endl;
  std::cout <<" \tpageId =" << pageId << std::endl;
  WaitForFtsDoneSignal();


  ftsDoneIsReceived = false;
  fts->ftsNextPage(sessionHandle, searchOptions, callStatus, errorFtsNextPage, pageId);
  std::cout << "Call ftsNextPage (synchronous) ****************************************************" <<std::endl;
  std::cout << "\tcallStatus = " << ((callStatus == CommonAPI::CallStatus::SUCCESS) ? "SUCCESS" : "NO_SUCCESS") << std::endl;
  std::cout << "\terror = " << errorFtsNextPage << std::endl;
  std::cout << "\tpageId = " << pageId << std::endl;
  WaitForFtsDoneSignal();


  fts->ftsCancel(sessionHandle, callStatus, errorFtsCancel);
  std::cout << "Call ftsCancel (synchronous) ******************************************************" <<std::endl;
  std::cout << "\tcallStatus = " << ((callStatus == CommonAPI::CallStatus::SUCCESS) ? "SUCCESS" : "NO_SUCCESS") << std::endl;
  std::cout << "\terror = " << errorFtsCancel << std::endl;


  fts->deleteLocationHandles(locationHandleList, callStatus);
  std::cout << "Call deleteLocationHandles (synchronous) ******************************************" <<std::endl;
  std::cout << "\tcallStatus = " << ((callStatus == CommonAPI::CallStatus::SUCCESS) ? "SUCCESS" : "NO_SUCCESS") << std::endl;

  return 0;
}

