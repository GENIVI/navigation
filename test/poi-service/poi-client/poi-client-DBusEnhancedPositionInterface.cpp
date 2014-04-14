/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file poi-client-DBusEnhancedPositionInterface.cpp
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
#include "poi-client-config.h"
#include "poi-client-DBusEnhancedPositionInterface.h"


DBusEnhancedPositionInterface::DBusEnhancedPositionInterface(const QString &service, const QString &path, const QDBusConnection &connection, QObject *parent)
    : QDBusAbstractInterface(service, path, staticInterfaceName(), connection, parent)
{
    mp_timer = new QTimer(this);
    QObject::connect(mp_timer, SIGNAL(timeout()), this, SLOT(onTimerPositionTimeout()));
}

DBusEnhancedPositionInterface::~DBusEnhancedPositionInterface()
{
    mp_timer->stop();
    delete mp_timer;
}

void DBusEnhancedPositionInterface::startTimerForPosition(uint timerTick)
{
    mp_timer->setInterval(timerTick);
    mp_timer->start();
}

