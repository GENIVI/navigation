/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file raw-file-sort.cpp
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

#include "poi-datamodel.h"
#include "raw-file-sort.h"

/**
 * \def std::string toString(const T& t)
 * \brief Macro to move into a string.
 * \param numeric value
*/
template<class T>
    std::string toString(const T& t)
{
     std::ostringstream stream;
     stream << t;
     return stream.str();
}

/**
 * \def std::string toString(const T& t)
 * \brief Macro to move into a numeric value.
 * \param string
 * the third parameter of from_string() should be one of std::hex, std::dec or std::oct
 * 
*/
template <class T>
bool from_string(T& t, 
                 const Glib::ustring& s,
                 std::ios_base& (*f)(std::ios_base&))
{
  std::istringstream iss(s);
  return !(iss >> f >> t).fail();
}

void clear_string(Glib::ustring* str)
{
    std::string::size_type index = 0;
    /*
    while ((index = str->find('\'', index)) != std::string::npos)
    {
        str->replace(index++, 1, "\"");
    }
    */
}

/**
 * \fn void xml_parser (Glib::ustring file_to_parse, std::string sort_primary_key, std::string* sort_list, uint8_t sort_list_size, poi_t* poi_buffer,uint16_t* poi_buffer_index)
 * \brief Function to parse and extract the POI from an xml file.
 *
 * \param Glib::ustring file_to_parse 	-Name of the file to parse
 * \param std::string sort_primary_key	-Primary key to find (e.g. "tourism")
 * \param std::string* sort_list		-List of secondary keys to find (e.g. "museum" or "hotel")
 * \param uint8_t sort_list_size		-Number of secondary keys to find
 * \param poi_t* poi_buffer				-Buffer of poi populated by the function
 * \param uint16_t* poi_buffer_index	-Number of poi found
 * \return void.
 */
