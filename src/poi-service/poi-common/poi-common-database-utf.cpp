/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file poi-common-database-utf.cpp
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
#include "poi-common-database-utf.h"
#include <stdio.h>
#include <iostream>

/**
 * \fn Database(const char* filename)
 * \brief Constructor.
 *
 * \param  const char* filename	-name of the database file to open
 * \return void.
 */
DatabaseUTF::DatabaseUTF(const char* filename)
{
	database = NULL;
    open(filename); //no check for valid file
	m_filename = filename;
}

/**
 * \fn ~Database()
 * \brief Destructor.
 *
 * \param
 * \return void.
 */
DatabaseUTF::~DatabaseUTF()
{
}

/**
 * \fn open(const char* filename)
 * \brief Open the database.
 *
 * \param  const char* filename -name of the database file to open
 * \return bool. -true if database consistant
 */
bool DatabaseUTF::open(const char* filename)
{
    if(sqlite3_open(filename, &database) == SQLITE_OK)
        return true;
         
    return false;  
}

/**
 * \fn schema()
 * \brief Get the scheme of the database.
 *
 * \param
 * \return bool. -true if SQL command succeed
 */
bool DatabaseUTF::schema()
{
	FILE *fpipe;
	std::string command = "";
	command += "sqlite3 ";
	command += m_filename;
	command += " \"";
	command += ".schema";
	command += "\"";
	
	char line[256];
	
	if ( !(fpipe = (FILE*)popen(command.c_str(),"r")) )
	{  // If fpipe is NULL
		perror("Problems with pipe");
    	return false;  
	}
	 
	while ( fgets( line, sizeof line, fpipe))
	{
		printf("%s", line);
	}
	pclose(fpipe);

	return true;         
}

/**
 * \fn add(const char* scheme_filename)
 * \brief Add a scheme to the database.
 *
 * \param  const char* scheme_filename -filename that contains the scheme
 * \return bool. -true if SQL command succeed
 */
bool DatabaseUTF::add(const char* scheme_filename)
{
	FILE *fpipe;
	std::string command = "";
	command += "sqlite3 ";
	command += m_filename;
    command = command + " < " + scheme_filename;

	char line[256];
	 
	if ( !(fpipe = (FILE*)popen(command.c_str(),"r")) )
	{  // If fpipe is NULL
		perror("Problems with pipe");
    	return false;  
	}
	 
	while ( fgets( line, sizeof line, fpipe))
	{
		printf("%s", line);
	}
	pclose(fpipe);

	return true;         	
}

/**
 * \fn beginTransaction()
 * \brief Begin a SQL transaction.
 *
 * \param
 * \return void
 */
void DatabaseUTF::beginTransaction()
{
    char* errorMessage;
    sqlite3_exec(database, "BEGIN TRANSACTION;", NULL, NULL, &errorMessage);
}

/**
 * \fn appendTransaction(const char* query)
 * \brief Append a SQL request.
 *
 * \param const char* query -SQL request
 * \return void
 */
void DatabaseUTF::appendTransaction(const char* query)
{
	sqlite3_exec(database, query, NULL, NULL, NULL);
}

/**
 * \fn commitTransaction()
 * \brief Commit a SQL transaction.
 *
 * \param
 * \return void
 */
void DatabaseUTF::commitTransaction()
{
	char* errorMessage;
	sqlite3_exec(database, "COMMIT;", NULL, NULL, &errorMessage);
}

/**
 * \fn query(const char* query)
 * \brief Query a SQL request.
 *
 * \param const char* query -SQL request
 * \return vector<vector<Glib::ustring> > -Result of the query
 */
vector<vector<Glib::ustring> > DatabaseUTF::query(const char* query)
{
    sqlite3_stmt *statement;
    vector<vector<Glib::ustring> > results;

    if(sqlite3_prepare_v2(database, query, -1, &statement, 0) == SQLITE_OK)
    {
        int cols = sqlite3_column_count(statement);
        int result = 0;
        while(true)
        {
            result = sqlite3_step(statement);

            if(result == SQLITE_ROW)
            {
                vector<Glib::ustring> values;
                for(int col = 0; col < cols; col++)
                {
                    Glib::ustring  val;
                    char * ptr = (char*)sqlite3_column_text(statement, col);
                    if(ptr)
                    {
                        val = ptr;
                    }
                    else val = ""; // this can be commented out since std::string  val;
                    values.push_back(val);  // now we will never push NULL
                }
                results.push_back(values);
            }
            else
            {
                break;
            }
        }

        sqlite3_finalize(statement);
    }

    string error = sqlite3_errmsg(database);
    if(error != "not an error") cout << query << " " << error << endl;
        return results;
}

/**
 * \fn close()
 * \brief Close the database.
 *
 * \param
 * \return void
 */
void DatabaseUTF::close()
{
    sqlite3_close(database);  
}

/**
 * \fn callback(void *NotUsed, int argc, char **argv, char **azColName)
 * \brief Call back function for database access.
 *
 * \param void *NotUsed
 * \param int argc
 * \param char **argv
 * \param char **azColName
 * \return int
 */
int DatabaseUTF::callback(void *NotUsed, int argc, char **argv, char **azColName)
{
	NotUsed=0;
	int i;
	for(i=0; i<argc; i++){
	printf("%s = %s\n", azColName[i], argv[i] ? argv[i]: "NULL");
	}
	printf("\n");
	return 0;
}


