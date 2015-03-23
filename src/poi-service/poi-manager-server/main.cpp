#include <iostream>
#include <thread>
#include <CommonAPI/CommonAPI.h> //Defined in the Common API Runtime library
#include "poi-manager-server-stub.h"

int main()
{
    std::shared_ptr<CommonAPI::Runtime> runtime = CommonAPI::Runtime::load();
    std::shared_ptr<CommonAPI::Factory> factory = runtime->createFactory();
    std::shared_ptr<CommonAPI::ServicePublisher> servicePublisher = runtime->getServicePublisher();
    const std::string& serviceAddress = "local:org.genivi.poiservice.POIContentManager:org.genivi.poiservice.POIContentManager";
    std::shared_ptr<PoiManagerServerStub> myService = std::make_shared<PoiManagerServerStub>();

    //register Interface for Management of a POI Content Access Module with add/remove features
    bool registerResult = servicePublisher->registerService(myService, serviceAddress, factory);
    if (registerResult != true) {
        std::cerr << "Registering of POI Manager stub failed." << std::endl;
        exit(1);
    }

    std::cout << "Welcome to Genivi POI Manager simulation (Server part)" << std::endl << std::endl;

    while(true) {
        std::cout << "Waiting for calls... (Abort with CTRL+C)" << std::endl;
        std::this_thread::sleep_for(std::chrono::seconds(60));
    }
    return 0;
}

