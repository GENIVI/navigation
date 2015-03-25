/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2015, PCA Peugeot Citroen
*
* \file poi-manager-server-stub.h
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
#ifndef POIMANAGERSERVERSTUBIMPL_H_
#define POIMANAGERSERVERSTUBIMPL_H_

#include <CommonAPI/CommonAPI.h>

#include "org/genivi/navigation/poiservice/POIContentManagerStubDefault.h"

#include "poi-common-database.h"

#include "poi-common-data-model.h"

using namespace org;
using namespace genivi;
using namespace navigation;
using namespace poiservice;

class PoiManagerServerStub: public org::genivi::navigation::poiservice::POIContentManagerStubDefault {

public:
    PoiManagerServerStub();
    ~PoiManagerServerStub();
    void getVersion(const std::shared_ptr<CommonAPI::ClientId> clientId, NavigationTypes::Version& version);
    void setLocale(const std::shared_ptr<CommonAPI::ClientId> clientId, std::string languageCode, std::string countryCode, std::string scriptCode);
    void getLocale(const std::shared_ptr<CommonAPI::ClientId> clientId, std::string& languageCode, std::string& countryCode, std::string& scriptCode);
    void getSupportedLocales(const std::shared_ptr<CommonAPI::ClientId> clientId, std::vector<POIServiceTypes::Locales>& localeList);
    void getAvailableCategories(const std::shared_ptr<CommonAPI::ClientId> clientId, std::vector<POIServiceTypes::CategoryAndName>& categories);
    void getRootCategory(const std::shared_ptr<CommonAPI::ClientId> clientId, POIServiceTypes::CategoryID& category);

    bool initDatabase(const char* poiDatabaseFileName);

private:
    NavigationTypes::Version m_version;
    std::string m_languageCode, m_countryCode, m_scriptCode;

    Database *mp_database; // database access
    uint16_t m_availableCategories;
    poi_category_common_t m_availableCategoryTable[MAX_CATEGORIES];
    POIServiceTypes::CategoryID m_rootCategory;

    void refreshCategoryList();
    void onError();
};

#endif /* POIMANAGERSERVERSTUBIMPL_H_ */
