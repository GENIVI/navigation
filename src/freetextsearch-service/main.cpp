/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2015, 2016 TomTom International B.V.
* \copyright Copyright (C) 2016, PCA Peugeot Citroen
* \author Peter Goedegebure (Peter.Goedegebure@tomtom.com)
* \author Philippe Colliot <philippe.colliot@mpsa.com>
* \author Morteza Damavandpeyma <Morteza.Damavandpeyma@tomtom.com>
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

#include <thread>
#include <iostream>

#include <CommonAPI/CommonAPI.hpp>
#include "FreeTextSearchStubImpl.hpp"

int main()
{
  std::shared_ptr < CommonAPI::Runtime > runtime = CommonAPI::Runtime::get();
  std::shared_ptr<FreeTextSearchStubImpl> myService = std::make_shared<FreeTextSearchStubImpl>();
  runtime->registerService("local", "test", myService);
  std::cout << "Successfully Registered FTS Service!" << std::endl;

  while (true)
  {
    std::cout << "Waiting for calls... (Abort with CTRL+C)" << std::endl;
    std::this_thread::sleep_for(std::chrono::seconds(2));
  }

  return 0;
}

