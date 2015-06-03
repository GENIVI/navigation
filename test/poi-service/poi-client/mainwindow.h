/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file mainwindow.h
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
#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include "QStandardItemModel"
#include <QtDBus>
#include <QDBusArgument>
#include <QCheckBox>
#include <QLineEdit>
#include <QListWidgetItem>
#include <QGraphicsScene>
#include <QGraphicsEllipseItem>
#include "positioning-constants.h"
#include "genivi-mapviewer-constants.h"
#include "genivi-navigationcore-constants.h"
#include "genivi-poiservice-constants.h"

#include "poi-client-DBusSearchInterface.h"
#include "poi-client-DBusContentAccessInterface.h"
#include "poi-client-DBusRoutingInterface.h"
#include "poi-client-DBusGuidanceInterface.h"
#include "poi-client-DBusEnhancedPositionInterface.h"
#include "poi-client-DBusNavigationCoreSessionInterface.h"
#include "poi-client-DBusConfigurationInterface.h"

namespace Ui {
    class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT
public:
    enum ScreenOrientation {
        ScreenOrientationLockPortrait,
        ScreenOrientationLockLandscape,
        ScreenOrientationAuto
    };

    explicit MainWindow(QWidget *parent = 0);
    virtual ~MainWindow();

    void InitUi();

// settings (from the config file)
    uint settingsInvalidHandle;
    int settingsPoiDisplayTableRows; //max number of rows displayed at a time
    QString settingsDefaultTextToSearch;
    geoCoordinate3D_t settingsDefaultLocation;
    QString settingsDefaultTextToBeInitialized;
    uint settingsDefaultRadius;
    version_t settingsVersion;
    QString settingsLanguageCode;
    QString settingsCountryCode;
    QString settingsScriptCode;
    QString settingsHMIlanguage;

    // The list of ids that is shared with the poi-server
    // It's needed to pass it as configuration values, because the type of the value (variant) is hard coded

    categoryId_t settingsCategoryAllCategories;

    attributeId_t settingsAttributeSource;
    attributeId_t settingsAttributeWebSite;
    attributeId_t settingsAttributePhone;
    attributeId_t settingsAttributeStars;
    attributeId_t settingsAttributeOpeningHours;
    attributeId_t settingsAttributeAddrHouseNumber;
    attributeId_t settingsAttributeAddrStreet;
    attributeId_t settingsAttributeAddrPostCode;
    attributeId_t settingsAttributeAddrCity;
    attributeId_t settingsAttributeBrand;
    attributeId_t settingsAttributeOperateur;

    uint settingsCAMOffset;

    uint settingsMapWidthInMeter;
    uint settingsMapHeightInMeter;
    int settingsTimerPeriodForPosition;


private slots:

    void on_startSearch_clicked();

    void on_createpoiHandle_clicked();

    void on_deletepoiHandle_clicked();

    void on_cancelSearch_clicked();

    void on_About_clicked();

    void on_getTopList_clicked();

    void on_getNextList_clicked();

    void on_getPrevList_clicked();

    void on_DBusSignalPoiStatus(uint poiSearchHandle, int statusValue);

    void on_DBusSignalResultListChanged(uint poiSearchHandle,ushort resultListSize);

    void on_DBusSignalCategoriesUpdated(QList<poiCategoryAndReason_t> poiCategories);

    void on_DBusSignalConfigurationChanged(QList<ushort> changedSettings);

    void on_DBusSignalPositionUpdate(ulong changedValues);

    void on_DBusSignalRouteCalculationSuccessful(uchar routeHandle,tupleUshortUshort unfullfilledPreferences);

    void on_DBusSignalRouteDeleted(uchar routeHandle);

    void on_setProximity_clicked();

    void on_cancelProximity_clicked();

    void on_embeddedAllCategoryCheckBox_stateChanged(int state);

    void on_addedAllCategoryCheckBox_stateChanged(int state);

private:

    void select_category();
    void manageDBusError(QDBusMessage reply);
    void initSettings();
    void manageStatus(int statusValue);
    void refreshViewTable(ushort windowSize);
    void clearViewTable();
    bool giveCategoryIndex(categoryId_t id, ushort *index_in_table);
    bool giveCategoryIndexAdditional(categoryId_t id,ushort *index_in_table);
    bool isNewCategory(categoryId_t id,QList<poiCategoryAndReason_t> poiList);

    enum tableViewPoiConstants
    {
        columnName = 0,
        columnCategory = 1,
        columnDistance = 2,
        columnId = 3,
        columnLatitude = 4,
        columnLongitude = 5,
        columnBeginAttributes = 6,
        columnSource = 6,
        columnWebSite = 7,
        columnPhone = 8,
        columnStars = 9,
        columnOpeningHours = 10,
        columnAddrHouseNumber = 11,
        columnAddrStreet = 12,
        columnAddrPostcode = 13,
        columnAddrCity = 14,
        columnBrand = 15,
        columnOperateur = 16,
        columnIcon = 17,
        columnSize
    };

