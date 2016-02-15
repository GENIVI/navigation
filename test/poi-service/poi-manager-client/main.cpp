/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2015, PCA Peugeot Citroen
*
* \file main.cpp
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

#include <stdbool.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <sys/types.h>
#include <iostream>
#include <cmath>
#include <typeinfo>
#include <getopt.h>
#include <fstream>
#include <gtk/gtk.h>
#include <functional>

#include <CommonAPI/CommonAPI.hpp> //Defined in the Common API Runtime library
#include <v0/org/genivi/navigation/poiservice/POIContentAccessModuleProxy.hpp>

#include "poi-common-data-model.h"

using namespace std;
using namespace v0::org::genivi::navigation;
using namespace poiservice;
using namespace org::genivi::navigation;
using namespace org::genivi;

// class  contentManager
class  contentManager
{

public:

    contentManager(std::shared_ptr<POIContentAccessModuleProxyDefault> proxy);

    ~contentManager();

    void getServerStatus();

    void ConfigurationChanged(const std::vector< uint16_t >& changedSettings);

    void CategoriesRemoved(const std::vector< CommonTypes::CategoryID >& categories);

    void POIAdded(const std::vector< POIServiceTypes::POI_ID >& pois);

    void POIRemoved(const std::vector< POIServiceTypes::POI_ID >& pois);

    void SearchStatusChanged(const NavigationTypes::Handle &handle, const POIServiceTypes::SearchStatusState &searchStatusState, const std::vector<POIServiceTypes::POI_ID> &pois);

    void connectPopupWindow(GtkWidget *window);

    void testCreateCategory();

    void testRemoveCategory();

    void testCreatePOI();

    void testRemovePOI();

    void testSearch();

    void createCategory(const CommonTypes::CategoryID& category);

    void dumpCategories();

    void dumpLocales();

private:

    GtkWidget *mp_popupWindow;
    std::shared_ptr<POIContentAccessModuleProxyDefault> mp_proxy;
    POIServiceTypes::CAMCategory m_category;
    CommonTypes::CategoryID m_category_id;
    std::vector<CommonTypes::CategoryID> m_category_ids;
    std::vector<POIServiceTypes::POI_ID> m_poi_ids;
    POIServiceTypes::PoiAddedDetails m_poi;
    NavigationTypes::Locale m_locales;

    std::string m_strTest;
};

static contentManager *clientContentManager;

