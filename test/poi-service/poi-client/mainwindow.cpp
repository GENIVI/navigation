/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file mainwindow.cpp
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
* 15-07-2014, Philippe Colliot, update positioning dbus path 
* <date>, <name>, <description of change>
*
* @licence end@
*/
#include "mainwindow.h"
#include "ui_mainwindow.h"
#include "about-dialog.h"
#include <QtCore/QCoreApplication>
#include <QMetaType>
#include <QFontDatabase>

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent), ui(new Ui::MainWindow)
{
}

MainWindow::~MainWindow()
{
    delete mp_tableViewPoi;
    delete m_dbusPoiSearchInterface;
    delete m_dbusConfigurationInterface;
    delete m_dbusNavigationRoutingInterface;
    delete m_dbusNavigationGuidanceInterface;
    delete m_dbusPositioningEnhancedPositionInterface;
    delete ui;
}

/**
 * \fn InitUi()
 * \brief Initialize the user interface and the DBus.
 *
 * \param
 * \return
 */
void MainWindow::InitUi()
{
    uchar row,column;
    QStringList headers;
    double fractpart, intpart;
    QString str;

    ui->setupUi(this);

    // populate table of poi
    mp_tableViewPoi = new QStandardItemModel(settingsPoiDisplayTableRows,columnSize,this); //set up the columns and the rows of the table

    // populate the column headers (order sensitive!)
    // Must fit that order: "Name","Category","Distance","ID","Latitude","Longitude"
    headers << QString(tr("Name")) << QString(tr("Category")) << QString(tr("Distance")) << QString(tr("ID")) << QString(tr("Latitude")) << QString(tr("Longitude"));
    // Must fit that list and order of attributes: "Source","WebSite","Phone","Stars","Open hours","HouseNumber","Street","Post code","City","Brand","Operator"
    headers << QString(tr("Source")) << QString(tr("WebSite")) << QString(tr("Phone")) << QString(tr("Stars")) << QString(tr("Open hours")) << QString(tr("Number")) << QString(tr("Street")) << QString(tr("Post code")) << QString(tr("City")) << QString(tr("Brand")) << QString(tr("Operator"));
    headers << QString(tr("Icon"));

    mp_tableViewPoi->setHorizontalHeaderLabels(headers);

    for (row=0;row<settingsPoiDisplayTableRows;row++)
    {
        for (column =0;column<columnSize;column++)
        {
            QStandardItem *cell = new QStandardItem();
            mp_tableViewPoi->setItem(row,column,cell);
        }
    }

    //create checkboxes for getting attributes
    // Must fit that list and order of attributes: "Source","WebSite","Phone","Stars","Open hours","HouseNumber","Street","Post code","City","Brand","Operator"
    QFont font("Ubuntu",8);
    QLabel *attribLabelSource = new QLabel(tr("Source"));
    attribLabelSource->setFont(font);
    ui->AttributeToGetLayout->addWidget(attribLabelSource);
    QCheckBox *attribGetSource = new QCheckBox();
    attribGetSource->setChecked(Qt::Unchecked);
    mp_attributeGetCheckBox.append(attribGetSource);
    ui->AttributeToGetLayout->addWidget(attribGetSource);

    QLabel *attribLabelWebSite = new QLabel(tr("WebSite"));
    attribLabelWebSite->setFont(font);
    ui->AttributeToGetLayout->addWidget(attribLabelWebSite);
    QCheckBox *attribGetWebSite = new QCheckBox();
    attribGetWebSite->setChecked(Qt::Unchecked);
    mp_attributeGetCheckBox.append(attribGetWebSite);
    ui->AttributeToGetLayout->addWidget(attribGetWebSite);

    QLabel *attribLabelPhone = new QLabel(tr("Phone"));
    attribLabelPhone->setFont(font);
    ui->AttributeToGetLayout->addWidget(attribLabelPhone);
    QCheckBox *attribGetPhone = new QCheckBox();
    attribGetPhone->setChecked(Qt::Unchecked);
    mp_attributeGetCheckBox.append(attribGetPhone);
    ui->AttributeToGetLayout->addWidget(attribGetPhone);

    QLabel *attribLabelStars = new QLabel(tr("Stars"));
    attribLabelStars->setFont(font);
    ui->AttributeToGetLayout->addWidget(attribLabelStars);
    QCheckBox *attribGetStars = new QCheckBox();
    attribGetStars->setChecked(Qt::Unchecked);
    mp_attributeGetCheckBox.append(attribGetStars);
    ui->AttributeToGetLayout->addWidget(attribGetStars);

    QLabel *attribLabelOpenHours = new QLabel(tr("Open hours"));
    attribLabelOpenHours->setFont(font);
    ui->AttributeToGetLayout->addWidget(attribLabelOpenHours);
    QCheckBox *attribGetOpenHours = new QCheckBox();
    attribGetOpenHours->setChecked(Qt::Unchecked);
    mp_attributeGetCheckBox.append(attribGetOpenHours);
    ui->AttributeToGetLayout->addWidget(attribGetOpenHours);

    QLabel *attribLabelHouseNumber = new QLabel(tr("Number"));
    attribLabelHouseNumber->setFont(font);
    ui->AttributeToGetLayout->addWidget(attribLabelHouseNumber);
    QCheckBox *attribGetHouseNumber = new QCheckBox();
    attribGetHouseNumber->setChecked(Qt::Unchecked);
    mp_attributeGetCheckBox.append(attribGetHouseNumber);
    ui->AttributeToGetLayout->addWidget(attribGetHouseNumber);

    QLabel *attribLabelStreet = new QLabel(tr("Street"));
    attribLabelStreet->setFont(font);
    ui->AttributeToGetLayout->addWidget(attribLabelStreet);
    QCheckBox *attribGetStreet = new QCheckBox();
    attribGetStreet->setChecked(Qt::Unchecked);
    mp_attributeGetCheckBox.append(attribGetStreet);
    ui->AttributeToGetLayout->addWidget(attribGetStreet);

    QLabel *attribLabelPostCode = new QLabel(tr("Post code"));
    attribLabelPostCode->setFont(font);
    ui->AttributeToGetLayout->addWidget(attribLabelPostCode);
    QCheckBox *attribGetPostCode = new QCheckBox();
    attribGetPostCode->setChecked(Qt::Unchecked);
    mp_attributeGetCheckBox.append(attribGetPostCode);
    ui->AttributeToGetLayout->addWidget(attribGetPostCode);

    QLabel *attribLabelCity = new QLabel(tr("City"));
    attribLabelCity->setFont(font);
    ui->AttributeToGetLayout->addWidget(attribLabelCity);
    QCheckBox *attribGetCity = new QCheckBox();
    attribGetCity->setChecked(Qt::Unchecked);
    mp_attributeGetCheckBox.append(attribGetCity);
    ui->AttributeToGetLayout->addWidget(attribGetCity);

    QLabel *attribLabelBrand = new QLabel(tr("Brand"));
    attribLabelBrand->setFont(font);
    ui->AttributeToGetLayout->addWidget(attribLabelBrand);
    QCheckBox *attribGetBrand = new QCheckBox();
    attribGetBrand->setChecked(Qt::Unchecked);
    mp_attributeGetCheckBox.append(attribGetBrand);
    ui->AttributeToGetLayout->addWidget(attribGetBrand);

    QLabel *attribLabelOperateur = new QLabel(tr("Operator"));
    attribLabelOperateur->setFont(font);
    ui->AttributeToGetLayout->addWidget(attribLabelOperateur);
    QCheckBox *attribGetOperateur = new QCheckBox();
    attribGetOperateur->setChecked(Qt::Unchecked);
    mp_attributeGetCheckBox.append(attribGetOperateur);
    ui->AttributeToGetLayout->addWidget(attribGetOperateur);

    ui->table_view_poi->setModel(mp_tableViewPoi);

    //no POI handle
    m_poiSearchHandle = settingsInvalidHandle;
    ui->poiHandle->setText(noValue);


    //no language set
    ui->languageCode->setText(noValue);
    ui->countryCode->setText(noValue);

    //no search mode selected
    isSetProximityModeSelected = false;
    isSearchAroundTheVehicleSelected = false;
    ui->searchMode->setText(noValue);
    ui->startSearch->setEnabled(false);
    ui->cancelSearch->setEnabled(false);

    // no route handle
    m_routeHandle = settingsInvalidHandle;
    m_startSearchOffset = 0; //by default from the vehicle current location
    m_endSearchOffset = 0; //by default until the destination
    ui->routeHandle->setText(noValue);

    m_totalNumberOfSegments = 0;
    ui->routeTotalSegments->setText(QString::number(m_totalNumberOfSegments));

    //search buffer empty
    ui->totalSize->setText(tr("EMPTY"));
    m_totalSize = 0;
    m_currentTopListIndex = 0;

    ui->recordFrom->setText(noValue);
    ui->recordTo->setText(noValue);

    // init default location
    m_geoLocation.latitude = settingsDefaultLocation.latitude;
    m_geoLocation.longitude = settingsDefaultLocation.longitude;
    m_geoLocation.altitude = settingsDefaultLocation.altitude;

    if (m_geoLocation.latitude < 0)
    {
        ui->latitude_direction->setCurrentIndex(ui->latitude_direction->findText(tr("SOUTH")));
        m_geoLocation.latitude *= -1;
    }
    else
        ui->latitude_direction->setCurrentIndex(ui->latitude_direction->findText(tr("NORTH")));

    if (m_geoLocation.longitude < 0)
    {
        ui->longitude_direction->setCurrentIndex(ui->longitude_direction->findText(tr("WEST")));
        m_geoLocation.longitude *= -1;
    }
    else
        ui->longitude_direction->setCurrentIndex(ui->longitude_direction->findText(tr("EAST")));


    fractpart = (modf(m_geoLocation.latitude, &intpart))*60;
    str.setNum(intpart);
    ui->latitude_degree->setText(str);
    fractpart = modf(fractpart, &intpart);
    str.setNum(intpart);
    ui->latitude_minute->setText(str);
    fractpart = (modf(fractpart*60, &intpart));
    str.setNum(intpart);
    ui->latitude_second->setText(str);

    fractpart = (modf(m_geoLocation.longitude, &intpart))*60;
    str.setNum(intpart);
    ui->longitude_degree->setText(str);
    fractpart = modf(fractpart, &intpart);
    str.setNum(intpart);
    ui->longitude_minute->setText(str);
    fractpart = (modf(fractpart*60, &intpart));
    str.setNum(intpart);
    ui->longitude_second->setText(str);

    //no current location for the time being
    ui->currentLocationLatitude->setText(noValue);
    ui->currentLocationLongitude->setText(noValue);

    // default version
    ui->VersionSearch->setText(noValue);

    // default text to search
    ui->stringToSearch->setText(settingsDefaultTextToSearch);

    //status
    manageStatus(GENIVI_POISERVICE_NOT_STARTED);

    //connect the graphic scene and the graphic view
    ui->graphicsView->setScene(&m_scenePOI);

    m_scenePOI.setForegroundBrush(QColor(255, 255, 255, 127));
    m_scenePOI.setForegroundBrush(QBrush(Qt::lightGray, Qt::CrossPattern));
    m_scenePOI.setSceneRect(0,0,ui->graphicsView->width(),ui->graphicsView->height());
    m_mapWidth = ui->graphicsView->width();
    m_mapHeight = ui->graphicsView->height();
    m_mapCenterX = ui->graphicsView->width()/2;
    m_mapCenterY = ui->graphicsView->height()/2;

    // init D-Bus (every interfaces on the session bus)
    //create instances of clients
    m_dbusPoiSearchInterface = new org::genivi::poiservice::poiSearch::DBusSearchInterface("org.genivi.poiservice.POISearch", "/org/genivi/poiservice/POISearch",
                                                                                                QDBusConnection::sessionBus(), this);
    m_dbusConfigurationInterface = new org::genivi::poiservice::poiSearch::DBusConfigurationInterface("org.genivi.poiservice.Configuration", "/org/genivi/poiservice/Configuration",
                                                                                                QDBusConnection::sessionBus(), this);
    m_dbusContentAccessInterface = new org::genivi::poiservice::poiContentAccess::DBusContentAccessInterface("org.genivi.poiservice.POIContentAccess","/org/genivi/poiservice/POIContentAccess",
                                                                                                QDBusConnection::sessionBus(), this);
    m_dbusNavigationRoutingInterface = new org::genivi::navigationcore::Routing::DBusRoutingInterface("org.genivi.navigationcore.Routing", "/org/genivi/navigationcore",
                                                                                                QDBusConnection::sessionBus(), this);
    m_dbusNavigationGuidanceInterface = new org::genivi::navigationcore::Guidance::DBusGuidanceInterface("org.genivi.navigationcore.Guidance", "/org/genivi/navigationcore",
                                                                                                QDBusConnection::sessionBus(), this);
    m_dbusPositioningEnhancedPositionInterface = new org::genivi::positioning::EnhancedPosition::DBusEnhancedPositionInterface("org.genivi.positioning.EnhancedPosition", "/org/genivi/positioning/EnhancedPosition",
                                                                                                QDBusConnection::sessionBus(), this);
    m_dbusNavigationCoreSessionInterface = new org::genivi::navigationcore::Session::DBusNavigationCoreSessionInterface("org.genivi.navigationcore.Session", "/org/genivi/navigationcore",
                                                                                                QDBusConnection::sessionBus(), this );

    //connect to signals
    QObject::connect(m_dbusPoiSearchInterface, SIGNAL(PoiStatus(uint,int)), this, SLOT(on_DBusSignalPoiStatus(uint,int)));
    QObject::connect(m_dbusPoiSearchInterface, SIGNAL(ResultListChanged(uint,ushort)), this, SLOT(on_DBusSignalResultListChanged(uint,ushort)));
    QObject::connect(m_dbusPoiSearchInterface, SIGNAL(CategoriesUpdated(QList<poiCategoryAndReason_t>)), this, SLOT(on_DBusSignalCategoriesUpdated(QList<poiCategoryAndReason_t>)));

    QObject::connect(m_dbusConfigurationInterface, SIGNAL(ConfigurationChanged(QList<ushort>)), this, SLOT(on_DBusSignalConfigurationChanged(QList<ushort>)));

    QObject::connect(m_dbusNavigationRoutingInterface, SIGNAL(RouteCalculationSuccessful(uchar,tupleUshortUshort)),this,SLOT(on_DBusSignalRouteCalculationSuccessful(uchar, tupleUshortUshort)));
    QObject::connect(m_dbusNavigationRoutingInterface, SIGNAL(RouteDeleted(uchar)),this,SLOT(on_DBusSignalRouteDeleted(uchar)));

    QObject::connect(m_dbusPositioningEnhancedPositionInterface, SIGNAL(PositionUpdate(ulong)),this,SLOT(on_DBusSignalPositionUpdate(ulong)));

    // start periodic timer for position
    m_dbusPositioningEnhancedPositionInterface->startTimerForPosition(settingsTimerPeriodForPosition);

    initSettings();
}

