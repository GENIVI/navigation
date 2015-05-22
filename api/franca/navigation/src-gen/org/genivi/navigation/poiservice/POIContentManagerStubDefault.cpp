/*
* This file was generated by the CommonAPI Generators.
* Used org.genivi.commonapi.core 2.1.6.v20140519.
* Used org.franca.core 0.8.11.201401091023.
*
* This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
* If a copy of the MPL was not distributed with this file, You can obtain one at
* http://mozilla.org/MPL/2.0/.
*/
#include <org/genivi/navigation/poiservice/POIContentManagerStubDefault.h>

namespace org {
namespace genivi {
namespace navigation {
namespace poiservice {

POIContentManagerStubDefault::POIContentManagerStubDefault():
        remoteEventHandler_(this),
        interfaceVersion_(POIContentManager::getInterfaceVersion()) {
}

const CommonAPI::Version& POIContentManagerStubDefault::getInterfaceVersion(std::shared_ptr<CommonAPI::ClientId> clientId) {
    return interfaceVersion_;
}

POIContentManagerStubRemoteEvent* POIContentManagerStubDefault::initStubAdapter(const std::shared_ptr<POIContentManagerStubAdapter>& stubAdapter) {
    CommonAPI::Stub<POIContentManagerStubAdapter, POIContentManagerStubRemoteEvent>::stubAdapter_ = stubAdapter;
    return &remoteEventHandler_;
}


/**
 * This method returns the API version implemented by the content access module.
 */
void POIContentManagerStubDefault::getVersion(const std::shared_ptr<CommonAPI::ClientId> clientId, NavigationTypes::Version& version) {
    // Call old style methods in default 
    getVersion(version);
}
void POIContentManagerStubDefault::getVersion(NavigationTypes::Version& version) {
    // No operation in default
}

/**
 * Set the current language set for the search by poi provider module.
       
 *  The language defines the poi and categories name and details language. If the
 *  language is not supported, the default details will be returned in the native
 *  language.
 */
void POIContentManagerStubDefault::setLocale(const std::shared_ptr<CommonAPI::ClientId> clientId, std::string languageCode, std::string countryCode, std::string scriptCode) {
    // Call old style methods in default 
    setLocale(languageCode, countryCode, scriptCode);
}
void POIContentManagerStubDefault::setLocale(std::string languageCode, std::string countryCode, std::string scriptCode) {
    // No operation in default
}

/**
 * Get the current language set for the search by poi provider module.
 */
void POIContentManagerStubDefault::getLocale(const std::shared_ptr<CommonAPI::ClientId> clientId, std::string& languageCode, std::string& countryCode, std::string& scriptCode) {
    // Call old style methods in default 
    getLocale(languageCode, countryCode, scriptCode);
}
void POIContentManagerStubDefault::getLocale(std::string& languageCode, std::string& countryCode, std::string& scriptCode) {
    // No operation in default
}

/**
 * Get the supported set of locales for the search by poi provider module.
 */
void POIContentManagerStubDefault::getSupportedLocales(const std::shared_ptr<CommonAPI::ClientId> clientId, std::vector<POIServiceTypes::Locales>& localeList) {
    // Call old style methods in default 
    getSupportedLocales(localeList);
}
void POIContentManagerStubDefault::getSupportedLocales(std::vector<POIServiceTypes::Locales>& localeList) {
    // No operation in default
}

/**
 * This method retrieves the list od POI categories available (pre-defined and
 *  custom).
 */
void POIContentManagerStubDefault::getAvailableCategories(const std::shared_ptr<CommonAPI::ClientId> clientId, std::vector<POIServiceTypes::CategoryAndName>& categories) {
    // Call old style methods in default 
    getAvailableCategories(categories);
}
void POIContentManagerStubDefault::getAvailableCategories(std::vector<POIServiceTypes::CategoryAndName>& categories) {
    // No operation in default
}

/**
 * Get the root category id. That would be ALL_CATEGORIES.
 */
void POIContentManagerStubDefault::getRootCategory(const std::shared_ptr<CommonAPI::ClientId> clientId, POIServiceTypes::CategoryID& category) {
    // Call old style methods in default 
    getRootCategory(category);
}
void POIContentManagerStubDefault::getRootCategory(POIServiceTypes::CategoryID& category) {
    // No operation in default
}

/**
 * Get the children categories id and type (top level) from the a parent unique id.
 */
void POIContentManagerStubDefault::getChildrenCategories(const std::shared_ptr<CommonAPI::ClientId> clientId, POIServiceTypes::CategoryID category, std::vector<POIServiceTypes::CategoryAndLevel>& categories) {
    // Call old style methods in default 
    getChildrenCategories(category, categories);
}
void POIContentManagerStubDefault::getChildrenCategories(POIServiceTypes::CategoryID category, std::vector<POIServiceTypes::CategoryAndLevel>& categories) {
    // No operation in default
}

/**
 * Get the parent categories id and type (top level) from the a unique id.
 */
void POIContentManagerStubDefault::getParentCategories(const std::shared_ptr<CommonAPI::ClientId> clientId, POIServiceTypes::CategoryID category, std::vector<POIServiceTypes::CategoryAndLevel>& categories) {
    // Call old style methods in default 
    getParentCategories(category, categories);
}
void POIContentManagerStubDefault::getParentCategories(POIServiceTypes::CategoryID category, std::vector<POIServiceTypes::CategoryAndLevel>& categories) {
    // No operation in default
}

/**
 * Creates a category by name and return an unique id.
 */
void POIContentManagerStubDefault::createCategory(const std::shared_ptr<CommonAPI::ClientId> clientId, POIServiceTypes::CAMCategory category, POIServiceTypes::CategoryID& unique_id) {
    // Call old style methods in default 
    createCategory(category, unique_id);
}
void POIContentManagerStubDefault::createCategory(POIServiceTypes::CAMCategory category, POIServiceTypes::CategoryID& unique_id) {
    // No operation in default
}

/**
 * Removes a list of categories. Because of required time to remove it from the
 *  database, a signal is emitted when the deletion is done.
 */
void POIContentManagerStubDefault::removeCategories(const std::shared_ptr<CommonAPI::ClientId> clientId, std::vector<POIServiceTypes::CategoryID> categories) {
    // Call old style methods in default 
    removeCategories(categories);
}
void POIContentManagerStubDefault::removeCategories(std::vector<POIServiceTypes::CategoryID> categories) {
    // No operation in default
}

/**
 * Adds a list of POIs to a category. Because of required time to add it to the
 *  database, a signal is emitted when the update is done, that gives the id of
 *  the elements added
 */
void POIContentManagerStubDefault::addPOIs(const std::shared_ptr<CommonAPI::ClientId> clientId, POIServiceTypes::CategoryID unique_id, std::vector<POIServiceTypes::PoiAddedDetails> poiList) {
    // Call old style methods in default 
    addPOIs(unique_id, poiList);
}
void POIContentManagerStubDefault::addPOIs(POIServiceTypes::CategoryID unique_id, std::vector<POIServiceTypes::PoiAddedDetails> poiList) {
    // No operation in default
}

/**
 * Removes a list of POIs to a category. Because of required time to remove it
 *  from the database, a signal is emitted when the update is done.
 */
void POIContentManagerStubDefault::removePOIs(const std::shared_ptr<CommonAPI::ClientId> clientId, std::vector<POIServiceTypes::POI_ID> ids) {
    // Call old style methods in default 
    removePOIs(ids);
}
void POIContentManagerStubDefault::removePOIs(std::vector<POIServiceTypes::POI_ID> ids) {
    // No operation in default
}

/**
 * This method is sent by the POI service component to inform all the CAM that a
 *  new POI search was started.
        It provides all the relevant search
 *  parameters. Of course the CAM will only be aware of the search if it registers
 *  one of the search categories.
 */
void POIContentManagerStubDefault::poiSearchStarted(const std::shared_ptr<CommonAPI::ClientId> clientId, NavigationTypes::Handle poiSearchHandle, uint16_t maxSize, NavigationTypes::Coordinate3D location, std::vector<POIServiceTypes::CategoryAndRadius> poiCategories, std::vector<POIServiceTypes::AttributeDetails> poiAttributes, std::string inputString, uint16_t sortOption) {
    // Call old style methods in default 
    poiSearchStarted(poiSearchHandle, maxSize, location, poiCategories, poiAttributes, inputString, sortOption);
}
void POIContentManagerStubDefault::poiSearchStarted(NavigationTypes::Handle poiSearchHandle, uint16_t maxSize, NavigationTypes::Coordinate3D location, std::vector<POIServiceTypes::CategoryAndRadius> poiCategories, std::vector<POIServiceTypes::AttributeDetails> poiAttributes, std::string inputString, uint16_t sortOption) {
    // No operation in default
}

/**
 * This method cancels the search for the current id.
 */
void POIContentManagerStubDefault::poiSearchCanceled(const std::shared_ptr<CommonAPI::ClientId> clientId, NavigationTypes::Handle poiSearchHandle) {
    // Call old style methods in default 
    poiSearchCanceled(poiSearchHandle);
}
void POIContentManagerStubDefault::poiSearchCanceled(NavigationTypes::Handle poiSearchHandle) {
    // No operation in default
}

/**
 * This method provides the poi results list found by the CAM.
        As the POI
 *  unique id is managed by the POI component, the CAM only provides the POI name,
 *  the category and coordinates as well as all the relevant detailed information.
 */
void POIContentManagerStubDefault::resultListRequested(const std::shared_ptr<CommonAPI::ClientId> clientId, uint8_t camId, NavigationTypes::Handle poiSearchHandle, std::vector<POIServiceTypes::AttributeID> attributes, POIServiceTypes::SearchStatusState& statusValue, uint16_t& resultListSize, std::vector<POIServiceTypes::PoiCAMDetails>& resultList) {
    // Call old style methods in default 
    resultListRequested(camId, poiSearchHandle, attributes, statusValue, resultListSize, resultList);
}
void POIContentManagerStubDefault::resultListRequested(uint8_t camId, NavigationTypes::Handle poiSearchHandle, std::vector<POIServiceTypes::AttributeID> attributes, POIServiceTypes::SearchStatusState& statusValue, uint16_t& resultListSize, std::vector<POIServiceTypes::PoiCAMDetails>& resultList) {
    // No operation in default
}

/**
 * This method retrieves the details associated to one or more POI.
        It
 *  contains the name, the parent categories, the list of attributes, the icons,
 *  ... .
 */
void POIContentManagerStubDefault::poiDetailsRequested(const std::shared_ptr<CommonAPI::ClientId> clientId, std::vector<POIServiceTypes::POI_ID> source_id, std::vector<POIServiceTypes::SearchResultDetails>& results) {
    // Call old style methods in default 
    poiDetailsRequested(source_id, results);
}
void POIContentManagerStubDefault::poiDetailsRequested(std::vector<POIServiceTypes::POI_ID> source_id, std::vector<POIServiceTypes::SearchResultDetails>& results) {
    // No operation in default
}


/**
 * guidanceStatusChanged = This signal is sent to the clients when one or more
 *  configuration settings changes.
 */
void POIContentManagerStubDefault::fireConfigurationChangedEvent(const std::vector<uint16_t>& changedSettings) {
    stubAdapter_->fireConfigurationChangedEvent(changedSettings);
}
/**
 * CategoriesRemoved = This signal is emitted when a list of categories and
 *  associated content has been removed from the database.
 */
void POIContentManagerStubDefault::fireCategoriesRemovedEvent(const std::vector<POIServiceTypes::CategoryID>& categories) {
    stubAdapter_->fireCategoriesRemovedEvent(categories);
}
/**
 * POIAdded = This signal is emitted when a list of POIs and associated content
 *  has been added to the database. It returns the ids.
 */
void POIContentManagerStubDefault::firePOIAddedEvent(const std::vector<POIServiceTypes::POI_ID>& pois) {
    stubAdapter_->firePOIAddedEvent(pois);
}
/**
 * POIRemoved = This signal is emitted when a list of POIs and associated content
 *  has been removed from the database.
 */
void POIContentManagerStubDefault::firePOIRemovedEvent(const std::vector<POIServiceTypes::POI_ID>& pois) {
    stubAdapter_->firePOIRemovedEvent(pois);
}


POIContentManagerStubDefault::RemoteEventHandler::RemoteEventHandler(POIContentManagerStubDefault* defaultStub):
        defaultStub_(defaultStub) {
}

} // namespace poiservice
} // namespace navigation
} // namespace genivi
} // namespace org