contentManager::contentManager(std::shared_ptr<POIContentAccessModuleProxyDefault> proxy)
{
    // test: create a new category, with a new attribute and add a poi under this category
    POIServiceTypes::Details categoryDetails;
    std::vector<CommonTypes::CategoryID> categoryParentsIDList;
    POIServiceTypes::Icon categoryIcons(std::string(ICON_URL));
    POIServiceTypes::Media categoryMedia(std::string(""));

    POIServiceTypes::CategoryAttribute categoryAttribute;
    POIServiceTypes::Operator categoryOperator;
    POIServiceTypes::AttributeValue categoryOperatorAttributeValue(int32_t(0));
    std::vector<POIServiceTypes::Operator> categoryOperatorList;

    std::vector<POIServiceTypes::CategoryAttribute> categoryAttributeList;

    POIServiceTypes::CategorySortOption categorySortOption;
    std::vector<POIServiceTypes::CategorySortOption> categorySortOptionList;

    POIServiceTypes::PoiAttribute poiAttribute;
    std::vector<POIServiceTypes::PoiAttribute> poiAttributeList;
    NavigationTypes::Coordinate3D location;

    mp_proxy = proxy;

    categoryParentsIDList.clear();
    categoryParentsIDList.push_back(PARENT_ID);
    categoryDetails.setParentsId(categoryParentsIDList);
    categoryDetails.setIcons(categoryIcons);
    categoryDetails.setName(NEW_CATEGORY_NAME);
    categoryDetails.setShortDesc("");
    categoryDetails.setMedia(categoryMedia);
    m_category.setDetails(categoryDetails);              //new category

    categoryAttributeList.clear();
    categoryAttribute.setId(ATTRIBUTE_PHONE);
    categoryAttribute.setName(ATTRIBUTE_PHONE_NAME);   //existing attribute
    categoryAttribute.setType(POIServiceTypes::AttributeType::INTEGER);
    categoryOperator.setName("");
    categoryOperator.setType(POIServiceTypes::OperatorType::EQUAL);
    categoryOperator.setValue(categoryOperatorAttributeValue);
    categoryOperatorList.push_back(categoryOperator);
    categoryAttribute.setOperators(categoryOperatorList);
    categoryAttributeList.push_back(categoryAttribute);    
    categoryAttribute.setId(ATTRIBUTE_CREDIT_CARD);      //new attribute id
    categoryAttribute.setName(ATTRIBUTE_CREDIT_CARD_NAME);  //new attribute
    categoryAttribute.setType(POIServiceTypes::AttributeType::INTEGER);
    categoryOperator.setName("");
    categoryOperator.setType(POIServiceTypes::OperatorType::EQUAL);
    categoryOperator.setValue(categoryOperatorAttributeValue);
    categoryOperatorList.push_back(categoryOperator);
    categoryAttribute.setOperators(categoryOperatorList);
    categoryAttributeList.push_back(categoryAttribute);
    m_category.setAttributeList(categoryAttributeList);

    categorySortOption.setId(POIServiceTypes::SortOption::SORT_DEFAULT);
    categorySortOption.setName("");
    categorySortOptionList.push_back(categorySortOption);
    m_category.setSortOptions(categorySortOptionList);

    m_poi.setName(POI_NAME);

    location.setLatitude(POI_LOCATION_LATITUDE);
    location.setLongitude(POI_LOCATION_LONGITUDE);
    location.setAltitude(POI_LOCATION_ALTITUDE);
    m_poi.setLocation(location);

    poiAttributeList.clear();
    poiAttribute.setId(ATTRIBUTE_ADDRCITY);
    poiAttribute.setType(POIServiceTypes::AttributeType::BOOLEAN);
    POIServiceTypes::AttributeValue vs(string(NEW_CITY_NAME));
    poiAttribute.setValue(vs);
    poiAttributeList.push_back(poiAttribute);
    poiAttribute.setId(ATTRIBUTE_STARS);
    poiAttribute.setType(POIServiceTypes::AttributeType::BOOLEAN);
    POIServiceTypes::AttributeValue v(NEW_STARS_VALUE);
    poiAttribute.setValue(v);
    poiAttributeList.push_back(poiAttribute);
    m_poi.setAttributeList(poiAttributeList);

    // init of the data test for search string
    m_strTest = SEARCH_STRING;

    m_category_id = INVALID_CATEGORY;

    m_locales.setLanguageCode(LANGUAGE_CODE);
    m_locales.setCountryCode(COUNTRY_CODE);
    m_locales.setScriptCode(SCRIPT_CODE);

    m_category_ids.clear(); //list empty for the moment

    m_poi_ids.clear(); //list empty for the moment

}

contentManager::~contentManager()
{
}

static void getVersionAsyncCallback(const CommonAPI::CallStatus& callStatus, const CommonTypes::Version& version)
{
    if (callStatus != CommonAPI::CallStatus::SUCCESS) {
        cout << "Remote getVersion failed with status: " << static_cast<std::underlying_type<CommonAPI::CallStatus>::type>(callStatus) << endl;
        return;
    }

    cout << "Version " << version.getVersionMajor() << "." << version.getVersionMinor() << "." << version.getVersionMicro() << endl;
    cout << "Date " << version.getDate() << endl;
}

void contentManager::getServerStatus()
{
    function<void(const CommonAPI::CallStatus&, const CommonTypes::Version&)> getVersion = getVersionAsyncCallback;
    CommonAPI::CallStatus callStatus;

    mp_proxy->getVersionAsync(getVersionAsyncCallback);

    dumpLocales();

    mp_proxy->setLocale(m_locales.getLanguageCode(),m_locales.getCountryCode(),m_locales.getScriptCode(),callStatus);

    cout << "Change locales" << endl;

    dumpLocales();

    dumpCategories();

}

void contentManager::ConfigurationChanged(const std::vector< uint16_t >& changedSettings)
{
    size_t index;

    cout << "Configuration changed:  ";
    for(index=0;index<changedSettings.size();index++)
    {
        cout << changedSettings.at(index);
        cout << endl;
    }
}

void contentManager::CategoriesRemoved(const std::vector<CommonTypes::CategoryID> &categories)
{
    size_t index;

    for(index=0;index<categories.size();index++)
    {
        if (m_category_id == categories.at(index))
        {
            m_category_id = INVALID_CATEGORY;
            cout << "Category " << categories.at(index) << " removed" << endl;
        }
    }

    dumpCategories();
}

