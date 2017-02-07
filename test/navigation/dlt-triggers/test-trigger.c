/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2017, PSA GROUPE
*
* \file test-trigger.c
*
* \brief This file is part of the poi proof of concept.
*
* \author Philippe Colliot <philippe.colliot@mpsa.com>
*
* \version 0.1
*
* This Source Code Form is subject to the terms of the
* Mozilla Public License (MPL), v. 2.0.
* If a copy of the MPL was not distributed with this file,
* You can obtain one at http://mozilla.org/MPL/2.0/.
*
* For further information see http://www.genivi.org/.
*
* List of changes:
* <date>, <name>, <description of change>
*
* @licence end@
*/

#include <stdio.h>      /* for printf() and fprintf() */
#include <stdlib.h>     /* for atoi() and exit() */
#include <string.h>
#include <dlt.h>

DLT_DECLARE_CONTEXT(con_test);

int main(int  argc , char**  argv )
{
    if (argc !=3)
    {
        printf("Usage: test-trigger 1 <name of test> --> start test for <name of test>\n");
        printf("       test-trigger 0 <name of test> --> stop test for <name of test>\n");
        return EXIT_FAILURE;
    }

    DLT_REGISTER_APP("NAVI","Test script");
    DLT_REGISTER_CONTEXT(con_test,"TEST","Navigation context for testing");

    if (strcmp(argv[1],"1")==0)
    {
        DLT_LOG(con_test,DLT_LOG_INFO,DLT_STRING("Start test of "),DLT_STRING(argv[2]));
    }
    else
    {
        DLT_LOG(con_test,DLT_LOG_INFO,DLT_STRING("Stop test of "),DLT_STRING(argv[2]));
    }

    DLT_UNREGISTER_CONTEXT(con_test);
    DLT_UNREGISTER_APP();
}
