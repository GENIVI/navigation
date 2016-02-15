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
#ifndef FREETEXTSEARCHSTUBIMPL_H_
#define FREETEXTSEARCHSTUBIMPL_H_

#include <CommonAPI/CommonAPI.hpp>
#include <org/genivi/CommonTypes.hpp>
#include <org/genivi/navigation/NavigationTypes.hpp>
#include <v0/org/genivi/navigation/freetextsearchservice/FreeTextSearch.hpp>
#include <v0/org/genivi/navigation/freetextsearchservice/FreeTextSearchStubDefault.hpp>

using namespace v0::org::genivi::navigation::freetextsearchservice;
using namespace org::genivi::navigation;
using namespace org::genivi;

class FreeTextSearchStubImpl: public FreeTextSearchStubDefault {

public:
	FreeTextSearchStubImpl();
    ~FreeTextSearchStubImpl();
    void getVersion(const std::shared_ptr<CommonAPI::ClientId> _client,	FreeTextSearch::RequestId _requestId, getVersionReply_t _reply);
    void ftsRequest(const std::shared_ptr<CommonAPI::ClientId> _client, FreeTextSearch::RequestId _requestId,
    		                FreeTextSearch::FtsString _inputString, ::org::genivi::navigation::NavigationTypes::Coordinate2D _searchLocation,
							FreeTextSearch::ShapeList _searchShapes, FreeTextSearch::PageSize _pageSize,
							FreeTextSearch::SearchOptions _searchOptions, FreeTextSearch::FtsString _searchConditions,
							FreeTextSearch::FuzzyLevel _fuzzyLevel, ftsRequestReply_t _reply);
    void ftsNextPage(const std::shared_ptr<CommonAPI::ClientId> _client, FreeTextSearch::RequestId _requestId,
    		                NavigationTypes::Handle _freeTextSearchHandle, FreeTextSearch::SearchOptions _searchOptions,
							ftsNextPageReply_t _reply);
    void ftsCancel(const std::shared_ptr<CommonAPI::ClientId> _client, FreeTextSearch::RequestId _requestId,
    		               NavigationTypes::Handle _freeTextSearchHandle, ftsCancelReply_t _reply);
    void deleteLocationHandles(const std::shared_ptr<CommonAPI::ClientId> _client, FreeTextSearch::RequestId _requestId,
    		               FreeTextSearch::LocationHandleList _locationHandleList, deleteLocationHandlesReply_t _reply);

};

#endif /* FREETEXTSEARCHSTUBIMPL_H_ */