/**
 * \fn select_category()
 * \brief Invoke the DBus methods SetCategories and SetAttributes before launching a search.
 *
 * \param
 * \return
 */
void MainWindow::select_category()
{
    QList<poiSearch_t> poi_search_list;
    poiSearch_t poi_search;
    ushort index,attribute_index;
    QList<poiAttributeFull_t> poi_attribute_list;
    poiAttributeFull_t poi_attribute;
    uint radius_displayed;

    // Update the requested categories
    // read the panel values and update the ellipses for embedded data
    for (index=0; index < m_poiCategoryList.size(); index++)
    {
        if (mp_categoryCheckBox[index]->isChecked())
        { //poi category selected for the search
            poi_search.id = m_poiCategoryList.at(index).id;
            poi_search.radius = (mp_radiusLineEditBox.at(index)->text().toUInt())/10; //radius sent in ten of meters
            radius_displayed = ((mp_radiusLineEditBox.at(index)->text().toUInt())*m_mapWidth)/(2*settingsMapWidthInMeter);
            mp_radiusEllipse.at(index)->setRect(QRectF((m_mapCenterX - radius_displayed/2), (m_mapCenterY - radius_displayed/2), radius_displayed, radius_displayed));
            mp_radiusEllipse.at(index)->show();
            poi_search_list << poi_search;
        }
        else
           mp_radiusEllipse.at(index)->hide();
    }

    // read the panel values and update the ellipses for additional data
    for (index=0; index < m_poiCategoryListAdditional.size(); index++)
    {
        if (mp_categoryCheckBoxAdditional[index]->isChecked())
        { //poi category selected for the search
            poi_search.id = m_poiCategoryListAdditional.at(index).id;
            poi_search.radius = (mp_radiusLineEditBoxAdditional.at(index)->text().toUInt())/10; //radius sent in ten of meters
            radius_displayed = ((mp_radiusLineEditBoxAdditional.at(index)->text().toUInt())*m_mapWidth)/(2*settingsMapWidthInMeter);
            mp_radiusEllipseAdditional.at(index)->setRect(QRectF((m_mapCenterX - radius_displayed/2), (m_mapCenterY - radius_displayed/2), radius_displayed, radius_displayed));
            mp_radiusEllipseAdditional.at(index)->show();
            poi_search_list << poi_search;
        }
        else
           mp_radiusEllipseAdditional.at(index)->hide();
    }

    //call the method with the list
    QDBusPendingReply<> reply_0 = m_dbusPoiSearchInterface->SetCategories(m_poiSearchHandle,poi_search_list);
    reply_0.waitForFinished();
    if (reply_0.isError())
        manageDBusError(reply_0.reply()); // call failed

    // Update the requested attributes
    // read the panel values for embedded data
    // Must fit that list and order of attributes: "Source","WebSite","Phone","Stars","Open hours","HouseNumber","Street","Post code","City","Brand","Operateur"
    for (index=0; index < m_poiCategoryList.size(); index++)
    {
        //preset the structure with default values
        poi_attribute.poiCategory = m_poiCategoryList.at(index).id;
        poi_attribute.value.value = QDBusVariant("no value");
        poi_attribute.mandatory = true;
        if (mp_categoryCheckBox[index]->isChecked())
        { //poi category selected for the search
            attribute_index = 0;
            if (mp_attributeSourceCheckBox.at(index)->isEnabled())
            {
                if (mp_attributeSourceCheckBox.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_STRING;
                    poi_attribute.id = m_poiCategoryDetailsList.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
            if (mp_attributeWebSiteCheckBox.at(index)->isEnabled())
            {
                if (mp_attributeWebSiteCheckBox.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_STRING;
                    poi_attribute.id = m_poiCategoryDetailsList.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
            if (mp_attributePhoneCheckBox.at(index)->isEnabled())
            {
                if (mp_attributePhoneCheckBox.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_STRING;
                    poi_attribute.id = m_poiCategoryDetailsList.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
            if (mp_attributeStarsCheckBox.at(index)->isEnabled())
            {
                if (mp_attributeStarsCheckBox.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_INTEGER;
                    poi_attribute.id = m_poiCategoryDetailsList.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
            if (mp_attributeOpeningHoursCheckBox.at(index)->isEnabled())
            {
                if (mp_attributeOpeningHoursCheckBox.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_STRING;
                    poi_attribute.id = m_poiCategoryDetailsList.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
            if (mp_attributeAddrHouseNumberCheckBox.at(index)->isEnabled())
            {
                if (mp_attributeAddrHouseNumberCheckBox.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_STRING;
                    poi_attribute.id = m_poiCategoryDetailsList.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
            if (mp_attributeAddrStreetCheckBox.at(index)->isEnabled())
            {
                if (mp_attributeAddrStreetCheckBox.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_STRING;
                    poi_attribute.id = m_poiCategoryDetailsList.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
            if (mp_attributeAddrPostCodeCheckBox.at(index)->isEnabled())
            {
                if (mp_attributeAddrPostCodeCheckBox.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_INTEGER;
                    poi_attribute.id = m_poiCategoryDetailsList.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
            if (mp_attributeAddrCityCheckBox.at(index)->isEnabled())
            {
                if (mp_attributeAddrCityCheckBox.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_STRING;
                    poi_attribute.id = m_poiCategoryDetailsList.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
            if (mp_attributeBrandCheckBox.at(index)->isEnabled())
            {
                if (mp_attributeBrandCheckBox.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_STRING;
                    poi_attribute.id = m_poiCategoryDetailsList.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
            if (mp_attributeOperateurCheckBox.at(index)->isEnabled())
            {
                if (mp_attributeOperateurCheckBox.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_STRING;
                    poi_attribute.id = m_poiCategoryDetailsList.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
        }
    }

    // read the panel values for additional data
    // Must fit that list and order of attributes: "Source","WebSite","Phone","Stars","Open hours","HouseNumber","Street","Post code","City","Brand","Operateur"
    for (index=0; index < m_poiCategoryListAdditional.size(); index++)
    {
        //preset the structure with default values
        poi_attribute.poiCategory = m_poiCategoryListAdditional.at(index).id;
        poi_attribute.value.value = QDBusVariant("no value");
        poi_attribute.mandatory = true;
        if (mp_categoryCheckBoxAdditional[index]->isChecked())
        { //poi category selected for the search
            attribute_index = 0;
            if (mp_attributeSourceCheckBoxAdditional.at(index)->isEnabled())
            {
                if (mp_attributeSourceCheckBoxAdditional.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_STRING;
                    poi_attribute.id = m_poiCategoryDetailsListAdditional.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
            if (mp_attributeWebSiteCheckBoxAdditional.at(index)->isEnabled())
            {
                if (mp_attributeWebSiteCheckBoxAdditional.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_STRING;
                    poi_attribute.id = m_poiCategoryDetailsListAdditional.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
            if (mp_attributePhoneCheckBoxAdditional.at(index)->isEnabled())
            {
                if (mp_attributePhoneCheckBoxAdditional.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_STRING;
                    poi_attribute.id = m_poiCategoryDetailsListAdditional.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
            if (mp_attributeStarsCheckBoxAdditional.at(index)->isEnabled())
            {
                if (mp_attributeStarsCheckBoxAdditional.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_INTEGER;
                    poi_attribute.id = m_poiCategoryDetailsListAdditional.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
            if (mp_attributeOpeningHoursCheckBoxAdditional.at(index)->isEnabled())
            {
                if (mp_attributeOpeningHoursCheckBoxAdditional.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_STRING;
                    poi_attribute.id = m_poiCategoryDetailsListAdditional.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
            if (mp_attributeAddrHouseNumberCheckBoxAdditional.at(index)->isEnabled())
            {
                if (mp_attributeAddrHouseNumberCheckBoxAdditional.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_STRING;
                    poi_attribute.id = m_poiCategoryDetailsListAdditional.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
            if (mp_attributeAddrStreetCheckBoxAdditional.at(index)->isEnabled())
            {
                if (mp_attributeAddrStreetCheckBoxAdditional.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_STRING;
                    poi_attribute.id = m_poiCategoryDetailsListAdditional.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
            if (mp_attributeAddrPostCodeCheckBoxAdditional.at(index)->isEnabled())
            {
                if (mp_attributeAddrPostCodeCheckBoxAdditional.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_INTEGER;
                    poi_attribute.id = m_poiCategoryDetailsListAdditional.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
            if (mp_attributeAddrCityCheckBoxAdditional.at(index)->isEnabled())
            {
                if (mp_attributeAddrCityCheckBoxAdditional.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_STRING;
                    poi_attribute.id = m_poiCategoryDetailsListAdditional.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
            if (mp_attributeBrandCheckBoxAdditional.at(index)->isEnabled())
            {
                if (mp_attributeBrandCheckBoxAdditional.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_STRING;
                    poi_attribute.id = m_poiCategoryDetailsListAdditional.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
            if (mp_attributeOperateurCheckBoxAdditional.at(index)->isEnabled())
            {
                if (mp_attributeOperateurCheckBoxAdditional.at(index)->isChecked())
                {
                    poi_attribute.type = GENIVI_POISERVICE_STRING;
                    poi_attribute.id = m_poiCategoryDetailsListAdditional.at(index).attributes.at(attribute_index).id;
                    poi_attribute_list.append(poi_attribute);
                }
                attribute_index++;
            }
        }
    }

    //call the method with the list
    QDBusPendingReply<> reply_1 = m_dbusPoiSearchInterface->SetAttributes(m_poiSearchHandle,poi_attribute_list);
    reply_1.waitForFinished();
    if (reply_1.isError())
        manageDBusError(reply_1.reply()); // call failed
}

/**
 * \fn on_startSearch_clicked()
 * \brief Start search around the vehicle invoke the DBus methods SetCategories, SetAttributes and StartPoiSearch.
 *
 * \param
 * \return
 */
void MainWindow::on_startSearch_clicked()
{
    ushort sortOption = GENIVI_POISERVICE_SORT_DEFAULT;

    if ((isSearchAroundTheVehicleSelected == false) && (isSetProximityModeSelected == false))
    {
        isSearchAroundTheVehicleSelected = true;

        if (ui->checkLocation->isChecked())
        { //location is given by enhanced position (current vehicle position)
            if ((ui->currentLocationLatitude->text() == noValue)&&(ui->currentLocationLongitude->text() == noValue))
            { //no location received
                // get default location
                ui->searchMode->setText(tr("Around the default location"));
                m_geoLocation.latitude = settingsDefaultLocation.latitude;
                m_geoLocation.longitude = settingsDefaultLocation.longitude;
                m_geoLocation.altitude = settingsDefaultLocation.altitude;
            }
            else
            { //get last location received
                ui->searchMode->setText(tr("Around the vehicle"));
                m_geoLocation.latitude = ui->currentLocationLatitude->text().toDouble();
                m_geoLocation.longitude = ui->currentLocationLongitude->text().toDouble();
                //todo manage the altitude
            }

        }
        else
        { //location is set by the user
            //get the value of the location on the panel
            ui->searchMode->setText(tr("Around a location"));
            m_geoLocation.latitude = ui->latitude_degree->text().toDouble() + (ui->latitude_minute->text().toDouble()/60) + (ui->latitude_second->text().toDouble()/3600);
            m_geoLocation.longitude = ui->longitude_degree->text().toDouble() + (ui->longitude_minute->text().toDouble()/60) + (ui->longitude_second->text().toDouble()/3600);

            if (ui->latitude_direction->currentIndex() == ui->latitude_direction->findText(tr("SOUTH")))
                m_geoLocation.latitude *= -1;

            if (ui->longitude_direction->currentIndex() == ui->longitude_direction->findText(tr("WEST")))
                m_geoLocation.longitude *= -1;
        }

        //set the center
        QDBusPendingReply<> reply_0 = m_dbusPoiSearchInterface->SetCenter(m_poiSearchHandle,m_geoLocation);
        reply_0.waitForFinished();
        if (reply_0.isError())
            manageDBusError(reply_0.reply()); // call failed

        //select the categories
        select_category();

        //start the search
        QDBusPendingReply<> reply_1 = m_dbusPoiSearchInterface->StartPoiSearch(m_poiSearchHandle,ui->stringToSearch->text(),sortOption);
        reply_1.waitForFinished();
        if (reply_1.isError())
            manageDBusError(reply_1.reply()); // call failed
    }
}

/**
 * \fn on_cancelSearch_clicked()
 * \brief Stop search around the vehicle, invoke the DBus method CancelPoiSearch.
 *
 * \param
 * \return
 */
void MainWindow::on_cancelSearch_clicked()
{
    if (isSearchAroundTheVehicleSelected == true)
    {
        isSearchAroundTheVehicleSelected = false;
        ui->searchMode->setText(noValue);
        clearViewTable();
        ui->totalSize->setText(tr("EMPTY"));
        m_totalSize = 0;
        m_currentTopListIndex = 0;
        ui->recordFrom->setText(noValue);
        ui->recordTo->setText(noValue);

        QDBusPendingReply<> reply_0 = m_dbusPoiSearchInterface->CancelPoiSearch(m_poiSearchHandle);
        reply_0.waitForFinished();
        if (reply_0.isError())
            manageDBusError(reply_0.reply()); // call failed
    }
}

/**
 * \fn on_createpoiHandle_clicked()
 * \brief Invoke the DBus method CreatePoiSearchHandle and set the m_poiSearchHandle.
 *
 * \param
 * \return
 */
void MainWindow::on_createpoiHandle_clicked()
{
    QString str;
    QDBusPendingReply<uint> reply = m_dbusPoiSearchInterface->CreatePoiSearchHandle();
    reply.waitForFinished();
    if (reply.isError())
        manageDBusError(reply.reply()); // call failed
     else
    {
        m_poiSearchHandle = reply.value();// use the returned value
        str = QString(tr("NUMBER")) + QString(":  ") + QString::number(m_poiSearchHandle);
        ui->poiHandle->setText(str);
        ui->startSearch->setEnabled(true);
        ui->cancelSearch->setEnabled(true);
    }
}

/**
 * \fn on_deletepoiHandle_clicked()
 * \brief Invoke the DBus method DeletePoiSearchHandle and reset the m_poiSearchHandle.
 *
 * \param
 * \param
 * \return
 */
void MainWindow::on_deletepoiHandle_clicked()
{
    QDBusPendingReply<> reply = m_dbusPoiSearchInterface->DeletePoiSearchHandle(m_poiSearchHandle);
    reply.waitForFinished();
    if (reply.isError())
        manageDBusError(reply.reply()); // call failed
     else
    {
        m_poiSearchHandle = settingsInvalidHandle;
        ui->poiHandle->setText(noValue);
        ui->startSearch->setEnabled(false);
        ui->cancelSearch->setEnabled(false);
    }
}

/**
 * \fn initSettings()
 * \brief Init the settings of the application, invoke DBus methods GetAvailableCategories, GetCategoriesDetails, GetVersion and GetRootCategory.
 *
 * \param
 * \param
 * \return
 */
void MainWindow::initSettings()
{
    ushort index,sub_index;
    uint radius;
    version_t version;
    QList<categoryId_t> categories;

    // dbus must be connected !

    // init the languages
    // for the poi search
    QDBusPendingReply<> reply_4 = m_dbusConfigurationInterface->SetLocale(settingsLanguageCode,settingsCountryCode,settingsScriptCode);
    reply_4.waitForFinished();
    if (reply_4.isError())
        manageDBusError(reply_4.reply()); // call failed
    else
    { // get the language to check if it's ok
       QDBusPendingReply<QString,QString,QString> reply_5 = m_dbusConfigurationInterface->GetLocale();
       reply_5.waitForFinished();
       if (reply_5.isError())
           manageDBusError(reply_5.reply()); // call failed
       else
       {
           if ((qdbus_cast<QString>(reply_5.argumentAt(0)) == settingsLanguageCode) && (qdbus_cast<QString>(reply_5.argumentAt(1)) == settingsCountryCode)&& (qdbus_cast<QString>(reply_5.argumentAt(2)) == settingsScriptCode))
           {
               ui->languageCode->setText(settingsLanguageCode);
               ui->countryCode->setText(settingsCountryCode);
               ui->scriptCode->setText(settingsScriptCode);
           }
       }
    }

    // init values provided by the POISearch server

    // GetAvailableCategories
    QDBusPendingReply<QList<poiCategoryFull_t> > reply_0 = m_dbusPoiSearchInterface->GetAvailableCategories();
    reply_0.waitForFinished();
    if (reply_0.isError())
        manageDBusError(reply_0.reply()); // call failed
    else
    { // get the categories and update the panel
        m_poiCategoryList.append(reply_0.value());
        for (index=0;index < m_poiCategoryList.size(); index++)
        {
            categories << m_poiCategoryList.at(index).id;

            QCheckBox *cat = new QCheckBox();
            cat->setText(QString::fromStdString(m_poiCategoryList.at(index).name));
            cat->setChecked(Qt::Unchecked);

            // Check if it's the all categories id
            if (m_poiCategoryList.at(index).id == settingsCategoryAllCategories)
            {
                connect(cat, SIGNAL(stateChanged(int)), this, SLOT(on_embeddedAllCategoryCheckBox_stateChanged(int)));
            }
            mp_categoryCheckBox.append(cat);
            ui->CategoryLayout->addWidget(cat);

            // Must fit that list and order of attributes: "Source","WebSite","Phone","Stars","Open hours","HouseNumber","Street","Post code","City","Brand","Operateur"

            QCheckBox *attribSource = new QCheckBox();
            attribSource->setChecked(Qt::Unchecked);
            mp_attributeSourceCheckBox.append(attribSource);
            ui->SourceLayout->addWidget(attribSource);

            QCheckBox *attribWebSite = new QCheckBox();
            attribWebSite->setChecked(Qt::Unchecked);
            mp_attributeWebSiteCheckBox.append(attribWebSite);
            ui->WebSiteLayout->addWidget(attribWebSite);

            QCheckBox *attribPhone = new QCheckBox();
            attribPhone->setChecked(Qt::Unchecked);
            mp_attributePhoneCheckBox.append(attribPhone);
            ui->PhoneLayout->addWidget(attribPhone);

            QCheckBox *attribStars = new QCheckBox();
            attribStars->setChecked(Qt::Unchecked);
            mp_attributeStarsCheckBox.append(attribStars);
            ui->StarsLayout->addWidget(attribStars);

            QCheckBox *attribOpeningHours = new QCheckBox();
            attribStars->setChecked(Qt::Unchecked);
            mp_attributeOpeningHoursCheckBox.append(attribOpeningHours);
            ui->OpeningHoursLayout->addWidget(attribOpeningHours);

            QCheckBox *attribAddrHouseNumber = new QCheckBox();
            attribAddrHouseNumber->setChecked(Qt::Unchecked);
            mp_attributeAddrHouseNumberCheckBox.append(attribAddrHouseNumber);
            ui->AddrHouseNumberLayout->addWidget(attribAddrHouseNumber);

            QCheckBox *attribAddrStreet = new QCheckBox();
            attribAddrStreet->setChecked(Qt::Unchecked);
            mp_attributeAddrStreetCheckBox.append(attribAddrStreet);
            ui->AddrStreetLayout->addWidget(attribAddrStreet);

            QCheckBox *attribAddrPostCode = new QCheckBox();
            attribAddrPostCode->setChecked(Qt::Unchecked);
            mp_attributeAddrPostCodeCheckBox.append(attribAddrPostCode);
            ui->AddrPostCodeLayout->addWidget(attribAddrPostCode);

            QCheckBox *attribAddrCity = new QCheckBox();
            attribAddrCity->setChecked(Qt::Unchecked);
            mp_attributeAddrCityCheckBox.append(attribAddrCity);
            ui->AddrCityLayout->addWidget(attribAddrCity);

            QCheckBox *attribBrand = new QCheckBox();
            attribBrand->setChecked(Qt::Unchecked);
            mp_attributeBrandCheckBox.append(attribBrand);
            ui->BrandLayout->addWidget(attribBrand);

            QCheckBox *attribOperateur = new QCheckBox();
            attribOperateur->setChecked(Qt::Unchecked);
            mp_attributeOperateurCheckBox.append(attribOperateur);
            ui->OperateurLayout->addWidget(attribOperateur);

            QLineEdit *rad = new QLineEdit();
            rad->setText(QString::number(settingsDefaultRadius));
            mp_radiusLineEditBox.append(rad);
            ui->RadiusLayout->addWidget(rad);

            radius = (settingsDefaultRadius*m_mapWidth)/(2*settingsMapWidthInMeter);
            QGraphicsEllipseItem *ellipse = m_scenePOI.addEllipse(QRectF((m_mapCenterX - radius/2), (m_mapCenterY - radius/2), radius, radius), QPen(Qt::green, 3, Qt::DashDotLine, Qt::RoundCap, Qt::RoundJoin), QBrush(Qt::NoBrush));
            ellipse->hide();
            mp_radiusEllipse.append(ellipse);
        }
    }

    QDBusPendingReply<QList<categoryDetailsList_t> > reply_1 = m_dbusPoiSearchInterface->GetCategoriesDetails(categories);
    reply_1.waitForFinished();
    if (reply_1.isError())
        manageDBusError(reply_1.reply()); // call failed
    else
    { // get the categories details and update the panel
        m_poiCategoryDetailsList.append(reply_1.value());
        for (index=0;index < m_poiCategoryDetailsList.size(); index++)
        {
            if (m_poiCategoryList.at(index).id != m_poiCategoryDetailsList.at(index).details.id)
            {
                //to do manage the error
                break;
            }
            else
            {
                //disable all the attributes as a default setting value
                // Must fit that list and order of attributes: "Source","WebSite","Phone","Stars","Open hours","HouseNumber","Street","Post code","City","Brand","Operateur"
                mp_attributeSourceCheckBox.at(index)->setEnabled(false);
                mp_attributeWebSiteCheckBox.at(index)->setEnabled(false);
                mp_attributePhoneCheckBox.at(index)->setEnabled(false);
                mp_attributeStarsCheckBox.at(index)->setEnabled(false);
                mp_attributeOpeningHoursCheckBox.at(index)->setEnabled(false);
                mp_attributeAddrHouseNumberCheckBox.at(index)->setEnabled(false);
                mp_attributeAddrStreetCheckBox.at(index)->setEnabled(false);
                mp_attributeAddrPostCodeCheckBox.at(index)->setEnabled(false);
                mp_attributeAddrCityCheckBox.at(index)->setEnabled(false);
                mp_attributeBrandCheckBox.at(index)->setEnabled(false);
                mp_attributeOperateurCheckBox.at(index)->setEnabled(false);
                //get the available attributes for the category
                //and set the attribute names
                 for (sub_index=0;sub_index<m_poiCategoryDetailsList.at(index).attributes.size();sub_index++)
                {
                    if (m_poiCategoryDetailsList.at(index).attributes.at(sub_index).id == settingsAttributeSource)
                    {
                        mp_attributeSourceCheckBox.at(index)->setEnabled(true);
                    }
                    else
                        if (m_poiCategoryDetailsList.at(index).attributes.at(sub_index).id == settingsAttributeWebSite)
                        {
                            mp_attributeWebSiteCheckBox.at(index)->setEnabled(true);
                        }
                        else
                            if (m_poiCategoryDetailsList.at(index).attributes.at(sub_index).id == settingsAttributePhone)
                            {
                                mp_attributePhoneCheckBox.at(index)->setEnabled(true);
                            }
                            else
                                if (m_poiCategoryDetailsList.at(index).attributes.at(sub_index).id == settingsAttributeStars)
                                {
                                    mp_attributeStarsCheckBox.at(index)->setEnabled(true);
                                }
                                else
                                    if (m_poiCategoryDetailsList.at(index).attributes.at(sub_index).id == settingsAttributeOpeningHours)
                                    {
                                        mp_attributeOpeningHoursCheckBox.at(index)->setEnabled(true);
                                    }
                                    else
                                        if (m_poiCategoryDetailsList.at(index).attributes.at(sub_index).id == settingsAttributeAddrHouseNumber)
                                        {
                                            mp_attributeAddrHouseNumberCheckBox.at(index)->setEnabled(true);
                                        }
                                        else
                                            if (m_poiCategoryDetailsList.at(index).attributes.at(sub_index).id == settingsAttributeAddrStreet)
                                            {
                                                mp_attributeAddrStreetCheckBox.at(index)->setEnabled(true);
                                            }
                                            else
                                                if (m_poiCategoryDetailsList.at(index).attributes.at(sub_index).id == settingsAttributeAddrPostCode)
                                                {
                                                    mp_attributeAddrPostCodeCheckBox.at(index)->setEnabled(true);
                                                }
                                                else
                                                    if (m_poiCategoryDetailsList.at(index).attributes.at(sub_index).id == settingsAttributeAddrCity)
                                                    {
                                                        mp_attributeAddrCityCheckBox.at(index)->setEnabled(true);
                                                    }
                                                    else
                                                        if (m_poiCategoryDetailsList.at(index).attributes.at(sub_index).id == settingsAttributeBrand)
                                                        {
                                                            mp_attributeBrandCheckBox.at(index)->setEnabled(true);
                                                        }
                                                        else
                                                            if (m_poiCategoryDetailsList.at(index).attributes.at(sub_index).id == settingsAttributeOperateur)
                                                            {
                                                                mp_attributeOperateurCheckBox.at(index)->setEnabled(true);
                                                            }
                }
            }
        }
    }

    // GetVersion of the poisearch component
    QDBusPendingReply<version_t > reply_2 = m_dbusPoiSearchInterface->GetVersion();
    reply_2.waitForFinished();
    if (reply_2.isError())
        manageDBusError(reply_2.reply()); // call failed
    else
    { // get the version and update the panel
        version = reply_2.value();
        ui->VersionSearch->setText("Search: " + QString::number(version.major) + "." + QString::number(version.minor) + "." + QString::number(version.micro) + " " + QString::fromStdString(version.date));
    }

    // GetRootCategory
    QDBusPendingReply<categoryId_t > reply_3 = m_dbusPoiSearchInterface->GetRootCategory();
    reply_3.waitForFinished();
    if (reply_3.isError())
        manageDBusError(reply_3.reply()); // call failed
    else
    { // get the root category and update the panel
        m_rootCategory.id = reply_3.value();
    }
}

/**
 * \fn
 * \brief .
 *
 * \param
 * \param
 * \return
 */
void MainWindow::on_About_clicked()
{
    aboutDialog about(this);
    about.exec();
}

/**
 * \fn refreshViewTable(ushort windowSize)
 * \brief Refresh the POI view by invoking the DBus methods RequestResultList and GetPoiDetails.
 *
 * \param
 * \param
 * \return
 */
void MainWindow::refreshViewTable(ushort windowSize)
{
    ushort index,sub_index,index_in_table;
    QString str;
    QList<attributeId_t> attributes;
    QList<resultSearch_t> poiList;
    QList<resultSearchDetails_t> poiDetailsList;
    QList<uint> idList;

    //populate attributes list with the requested attributes
    if (mp_attributeGetCheckBox.at(settingsAttributeSource)->isChecked())
        attributes << settingsAttributeSource;
     if (mp_attributeGetCheckBox.at(settingsAttributeWebSite)->isChecked())
        attributes << settingsAttributeWebSite;
     if (mp_attributeGetCheckBox.at(settingsAttributePhone)->isChecked())
        attributes << settingsAttributePhone;
     if (mp_attributeGetCheckBox.at(settingsAttributeStars)->isChecked())
        attributes << settingsAttributeStars;
     if (mp_attributeGetCheckBox.at(settingsAttributeOpeningHours)->isChecked())
        attributes << settingsAttributeOpeningHours;
     if (mp_attributeGetCheckBox.at(settingsAttributeAddrHouseNumber)->isChecked())
        attributes << settingsAttributeAddrHouseNumber;
     if (mp_attributeGetCheckBox.at(settingsAttributeAddrStreet)->isChecked())
        attributes << settingsAttributeAddrStreet;
     if (mp_attributeGetCheckBox.at(settingsAttributeAddrPostCode)->isChecked())
        attributes << settingsAttributeAddrPostCode;
     if (mp_attributeGetCheckBox.at(settingsAttributeAddrCity)->isChecked())
        attributes << settingsAttributeAddrCity;
     if (mp_attributeGetCheckBox.at(settingsAttributeBrand)->isChecked())
        attributes << settingsAttributeBrand;
     if (mp_attributeGetCheckBox.at(settingsAttributeOperateur)->isChecked())
        attributes << settingsAttributeOperateur;

    clearViewTable();

    // RequestResultList
    QDBusPendingReply<int, ushort, QList<resultSearch_t> >reply_0 = m_dbusPoiSearchInterface->RequestResultList(m_poiSearchHandle, m_currentTopListIndex, windowSize, attributes);
    reply_0.waitForFinished();
    if (reply_0.isError())
        manageDBusError(reply_0.reply()); // call failed
    else
    { // get the poi and update the panel
        if (qdbus_cast<ushort>(reply_0.argumentAt(0)) == GENIVI_POISERVICE_FINISHED) //check status
        {
            poiList << (qdbus_cast<QList<resultSearch_t> >(reply_0.argumentAt(2))); //get the list
            if (qdbus_cast<ushort>(reply_0.argumentAt(1)) != m_totalSize)
            {
                //POIListChanged gives a size that is different from the size given by this method ?
            }
            if (poiList.size() > 0) //check if list not empty to avoid crash !
            {
                for(index=0;index<qdbus_cast<ushort>(reply_0.argumentAt(1));index++)
                {
                    mp_tableViewPoi->item(index,columnDistance)->setText(QString::number(poiList.at(index).distance));
                    mp_tableViewPoi->item(index,columnId)->setText(QString::number(poiList.at(index).id));
                    idList.push_back(poiList.at(index).id);
                    for (sub_index=0;sub_index<poiList.at(index).attributes.size();sub_index++)
                    {
                        str = poiList.at(index).attributes.at(sub_index).value.value.variant().toString();
                        mp_tableViewPoi->item(index,columnBeginAttributes+poiList.at(index).attributes.at(sub_index).id)->setText(str);
                    }
                 }
            }
        }
    }

    // GetPoiDetails
    QDBusPendingReply<QList<resultSearchDetails_t> >reply_1 = m_dbusPoiSearchInterface->GetPoiDetails(idList);
    reply_1.waitForFinished();
    if (reply_1.isError())
        manageDBusError(reply_1.reply()); // call failed
    else
    { // get the poi and update the panel
        poiDetailsList.append(reply_1.value());
        if (poiDetailsList.size() > 0)
        {
            for(index=0;index<poiDetailsList.size();index++)
            {
                mp_tableViewPoi->item(index,columnName)->setText(poiDetailsList.at(index).details.name);
                if (giveCategoryIndex(poiDetailsList.at(index).categories.at(0),&index_in_table) == true)
                { //found into the embedded data
                    mp_tableViewPoi->item(index,columnCategory)->setText(QString::fromStdString(m_poiCategoryList.at(index_in_table).name));  //only one category !
                    mp_tableViewPoi->item(index,columnIcon)->setText(m_poiCategoryDetailsList.at(index_in_table).details.icons.value.variant().toString());
                    QPixmap pixmap(mp_tableViewPoi->item(index,columnIcon)->text());
                    m_tableIconPOI.append(pixmap);
                }
                else
                { //search into the additional data
                    if (giveCategoryIndexAdditional(poiDetailsList.at(index).categories.at(0),&index_in_table) == true)
                    { //found into the additional data
                        mp_tableViewPoi->item(index,columnCategory)->setText(QString::fromStdString(m_poiCategoryListAdditional.at(index_in_table).name));  //only one category !
                        mp_tableViewPoi->item(index,columnIcon)->setText(m_poiCategoryDetailsListAdditional.at(index_in_table).details.icons.value.variant().toString());
                        QPixmap pixmap(mp_tableViewPoi->item(index,columnIcon)->text());
                        m_tableIconPOI.append(pixmap);
                    }
                }
                mp_tableViewPoi->item(index,columnLatitude)->setText(QString::number(poiDetailsList.at(index).details.location.latitude));
                mp_tableViewPoi->item(index,columnLongitude)->setText(QString::number(poiDetailsList.at(index).details.location.longitude));
            }
        }
    }
    ui->recordFrom->setText(QString::number(m_currentTopListIndex));
    ui->recordTo->setText(QString::number(m_currentTopListIndex+windowSize-1));
}

/**
 * \fn on_getTopList_clicked()
 * \brief get top records of the list.
 *
 * \param
 * \param
 * \return
 */
void MainWindow::on_getTopList_clicked()
{
    if (m_totalSize != 0)
    {
        m_currentTopListIndex = 0;
        if (m_totalSize > settingsPoiDisplayTableRows)
            refreshViewTable(settingsPoiDisplayTableRows);
        else
            refreshViewTable(m_totalSize);
    }
}

/**
 * \fn on_getNextList_clicked()
 * \brief get next records.
 *
 * \param
 * \param
 * \return
 */
void MainWindow::on_getNextList_clicked()
{
    if (m_totalSize != 0)
    {
        if ((m_currentTopListIndex + settingsPoiDisplayTableRows) < m_totalSize)
        {
            m_currentTopListIndex += settingsPoiDisplayTableRows;
            if ((m_currentTopListIndex + settingsPoiDisplayTableRows) < m_totalSize)
                refreshViewTable(settingsPoiDisplayTableRows);
            else
                refreshViewTable(m_totalSize - m_currentTopListIndex);
        }
        else
        { //end of list reached, do something ?

        }
    }
}

/**
 * \fn on_getPrevList_clicked()
 * \brief get previous records.
 *
 * \param
 * \param
 * \return
 */
void MainWindow::on_getPrevList_clicked()
{
    if (m_totalSize != 0)
    {
        if (m_currentTopListIndex >= settingsPoiDisplayTableRows)
        { //not the top page
            m_currentTopListIndex -= settingsPoiDisplayTableRows;
            refreshViewTable(settingsPoiDisplayTableRows);
        }
        else
        { //top of list reached, do something ?

        }
    }
}



/**
 * \fn on_setProximity_clicked()
 * \brief Set proximity alert invoke the DBus methods SetCategories, SetAttributes, SetCenter and StartPoiProximityAlert.
 *
 * \param
 * \return
 */
void MainWindow::on_setProximity_clicked()
{
    ushort sortOption = GENIVI_POISERVICE_SORT_DEFAULT;

    if ((isSetProximityModeSelected == false) && (isSearchAroundTheVehicleSelected == false))
    {
        isSetProximityModeSelected = true;
        ui->searchMode->setText(tr("Proximity search"));

        //select the categories
        select_category();

        //set the proximity alert
        QDBusPendingReply<> reply_1 = m_dbusPoiSearchInterface->StartPoiProximityAlert(m_poiSearchHandle,ui->stringToSearch->text(),sortOption);
        reply_1.waitForFinished();
        if (reply_1.isError())
            manageDBusError(reply_1.reply()); // call failed
    }
}

/**
 * \fn on_cancelProximity_clicked()
 * \brief Stop proximity alert, invoke the DBus method CancelPoiProximityAlert.
 *
 * \param
 * \return
 */
void MainWindow::on_cancelProximity_clicked()
{
    if (isSetProximityModeSelected == true)
    {
        isSetProximityModeSelected = false;
        ui->searchMode->setText(noValue);

        //search around a location unset
        QDBusPendingReply<> reply_0 = m_dbusPoiSearchInterface->CancelPoiProximityAlert(m_poiSearchHandle);
        reply_0.waitForFinished();
        if (reply_0.isError())
            manageDBusError(reply_0.reply()); // call failed
    }
}


void MainWindow::on_embeddedAllCategoryCheckBox_stateChanged(int state)
{
    if (state)
    {
        if (mp_attributeSourceCheckBox.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributeSourceCheckBox.at(settingsCategoryAllCategories)->setChecked(true);
        if (mp_attributeWebSiteCheckBox.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributeWebSiteCheckBox.at(settingsCategoryAllCategories)->setChecked(true);
        if (mp_attributePhoneCheckBox.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributePhoneCheckBox.at(settingsCategoryAllCategories)->setChecked(true);
        if (mp_attributeStarsCheckBox.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributeStarsCheckBox.at(settingsCategoryAllCategories)->setChecked(true);
        if (mp_attributeOpeningHoursCheckBox.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributeOpeningHoursCheckBox.at(settingsCategoryAllCategories)->setChecked(true);
        if (mp_attributeAddrHouseNumberCheckBox.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributeAddrHouseNumberCheckBox.at(settingsCategoryAllCategories)->setChecked(true);
        if (mp_attributeAddrStreetCheckBox.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributeAddrStreetCheckBox.at(settingsCategoryAllCategories)->setChecked(true);
        if (mp_attributeAddrPostCodeCheckBox.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributeAddrPostCodeCheckBox.at(settingsCategoryAllCategories)->setChecked(true);
        if (mp_attributeAddrCityCheckBox.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributeAddrCityCheckBox.at(settingsCategoryAllCategories)->setChecked(true);
        if (mp_attributeBrandCheckBox.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributeBrandCheckBox.at(settingsCategoryAllCategories)->setChecked(true);
        if (mp_attributeOperateurCheckBox.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributeOperateurCheckBox.at(settingsCategoryAllCategories)->setChecked(true);
    }
    else
    {
        mp_attributeSourceCheckBox.at(settingsCategoryAllCategories)->setChecked(false);
        mp_attributeWebSiteCheckBox.at(settingsCategoryAllCategories)->setChecked(false);
        mp_attributePhoneCheckBox.at(settingsCategoryAllCategories)->setChecked(false);
        mp_attributeStarsCheckBox.at(settingsCategoryAllCategories)->setChecked(false);
        mp_attributeOpeningHoursCheckBox.at(settingsCategoryAllCategories)->setChecked(false);
        mp_attributeAddrHouseNumberCheckBox.at(settingsCategoryAllCategories)->setChecked(false);
        mp_attributeAddrStreetCheckBox.at(settingsCategoryAllCategories)->setChecked(false);
        mp_attributeAddrPostCodeCheckBox.at(settingsCategoryAllCategories)->setChecked(false);
        mp_attributeAddrCityCheckBox.at(settingsCategoryAllCategories)->setChecked(false);
        mp_attributeBrandCheckBox.at(settingsCategoryAllCategories)->setChecked(false);
        mp_attributeOperateurCheckBox.at(settingsCategoryAllCategories)->setChecked(false);
    }
}

void MainWindow::on_addedAllCategoryCheckBox_stateChanged(int state)
{
    if (state)
    {
        if (mp_attributeSourceCheckBoxAdditional.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributeSourceCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(true);
        if (mp_attributeWebSiteCheckBoxAdditional.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributeWebSiteCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(true);
        if (mp_attributePhoneCheckBoxAdditional.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributePhoneCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(true);
        if (mp_attributeStarsCheckBoxAdditional.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributeStarsCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(true);
        if (mp_attributeOpeningHoursCheckBoxAdditional.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributeOpeningHoursCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(true);
        if (mp_attributeAddrHouseNumberCheckBoxAdditional.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributeAddrHouseNumberCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(true);
        if (mp_attributeAddrStreetCheckBoxAdditional.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributeAddrStreetCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(true);
        if (mp_attributeAddrPostCodeCheckBoxAdditional.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributeAddrPostCodeCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(true);
        if (mp_attributeAddrCityCheckBoxAdditional.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributeAddrCityCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(true);
        if (mp_attributeBrandCheckBoxAdditional.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributeBrandCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(true);
        if (mp_attributeOperateurCheckBoxAdditional.at(settingsCategoryAllCategories)->isEnabled())
            mp_attributeOperateurCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(true);
    }
    else
    {
        mp_attributeSourceCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(false);
        mp_attributeWebSiteCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(false);
        mp_attributePhoneCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(false);
        mp_attributeStarsCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(false);
        mp_attributeOpeningHoursCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(false);
        mp_attributeAddrHouseNumberCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(false);
        mp_attributeAddrStreetCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(false);
        mp_attributeAddrPostCodeCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(false);
        mp_attributeAddrCityCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(false);
        mp_attributeBrandCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(false);
        mp_attributeOperateurCheckBoxAdditional.at(settingsCategoryAllCategories)->setChecked(false);
    }
}

//Management of DBus signals
/**
 * \fn on_DBusSignalPoiStatus(handleId_t poiSearchHandle,int statusValue)
 * \brief Signal received when the POI status changed.
 *
 * \param uint poiSearchHandle
 * \param int statusValue
 * \return
 */
void MainWindow::on_DBusSignalPoiStatus(uint poiSearchHandle, int statusValue)
{
    if (poiSearchHandle == m_poiSearchHandle)
    {
        manageStatus(statusValue);
    }
}

/**
 * \fn on_DBusSignalResultListChanged(handleId_t poiSearchHandle,ushort resultListSize)
 * \brief Signal received when the result list changed.
 *
 * \param uint poiSearchHandle
 * \param ushort totalSize
 * \return
 */
void MainWindow::on_DBusSignalResultListChanged(uint poiSearchHandle, ushort resultListSize)
{
    QString str;
    if (poiSearchHandle == m_poiSearchHandle)
    {
        m_totalSize = resultListSize;
        if (m_totalSize == 0)
            ui->totalSize->setText(tr("EMPTY"));
        else
        {
            str = QString::number(m_totalSize) + " record(s)";
            ui->totalSize->setText(str);
            clearViewTable();
            m_currentTopListIndex = 0;
            ui->recordFrom->setText("");
            ui->recordTo->setText("");            
        }
    }
}

/**
 * \fn on_DBusSignalCategoriesRegistered(QList<poiCategoryAndReason_t> poiCategoriesAndReason)
 * \brief Signal received when new categories have been registered, invokes the DBus method GetAvailableCategories and GetCategoriesDetails.
 *
 * \param QList<poiCategoryAndReason_t> poiCategories
 * \param
 * \return
 */
void MainWindow::on_DBusSignalCategoriesUpdated(QList<poiCategoryAndReason_t> poiCategoriesAndReason)
{
    ushort index,sub_index;
    uint radius;
    QList<poiCategoryFull_t> poiList;
    QList<categoryId_t> categories;
    QCheckBox *item;
    QLineEdit *line;
    QGraphicsEllipseItem *ellipse;

    // Because of relatively low amount of categories, strategy is to clean up everything and to refresh the whole additional categories
    // Implementation is not really the right way to manage it, needs to be improved
    // Preliminary clean up

    // Clean up display
    for (index=0;index < mp_categoryCheckBoxAdditional.size();index++)
    {
        item = mp_categoryCheckBoxAdditional.at(index);
        delete item;
    }
    // Must fit that list and order of attributes: "Source","WebSite","Phone","Stars","Open hours","HouseNumber","Street","Post code","City","Brand","Operateur"
    for (index=0;index < mp_attributeSourceCheckBoxAdditional.size();index++)
    {
        item = mp_attributeSourceCheckBoxAdditional.at(index);
        delete item;
    }
    for (index=0;index < mp_attributeWebSiteCheckBoxAdditional.size();index++)
    {
        item = mp_attributeWebSiteCheckBoxAdditional.at(index);
        delete item;
    }
    for (index=0;index < mp_attributePhoneCheckBoxAdditional.size();index++)
    {
        item = mp_attributePhoneCheckBoxAdditional.at(index);
        delete item;
    }
    for (index=0;index < mp_attributeStarsCheckBoxAdditional.size();index++)
    {
        item = mp_attributeStarsCheckBoxAdditional.at(index);
        delete item;
    }
    for (index=0;index < mp_attributeOpeningHoursCheckBoxAdditional.size();index++)
    {
        item = mp_attributeOpeningHoursCheckBoxAdditional.at(index);
        delete item;
    }
    for (index=0;index < mp_attributeAddrHouseNumberCheckBoxAdditional.size();index++)
    {
        item = mp_attributeAddrHouseNumberCheckBoxAdditional.at(index);
        delete item;
    }
    for (index=0;index < mp_attributeAddrStreetCheckBoxAdditional.size();index++)
    {
        item = mp_attributeAddrStreetCheckBoxAdditional.at(index);
        delete item;
    }
    for (index=0;index < mp_attributeAddrPostCodeCheckBoxAdditional.size();index++)
    {
        item = mp_attributeAddrPostCodeCheckBoxAdditional.at(index);
        delete item;
    }
    for (index=0;index < mp_attributeAddrCityCheckBoxAdditional.size();index++)
    {
        item = mp_attributeAddrCityCheckBoxAdditional.at(index);
        delete item;
    }
    for (index=0;index < mp_attributeBrandCheckBoxAdditional.size();index++)
    {
        item = mp_attributeBrandCheckBoxAdditional.at(index);
        delete item;
    }
    for (index=0;index < mp_attributeOperateurCheckBoxAdditional.size();index++)
    {
        item = mp_attributeOperateurCheckBoxAdditional.at(index);
        delete item;
    }

    for (index=0;index < mp_radiusLineEditBoxAdditional.size();index++)
    {
        line = mp_radiusLineEditBoxAdditional.at(index);
        delete line;
    }
    for (index=0;index < mp_radiusEllipseAdditional.size();index++)
    {
        ellipse = mp_radiusEllipseAdditional.at(index);
        delete ellipse;
    }

    // Clean up tables
    m_poiCategoryListAdditional.clear();
    m_poiCategoryDetailsListAdditional.clear();
    mp_categoryCheckBoxAdditional.clear();
    // Must fit that list and order of attributes: "Source","WebSite","Phone","Stars","Open hours","HouseNumber","Street","Post code","City","Brand","Operateur"
    mp_attributeSourceCheckBoxAdditional.clear();
    mp_attributeWebSiteCheckBoxAdditional.clear();
    mp_attributePhoneCheckBoxAdditional.clear();
    mp_attributeStarsCheckBoxAdditional.clear();
    mp_attributeOpeningHoursCheckBoxAdditional.clear();
    mp_attributeAddrHouseNumberCheckBoxAdditional.clear();
    mp_attributeAddrStreetCheckBoxAdditional.clear();
    mp_attributeAddrPostCodeCheckBoxAdditional.clear();
    mp_attributeAddrCityCheckBoxAdditional.clear();
    mp_attributeBrandCheckBoxAdditional.clear();
    mp_attributeOperateurCheckBoxAdditional.clear();
    mp_radiusLineEditBoxAdditional.clear();
    mp_radiusEllipseAdditional.clear();


    // GetAvailableCategories (the embedded and the additional)
    QDBusPendingReply<QList<poiCategoryFull_t> > reply_0 = m_dbusPoiSearchInterface->GetAvailableCategories();
    reply_0.waitForFinished();
    if (reply_0.isError())
        manageDBusError(reply_0.reply()); // call failed
    else
    { // check if it's an additional category and update the additional panel
        poiList.append(reply_0.value());
        categories.clear(); // list used for the GetCategoriesDetails
        for (index=0;index < poiList.size(); index++)
        {
            if (isNewCategory(poiList.at(index).id,poiCategoriesAndReason) == true)
            {
                m_poiCategoryListAdditional.push_back(poiList.at(index));

                categories << poiList.at(index).id;

                QCheckBox *cat = new QCheckBox();
                cat->setText(QString::fromStdString((poiList.at(index)).name));
                cat->setChecked(Qt::Unchecked);

                // Check if it's the all categories id
                if (poiList.at(index).id == settingsCategoryAllCategories + settingsCAMOffset)
                {
                    connect(cat, SIGNAL(stateChanged(int)), this, SLOT(on_addedAllCategoryCheckBox_stateChanged(int)));
                }

                mp_categoryCheckBoxAdditional.append(cat);
                ui->CategoryLayoutAdditional->addWidget(cat);

                // Must fit that list and order of attributes: "Source","WebSite","Phone","Stars","Open hours","HouseNumber","Street","Post code","City","Brand","Operateur"
                QCheckBox *attribSource = new QCheckBox();
                attribSource->setChecked(Qt::Unchecked);
                attribSource->setEnabled(false);
                mp_attributeSourceCheckBoxAdditional.append(attribSource);
                ui->SourceLayoutAdditional->addWidget(attribSource);

                QCheckBox *attribWebSite = new QCheckBox();
                attribWebSite->setChecked(Qt::Unchecked);
                attribWebSite->setEnabled(false);
                mp_attributeWebSiteCheckBoxAdditional.append(attribWebSite);
                ui->WebSiteLayoutAdditional->addWidget(attribWebSite);

                QCheckBox *attribPhone = new QCheckBox();
                attribPhone->setChecked(Qt::Unchecked);
                attribPhone->setEnabled(false);
                mp_attributePhoneCheckBoxAdditional.append(attribPhone);
                ui->PhoneLayoutAdditional->addWidget(attribPhone);

                QCheckBox *attribStars = new QCheckBox();
                attribStars->setChecked(Qt::Unchecked);
                attribStars->setEnabled(false);
                mp_attributeStarsCheckBoxAdditional.append(attribStars);
                ui->StarsLayoutAdditional->addWidget(attribStars);

                QCheckBox *attribOpeningHours = new QCheckBox();
                attribOpeningHours->setChecked(Qt::Unchecked);
                attribOpeningHours->setEnabled(false);
                mp_attributeOpeningHoursCheckBoxAdditional.append(attribOpeningHours);
                ui->OpeningHoursLayoutAdditional->addWidget(attribOpeningHours);

                QCheckBox *attribAddrHouseNumber = new QCheckBox();
                attribAddrHouseNumber->setChecked(Qt::Unchecked);
                attribAddrHouseNumber->setEnabled(false);
                mp_attributeAddrHouseNumberCheckBoxAdditional.append(attribAddrHouseNumber);
                ui->AddrHouseNumberLayoutAdditional->addWidget(attribAddrHouseNumber);

                QCheckBox *attribAddrStreet = new QCheckBox();
                attribAddrStreet->setChecked(Qt::Unchecked);
                attribAddrStreet->setEnabled(false);
                mp_attributeAddrStreetCheckBoxAdditional.append(attribAddrStreet);
                ui->AddrStreetLayoutAdditional->addWidget(attribAddrStreet);

                QCheckBox *attribAddrPostCode = new QCheckBox();
                attribAddrPostCode->setChecked(Qt::Unchecked);
                attribAddrPostCode->setEnabled(false);
                mp_attributeAddrPostCodeCheckBoxAdditional.append(attribAddrPostCode);
                ui->AddrPostCodeLayoutAdditional->addWidget(attribAddrPostCode);

                QCheckBox *attribAddrCity = new QCheckBox();
                attribAddrCity->setChecked(Qt::Unchecked);
                attribAddrCity->setEnabled(false);
                mp_attributeAddrCityCheckBoxAdditional.append(attribAddrCity);
                ui->AddrCityLayoutAdditional->addWidget(attribAddrCity);

                QCheckBox *attribBrand = new QCheckBox();
                attribBrand->setChecked(Qt::Unchecked);
                attribBrand->setEnabled(false);
                mp_attributeBrandCheckBoxAdditional.append(attribBrand);
                ui->BrandLayoutAdditional->addWidget(attribBrand);

                QCheckBox *attribOperateur = new QCheckBox();
                attribOperateur->setChecked(Qt::Unchecked);
                attribOperateur->setEnabled(false);
                mp_attributeOperateurCheckBoxAdditional.append(attribOperateur);
                ui->OperateurLayoutAdditional->addWidget(attribOperateur);

                QLineEdit *rad = new QLineEdit();
                rad->setText(QString::number(settingsDefaultRadius));
                mp_radiusLineEditBoxAdditional.append(rad);
                ui->RadiusLayoutAdditional->addWidget(rad);

                radius = (settingsDefaultRadius*m_mapWidth)/(2*settingsMapWidthInMeter);
                QGraphicsEllipseItem *ellipse = m_scenePOI.addEllipse(QRectF((m_mapCenterX - radius/2), (m_mapCenterY - radius/2), radius, radius), QPen(Qt::green, 3, Qt::DashDotLine, Qt::RoundCap, Qt::RoundJoin), QBrush(Qt::NoBrush));
                ellipse->hide();
                mp_radiusEllipseAdditional.append(ellipse);
            }
        }
    }

    // GetCategoriesDetails
    QDBusPendingReply<QList<categoryDetailsList_t> > reply_1 = m_dbusPoiSearchInterface->GetCategoriesDetails(categories);
    reply_1.waitForFinished();
    if (reply_1.isError())
        manageDBusError(reply_1.reply()); // call failed
    else
    { // get the categories details and update the panel
        m_poiCategoryDetailsListAdditional.append(reply_1.value());
        for (index=0;index < m_poiCategoryDetailsListAdditional.size(); index++)
        {
            if (m_poiCategoryListAdditional.at(index).id != m_poiCategoryDetailsListAdditional.at(index).details.id)
            {
                //to do manage the error
                break;
            }
            else
            {
                //get the available attributes for the category
                // Must fit that list and order of attributes: "Source","WebSite","Phone","Stars","Open hours","HouseNumber","Street","Post code","City","Brand","Operateur"
                for (sub_index=0;sub_index<m_poiCategoryDetailsListAdditional.at(index).attributes.size();sub_index++)
                {
                    if (m_poiCategoryDetailsListAdditional.at(index).attributes.at(sub_index).id == settingsAttributeSource)
                        mp_attributeSourceCheckBoxAdditional.at(index)->setEnabled(true);
                    else
                        if (m_poiCategoryDetailsListAdditional.at(index).attributes.at(sub_index).id == settingsAttributeWebSite)
                            mp_attributeWebSiteCheckBoxAdditional.at(index)->setEnabled(true);
                        else
                            if (m_poiCategoryDetailsListAdditional.at(index).attributes.at(sub_index).id == settingsAttributePhone)
                                mp_attributePhoneCheckBoxAdditional.at(index)->setEnabled(true);
                            else
                                if (m_poiCategoryDetailsListAdditional.at(index).attributes.at(sub_index).id == settingsAttributeStars)
                                    mp_attributeStarsCheckBoxAdditional.at(index)->setEnabled(true);
                                else
                                    if (m_poiCategoryDetailsListAdditional.at(index).attributes.at(sub_index).id == settingsAttributeOpeningHours)
                                        mp_attributeOpeningHoursCheckBoxAdditional.at(index)->setEnabled(true);
                                    else
                                        if (m_poiCategoryDetailsListAdditional.at(index).attributes.at(sub_index).id == settingsAttributeAddrHouseNumber)
                                            mp_attributeAddrHouseNumberCheckBoxAdditional.at(index)->setEnabled(true);
                                        else
                                            if (m_poiCategoryDetailsListAdditional.at(index).attributes.at(sub_index).id == settingsAttributeAddrStreet)
                                                mp_attributeAddrStreetCheckBoxAdditional.at(index)->setEnabled(true);
                                            else
                                                if (m_poiCategoryDetailsListAdditional.at(index).attributes.at(sub_index).id == settingsAttributeAddrPostCode)
                                                    mp_attributeAddrPostCodeCheckBoxAdditional.at(index)->setEnabled(true);
                                                else
                                                    if (m_poiCategoryDetailsListAdditional.at(index).attributes.at(sub_index).id == settingsAttributeAddrCity)
                                                        mp_attributeAddrCityCheckBoxAdditional.at(index)->setEnabled(true);
                                                    else
                                                        if (m_poiCategoryDetailsListAdditional.at(index).attributes.at(sub_index).id == settingsAttributeBrand)
                                                            mp_attributeBrandCheckBoxAdditional.at(index)->setEnabled(true);
                                                        else
                                                            if (m_poiCategoryDetailsListAdditional.at(index).attributes.at(sub_index).id == settingsAttributeOperateur)
                                                                mp_attributeOperateurCheckBoxAdditional.at(index)->setEnabled(true);
                }
            }
        }
    }
}

void MainWindow::on_DBusSignalConfigurationChanged(QList<ushort> changedSettings)
{

}


/**
 * \fn on_DBusSignalPositionUpdate(QList<ushort> changedValues)
 * \brief Signal received when the position changed, invokes the DBus method GetPosition.
 *
 * \param QList<ushort> changedValues
 * \param
 * \return
 */
void MainWindow::on_DBusSignalPositionUpdate(ulong changedValues)
{
    qulonglong timestamp;
    tupleUlongVariant data;

    // GetPositionInfo
    QDBusPendingReply<qulonglong, tupleUlongVariant>reply_0 = m_dbusPositioningEnhancedPositionInterface->GetPositionInfo(changedValues);
    reply_0.waitForFinished();
    if (reply_0.isError())
        manageDBusError(reply_0.reply()); // call failed
    else
    {
        timestamp = qdbus_cast<qulonglong>(reply_0.argumentAt(0));
        data = qdbus_cast<tupleUlongVariant>(reply_0.argumentAt(1));
        if (data.contains(GENIVI_ENHANCEDPOSITIONSERVICE_LATITUDE))
            ui->currentLocationLatitude->setText(QString::number(data.value(GENIVI_ENHANCEDPOSITIONSERVICE_LATITUDE).variant().toDouble()));
        if (data.contains(GENIVI_ENHANCEDPOSITIONSERVICE_LONGITUDE))
            ui->currentLocationLongitude->setText(QString::number(data.value(GENIVI_ENHANCEDPOSITIONSERVICE_LONGITUDE).variant().toDouble()));

    }
}

/**
 * \fn on_DBusSignalRouteCalculationSuccessful(uchar sessionHandle, uchar routeHandle, QList<ushort> unfullfilledPreferences)
 * \brief Signal received when a route calculation is done, invokes the DBus methods SetRouteHandle, GetRouteBoundingBox and GetRouteSegments.
 *
 * \param uchar routeHandle
 * \param QList<ushort> unfullfilledPreferences
 * \return
 */
void MainWindow::on_DBusSignalRouteCalculationSuccessful(uchar routeHandle, tupleUshortUshort unfullfilledPreferences)
{
    QString str;
    short detailLevel;
    QList<ushort> valuesToReturn;
    uint numberOfSegments;
    uint offset;
    int index;
    route_vector_t routeVector;
    QList<tupleUshortVariant> routeSegments;

    m_routeHandle = routeHandle;
    ui->searchMode->setText(tr("Along a route"));
    str = QString(tr("NUMBER")) + QString(":  ") + QString::number(m_routeHandle);
    ui->routeHandle->setText(str);
    m_totalNumberOfSegments = 0; //reset the number of segments
    m_route.clear();//empty the route

    //Set the route on the server
    QDBusPendingReply<> reply_0 = m_dbusPoiSearchInterface->SetRouteHandle(m_poiSearchHandle,m_sessionHandle, m_routeHandle,m_startSearchOffset,m_endSearchOffset);
    reply_0.waitForFinished();
    if (reply_0.isError())
        manageDBusError(reply_0.reply()); // call failed

    //Get the bounding box for displaying it on the client
    QDBusPendingReply<boundingBox_t> reply_1 = m_dbusNavigationRoutingInterface->GetRouteBoundingBox(m_sessionHandle, m_routeHandle);
    reply_1.waitForFinished();
    if (reply_1.isError())
        manageDBusError(reply_1.reply()); // call failed
    else
    {

    }

    //Get the amount of segments
    detailLevel = 1;
    offset = 0;
    numberOfSegments = 0; //just to get the total amount !
    valuesToReturn.push_back(GENIVI_NAVIGATIONCORE_START_LATITUDE);
    valuesToReturn.push_back(GENIVI_NAVIGATIONCORE_END_LATITUDE);
    valuesToReturn.push_back(GENIVI_NAVIGATIONCORE_START_LONGITUDE);
    valuesToReturn.push_back(GENIVI_NAVIGATIONCORE_END_LONGITUDE);

    QDBusPendingReply<uint,QList<tupleUshortVariant> > reply_2 = m_dbusNavigationRoutingInterface->GetRouteSegments(m_routeHandle,detailLevel,valuesToReturn,numberOfSegments,offset);
    reply_2.waitForFinished();
    if (reply_2.isError())
        manageDBusError(reply_2.reply()); // call failed
    else
    {
        m_totalNumberOfSegments = qdbus_cast<uint>(reply_2.argumentAt(0));
        ui->routeTotalSegments->setText(QString::number(m_totalNumberOfSegments));
    }

    //Get the whole route
    numberOfSegments = m_totalNumberOfSegments;
    QDBusPendingReply<uint,QList<tupleUshortVariant> > reply_3 = m_dbusNavigationRoutingInterface->GetRouteSegments(m_routeHandle,detailLevel,valuesToReturn,numberOfSegments,offset);
    reply_3.waitForFinished();
    if (reply_3.isError())
        manageDBusError(reply_3.reply()); // call failed
    else
    {
        routeSegments << (qdbus_cast<QList<tupleUshortVariant> >(reply_3.argumentAt(1))); //get the list
        for (index=0;index<routeSegments.size();index++)
        {
            if (routeSegments.at(index).contains(GENIVI_NAVIGATIONCORE_START_LATITUDE))
                routeVector.startPoint.latitude = routeSegments.at(index).value(GENIVI_NAVIGATIONCORE_START_LATITUDE).variant().toDouble();
            if (routeSegments.at(index).contains(GENIVI_NAVIGATIONCORE_START_LONGITUDE))
                routeVector.startPoint.longitude = routeSegments.at(index).value(GENIVI_NAVIGATIONCORE_START_LONGITUDE).variant().toDouble();
            if (routeSegments.at(index).contains(GENIVI_NAVIGATIONCORE_END_LATITUDE))
                routeVector.endPoint.latitude = routeSegments.at(index).value(GENIVI_NAVIGATIONCORE_END_LATITUDE).variant().toDouble();
            if (routeSegments.at(index).contains(GENIVI_NAVIGATIONCORE_END_LONGITUDE))
                routeVector.endPoint.longitude = routeSegments.at(index).value(GENIVI_NAVIGATIONCORE_END_LONGITUDE).variant().toDouble();
            m_route.push_back(routeVector);
        }
    }

}

/**
 * \fn on_DBusSignalRouteDeleted(uchar sessionHandle, uchar routeHandle)
 * \brief Signal recieved when a route is deleted.
 *
 * \param uchar routeHandle
 * \return
 */
void MainWindow::on_DBusSignalRouteDeleted(uchar routeHandle)
{
    if (m_routeHandle == routeHandle)
    {
        m_routeHandle = GENIVI_POISERVICE_INVALID;
    }
}

//Utilities
/**
 * \fn clearViewTable()
 * \brief clean up the view table.
 *
 * \param
 * \param
 * \return
 */
void MainWindow::clearViewTable()
{
    uchar row,column;

    m_tableIconPOI.clear();
    for (row=0;row<settingsPoiDisplayTableRows;row++)
    {
        for (column =0;column<columnSize;column++)
        {
            mp_tableViewPoi->item(row,column)->setText("");
        }
    }


}

/**
 * \fn manageDBusError(QDBusMessage reply)
 * \brief manage the error that appears on the dbus.
 *
 * \param
 * \param
 * \return
 */
void MainWindow::manageDBusError(QDBusMessage reply)
{
    qDebug() << reply.errorMessage();
}

/**
 * \fn manageStatus(ushort statusValue)
 * \brief manage the string displayed according to the status.
 *
 * \param int statusValue
 * \param
 * \return
 */
void MainWindow::manageStatus(int statusValue)
{
    QString str;

    m_searchStatus = statusValue;

    switch(statusValue)
    {
    case GENIVI_POISERVICE_INVALID:
        str="INVALID";
        break;
    case GENIVI_POISERVICE_NOT_STARTED:
        str="NOT_STARTED";
        break;
    case GENIVI_POISERVICE_SEARCHING:
        str="SEARCHING";
        break;
    case GENIVI_POISERVICE_FINISHED:
        str="FINISHED";
        break;
    default:
        str="INVALID";
        break;
    }
    ui->search_status->setText(str);
}


/**
 * \fn giveCategoryIndex(ushort id,ushort* index_in_table)
 * \brief give the index of the category into the embedded data.
 *
 * \param ushort id . The category id
 * \param ushort* index_in_table . The index
 * \param
 * \return true if index found
 */
bool MainWindow::giveCategoryIndex(categoryId_t id,ushort* index_in_table)
{
    bool isFound;

    isFound = false;
    *index_in_table = 0;
    do
    {
        if (m_poiCategoryList.at(*index_in_table).id == id)
        {
            isFound = true;
        }
        else
            *index_in_table += 1;
    } while ((isFound == false) && (*index_in_table <m_poiCategoryList.size()));
    return(isFound);
}

/**
 * \fn giveCategoryIndexAdditional(ushort id,ushort* index_in_table)
 * \brief give the index of the category into the additional data.
 *
 * \param ushort id . The category id
 * \param ushort* index_in_table . The index
 * \param
 * \return true if index found
 */
bool MainWindow::giveCategoryIndexAdditional(categoryId_t id,ushort* index_in_table)
{
    bool isFound;

    isFound = false;
    *index_in_table = 0;
    do
    {
        if (m_poiCategoryListAdditional.at(*index_in_table).id == id)
        {
            isFound = true;
        }
        else
            *index_in_table += 1;
    } while ((isFound == false) && (*index_in_table <m_poiCategoryListAdditional.size()));
    return(isFound);
}

bool MainWindow::isNewCategory(categoryId_t id,QList<poiCategoryAndReason_t> poiList)
{
    bool isFound;
    ushort index = 0;
    isFound = false;

    do
    {
        if ((poiList.at(index).reason == GENIVI_POISERVICE_ADDED)&&poiList.at(index).id == id)
            isFound = true;
        else
            ++index;
    } while ((isFound == false) && (index < poiList.size()));
    return(isFound);
}
