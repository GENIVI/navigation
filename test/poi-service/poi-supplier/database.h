/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file database.h
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

#ifndef __DATABASE_H__
#define __DATABASE_H__
	 
#include <string>
#include <vector>
#include <sqlite3.h>
#include <glibmm/ustring.h>


using namespace std;
	 
class Database
{
	public:
		Database(char* filename);
	    ~Database();
	     
	    bool open(char* filename);
		bool schema();
		bool add(const char* scheme_filename); 
        vector<vector<Glib::ustring> > query(const char* query);
	    void close();
		void beginTransaction();
		void appendTransaction(const char* query);
		void commitTransaction();
	     
	private:
		static int callback(void *NotUsed, int argc, char **argv, char **azColName);
	    sqlite3 *database;
		std::string m_filename;
};
	 
#endif
