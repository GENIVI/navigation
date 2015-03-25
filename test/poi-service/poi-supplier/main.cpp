/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file main.cpp
*
* \brief This file is part of the poi proof of concept.
*
* \author Philippe Colliot <philippe.colliot@mpsa.com>
*
* \version 1.1
*
* This Source Code Form is subject to the terms of the
* Mozilla Public License (MPL), v. 2.0.
* If a copy of the MPL was not distributed with this file,
* You can obtain one at http://mozilla.org/MPL/2.0/.
*
* For further information see http://www.genivi.org/.
*
* List of changes:
* 10-02-2014, Philippe Colliot, refinement and migration to the new repository
* <date>, <name>, <description of change>
*
* @licence end@
*/

#include <getopt.h>

#include "poi-common-database.h"

#include "poi-datamodel.h"

#include "raw-file-sort.h"

#ifndef SAFE_DELETE
#define SAFE_DELETE(_p)			{ if ((_p) != NULL) { delete(_p); (_p) = NULL; } }
#endif

#ifndef SAFE_DELETE_LIST
#define SAFE_DELETE_LIST(_p)	{ if ((_p) != NULL) { delete[](_p); (_p) = NULL; } }
#endif

const char* SQL_POI_TABLE_SELECT =  "SELECT Id,name,latitude,longitude,altitude,segment,offset,source,website,phone,stars,openingHours,addrHousenumber,addrStreet,addrPostCode,addrCity FROM poi;";
const char* SQL_POI_TABLE_INSERT =  "INSERT INTO poi VALUES (";
const char* SQL_BELONGSTO_TABLE_INSERT = "INSERT INTO belongsto (Id,poiprovider_Id,poicategory_Id,poi_Id) ";
const char* SQL_POIPROVIDERID_SELECT = "(SELECT Id FROM poiprovider WHERE name='OpenStreetMap')";
const char* SQL_POICATEGORYID_SELECT = "(SELECT Id FROM poicategory WHERE name='";
const char* SQL_POI_MAX_ID = "SELECT MAX(Id) FROM poi;";
const char* program_name; //file to sink outputs


// the third parameter of from_string() should be
// one of std::hex, std::dec or std::oct
template <class T>
bool from_string(T& t, const std::string& s, std::ios_base& (*f)(std::ios_base&))
{
  std::istringstream iss(s);
  return !(iss >> f >> t).fail();
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
  fprintf (stream, "Use: %s options [database] [file] [sort key]\n",program_name);
  fprintf (stream,
           " -h --help               Display this message.\n"
           " -a --add_scheme database scheme     Add sql scheme to database.\n"
           " -v --view database      View database structure.\n"
           " -p --parse_file database file primary=KEY secondary=KEY1,[KEY2,]   Parse file according to sort keys (end with a comma) and update the database.\n"
           " -s --select database      Select poi table to check the database.\n"
           );
  exit (exit_code);
}

/**
 * \fn int main (int  argc , char**  argv)
 * \brief xml parser and POI database provider.
 *
 * \param  int  argc
 * \param  char**  argv
 * \return EXIT_SUCCESS, EXIT_FAILURE.
 */
