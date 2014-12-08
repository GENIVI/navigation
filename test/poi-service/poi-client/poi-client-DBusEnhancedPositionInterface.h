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

    inline QDBusPendingReply<qulonglong, tupleUlongVariant> GetPositionInfo(ulong valuesToReturn)
    { // "t" in "t" "a{tv}" out
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(valuesToReturn);
        return asyncCallWithArgumentList(QLatin1String("GetPositionInfo"), argumentList);
    }

    inline QDBusPendingReply<qulonglong, QList<satelliteInfo_t> > GetSatelliteInfo()
    { // "t" "a(qqqqqb)" out
        return asyncCall(QLatin1String("GetSatelliteInfo"));
    }

    inline QDBusPendingReply<qulonglong, tupleUlongVariant> GetTime()
    { // "t" "a{tv}" out
        return asyncCall(QLatin1String("GetTime"));
    }

    void onTimerPositionTimeout()
    {
        QDBusPendingReply<qulonglong, tupleUlongVariant> reply = GetTime();
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