void xml_parser(Glib::ustring file_to_parse, std::string sort_primary_key, std::string* sort_list, uint8_t sort_list_size, poi_t* poi_buffer,poiId_t* poi_buffer_index)
{
	geo_node_t geo_node_buffer[GEO_NODE_BUFFER_SIZE]; // table to store the geo locations, for the time being, all the lat lon node are stored
	uint16_t geo_node_buffer_index = 0; //index of the next free row in the geo_node_buffer

	uint64_t node_buffer[NODE_BUFFER_SIZE]; // table to store the nd id
	uint16_t node_buffer_index = 0; //index of the next free row in the node_buffer
	
	geo_node_t node; //temporary geo node
	poi_t poi; //temporary poi
	INIT_DEFAULT_POI(node,poi); //set the node and the poi to default value (in case of missing fields into the xml file)

	*poi_buffer_index = 0; //for the moment, no poi into the buffer
	
	uint16_t sort_index = 0; //generic index

	//booleans used for content analysis
	bool is_a_geo_node = false; // true when something like that appears: <node id="1426135889" lat="48.8829411" lon="2.3077935"> or />
	bool is_a_way = false; 	// true when something like that appears: <way id="68353844">
	bool is_primary_key_found = false; //true when primary key found
	bool is_sort_key_found = false; //true when the keys are found
	bool is_a_poi_name = false; //true when something like that appears: <tag k="name" v="xxxx"/>
	bool is_a_poi_phone = false; //true when something like that appears: <tag k="phone" v="xxxx"/>
	bool is_a_poi_website = false; //true when something like that appears: <tag k="website" v="xxxx"/>
    bool is_a_poi_stars = false; //true when something like that appears: <tag k="stars" v="x"/>
	bool is_a_poi_source = false; //true when something like that appears: <tag k="source" v="xxxx"/>
    bool is_a_poi_opening_hours = false; //true when something like that appears: <tag k="opening_hours" v="Mo-Sa 10:00-19:15"/>
    bool is_a_poi_addr_house_number = false; //true when something like that appears: <tag k="addr:housenumber" v="139"/>
    bool is_a_poi_addr_street = false; //true when something like that appears: <tag k="addr:street" v="Boulevard Voltaire"/>
    bool is_a_poi_addr_postcode = false; //true when something like that appears: <tag k="addr:postcode" v="94410"/>
    bool is_a_poi_addr_city = false; //true when something like that appears: <tag k="addr:city" v="Saint-Maurice"/>
    bool is_a_poi_brand = false; //true when something like that appears:<tag k="brand" v="Agip"/>
    bool is_a_poi_operateur = false; //true when something like that appears:<tag k="operator" v="Total"/>

    std::string name; //name read into the xml file
    Glib::ustring value; //value read into the xml file
    uint8_t depth; //depth into the xml tree
	
	xmlpp::TextReader reader(file_to_parse); //open the file to parse

	while(reader.read())
	{
		depth = reader.get_depth();
		name = reader.get_name();

		// begin of analysis of is_a_node
		if (is_a_geo_node == false) 
		{
			if ((depth ==1) && (name == "node"))
			{
				if(reader.has_attributes())
				{
					reader.move_to_first_attribute();
					do
					{
						name = reader.get_name();
						value = reader.get_value();
						if (name == "id")
						{
							from_string<uint64_t>(node.segment, value, std::dec);
						}
						if (name == "lat")
						{
							from_string<double>(node.latitude, value, std::dec);
						}
						if (name == "lon")
						{
							from_string<double>(node.longitude, value, std::dec);
							is_a_geo_node = true;
						}
					} while(reader.move_to_next_attribute());
					reader.move_to_element();
				}			
			}
		}
		else // is_a_geo_node is true
		{ //a node 'node' already read, see next node
			if (depth ==1)
			{ //come back from sub node analysis
				if (is_sort_key_found)
				{
					if (*poi_buffer_index < POI_BUFFER_SIZE)
					{
						poi_buffer[*poi_buffer_index].node.segment = node.segment;
						poi_buffer[*poi_buffer_index].node.latitude = node.latitude;
						poi_buffer[*poi_buffer_index].node.longitude = node.longitude;
						poi_buffer[*poi_buffer_index].category = poi.category;
                        clear_string(&poi.name);
						poi_buffer[*poi_buffer_index].name = poi.name;
						poi_buffer[*poi_buffer_index].phone = poi.phone;
                        clear_string(&poi.website);
                        poi_buffer[*poi_buffer_index].website = poi.website;
                        clear_string(&poi.source);
                        poi_buffer[*poi_buffer_index].source = poi.source;
                        clear_string(&poi.opening_hours);
                        poi_buffer[*poi_buffer_index].opening_hours = poi.opening_hours;
                        clear_string(&poi.addr_house_number);
                        poi_buffer[*poi_buffer_index].addr_house_number = poi.addr_house_number;
                        clear_string(&poi.addr_street);
                        poi_buffer[*poi_buffer_index].addr_street = poi.addr_street;
                        poi_buffer[*poi_buffer_index].addr_postcode = poi.addr_postcode;
                        clear_string(&poi.addr_city);
                        poi_buffer[*poi_buffer_index].addr_city = poi.addr_city;
                        poi_buffer[*poi_buffer_index].stars = poi.stars;
						poi_buffer[*poi_buffer_index].offset = poi.offset;
                        clear_string(&poi.brand);
                        poi_buffer[*poi_buffer_index].brand = poi.brand;
                        clear_string(&poi.operateur);
                        poi_buffer[*poi_buffer_index].operateur = poi.operateur;
                        *poi_buffer_index +=1;
						INIT_DEFAULT_POI(node,poi); //reset the node and the poi to default value
					}
                    else
                        std::cout  << "poi buffer overload";
					is_sort_key_found = false;
				}
				else
				{ //next node is not a sub node
				//save the simple node 'node' into the buffer
					if (geo_node_buffer_index < GEO_NODE_BUFFER_SIZE)
					{
						geo_node_buffer[geo_node_buffer_index].segment = node.segment;
						geo_node_buffer[geo_node_buffer_index].latitude = node.latitude;
						geo_node_buffer[geo_node_buffer_index].longitude = node.longitude;
						geo_node_buffer_index++;	
					}
                    else
                        std::cout << "geo node buffer overload";
				}
				is_a_geo_node = false;	
			}
			else
			{ // depth is not 1
				if ((depth == 2) && (name == "tag")&&(reader.has_attributes()))
				{
					reader.move_to_first_attribute();
					do
					{
						name = reader.get_name();
						value = reader.get_value();
						if (name == "k")
						{
							if (value == "name")
								is_a_poi_name = true;
							else if (value == "phone")
								is_a_poi_phone = true;
							else if (value == "website")
								is_a_poi_website = true;
							else if (value == "stars")
								is_a_poi_stars = true;
							else  if (value == "source")
								is_a_poi_source = true;
                            else  if (value == "opening_hours")
                                is_a_poi_opening_hours = true;
                            else  if (value == "addr:housenumber")
                                is_a_poi_addr_house_number = true;
                            else  if (value == "addr:street")
                                is_a_poi_addr_street = true;
                            else  if (value == "addr:postcode")
                                is_a_poi_addr_postcode = true;
                            else  if (value == "addr:city")
                                is_a_poi_addr_city = true;
                            else  if (value == "brand")
                                is_a_poi_brand = true;
                            else  if (value == "operator")
                                is_a_poi_operateur = true;
                            else if (value == sort_primary_key)
								is_primary_key_found = true;
						}

						if ((is_a_poi_name)&&(name == "v"))
						{
							poi.name = value;
							is_a_poi_name = false;
						}
						else if ((is_a_poi_phone)&&(name == "v"))
						{
							poi.phone = value;
							is_a_poi_phone = false;
						}
						else if ((is_a_poi_website)&&(name == "v"))
						{
							poi.website = value;
							is_a_poi_website = false;
						}
						else if ((is_a_poi_stars)&&(name == "v"))
						{
							from_string<uint16_t>(poi.stars, value, std::dec);
							is_a_poi_stars = false;
						}
						else if ((is_a_poi_source)&&(name == "v"))
						{
							poi.source = value;
							is_a_poi_source = false;
						}
                        else if ((is_a_poi_opening_hours)&&(name == "v"))
                        {
                            poi.opening_hours = value;
                            is_a_poi_opening_hours = false;
                        }
                        else if ((is_a_poi_addr_house_number)&&(name == "v"))
                        {
                            poi.addr_house_number = value;
                            is_a_poi_addr_house_number = false;
                        }
                        else if ((is_a_poi_addr_street)&&(name == "v"))
                        {
                            poi.addr_street = value;
                            is_a_poi_addr_street = false;
                        }
                        else if ((is_a_poi_addr_postcode)&&(name == "v"))
                        {
                            from_string<uint16_t>(poi.addr_postcode, value, std::dec);
                            is_a_poi_addr_postcode = false;
                        }
                        else if ((is_a_poi_addr_city)&&(name == "v"))
                        {
                            poi.addr_city = value;
                            is_a_poi_addr_city = false;
                        }
                        else if ((is_a_poi_operateur)&&(name == "v"))
                        {
                            poi.operateur = value;
                            is_a_poi_operateur = false;
                        }
                        else if ((is_a_poi_brand)&&(name == "v"))
                        {
                            poi.brand = value;
                            is_a_poi_brand = false;
                        }
                        else if ((is_primary_key_found)&&(name == "v"))
						{ 
							poi.category = value;
							is_primary_key_found = false;
							sort_index = 0;
							do {
								if (value == sort_list[sort_index])
									is_sort_key_found = true;	// sort key found
							} while ((++sort_index < sort_list_size) && (is_sort_key_found == false));										
						}
					} while(reader.move_to_next_attribute());
					reader.move_to_element();
				}
			}
		}
		// begin of analysis of is_a_way
		if (is_a_way == false)
		{
			if ((depth ==1) && (name == "way"))
				is_a_way = true;
		}
		else //is_a_way is true 
		{ //a node 'way' already read, see next node
			if (depth ==1)
			{ //come back from sub node analysis
				if (is_sort_key_found)
				{
					if (*poi_buffer_index < POI_BUFFER_SIZE)
					{
						// looking for geo coordinate
						if (geo_node_buffer_index > 0)
						{ //at least one position available, can search for the id
							sort_index = 0;
							do
							{
								if (node_buffer[0] == geo_node_buffer[sort_index].segment)
								{ // for the moment, just use id of the first node stored into node_buffer[0]
									poi_buffer[*poi_buffer_index].node.segment = geo_node_buffer[sort_index].segment;
									poi_buffer[*poi_buffer_index].node.latitude = geo_node_buffer[sort_index].latitude;
									poi_buffer[*poi_buffer_index].node.longitude = geo_node_buffer[sort_index].longitude;
									poi_buffer[*poi_buffer_index].category = poi.category;
                                    clear_string(&poi.name);
                                    poi_buffer[*poi_buffer_index].name = poi.name;
                                    poi_buffer[*poi_buffer_index].phone = poi.phone;
                                    clear_string(&poi.website);
                                    poi_buffer[*poi_buffer_index].website = poi.website;
                                    clear_string(&poi.source);
                                    poi_buffer[*poi_buffer_index].source = poi.source;
                                    clear_string(&poi.opening_hours);
                                    poi_buffer[*poi_buffer_index].opening_hours = poi.opening_hours;
                                    clear_string(&poi.addr_house_number);
                                    poi_buffer[*poi_buffer_index].addr_house_number = poi.addr_house_number;
                                    clear_string(&poi.addr_street);
                                    poi_buffer[*poi_buffer_index].addr_street = poi.addr_street;
                                    poi_buffer[*poi_buffer_index].addr_postcode = poi.addr_postcode;
                                    clear_string(&poi.addr_city);
                                    poi_buffer[*poi_buffer_index].addr_city = poi.addr_city;
                                    poi_buffer[*poi_buffer_index].stars = poi.stars;
									poi_buffer[*poi_buffer_index].offset = poi.offset;
                                    clear_string(&poi.brand);
                                    poi_buffer[*poi_buffer_index].brand = poi.brand;
                                    clear_string(&poi.operateur);
                                    poi_buffer[*poi_buffer_index].operateur = poi.operateur;
                                    *poi_buffer_index +=1;
									break; // found so not necessary to go forward
								}
							} while (++sort_index < geo_node_buffer_index);
							if (sort_index == geo_node_buffer_index)
							{
								
							}
						}
						INIT_DEFAULT_POI(node,poi); //reset the node and the poi to default value
					}
                    else
                        std::cout << "poi buffer overload";
                    is_sort_key_found = false;
				}
				node_buffer_index = 0; //reset for the next way
				is_a_way = false;	
			}
			else
			{
				if (depth == 2)
				{ // next node will be a sub node to be checked
					if (name == "nd")
					{ //search for the specific nd
						if(reader.has_attributes())
						{
							reader.move_to_first_attribute();
							name = reader.get_name();
							value = reader.get_value();
							if (name == "ref")
							{						
								if (node_buffer_index < NODE_BUFFER_SIZE)
								{ //save the sub node 'nd' into the buffer
									from_string<uint64_t>(node_buffer[node_buffer_index], value, std::dec);
									node_buffer_index++;
								}
                                else
                                    std::cout << "node buffer overload";
							}
						}						
					}
					if ((name == "tag")&&(reader.has_attributes()))
					{
						reader.move_to_first_attribute();
						do
						{
							name = reader.get_name();
							value = reader.get_value();
							if (name == "k")
							{
								if (value == "name")
									is_a_poi_name = true;
								else if (value == "phone")
									is_a_poi_phone = true;
								else if (value == "website")
									is_a_poi_website = true;
								else if (value == "stars")
									is_a_poi_stars = true;
								else  if (value == "source")
									is_a_poi_source = true;
                                else  if (value == "opening_hours")
                                    is_a_poi_opening_hours = true;
                                else  if (value == "addr:housenumber")
                                    is_a_poi_addr_house_number = true;
                                else  if (value == "addr:street")
                                    is_a_poi_addr_street = true;
                                else  if (value == "addr:postcode")
                                    is_a_poi_addr_postcode = true;
                                else  if (value == "addr:city")
                                    is_a_poi_addr_city = true;
                                else  if (value == "operator")
                                    is_a_poi_operateur = true;
                                else  if (value == "brand")
                                    is_a_poi_brand = true;
                                else if (value == sort_primary_key)
									is_primary_key_found = true;
							}

							if ((is_a_poi_name)&&(name == "v"))
							{
								poi.name = value;
								is_a_poi_name = false;
							}
							else if ((is_a_poi_phone)&&(name == "v"))
							{
								poi.phone = value;
								is_a_poi_phone = false;
							}
							else if ((is_a_poi_website)&&(name == "v"))
							{
								poi.website = value;
								is_a_poi_website = false;
							}
							else if ((is_a_poi_stars)&&(name == "v"))
							{
								from_string<uint16_t>(poi.stars, value, std::dec);
								is_a_poi_stars = false;
							}
							else if ((is_a_poi_source)&&(name == "v"))
							{
								poi.source = value;
								is_a_poi_source = false;
							}
                            else if ((is_a_poi_opening_hours)&&(name == "v"))
                            {
                                poi.opening_hours = value;
                                is_a_poi_opening_hours = false;
                            }
                            else if ((is_a_poi_addr_house_number)&&(name == "v"))
                            {
                                poi.addr_house_number = value;
                                is_a_poi_addr_house_number = false;
                            }
                            else if ((is_a_poi_addr_street)&&(name == "v"))
                            {
                                poi.addr_street = value;
                                is_a_poi_addr_street = false;
                            }
                            else if ((is_a_poi_addr_postcode)&&(name == "v"))
                            {
                                from_string<uint16_t>(poi.addr_postcode, value, std::dec);
                                is_a_poi_addr_postcode = false;
                            }
                            else if ((is_a_poi_addr_city)&&(name == "v"))
                            {
                                poi.addr_city = value;
                                is_a_poi_addr_city = false;
                            }
                            else if ((is_a_poi_operateur)&&(name == "v"))
                            {
                                poi.operateur = value;
                                is_a_poi_operateur = false;
                            }
                            else if ((is_a_poi_brand)&&(name == "v"))
                            {
                                poi.brand = value;
                                is_a_poi_brand = false;
                            }
                            else if ((is_primary_key_found)&&(name == "v"))
							{ 
								poi.category = value;
								is_primary_key_found = false;
								sort_index = 0;
								do {
									if (value == sort_list[sort_index])
										is_sort_key_found = true;	// sort key found
								} while ((++sort_index < sort_list_size) && (is_sort_key_found == false));										
							}
						} while(reader.move_to_next_attribute());
						reader.move_to_element();
					}
				}
			}
		}
	}	
}