    Ui::MainWindow *ui;
    QGraphicsScene m_scenePOI;
    QList<QPixmap> m_tableIconPOI;

    //handles to DBus interfaces
    org::genivi::poiservice::poiSearch::DBusSearchInterface *m_dbusPoiSearchInterface;
    org::genivi::poiservice::poiSearch::DBusConfigurationInterface *m_dbusConfigurationInterface;
    org::genivi::navigationcore::Routing::DBusRoutingInterface *m_dbusNavigationRoutingInterface;
    org::genivi::navigationcore::Guidance::DBusGuidanceInterface *m_dbusNavigationGuidanceInterface;
    DBusEnhancedPositionInterface *m_dbusPositioningEnhancedPositionInterface;
    org::genivi::navigationcore::Session::DBusNavigationCoreSessionInterface *m_dbusNavigationCoreSessionInterface;
    org::genivi::poiservice::poiContentAccess::DBusContentAccessInterface *m_dbusContentAccessInterface;

    geoCoordinate3D_t m_geoLocation;

    //handles to managed elements by GENIVI components
    handleId_t m_poiSearchHandle;
    uchar m_routeHandle;
    uchar m_sessionHandle;

    std::string m_languageCode;
    std::string m_countryCode;
    std::string m_scriptCode;

    int m_searchStatus;

    poiCategoryFull_t m_rootCategory;

    QList<poiCategoryFull_t> m_poiCategoryList;
    QList<poiCategoryFull_t> m_poiCategoryListAdditional;
    QList<categoryDetailsList_t> m_poiCategoryDetailsList;
    QList<categoryDetailsList_t> m_poiCategoryDetailsListAdditional;

    QList<QLineEdit*> mp_radiusLineEditBox;
    QList<QCheckBox*> mp_categoryCheckBox;

    QList<QCheckBox*> mp_attributeSourceCheckBox;
    QList<QCheckBox*> mp_attributeWebSiteCheckBox;
    QList<QCheckBox*> mp_attributePhoneCheckBox;
    QList<QCheckBox*> mp_attributeStarsCheckBox;
    QList<QCheckBox*> mp_attributeOpeningHoursCheckBox;
    QList<QCheckBox*> mp_attributeAddrHouseNumberCheckBox;
    QList<QCheckBox*> mp_attributeAddrStreetCheckBox;
    QList<QCheckBox*> mp_attributeAddrPostCodeCheckBox;
    QList<QCheckBox*> mp_attributeAddrCityCheckBox;
    QList<QCheckBox*> mp_attributeBrandCheckBox;
    QList<QCheckBox*> mp_attributeOperateurCheckBox;
    QList<QCheckBox*> mp_attributeGetCheckBox;

    QList<QLineEdit*> mp_radiusLineEditBoxAdditional;
    QList<QCheckBox*> mp_categoryCheckBoxAdditional;

    QList<QCheckBox*> mp_attributeSourceCheckBoxAdditional;
    QList<QCheckBox*> mp_attributeWebSiteCheckBoxAdditional;
    QList<QCheckBox*> mp_attributePhoneCheckBoxAdditional;
    QList<QCheckBox*> mp_attributeStarsCheckBoxAdditional;
    QList<QCheckBox*> mp_attributeOpeningHoursCheckBoxAdditional;
    QList<QCheckBox*> mp_attributeAddrHouseNumberCheckBoxAdditional;
    QList<QCheckBox*> mp_attributeAddrStreetCheckBoxAdditional;
    QList<QCheckBox*> mp_attributeAddrPostCodeCheckBoxAdditional;
    QList<QCheckBox*> mp_attributeAddrCityCheckBoxAdditional;
    QList<QCheckBox*> mp_attributeBrandCheckBoxAdditional;
    QList<QCheckBox*> mp_attributeOperateurCheckBoxAdditional;
    QList<QCheckBox*> mp_attributeGetCheckBoxAdditional;

    QStandardItemModel *mp_tableViewPoi;
    ushort m_totalSize;
    ushort m_currentTopListIndex;
    ushort m_startSearchOffset;
    ushort m_endSearchOffset;

    //
    QList<QGraphicsEllipseItem*> mp_radiusEllipse;
    QList<QGraphicsEllipseItem*> mp_radiusEllipseAdditional;
    QList<QBrush> m_categoryColor;
    uint m_mapWidth;
    uint m_mapHeight;
    uint m_mapCenterX;
    uint m_mapCenterY;
    uint m_totalNumberOfSegments;
    QList<route_vector_t> m_route;
    bool isSetProximityModeSelected;
    bool isSearchAroundTheVehicleSelected;

    QList<satelliteInfo_t> m_satelliteInfo;
    uchar m_satelliteAmount;
};

#endif // MAINWINDOW_H