void contentManager::POIAdded(const std::vector<POIServiceTypes::POI_ID> &pois)
{
    size_t index;

    m_poi_ids.clear();
    for(index=0;index<pois.size();index++)
    {
        cout << "POI " << pois.at(index) << " added" << endl;
        m_poi_ids.push_back(pois.at(index));
    }
}

void contentManager::POIRemoved(const std::vector<POIServiceTypes::POI_ID> &pois)
{
    size_t index;

    for(index=0;index<pois.size();index++)
    {
        cout << "POI " << pois.at(index) << " removed" << endl;
    }

}

void contentManager::SearchStatusChanged(const NavigationTypes::Handle &handle, const POIServiceTypes::SearchStatusState &searchStatusState, const std::vector<POIServiceTypes::POI_ID> &pois)
{
    size_t index;

    if(handle == SEARCH_HANDLE)
    {
        cout << "Search state " << searchStatusState << endl;
        if(searchStatusState == POIServiceTypes::SearchStatusState::FINISHED)
        {
            cout << "Result list size " << pois.size() << endl;
            if(pois.size()>0)
            {
                for(index=0;index<pois.size();index++)
                {
                    cout << "POI id "  << pois.at(index) << endl;
                }
            }
        }
    }
}

void contentManager::connectPopupWindow(GtkWidget *window)
{
    mp_popupWindow = window;
}

static void createCategoryAsyncCallback(const CommonAPI::CallStatus& callStatus, const CommonTypes::CategoryID& categoryID)
{
    if (callStatus != CommonAPI::CallStatus::SUCCESS) {
        cout << "Remote createCategory failed with status: " << static_cast<std::underlying_type<CommonAPI::CallStatus>::type>(callStatus) << endl;
        return;
    }

    cout << "Category " << categoryID << " created" << endl;

    clientContentManager->createCategory(categoryID);

    clientContentManager->dumpCategories();
}

void contentManager::createCategory(const CommonTypes::CategoryID& category)
{
    m_category_id = category;
}

void contentManager::dumpCategories()
{
    std::vector<POIServiceTypes::CategoryAndName> categories;
    CommonAPI::CallStatus callStatus;
    size_t index;

    mp_proxy->getAvailableCategories(callStatus,categories);

    for(index=0;index<categories.size();index++)
    {
        cout << "id: " << categories.at(index).getUniqueId() << " name: " << categories.at(index).getName() << " top level: " << categories.at(index).getTopLevel() << endl;
    }
}

void contentManager::dumpLocales()
{
    std::string languageCode, countryCode, scriptCode;
    CommonAPI::CallStatus callStatus;

    mp_proxy->getLocale(callStatus,languageCode,countryCode,scriptCode);

    cout << "languageCode: " << languageCode << " " << "countryCode: " << countryCode << " " << "scriptCode: " << scriptCode << " " << endl;
}

void contentManager::testCreateCategory()
{
    function<void(const CommonAPI::CallStatus&, const CommonTypes::CategoryID&)> fcb = createCategoryAsyncCallback;

    mp_proxy->createCategoryAsync(m_category,createCategoryAsyncCallback);

}

void contentManager::testRemoveCategory()
{
    std::vector<CommonTypes::CategoryID> categories;
    CommonAPI::CallStatus status;

    categories.push_back(m_category_id);

    mp_proxy->removeCategories(categories,status);
}

void contentManager::testCreatePOI()
{
    std::vector<POIServiceTypes::PoiAddedDetails> poiList;
    CommonAPI::CallStatus status;

    poiList.push_back(m_poi);
    mp_proxy->addPOIs(m_category_id,poiList,status);
}

void contentManager::testRemovePOI()
{
    CommonAPI::CallStatus status;

    mp_proxy->removePOIs(m_poi_ids,status);
}

