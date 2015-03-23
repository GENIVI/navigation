#ifndef POIMANAGERSERVERSTUBIMPL_H_
#define POIMANAGERSERVERSTUBIMPL_H_

#include <CommonAPI/CommonAPI.h>

#include "org/genivi/navigation/poiservice/POIContentManagerStubDefault.h"

using namespace org;
using namespace genivi;
using namespace navigation;
using namespace poiservice;

class PoiManagerServerStub: public org::genivi::navigation::poiservice::POIContentManagerStubDefault {

public:
    PoiManagerServerStub();
    ~PoiManagerServerStub();
    void getVersion(const std::shared_ptr<CommonAPI::ClientId> clientId, NavigationTypes::Version& version);
private:
    NavigationTypes::Version m_version;
};

#endif /* POIMANAGERSERVERSTUBIMPL_H_ */
