/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file poi-client-DBusGuidanceInterface.h
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
#ifndef POICLIENTDBUSGUIDANCEINTERFACE_H
#define POICLIENTDBUSGUIDANCEINTERFACE_H

#include <QtCore/QObject>
#include <QtCore/QMetaObject>
#include <QtCore/QVariant>
#include <QtDBus/QtDBus>
#include <QtCore/QByteArray>
#include <QtCore/QList>
#include <QtCore/QMap>
#include <QtCore/QString>
#include <QtCore/QStringList>
#include <QtCore/QVariant>

#include "poi-client-config.h"

#include "../poi-common/poi-marshal-handler.h"


/*
 * Proxy class for interface POIPOCDBusGuidanceInterface
 */
class DBusGuidanceInterface: public QDBusAbstractInterface
{
    Q_OBJECT
public:
    static inline const char *staticInterfaceName()
    { return "org.genivi.navigation.navigationcore.Guidance"; }

public:
    DBusGuidanceInterface(const QString &service, const QString &path, const QDBusConnection &connection, QObject *parent = 0);

    ~DBusGuidanceInterface();

public Q_SLOTS: // METHODS




Q_SIGNALS: // SIGNALS
//D-Bus signals here

private:

};

namespace org {
  namespace genivi {
    namespace navigation {
        namespace navigationcore {
            namespace Guidance {
        typedef ::DBusGuidanceInterface DBusGuidanceInterface;
            }
        }
    }
  }
}

#endif // POICLIENTDBUSGUIDANCEINTERFACE_H
