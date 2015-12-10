/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file genivi_navigationcore_speechoutput.cxx
*
* \brief This file is part of the Navit POC.
*
* \author Philippe Colliot <philippe.colliot@mpsa.com>
*
* \version 1.0
*
* This Source Code Form is subject to the terms of the
* Mozilla Public License (MPL), v. 2.0.
* If a copy of the MPL was not distributed with this file,
* You can obtain one at http://mozilla.org/MPL/2.0/.
*
* For further information see http://www.genivi.org/.
*
* List of changes:
* 
* <date>, <name>, <description of change>
*
* @licence end@
*/
#include <dbus-c++/glib-integration.h>
#include "genivi-speechservice-constants.h"
#include "genivi-speechservice-speechoutput_proxy.h"
#include "config.h"
#define USE_PLUGINS 1
#include "debug.h"
#include "plugin.h"
#include "item.h"
#include "config_.h"
#include "navit.h"
#include "search.h"
#include "callback.h"
#include "event.h"
#include "coord.h"
#include "transform.h"
#include "speech.h"

#if (!DEBUG_ENABLED)
#undef dbg
#define dbg(level,...) ;
#endif

DBus::Glib::BusDispatcher dispatcher;
DBus::Connection *conn;

struct speech_priv {
    class SpeechOutput *speech_output;
    struct callback_list *cbl;
    struct callback *cb;
    GList *free_buffers;
    GList *phrases;
};

class SpeechOutput
: public org::genivi::hmi::speechservice::SpeechOutput_proxy,
  public DBus::ObjectProxy
{
    public:
    struct speech_priv *m_priv;
    SpeechOutput(DBus::Connection &connection, struct vehicle_priv *priv)
        : DBus::ObjectProxy(connection,
                                    "/org/genivi/hmi/speechservice/SpeechOutput",
                                    "org.genivi.hmi.speechservice.SpeechOutput")
    {
        m_priv=priv;
    }

    void notifyConnectionStatus(const uint32_t& connectionStatus)
    {

    }

    void notifyMarkerReached(const uint32_t& chunkID, const std::string& marker)
    {

    }

    void notifyQueueStatus(const uint32_t& queueStatus)
    {

    }

    void notifyTTSStatus(const uint32_t& ttsStatus)
    {

    }
};

static void
free_list(gpointer pointer, gpointer list )
{
    if ( list )
    {
        struct speech_priv *sp_priv = (struct speech_priv *)list;
    }
    g_free(pointer);
}

static void
genivi_speechoutput_destroy(struct speech_priv *sp_priv)
{
    dbg(lvl_debug,"enter\n");
    DBus::default_dispatcher = &dispatcher;
    delete(sp_priv->speech_output);
    callback_destroy(sp_priv->cb);
    g_free(priv);
}

static int
genivi_speechoutput_say(struct speech_priv *sp_priv, const char *text) {
    char *phrase = g_strdup(text);
    dbg(lvl_debug, "Speak: '%s'\n", text);

    return 0;
}

static struct speech_methods genivi_speechoutput_meth = {
    genivi_speechoutput_destroy,
    genivi_speechoutput_say,
};

static void
genivi_speechoutput_callback(struct speech_priv *sp_priv)
{
}

static struct speech_priv *
genivi_speechoutput_new(struct speech_methods *meth, genivi_speech, struct callback_list *cb_list) {
    struct speech_priv *ret = NULL;

    dbg(lvl_debug, "enter\n");

    *meth=genivi_speechoutput_meth;

    ret=g_new(struct speech_priv,1);
    ret->speech_output = new SpeechOutput(*conn,ret);
    ret->cb=callback_new_1(callback_cast(genivi_speechoutput_callback), ret);
    ret->cbl=cb_list;

    return ret;
}

void plugin_init(void)
{
    event_request_system("glib","genivi_speechservice_speechoutput");
    dispatcher.attach(NULL);
    DBus::default_dispatcher = &dispatcher;
    conn = new DBus::Connection(DBus::Connection::SessionBus());
    conn->setup(&dispatcher);
    dbg(lvl_debug,"enter\n");

    plugin_register_speech_type("genivi_speech", genivi_speechoutput_new);
}
