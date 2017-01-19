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

#ifndef FREETEXTSEARCHSTUBIMPL_H_
#define FREETEXTSEARCHSTUBIMPL_H_

#include <CommonAPI/CommonAPI.hpp>
#include <v4/org/genivi/CommonTypes.hpp>
#include <v4/org/genivi/navigation/NavigationTypes.hpp>
#include <v0/org/genivi/navigation/freetextsearchservice/FreeTextSearch.hpp>
#include <v0/org/genivi/navigation/freetextsearchservice/FreeTextSearchStubDefault.hpp>

using namespace v0::org::genivi::navigation::freetextsearchservice;
using namespace v4::org::genivi::navigation;
using namespace v4::org::genivi;

class FreeTextSearchStubImpl: public FreeTextSearchStubDefault
{

public:
  void getVersion(const std::shared_ptr<CommonAPI::ClientId> _client,
      getVersionReply_t _reply) override;

  void ftsRequest(const std::shared_ptr<CommonAPI::ClientId> _client,
      FreeTextSearch::FtsString _inputString,
      NavigationTypes::Coordinate2D _searchLocation,
      FreeTextSearch::ShapeList _searchShapes,
      FreeTextSearch::PageSize _pageSize,
      FreeTextSearch::SearchOptions _searchOptions,
      FreeTextSearch::FtsString _searchConditions,
      FreeTextSearch::FuzzyLevel _fuzzyLevel, ftsRequestReply_t _reply)
          override;

  void ftsNextPage(const std::shared_ptr<CommonAPI::ClientId> _client,
      NavigationTypes::Handle _sessionHandle,
      FreeTextSearch::SearchOptions _searchOptions, ftsNextPageReply_t _reply)
          override;

  void ftsCancel(const std::shared_ptr<CommonAPI::ClientId> _client,
      NavigationTypes::Handle _sessionHandle, ftsCancelReply_t _reply) override;

  void deleteLocationHandles(const std::shared_ptr<CommonAPI::ClientId> _client,
      FreeTextSearch::LocationHandleList _locationHandleList,
      deleteLocationHandlesReply_t _reply) override;
private:
  NavigationTypes::Handle iSessionHandle = 0;
  FreeTextSearch::PageId iPageId = 0;
  bool iSearchIsInProgress = false;

};

#endif /* FREETEXTSEARCHSTUBIMPL_H_ */
