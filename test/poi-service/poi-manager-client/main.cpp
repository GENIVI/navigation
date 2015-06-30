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


#include "genivi-poiservice-contentmanager_proxy.h"
#include "genivi-poiservice-constants.h"

#include <dbus-c++/glib-integration.h>

#include "poi-common-dbus-data-model-new-variant.h"

static const char* contentManager_OBJECT_PATH = "/org/genivi/poiservice/POIContentManager";
static const char* contentManager_SERVICE_NAME = "org.genivi.poiservice.POIContentManager";

using namespace DBus;
using namespace std;
using namespace org::genivi::poiservice;

// DBus instances
static DBus::Glib::BusDispatcher *dispatcher;
static DBus::Connection *dbusConnection;

// class  contentManager
class  contentManager
: public org::genivi::poiservice::POIContentManager_proxy,
  public DBus::IntrospectableProxy,
  public DBus::ObjectProxy
{

public:

    contentManager(DBus::Connection &connection);

    ~contentManager();

    void ConfigurationChanged(const std::vector< uint16_t >& changedSettings);

    void CategoriesRemoved(const std::vector< uint32_t >& categories);

    void POIAdded(const std::vector< uint32_t >& pois);

    void POIRemoved(const std::vector< uint32_t >& pois);

    void connectPopupWindow(GtkWidget *window);

    void testCreateCategory();

    void testRemoveCategory();

    void testCreatePOI();

    void testRemovePOI();

    void testSearch();

private:

    GtkWidget *mp_popupWindow;
    DBus_CAMcategory m_category;
    categoryId_t m_category_id;
    poiId_t m_poi_id;
    DBus_PoiAddedDetails m_poi;
    DBus_geoCoordinate3D m_left_bottom_location,m_right_top_location;
    std::string m_strTest;
};

static contentManager *clientContentManager;

contentManager::contentManager(DBus::Connection &connection)
    : DBus::ObjectProxy(connection, contentManager_OBJECT_PATH, contentManager_SERVICE_NAME)
{
    DBus_poiAttribute::poiAttribute_t poi_attribute;
    DBus_categoryAttribute::categoryAttribute_t category_attribute;   
    DBus_CAMcategory::CAMcategory_t category;
    DBus_PoiAddedDetails::PoiAddedDetails_t poi;
    DBus_geoCoordinate3D::geoCoordinate3D_t left_bottom_location,right_top_location;

    // init of data test for category
    category = m_category.get();
    category.details.name = "recreation";               //new category

    category_attribute.id = ATTRIBUTE_PHONE;
    category_attribute.name = "phone";                  //existing attribute
    category_attribute.type = GENIVI_POISERVICE_STRING;
    category.attributes.push_back(category_attribute);

    category_attribute.id = ATTRIBUTE_CREDIT_CARD;      //new attribute id
    category_attribute.name = "credit card";            //new attribute
    category_attribute.type = GENIVI_POISERVICE_STRING;
    category.attributes.push_back(category_attribute);

    category.details.parents_id.push_back(0);

    m_category.set(category);

    // init of data test for poi
    poi = m_poi.get();
    poi.name = POI_NAME;

    poi.location.altitude = 120;
    poi.location.latitude = 48.779839;
    poi.location.longitude = 2.217260;

    poi_attribute.id = ATTRIBUTE_ADDRCITY;
    std::string vs(string("Velizy"));
    poi_attribute.value.index = DBus_variantAttributeValue::AS_STRING;
    poi_attribute.value.content.stringValue = vs;
    poi.attributes.push_back(poi_attribute);

    poi_attribute.id = ATTRIBUTE_STARS;
    std::string v("5");
    poi_attribute.value.index = DBus_variantAttributeValue::AS_STRING;
    poi_attribute.value.content.stringValue = v;
    poi.attributes.push_back(poi_attribute);

    m_poi.set(poi);

    // init of data test for location
    left_bottom_location = m_left_bottom_location.get();
    right_top_location = m_right_top_location.get();
    left_bottom_location.latitude = 48.76;
    left_bottom_location.longitude = 2.22;
    right_top_location.latitude = 48.78;
    right_top_location.longitude = 2.20;

    m_left_bottom_location.set(left_bottom_location);
    m_right_top_location.set(right_top_location);

    // initi of the data test for search string
    m_strTest = SEARCH_STRING;

}

contentManager::~contentManager()
{
}

void contentManager::ConfigurationChanged(const std::vector< uint16_t >& changedSettings)
{
    size_t index;

    cout << "ConfigurationChanged";
    for(index=0;index<changedSettings.size();index++)
    {
        cout << changedSettings.at(index);
    }
    cout << endl;
}

void contentManager::CategoriesRemoved(const std::vector< uint32_t >& categories)
{
    size_t index;

    cout << "Categories Removed" << endl;
    for(index=0;index<categories.size();index++)
    {
        cout << "Id: " << categories.at(index) << endl;
    }
}

void contentManager::POIAdded(const std::vector< uint32_t >& pois)
{
    size_t index;

    cout << "POI Added"  << endl;
    for(index=0;index<pois.size();index++)
    {
        cout << "Id: " << pois.at(index)  << endl;
    }
}

void contentManager::POIRemoved(const std::vector< uint32_t >& pois)
{
    size_t index;

    cout << "POI Removed" << endl;
    for(index=0;index<pois.size();index++)
    {
        cout << "Id: " << pois.at(index) << endl;
    }
}

void contentManager::connectPopupWindow(GtkWidget *window)
{
    mp_popupWindow = window;
}

void contentManager::testCreateCategory()
{
    m_category_id = createCategory(m_category.getDBus());
    cout << "Category Created" << endl << "Id: " << m_category_id << endl;

}

void contentManager::testRemoveCategory()
{
    std::vector<categoryId_t> categories;
    categories.push_back(m_category_id);

    removeCategories(categories);
}

void contentManager::testCreatePOI()
{

}

void contentManager::testRemovePOI()
{

}

void contentManager::testSearch()
{
    std::vector<poiId_t> poi_id_list;

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
            // creating the dispatcher
            dispatcher = new DBus::Glib::BusDispatcher();
            DBus::default_dispatcher = dispatcher;
            dispatcher->attach(NULL);

            // create a connection on the session bus
            dbusConnection = new DBus::Connection(DBus::Connection::SessionBus());
            dbusConnection->setup(dispatcher);

            // create a client for ContentManager
            clientContentManager = new contentManager(*dbusConnection);

            // Create the interface panel
            gtk_init (&argc, &argv);

            // Create a new window
            window = gtk_window_new (GTK_WINDOW_TOPLEVEL);

            // Connect the dbus client to the popup window (for feedback on signals)
            clientContentManager->connectPopupWindow(window);

            // Populate the window and connect it to the dbus client (for commands)
            populateWindow(window,clientContentManager);

            // Send a feedback to the user
            cout << "poi manager client started" << endl;

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
        case -1:    /* End of options.  */
            break;
        default:    /* Error  */
            print_usage (stderr, 1);
        }
    }
    while (next_option != -1);

    return EXIT_SUCCESS;
}
