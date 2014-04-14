/********************************************************************************
** Form generated from reading UI file 'mainwindow.ui'
**
** Created: Thu Mar 14 14:16:40 2013
**      by: Qt User Interface Compiler version 4.8.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_MAINWINDOW_H
#define UI_MAINWINDOW_H

#include <QtCore/QLocale>
#include <QtCore/QVariant>
#include <QtGui/QAction>
#include <QtGui/QApplication>
#include <QtGui/QButtonGroup>
#include <QtGui/QFrame>
#include <QtGui/QGroupBox>
#include <QtGui/QHeaderView>
#include <QtGui/QLabel>
#include <QtGui/QMainWindow>
#include <QtGui/QMenuBar>
#include <QtGui/QPushButton>
#include <QtGui/QStatusBar>
#include <QtGui/QToolBar>
#include <QtGui/QWidget>

QT_BEGIN_NAMESPACE

class Ui_MainWindow
{
public:
    QWidget *centralWidget;
    QLabel *camID;
    QLabel *poiCategoryName;
    QLabel *poiCategoryID;
    QGroupBox *groupBox_2;
    QLabel *VersionCAM;
    QWidget *background;
    QPushButton *addCAMCategory;
    QPushButton *removeCAMCategory;
    QPushButton *unregisterCAM;
    QPushButton *registerCAM;
    QGroupBox *groupBox;
    QLabel *languageCode;
    QLabel *countryCode;
    QFrame *line;
    QFrame *line_2;
    QMenuBar *menuBar;
    QToolBar *mainToolBar;
    QStatusBar *statusBar;

    void setupUi(QMainWindow *MainWindow)
    {
        if (MainWindow->objectName().isEmpty())
            MainWindow->setObjectName(QString::fromUtf8("MainWindow"));
        MainWindow->resize(350, 443);
        MainWindow->setMinimumSize(QSize(350, 443));
        MainWindow->setMaximumSize(QSize(350, 443));
        QIcon icon;
        icon.addFile(QString::fromUtf8(":/new/image/POIPOCContentAccessModule.png"), QSize(), QIcon::Normal, QIcon::Off);
        MainWindow->setWindowIcon(icon);
        MainWindow->setStyleSheet(QString::fromUtf8("background-color: rgb(207, 245, 255);"));
        centralWidget = new QWidget(MainWindow);
        centralWidget->setObjectName(QString::fromUtf8("centralWidget"));
        camID = new QLabel(centralWidget);
        camID->setObjectName(QString::fromUtf8("camID"));
        camID->setGeometry(QRect(280, 200, 71, 20));
        QFont font;
        font.setPointSize(9);
        camID->setFont(font);
        camID->setStyleSheet(QString::fromUtf8("color: rgb(0, 85, 255);"));
        poiCategoryName = new QLabel(centralWidget);
        poiCategoryName->setObjectName(QString::fromUtf8("poiCategoryName"));
        poiCategoryName->setGeometry(QRect(280, 310, 101, 17));
        poiCategoryName->setFont(font);
        poiCategoryName->setStyleSheet(QString::fromUtf8("color: rgb(0, 85, 255);"));
        poiCategoryID = new QLabel(centralWidget);
        poiCategoryID->setObjectName(QString::fromUtf8("poiCategoryID"));
        poiCategoryID->setGeometry(QRect(280, 340, 101, 17));
        poiCategoryID->setFont(font);
        poiCategoryID->setStyleSheet(QString::fromUtf8("color: rgb(0, 85, 255);"));
        groupBox_2 = new QGroupBox(centralWidget);
        groupBox_2->setObjectName(QString::fromUtf8("groupBox_2"));
        groupBox_2->setGeometry(QRect(10, 300, 141, 61));
        QFont font1;
        font1.setBold(true);
        font1.setWeight(75);
        groupBox_2->setFont(font1);
        groupBox_2->setStyleSheet(QString::fromUtf8("background-color: rgb(170, 170, 255);"));
        VersionCAM = new QLabel(groupBox_2);
        VersionCAM->setObjectName(QString::fromUtf8("VersionCAM"));
        VersionCAM->setGeometry(QRect(0, 30, 131, 17));
        VersionCAM->setFont(font);
        background = new QWidget(centralWidget);
        background->setObjectName(QString::fromUtf8("background"));
        background->setGeometry(QRect(0, 0, 401, 181));
        background->setAutoFillBackground(false);
        background->setStyleSheet(QString::fromUtf8("image: url(:/new/image/magasin.jpg);"));
        addCAMCategory = new QPushButton(centralWidget);
        addCAMCategory->setObjectName(QString::fromUtf8("addCAMCategory"));
        addCAMCategory->setGeometry(QRect(170, 300, 98, 27));
        addCAMCategory->setAutoFillBackground(false);
        addCAMCategory->setStyleSheet(QString::fromUtf8("background-color: rgb(170, 255, 255);"));
        removeCAMCategory = new QPushButton(centralWidget);
        removeCAMCategory->setObjectName(QString::fromUtf8("removeCAMCategory"));
        removeCAMCategory->setGeometry(QRect(170, 340, 98, 27));
        removeCAMCategory->setStyleSheet(QString::fromUtf8("background-color: rgb(170, 255, 255);"));
        unregisterCAM = new QPushButton(centralWidget);
        unregisterCAM->setObjectName(QString::fromUtf8("unregisterCAM"));
        unregisterCAM->setGeometry(QRect(170, 240, 98, 27));
        unregisterCAM->setStyleSheet(QString::fromUtf8("background-color: rgb(170, 255, 255);"));
        registerCAM = new QPushButton(centralWidget);
        registerCAM->setObjectName(QString::fromUtf8("registerCAM"));
        registerCAM->setGeometry(QRect(170, 200, 98, 27));
        registerCAM->setStyleSheet(QString::fromUtf8("background-color: rgb(170, 255, 255);"));
        registerCAM->setLocale(QLocale(QLocale::English, QLocale::UnitedStates));
        groupBox = new QGroupBox(centralWidget);
        groupBox->setObjectName(QString::fromUtf8("groupBox"));
        groupBox->setGeometry(QRect(10, 200, 120, 80));
        groupBox->setFont(font1);
        groupBox->setStyleSheet(QString::fromUtf8("background-color: rgb(170, 170, 255);"));
        languageCode = new QLabel(groupBox);
        languageCode->setObjectName(QString::fromUtf8("languageCode"));
        languageCode->setGeometry(QRect(0, 30, 66, 17));
        languageCode->setFont(font);
        countryCode = new QLabel(groupBox);
        countryCode->setObjectName(QString::fromUtf8("countryCode"));
        countryCode->setGeometry(QRect(0, 60, 66, 17));
        countryCode->setFont(font);
        line = new QFrame(centralWidget);
        line->setObjectName(QString::fromUtf8("line"));
        line->setGeometry(QRect(150, 280, 241, 16));
        line->setFrameShape(QFrame::HLine);
        line->setFrameShadow(QFrame::Sunken);
        line_2 = new QFrame(centralWidget);
        line_2->setObjectName(QString::fromUtf8("line_2"));
        line_2->setGeometry(QRect(143, 200, 20, 191));
        line_2->setFrameShape(QFrame::VLine);
        line_2->setFrameShadow(QFrame::Sunken);
        MainWindow->setCentralWidget(centralWidget);
        background->raise();
        camID->raise();
        poiCategoryName->raise();
        poiCategoryID->raise();
        groupBox_2->raise();
        addCAMCategory->raise();
        removeCAMCategory->raise();
        unregisterCAM->raise();
        registerCAM->raise();
        groupBox->raise();
        line->raise();
        line_2->raise();
        menuBar = new QMenuBar(MainWindow);
        menuBar->setObjectName(QString::fromUtf8("menuBar"));
        menuBar->setGeometry(QRect(0, 0, 350, 25));
        MainWindow->setMenuBar(menuBar);
        mainToolBar = new QToolBar(MainWindow);
        mainToolBar->setObjectName(QString::fromUtf8("mainToolBar"));
        MainWindow->addToolBar(Qt::TopToolBarArea, mainToolBar);
        statusBar = new QStatusBar(MainWindow);
        statusBar->setObjectName(QString::fromUtf8("statusBar"));
        MainWindow->setStatusBar(statusBar);

        retranslateUi(MainWindow);

        QMetaObject::connectSlotsByName(MainWindow);
    } // setupUi

    void retranslateUi(QMainWindow *MainWindow)
    {
        MainWindow->setWindowTitle(QApplication::translate("MainWindow", "Bicycle shop", 0, QApplication::UnicodeUTF8));
        camID->setText(QApplication::translate("MainWindow", "TextLabel", 0, QApplication::UnicodeUTF8));
        poiCategoryName->setText(QApplication::translate("MainWindow", "TextLabel", 0, QApplication::UnicodeUTF8));
        poiCategoryID->setText(QApplication::translate("MainWindow", "TextLabel", 0, QApplication::UnicodeUTF8));
        groupBox_2->setTitle(QApplication::translate("MainWindow", "Version", 0, QApplication::UnicodeUTF8));
        VersionCAM->setText(QApplication::translate("MainWindow", "TextLabel", 0, QApplication::UnicodeUTF8));
        addCAMCategory->setText(QApplication::translate("MainWindow", "ADDandREG", 0, QApplication::UnicodeUTF8));
        removeCAMCategory->setText(QApplication::translate("MainWindow", "REMOVE", 0, QApplication::UnicodeUTF8));
        unregisterCAM->setText(QApplication::translate("MainWindow", "UNREGISTER", 0, QApplication::UnicodeUTF8));
        registerCAM->setText(QApplication::translate("MainWindow", "REGISTER", 0, QApplication::UnicodeUTF8));
        groupBox->setTitle(QApplication::translate("MainWindow", "Language", 0, QApplication::UnicodeUTF8));
        languageCode->setText(QApplication::translate("MainWindow", "TextLabel", 0, QApplication::UnicodeUTF8));
        countryCode->setText(QApplication::translate("MainWindow", "TextLabel", 0, QApplication::UnicodeUTF8));
    } // retranslateUi

};

namespace Ui {
    class MainWindow: public Ui_MainWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_MAINWINDOW_H
