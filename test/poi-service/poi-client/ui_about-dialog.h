/********************************************************************************
** Form generated from reading UI file 'about-dialog.ui'
**
** Created: Fri Feb 7 10:48:21 2014
**      by: Qt User Interface Compiler version 4.8.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_ABOUT_2D_DIALOG_H
#define UI_ABOUT_2D_DIALOG_H

#include <QtCore/QVariant>
#include <QAction>
#include <QApplication>
#include <QButtonGroup>
#include <QDialog>
#include <QHeaderView>
#include <QPushButton>
#include <QTextBrowser>
#include <QWidget>

QT_BEGIN_NAMESPACE

class Ui_aboutDialog
{
public:
    QTextBrowser *textBrowser;
    QPushButton *pushButton;
    QWidget *widget;

    void setupUi(QDialog *aboutDialog)
    {
        if (aboutDialog->objectName().isEmpty())
            aboutDialog->setObjectName(QString::fromUtf8("aboutDialog"));
        aboutDialog->setEnabled(true);
        aboutDialog->resize(400, 276);
        aboutDialog->setStyleSheet(QString::fromUtf8("background-color: rgb(176, 196, 222);"));
        textBrowser = new QTextBrowser(aboutDialog);
        textBrowser->setObjectName(QString::fromUtf8("textBrowser"));
        textBrowser->setEnabled(true);
        textBrowser->setGeometry(QRect(20, 10, 361, 192));
        textBrowser->setSource(QUrl(QString::fromUtf8("qrc:/new/text/about.txt")));
        pushButton = new QPushButton(aboutDialog);
        pushButton->setObjectName(QString::fromUtf8("pushButton"));
        pushButton->setGeometry(QRect(280, 220, 98, 27));
        pushButton->setStyleSheet(QString::fromUtf8("background-color: rgb(170, 255, 255);"));
        widget = new QWidget(aboutDialog);
        widget->setObjectName(QString::fromUtf8("widget"));
        widget->setGeometry(QRect(30, 210, 231, 51));
        widget->setStyleSheet(QString::fromUtf8("image: url(:/new/image/psa.jpg);"));

        retranslateUi(aboutDialog);
        QObject::connect(pushButton, SIGNAL(clicked()), aboutDialog, SLOT(accept()));

        QMetaObject::connectSlotsByName(aboutDialog);
    } // setupUi

    void retranslateUi(QDialog *aboutDialog)
    {
        aboutDialog->setWindowTitle(QApplication::translate("aboutDialog", "About", 0));
        pushButton->setText(QApplication::translate("aboutDialog", "OK", 0));
    } // retranslateUi

};

namespace Ui {
    class aboutDialog: public Ui_aboutDialog {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_ABOUT_2D_DIALOG_H
