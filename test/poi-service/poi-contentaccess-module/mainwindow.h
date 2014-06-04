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

#define noValue "-------"

class contentAccessModuleServer;
class poiContentAccess;


namespace Ui {
class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT
    
public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();

    void ConnectTocontentAccessModuleServer(contentAccessModuleServer *server);

    void ConnectTopoiContentAccessClient(poiContentAccess *client);

    void InitUi();

    void on_SetLanguage(const std::string languageCode, const std::string countryCode);


private slots:
    void on_registerCAM_clicked();

    void on_unregisterCAM_clicked();

    void on_addCAMCategory_clicked();

    void on_removeCAMCategory_clicked();

private:
    void initSettings();

    Ui::MainWindow *ui;
    contentAccessModuleServer* mp_contentAccessModule;
    poiContentAccess* mp_poiContentAccess;
    std::vector<ushort> m_categoriesID;
};

#endif // MAINWINDOW_H
