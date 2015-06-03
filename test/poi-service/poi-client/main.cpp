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
#include "mainwindow.h"
#include "../poi-common/poi-marshal-handler.h"

#include <QApplication>
#include <QTranslator>
#include <QSettings>

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);
    MarshalHandler::registerMetaType();

    QTranslator translator;

    MainWindow mainWindow;

    //get settings stored into the conf file (in $HOME/.config/poi-service/poi-client.conf)

    QSettings settings("poi-service", "poi-client");
    mainWindow.settingsInvalidHandle = settings.value("InvalidHandle").toUInt();
    mainWindow.settingsPoiDisplayTableRows = settings.value("PoiDisplayTableRows").toInt();
    mainWindow.settingsDefaultTextToSearch = settings.value("DefaultTextToSearch").toString();
    mainWindow.settingsDefaultLocation.latitude = settings.value("DefaultLocation/latitude").toDouble();
    mainWindow.settingsDefaultLocation.longitude = settings.value("DefaultLocation/longitude").toDouble();
    mainWindow.settingsDefaultLocation.altitude = settings.value("DefaultLocation/altitude").toInt();
    mainWindow.settingsDefaultTextToBeInitialized = settings.value("DefaultTextToBeInitialized").toString();
    mainWindow.settingsDefaultRadius = settings.value("DefaultRadius").toUInt();
    mainWindow.settingsLanguageCode = settings.value("Language/language").toString();
    mainWindow.settingsCountryCode = settings.value("Language/country").toString();
    mainWindow.settingsScriptCode = settings.value("Language/script").toString();
    mainWindow.settingsHMIlanguage = settings.value("Language/HMI").toString();

    mainWindow.settingsCategoryAllCategories = settings.value("Category/AllCategories").toUInt();

    mainWindow.settingsAttributeSource = settings.value("Attribute/Source").toUInt();
    mainWindow.settingsAttributeWebSite = settings.value("Attribute/WebSite").toUInt();
    mainWindow.settingsAttributePhone = settings.value("Attribute/Phone").toUInt();
    mainWindow.settingsAttributeStars = settings.value("Attribute/Stars").toUInt();
    mainWindow.settingsAttributeOpeningHours = settings.value("Attribute/OpeningHours").toUInt();
    mainWindow.settingsAttributeAddrHouseNumber = settings.value("Attribute/Number").toUInt();
    mainWindow.settingsAttributeAddrStreet = settings.value("Attribute/Street").toUInt();
    mainWindow.settingsAttributeAddrPostCode = settings.value("Attribute/PostCode").toUInt();
    mainWindow.settingsAttributeAddrCity = settings.value("Attribute/City").toUInt();
    mainWindow.settingsAttributeBrand = settings.value("Attribute/Brand").toUInt();
    mainWindow.settingsAttributeOperateur = settings.value("Attribute/Operateur").toUInt();

    mainWindow.settingsCAMOffset = settings.value("CAMOffset").toUInt();

    mainWindow.settingsMapWidthInMeter = settings.value("MapWidthInMeter").toUInt();
    mainWindow.settingsMapHeightInMeter = settings.value("MapHeightInMeter").toUInt();
    mainWindow.settingsTimerPeriodForPosition = settings.value("TimerPeriodForPosition").toInt();

    if (translator.load("poi-client_"+ mainWindow.settingsHMIlanguage))
    {
        if (QResource::registerResource("poi-client-resource.rcc","./"))
        {
            app.installTranslator(&translator);

            //init ui
            mainWindow.InitUi();

            mainWindow.show();

            QDBusConnection connection = QDBusConnection::sessionBus();


            return app.exec();
        }
        else
            return(-1);
    }
    else
        return(-1);

}