void contentManager::testSearch()
{
    NavigationTypes::Coordinate3D location;
    POIServiceTypes::AttributeDetails attributeDetails;
    std::vector<POIServiceTypes::AttributeDetails> poiAttributes;
    POIServiceTypes::CategoryAndRadius categoryAndRadius;
    std::vector<POIServiceTypes::CategoryAndRadius> poiCategories;
    CommonAPI::CallStatus status;

    location.setLatitude(SEARCH_CENTER_LOCATION_LATITUDE);
    location.setLongitude(SEARCH_CENTER_LOCATION_LONGITUDE);
    location.setAltitude(SEARCH_CENTER_LOCATION_ALTITUDE);

    poiCategories.clear();
    categoryAndRadius.setId(m_category_id);
    categoryAndRadius.setRadius(SEARCH_RADIUS);
    poiCategories.push_back(categoryAndRadius);

    attributeDetails.setCategoryId(m_category_id);
    attributeDetails.setId(ATTRIBUTE_ADDRCITY);
    poiAttributes.push_back(attributeDetails);

    mp_proxy->poiSearchStarted(SEARCH_HANDLE,SEARCH_MAX_SIZE,location,poiCategories,poiAttributes,SEARCH_STRING,POIServiceTypes::SortOption::ATTRIBUTE_CUSTOM,status);
}

const char* program_name; //file to sink outputs

/**
 * \fn is_readable (const std::string & file)
 * \brief Check if file can be opened.
 *
 * \param  const std::string & file	-name of the file
 * \return true if file readable.
 */
bool is_readable( const std::string & file )
{
    std::ifstream fi( file.c_str() );
    return !fi.fail();
}

static void popupMessage( GtkWidget *widget,
                      gpointer   data )
{
    g_print ("Message:  %s \n", (gchar *) data);
}

static gboolean deleteWindow( GtkWidget *widget,
                              GdkEvent  *event,
                              gpointer   data )
{
    gtk_main_quit ();
    g_print ("poi manager client closed\n");
    return FALSE;
}

static void onCreateCategory( GtkWidget *widget,
                      contentManager *clientContentManager )
{
    clientContentManager->testCreateCategory();
}

static void onDeleteCategory( GtkWidget *widget,
                      contentManager *clientContentManager )
{
    clientContentManager->testRemoveCategory();
}

static void onCreatePoi( GtkWidget *widget,
                      contentManager *clientContentManager )
{
    clientContentManager->testCreatePOI();
}

static void onDeletePoi( GtkWidget *widget,
                      contentManager *clientContentManager )
{
    clientContentManager->testRemovePOI();
}

static void onSearch( GtkWidget *widget,
                      contentManager *clientContentManager )
{
    clientContentManager->testSearch();
}

void populateWindow(GtkWidget *window,contentManager *clientContentManager)
{
    GtkWidget *button;
    GtkWidget *box;

    gtk_window_set_title (GTK_WINDOW (window), "Poi Manager Client");

    g_signal_connect (window, "delete-event",
              G_CALLBACK (deleteWindow), NULL);

    gtk_container_set_border_width (GTK_CONTAINER (window), 10);

    box = gtk_box_new(GTK_ORIENTATION_HORIZONTAL,5);

    gtk_container_add (GTK_CONTAINER (window), box);

    button = gtk_button_new_with_label ("Create category");

    g_signal_connect (button, "clicked",
              G_CALLBACK (onCreateCategory), clientContentManager);

    gtk_box_pack_start (GTK_BOX(box), button, TRUE, TRUE, 0);

    gtk_widget_show (button);

    button = gtk_button_new_with_label ("Delete category");

    g_signal_connect (button, "clicked",
              G_CALLBACK (onDeleteCategory), clientContentManager);

    gtk_box_pack_start(GTK_BOX (box), button, TRUE, TRUE, 0);

    gtk_widget_show (button);

    gtk_widget_show (box);

    button = gtk_button_new_with_label ("Create POI");

    g_signal_connect (button, "clicked",
              G_CALLBACK (onCreatePoi), clientContentManager);

    gtk_box_pack_start (GTK_BOX(box), button, TRUE, TRUE, 0);

    gtk_widget_show (button);

    button = gtk_button_new_with_label ("Delete POI");

    g_signal_connect (button, "clicked",
              G_CALLBACK (onDeletePoi), clientContentManager);

    gtk_box_pack_start(GTK_BOX (box), button, TRUE, TRUE, 0);

    gtk_widget_show (button);

    button = gtk_button_new_with_label ("Search");

    g_signal_connect (button, "clicked",
              G_CALLBACK (onSearch), clientContentManager);

    gtk_box_pack_start (GTK_BOX(box), button, TRUE, TRUE, 0);

    gtk_widget_show (button);

    gtk_widget_show (box);

    gtk_widget_show (window);
}

/**
 * \fn print_usage (FILE* stream, int exit_code)
 * \brief Display the available options.
 *
 * \param  const FILE* stream	-name of stream to use
 * \param  int exit_code	-exit code
 * \return void.
 */
