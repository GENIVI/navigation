#include "poi-manager-server-stub.h"

PoiManagerServerStub::PoiManagerServerStub() {
    m_version.versionMajor = 1;
    m_version.versionMicro = 0;
    m_version.versionMinor = 0;
    m_version.date = "19-12-2012";

}

PoiManagerServerStub::~PoiManagerServerStub() {
}

void PoiManagerServerStub::getVersion(const std::shared_ptr<CommonAPI::ClientId> clientId, NavigationTypes::Version& version)
{
    version = m_version;
}
