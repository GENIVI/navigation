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

#include "poi-contentaccess-module-class.h"

#include "mainwindow.h"
#include "ui_mainwindow.h"


MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{

    ui->setupUi(this);

}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::ConnectTocontentAccessModuleServer(contentAccessModuleServer *server)
{
    mp_contentAccessModule = server; //link to the instance of contentAccessModule
}

void MainWindow::ConnectTopoiContentAccessClient(poiContentAccess *client)
{
    mp_poiContentAccess = client; //link to the instance of poiContentAccess
}

void MainWindow::InitUi()
{
    DBus_version vers;
    DBus_version::version_t version;

    // version
    vers.setDBus(mp_contentAccessModule->GetVersion());
    version = vers.get();
    ui->VersionCAM->setText("CAM: " + QString::number(version.major) + "." + QString::number(version.minor) + "." + QString::number(version.micro) + " " + QString::fromStdString(version.date));

    //no cam id, no category added and registered
    ui->camID->setText(noValue);
    ui->poiCategoryID->setText(noValue);
    ui->poiCategoryName->setText(noValue);

    //no language set
    ui->languageCode->setText(noValue);
    ui->countryCode->setText(noValue);
    ui->scriptCode->setText(noValue);

    //internationalisation
    ui->registerCAM->setText(tr("REGISTER"));
    ui->unregisterCAM->setText(tr("UNREGISTER"));
    ui->addCAMCategory->setText(tr("ADDandREG"));
    ui->removeCAMCategory->setText(tr("REMOVE"));

    initSettings();
}

void MainWindow::initSettings()
{
    m_categoriesID.clear();
}

void MainWindow::on_SetLocale(const std::string languageCode, const std::string countryCode, const std::string scriptCode)
{
    ui->languageCode->setText(QString::fromStdString(languageCode));
    ui->countryCode->setText(QString::fromStdString(countryCode));
    ui->scriptCode->setText(QString::fromStdString(scriptCode));
}


void MainWindow::on_registerCAM_clicked()
{
    uint8_t camId;
    QString str;

    camId = mp_poiContentAccess->RegisterContentAccessModule(mp_contentAccessModule->getCAMName());
    mp_contentAccessModule->connectCAM(camId);
    str = QString(tr("NUMBER")) + QString(":  ") + QString::number(camId);
    ui->camID->setText(str);
}

void MainWindow::on_unregisterCAM_clicked()
{
    if (mp_contentAccessModule->getCAMId() != contentAccessModuleServer::INVALID_HANDLE)
    {
        //first remove the categories
        on_removeCAMCategory_clicked();

        // and now unregister the CAM
        mp_poiContentAccess->UnRegisterContentAccessModule(mp_contentAccessModule->getCAMId());
        mp_contentAccessModule->disconnectCAM();
        ui->camID->setText(noValue);
    }
}

void MainWindow::on_addCAMCategory_clicked()
{
    std::vector< DBus_CAMcategory::DBus_CAMcategory_t > poiCategories;

    //check if the CAM has been registered
    if (mp_contentAccessModule->getCAMId() != mp_contentAccessModule->INVALID_HANDLE)
    {
        //get the categories IDs from the CAM
        poiCategories = mp_contentAccessModule->getCategories();
        // add the categories on the content access server
        m_categoriesID = mp_poiContentAccess->AddCategories(mp_contentAccessModule->getCAMId(),poiCategories);
        // set the categories alias IDs into the CAM
        mp_contentAccessModule->setCategoriesID(m_categoriesID);

        //register the categories (by using the alias IDs)
        mp_poiContentAccess->RegisterPoiCategories(mp_contentAccessModule->getCAMId(),m_categoriesID);

        //refresh the panel
        ui->poiCategoryID->setText(QString::number(m_categoriesID.size()));
        ui->poiCategoryName->setText(tr("Categories added"));
    }
}

void MainWindow::on_removeCAMCategory_clicked()
{
    //remove the categories if necessary(the categories are unregistered on the server side)
    if (m_categoriesID.size()>0)
    {
        mp_poiContentAccess->RemoveCategories(mp_contentAccessModule->getCAMId(),m_categoriesID);

        //no category
        m_categoriesID.clear();

        //refresh the panel (only one category)
        ui->poiCategoryID->setText(noValue);
        ui->poiCategoryName->setText(noValue);
    }
}