void print_usage (FILE* stream, int exit_code)
{
  fprintf (stream, "Use: %s options [database]\n",program_name);
  fprintf (stream,
           " -h --help               Display this message.\n"
           " -f --file database      Open the database.\n"
           " -t --test               Test.\n");
  exit (exit_code);
}

/**
 * \fn int main (int  argc , char**  argv)
 * \brief POI content manager  implements the component of POI Service "POIContentManager" to add/remove poi.
 *
 * \param  int  argc
 * \param  char**  argv
 * \return EXIT_SUCCESS, EXIT_FAILURE.
 */
int main(int  argc , char**  argv )
{
    GtkWidget *window;

    // Set the global C and C++ locale to the user-configured locale,
    // so we can use std::cout with UTF-8, via Glib::ustring, without exceptions.
    std::locale::global(std::locale(""));

    std::shared_ptr < CommonAPI::Runtime > runtime = CommonAPI::Runtime::get();

    const std::string &domain = "local";
    const std::string &instance = "POIContentManager";

    std::shared_ptr<POIContentAccessModuleProxyDefault> myProxy = runtime->buildProxy<POIContentAccessModuleProxy>(domain,instance);

    while (!myProxy->isAvailable()) {
        usleep(10);
    }
    cout << "poi manager client started" << endl;

    //index used for argument analysis
    int next_option;

    /* Valid letters for short options. */
    const char* const short_options = "htf:";
    /* Valid string for long options. */
    const struct option long_options[] = {
        { "help",     0, NULL, 'h' },
        { "test",     0, NULL, 't' },
        { "file",     2, NULL, 'f' },
        { NULL,       0, NULL, 0   }   /* Always at the end of the table.  */
    };
    char* database_filename = NULL; //database filename passed as first argument
    program_name = argv[0];

    do {
        next_option = getopt_long (argc, argv, short_options,
                                  long_options, NULL);
        switch (next_option)
        {
        case 'h':   /* -h --help */
            print_usage (stdout, 0);
            break;
        case 't':   /* -t --test */

            // create a client for ContentManager
            clientContentManager = new contentManager(myProxy);

            // Create the interface panel
            gtk_init (&argc, &argv);

            // Create a new window
            window = gtk_window_new (GTK_WINDOW_TOPLEVEL);

            // Connect the client to the popup window (for feedback on signals)
            clientContentManager->connectPopupWindow(window);

            // Populate the window and connect it to the client (for commands)
            populateWindow(window,clientContentManager);

            // Connect the DBus signals
            myProxy->getCategoriesRemovedEvent().subscribe([&](const std::vector<CommonTypes::CategoryID>& categories) {
                clientContentManager->CategoriesRemoved(categories);
            });
            myProxy->getConfigurationChangedEvent().subscribe([&](const std::vector< uint16_t >& changedSettings) {
                clientContentManager->ConfigurationChanged(changedSettings);
            });
            myProxy->getPOIAddedEvent().subscribe([&](const std::vector< POIServiceTypes::POI_ID >& pois) {
                clientContentManager->POIAdded(pois);
            });
            myProxy->getPOIRemovedEvent().subscribe([&](const std::vector< POIServiceTypes::POI_ID >& pois) {
                clientContentManager->POIRemoved(pois);
            });
            myProxy->getSearchStatusChangedEvent().subscribe([&](const NavigationTypes::Handle handle, const POIServiceTypes::SearchStatusState searchStatusState, const std::vector< POIServiceTypes::POI_ID >& pois ) {
                clientContentManager->SearchStatusChanged(handle,searchStatusState,pois);
            });

            // Send a feedback to the user
            cout << "poi manager client started" << endl;

            // Get server status
            clientContentManager->getServerStatus();

            // loop listening
            gtk_main();

            break;
        case 'f':   /* -f --file database*/
            database_filename = argv[2];
            if (!is_readable(database_filename))
                print_usage (stderr, 1);
            else
            {
                // Manage the database content
                cout << "Not implemented yet" << endl;
            }
            break;
        case '?':   /* Invalid option. */
            print_usage (stderr, 1);
            break;
        case -1:    /* End of options.  */
            break;
        default:    /* Error  */
            print_usage (stderr, 1);
        }
    }
    while (next_option != -1);

    return EXIT_SUCCESS;
}
