/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file poi-client-DBusEnhancedPositionInterface.h
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
#ifndef POICLIENTDBUSENHANCEDPOSITIONINTERFACE_H
#define POICLIENTDBUSENHANCEDPOSITIONINTERFACE_H

#include "../poi-common/poi-marshal-handler.h"

/*
 * Proxy class for interface POIPOCDBusEnhancedPositionInterface
 */
class DBusEnhancedPositionInterface: public QDBusAbstractInterface
{
    Q_OBJECT
public:
    static inline const char *staticInterfaceName()
    { return "org.genivi.positioning.EnhancedPosition"; }
public:
    DBusEnhancedPositionInterface(const QString &service, const QString &path, const QDBusConnection &connection, QObject *parent = 0);

    ~DBusEnhancedPositionInterface();

    void startTimerForPosition(uint timerTick);


public Q_SLOTS: // METHODS

    inline QDBusPendingReply<version_t> GetVersion()
    { //"(qqqs)" out
        return asyncCall(QLatin1String("GetVersion"));
    }

    inline QDBusPendingReply<tupleVariant_t> GetData(QList<ushort> valuesToReturn)
    { // "aq" in "a{qv}" out
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(valuesToReturn);
        return asyncCallWithArgumentList(QLatin1String("GetData"), argumentList);
    }

    inline QDBusPendingReply<tupleVariant_t> GetPosition()
    { // "a{qv}" out
        return asyncCall(QLatin1String("GetPosition"));
    }

    inline QDBusPendingReply<tupleVariant_t> GetRotationRate()
    { // "a{qv}" out
        return asyncCall(QLatin1String("GetRotationRate"));
    }

    inline QDBusPendingReply<tupleVariant_t> GetAccuracy()
    { // "a{qv}" out
        return asyncCall(QLatin1String("GetAccuracy"));
    }

    inline QDBusPendingReply<tupleVariant_t> GetSatelliteInfo()
    { // "a{qv}" out
        return asyncCall(QLatin1String("GetSatelliteInfo"));
    }

    inline QDBusPendingReply<tupleVariant_t> GetStatus()
    { // "a{qv}" out
        return asyncCall(QLatin1String("GetStatus"));
    }

    inline QDBusPendingReply<tupleVariant_t> GetTime()
    { // "a{qv}" out
        return asyncCall(QLatin1String("GetTime"));
    }

    void onTimerPositionTimeout()
    {
        QDBusPendingReply<tupleVariant_t> reply = GetTime();
        reply.waitForFinished();
    }

Q_SIGNALS: // SIGNALS

private:
    QTimer* mp_timer;
};

namespace org {
  namespace genivi {
    namespace positioning {
        namespace EnhancedPosition {
      typedef ::DBusEnhancedPositionInterface DBusEnhancedPositionInterface;
        }
    }
  }
}

#endif // POICLIENTDBUSENHANCEDPOSITIONINTERFACE_H
