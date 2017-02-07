#!/usr/bin/python

"""
**************************************************************************
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 201, PSA GROUPE
*
* \file dlt-trigger.py
*
* \brief This script is part of the FSA scenario.
*
* \author Philippe Colliot <philippe.colliot@mpsa.com>
*
* \version 1.0
*
* This Source Code Form is subject to the terms of the
* Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed with
# this file, You can obtain one at http://mozilla.org/MPL/2.0/.

* List of changes:
*
* @licence end@

**************************************************************************
"""
import subprocess,os
from subprocess import call 

PATH_TEST_TRIGGER='./dlt-triggers/bin/'

def startTrigger(name): 
	FNULL = open(os.devnull,'w')
	test_trigger=PATH_TEST_TRIGGER + 'test-trigger'
	call([test_trigger, "1", name])

def stopTrigger(name): 
	FNULL = open(os.devnull,'w')
	test_trigger=PATH_TEST_TRIGGER + 'test-trigger'
	call([test_trigger, "0", name])

