/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2015, PCA Peugeot Citroen
*
* \file poi-manager-server-stub.cpp
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
#include "poi-manager-server-stub.h"

PoiManagerServerStub::PoiManagerServerStub() {
    m_version.versionMajor = 1;
    m_version.versionMicro = 0;
    m_version.versionMinor = 0;
    m_version.date = "19-12-2012";

}

PoiManagerServerStub::~PoiManagerServerStub() {
}

void PoiManagerServerStub::getVersion(const std::shared_ptr<CommonAPI::ClientId> clientId, NavigationTypes::Version& version)
{
    version = m_version;
}

void PoiManagerServerStub::setLocale(const std::shared_ptr<CommonAPI::ClientId> clientId, std::string languageCode, std::string countryCode, std::string scriptCode)
{
    m_languageCode = languageCode;
    m_countryCode = countryCode;
    m_scriptCode = scriptCode;
}

void PoiManagerServerStub::getLocale(const std::shared_ptr<CommonAPI::ClientId> clientId, std::string& languageCode, std::string& countryCode, std::string& scriptCode)
{
    languageCode = m_languageCode;
    countryCode = m_countryCode;
    scriptCode = m_scriptCode;
}

void PoiManagerServerStub::getSupportedLocales(const std::shared_ptr<CommonAPI::ClientId> clientId, std::vector<POIServiceTypes::Locales>& localeList)
{
    POIServiceTypes::Locales en_US { "eng","USA", "Latn" };
    POIServiceTypes::Locales fr_FR { "fra","FRA", "Latn" };
    localeList.push_back(en_US);
    localeList.push_back(fr_FR);
}