int main(int  argc , char**  argv )
{
    poi_t poi_buffer[POI_BUFFER_SIZE]; //table to store the POIs
    poiId_t poi_buffer_index; //number of POIs found

    std::string sort_primary_key; //primary key (set as a parameter)
    std::string *sort_list; //list of secondary keys (set as parameters)
    uint8_t sort_list_size; //number of secondary keys

    Database *sqlDatabase; //sqlite3 database
    Glib::ustring sqlQuery; //SQL request on database
    vector<vector<Glib::ustring> > sqlQueryResult; //result of the query on database
    vector<Glib::ustring>  sqlQueryLine;

    std::ostringstream  strStream; //temporary stream used for transformation into string
    poiId_t offset_id; //offset to the next free item in the database

    // Set the global C and C++ locale to the user-configured locale,
    // so we can use std::cout with UTF-8, via Glib::ustring, without exceptions.
    std::locale::global(std::locale(""));

    //index used for argument analysis
    int next_option;
    size_t begin_index;
    size_t end_index;
    size_t key_index;

    /* Valid letters for short options. */
    const char* const short_options = "ha:v:p:s:";
    /* Valid string for long options. */
    const struct option long_options[] = {
        { "help",     0, NULL, 'h' },
        { "add_scheme", 2, NULL, 'a' },
        { "view_structure", 2, NULL, 'v' },
        { "parse_file", 4, NULL, 'p' },
        { "select", 2, NULL, 's' },
        { NULL,       0, NULL, 0   }   /* Always at the end of the table.  */
    };
    char* database_filename = NULL; //database filename passed as argument
    const char* scheme_filename = NULL; //sql scheme filename passed as argument
    const char* xml_filename = NULL; //xml filename passed as argument
    std::string keys = "";
    program_name = argv[0];

    do {
        next_option = getopt_long (argc, argv, short_options,
                                  long_options, NULL);
        switch (next_option)
        {
        case 'h':   /* -h --help */
            print_usage (stdout, 0);
            break;
        case 'a':   /* -a --add_scheme database scheme */
            database_filename = argv[2];
            scheme_filename = argv[3];
            sqlDatabase = new Database(database_filename);
            sqlDatabase->add(scheme_filename);
            sqlDatabase->close();
            delete sqlDatabase;
            break;
        case 'v':   /* -v --view database */
            database_filename = argv[2];
            sqlDatabase = new Database(database_filename);
            sqlDatabase->schema();
            sqlDatabase->close();
            delete sqlDatabase;
            break;
        case 's':   /* -s --select database */
            database_filename = argv[2];
            sqlDatabase = new Database(database_filename);
            sqlQueryResult = sqlDatabase->query(SQL_POI_TABLE_SELECT);
            for(vector<vector<Glib::ustring> >::iterator it = sqlQueryResult.begin(); it < sqlQueryResult.end(); ++it)
            {
                vector<Glib::ustring> row = *it;
                cout << "Values: (Id=" << row.at(0) << ", name=" << row.at(1) << ")" << endl;
            }
            sqlDatabase->close();
            delete sqlDatabase;
            break;
        case 'p': /* -p --parse_file database file primary=KEY secondary=KEY1,[KEY2,] */
            xml_filename = argv[3];
            //get primary key
            keys = argv[4];
            if (keys.find("primary=",0) == string::npos)
                print_usage (stderr, 1); /* Invalid option. */
            begin_index = keys.find("=",0);
            sort_primary_key = keys.substr(begin_index+1,keys.length());
            //get secondary key list
            keys = argv[5];
            if (keys.find("secondary=",0) == string::npos)
                print_usage (stderr, 1); /* Invalid option. */
            keys.erase(0,10); //remove 'secondary=' so 10 char !

            sort_list_size = 0;
            begin_index = 0;
            do
            {
                end_index = keys.find(",",begin_index);
                if (end_index != string::npos)
                {
                    sort_list_size++;
                    begin_index = end_index + 1;
                }
                else
                    break;

            } while(begin_index < keys.length());
            if (sort_list_size == 0)
                print_usage (stderr, 1); /* Invalid option. */

            sort_list = new std::string[sort_list_size];
            key_index = 0;
            begin_index = 0;
            end_index = 0;
            do
            {
                end_index = keys.find(",",begin_index);
                if (end_index != string::npos)
                {
                    sort_list[key_index++] = keys.substr(begin_index,(end_index - begin_index));
                    begin_index = end_index + 1;
                }

            } while(begin_index < keys.length());
            //parse the file
            xml_parser(xml_filename, sort_primary_key, sort_list, sort_list_size, poi_buffer, &poi_buffer_index);
            // database update
            database_filename = argv[2];
            sqlDatabase = new Database(database_filename);
            //get id
            sqlQueryResult = sqlDatabase->query(SQL_POI_MAX_ID);
            sqlQueryLine = sqlQueryResult.at(0);
            if (sqlQueryLine[0] == "")
                offset_id = 0; //table is empty
            else
            {
                from_string<poiId_t>(offset_id,sqlQueryLine[0], std::dec);
                offset_id +=1; //to next free index
            }

            //populate the table
            begin_index = 0;
            while (begin_index < poi_buffer_index)
            {
                sqlDatabase->beginTransaction();

                // prepare statement for the poi table
                // example:INSERT INTO poi VALUES (1,'Palais de la D=Wcouverte',48.8662070,2.3109250,0,27415779,0,'default','http://www.palais-decouverte.fr/','default',0,'Tu-Sa 09:30-18:30; Sa 10:00-19:00; PH 10:00-19:00','default','default',2,'default');
                sqlQuery = SQL_POI_TABLE_INSERT;
                strStream.str("");
                strStream << (begin_index + offset_id);
                sqlQuery += strStream.str();
                sqlQuery += ",'";
                sqlQuery.append(poi_buffer[begin_index].name);
                sqlQuery += "',";
                strStream.str("");
                strStream.precision(7);
                strStream << fixed << poi_buffer[begin_index].node.latitude;
                sqlQuery += strStream.str();
                sqlQuery += ",";
                strStream.str("");
                strStream.precision(7);
                strStream << fixed << poi_buffer[begin_index].node.longitude;
                sqlQuery += strStream.str();
                sqlQuery += ",";
                strStream.str("");
                strStream << poi_buffer[begin_index].altitude;
                sqlQuery += strStream.str();
                sqlQuery += ",";
                strStream.str("");
                strStream << poi_buffer[begin_index].node.segment;
                sqlQuery += strStream.str();
                sqlQuery += ",";
                strStream.str("");
                strStream << poi_buffer[begin_index].offset;
                sqlQuery += strStream.str();
                sqlQuery += ",'";
                sqlQuery.append(poi_buffer[begin_index].source);
                sqlQuery += "','";
                sqlQuery.append(poi_buffer[begin_index].website);
                sqlQuery += "','";
                sqlQuery.append(poi_buffer[begin_index].phone);
                sqlQuery += "',";
                strStream.str("");
                strStream << poi_buffer[begin_index].stars;
                sqlQuery += strStream.str();
                sqlQuery += ",'";
                sqlQuery.append(poi_buffer[begin_index].opening_hours);
                sqlQuery += "','";
                sqlQuery.append(poi_buffer[begin_index].addr_house_number);
                sqlQuery += "','";
                sqlQuery.append(poi_buffer[begin_index].addr_street);
                sqlQuery += "',";
                strStream.str("");
                strStream << poi_buffer[begin_index].addr_postcode;
                sqlQuery += strStream.str();
                sqlQuery += ",'";
                sqlQuery.append(poi_buffer[begin_index].addr_city);
                sqlQuery += "','";
                sqlQuery.append(poi_buffer[begin_index].brand);
                sqlQuery += "','";
                sqlQuery.append(poi_buffer[begin_index].operateur);
                sqlQuery += "');";
                sqlDatabase->appendTransaction(sqlQuery.c_str());

                // prepare statement for the belongsto table
                // example: INSERT INTO belongsto (Id,poiprovider_Id,poicategory_Id,poi_Id)
                //          SELECT (begin_index + offset_id),(SELECT Id FROM poiprovider WHERE name='OpenStreetMap'),(SELECT Id FROM poicategory WHERE name='museum'),(begin_index + offset_id) ;
                // database needs to be populated with poi categories and providers before !
                // to do : preliminary check before the loop !
                sqlQuery = SQL_BELONGSTO_TABLE_INSERT;
                sqlQuery += "SELECT ";
                strStream.str("");
                strStream << (begin_index + offset_id);
                sqlQuery += strStream.str();
                sqlQuery += ",";
                sqlQuery += SQL_POIPROVIDERID_SELECT;
                sqlQuery += ",";
                sqlQuery += SQL_POICATEGORYID_SELECT;
                sqlQuery.append(poi_buffer[begin_index].category);
                sqlQuery += "'),";
                strStream.str("");
                strStream << (begin_index + offset_id);
                sqlQuery += strStream.str();
                sqlQuery += ";";
                sqlDatabase->appendTransaction(sqlQuery.c_str());

                sqlDatabase->commitTransaction(); //execute the transaction

                begin_index++;
            }


            cout << ("Added records= ") << poi_buffer_index << endl;
            sqlDatabase->close();
            delete sqlDatabase;
            delete[] sort_list;
            break;
        case '?':   /* Invalid option. */
            print_usage (stderr, 1);
        case -1:    /* End of options.  */
            break;
        default:    /* Error  */
            return EXIT_FAILURE;
        }
    }
    while (next_option != -1);

    return EXIT_SUCCESS;
}
