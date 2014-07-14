;
; Copyright (C) 2013 TomTom International B.V.
; 
; This Source Code Form is subject to the terms of the Mozilla Public
; License, v. 2.0. If a copy of the MPL was not distributed with this
; file, You can obtain one at http://mozilla.org/MPL/2.0/.
;
;
; NSIS script om de GENIVI Traffic Incidents POC installer te genereren.
;

!include LogicLib.nsh

;--------------------------------

!macro BIMAGE IMAGE
    Push $0
    GetTempFileName $0
    File /oname=$0 "${IMAGE}"
    SetBrandingImage $0
    Delete $0
    Pop $0
!macroend


;--------------------------------

Name "GENIVI Traffic Incidents POC"
Caption "GENIVI Traffic Incidents POC"

OutFile "..\target\TrafficIncidentsPOC-Installer.exe"

LicenseText "In order to install this software you have to agree with the following license agreement"
LicenseData "Traffic Info license.rtf"


InstallColors 101010 e0e0e0
XPStyle on

; Add branding image to the installer (an image placeholder on the side).
; It is not enough to just add the placeholder, we must set the image too...
; We will later set the image in every pre-page function.
; We can also set just one persistent image in .onGUIInit
AddBrandingImage left 50 10

InstallDir       "$PROGRAMFILES\Traffic Info demo"


;--------------------------------

Page license setBrandingImage
Page components
Page directory
Page instfiles "" "" readySound

UninstPage uninstConfirm
UninstPage instfiles

;--------------------------------


Section "" ; empty string makes it hidden.
  SetOutPath $INSTDIR
SectionEnd


Section "!Traffic Incidents POC"
  SectionIn RO
  
  ; Create folder with all jars, copy them from there to required locations. Remove afterwards.
  CreateDirectory $INSTDIR\jars
  File "/oname=jars\dbuswrapper-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficincidentsservice\dbuswrapper\1.0-SNAPSHOT\dbuswrapper-1.0-SNAPSHOT.jar"
  File "/oname=jars\dbus-java-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficinfo\dbus-java\1.0-SNAPSHOT\dbus-java-1.0-SNAPSHOT.jar"
  File "/oname=jars\libmatthew-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficinfo\libmatthew\1.0-SNAPSHOT\libmatthew-1.0-SNAPSHOT.jar"
  File "/oname=jars\trafficinfo-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficinfo\1.0-SNAPSHOT\trafficinfo-1.0-SNAPSHOT.jar"
  File "/oname=jars\demo-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficinfo\demo\1.0-SNAPSHOT\demo-1.0-SNAPSHOT.jar"
  File "/oname=jars\tecservice-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficinfo\tpeg\tecservice\1.0-SNAPSHOT\tecservice-1.0-SNAPSHOT.jar"
  File "/oname=jars\tpegfwk-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficinfo\tpegfwk\1.0-SNAPSHOT\tpegfwk-1.0-SNAPSHOT.jar"
  File "/oname=jars\tpegfwktypes-model-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficinfo\tpegfwktypes-model\1.0-SNAPSHOT\tpegfwktypes-model-1.0-SNAPSHOT.jar"
  File "/oname=jars\tpegtables-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficinfo\tpegtables\1.0-SNAPSHOT\tpegtables-1.0-SNAPSHOT.jar"
  File "/oname=jars\event-model-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficinfo\tpeg\tec\event-model\1.0-SNAPSHOT\event-model-1.0-SNAPSHOT.jar"
  File "/oname=jars\commons-logging-1.0.4.jar" "D:\maven_repository\repository\commons-logging\commons-logging\1.0.4\commons-logging-1.0.4.jar"
  File "/oname=jars\openlr-cli-sqlite-with-dependencies-1.2.2.jar" "D:\maven_repository\repository\openlr\openlr-cli-sqlite-with-dependencies\1.2.2\openlr-cli-sqlite-with-dependencies-1.2.2.jar"
  File "/oname=jars\openlr-map-1.2.2.jar" "D:\maven_repository\repository\openlr\openlr-map\1.2.2\openlr-map-1.2.2.jar"
  File "/oname=jars\openlr-map-sqlite-with-dependencies-1.2.2.jar" "D:\maven_repository\repository\openlr\openlr-map-sqlite-with-dependencies\1.2.2\openlr-map-sqlite-with-dependencies-1.2.2.jar"
  File "/oname=jars\basetypes-model-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\basetypes-model\1.0-SNAPSHOT\basetypes-model-1.0-SNAPSHOT.jar"
  File "/oname=jars\booleanexpr-model-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\booleanexpr-model\1.0-SNAPSHOT\booleanexpr-model-1.0-SNAPSHOT.jar"
  File "/oname=jars\iconset-model-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\iconset-model\1.0-SNAPSHOT\iconset-model-1.0-SNAPSHOT.jar"
  File "/oname=jars\locref-model-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\locref-model\1.0-SNAPSHOT\locref-model-1.0-SNAPSHOT.jar"
  File "/oname=jars\sni-model-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficinfo\tpeg\sni-model\1.0-SNAPSHOT\sni-model-1.0-SNAPSHOT.jar"
  File "/oname=jars\trafficincidents-trafficincident-model-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficincidentsservice\trafficincidents\trafficincidents-trafficincident-model\1.0-SNAPSHOT\trafficincidents-trafficincident-model-1.0-SNAPSHOT.jar"
  File "/oname=jars\trafficincidenttables-model-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficincidentsservice\trafficincidenttables-model\1.0-SNAPSHOT\trafficincidenttables-model-1.0-SNAPSHOT.jar"
  File "/oname=jars\trafficincidentsservice-model-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficincidentsservice\trafficincidentsservice-model\1.0-SNAPSHOT\trafficincidentsservice-model-1.0-SNAPSHOT.jar"
  File "/oname=jars\trafficincidentfeed-trafficincident-model-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficincidentsservice\trafficincidentfeed\trafficincidentfeed-trafficincident-model\1.0-SNAPSHOT\trafficincidentfeed-trafficincident-model-1.0-SNAPSHOT.jar"
  File "/oname=jars\trafficincidentsexampleclients-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficinfo\trafficincidentsexampleclients\1.0-SNAPSHOT\trafficincidentsexampleclients-1.0-SNAPSHOT.jar"
  File "/oname=jars\org.eclipse.emf.common-2.8.0.v20130125-0546.jar" "D:\maven_repository\repository\org\eclipse\emf\org.eclipse.emf.common\2.8.0.v20130125-0546\org.eclipse.emf.common-2.8.0.v20130125-0546.jar"
  File "/oname=jars\org.eclipse.emf.ecore-2.8.3.v20130125-0546.jar" "D:\maven_repository\repository\org\eclipse\emf\org.eclipse.emf.ecore\2.8.3.v20130125-0546\org.eclipse.emf.ecore-2.8.3.v20130125-0546.jar"
  File "/oname=jars\org.eclipse.emf.ecore.xmi-2.8.1.v20130125-0546.jar" "D:\maven_repository\repository\org\eclipse\emf\org.eclipse.emf.ecore.xmi\2.8.1.v20130125-0546\org.eclipse.emf.ecore.xmi-2.8.1.v20130125-0546.jar"
  File "/oname=jars\org.jdesktop.swingx-none.jar" "D:\maven_repository\repository\org\jdesktop\org.jdesktop.swingx\none\org.jdesktop.swingx-none.jar"
  File "/oname=jars\org.jdesktop.swingx-ws-2007_10_14.jar" "D:\maven_repository\repository\org\jdesktop\org.jdesktop.swingx-ws\2007_10_14\org.jdesktop.swingx-ws-2007_10_14.jar"

  File "..\scripts\RunTrafficIncidentsPOC.sh"
  
  CreateDirectory $INSTDIR\TrafficIncidentsService
  File "/oname=TrafficIncidentsService\RunTrafficIncidentsService.sh" "..\scripts\TrafficIncidentsService\RunTrafficIncidentsService.sh"
  File "/oname=TrafficIncidentsService\dbus.impl-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficincidentsservice\dbus.impl\1.0-SNAPSHOT\dbus.impl-1.0-SNAPSHOT.jar"
  CopyFiles "$INSTDIR\jars\*.jar" "$INSTDIR\TrafficIncidentsService"
  
  CreateDirectory $INSTDIR\TrafficIncidentsFeed
  File "/oname=TrafficIncidentsFeed\trafficincidenttestfeed-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficinfo\trafficincidenttestfeed\1.0-SNAPSHOT\trafficincidenttestfeed-1.0-SNAPSHOT.jar"
  File "/oname=TrafficIncidentsFeed\tpegtec-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficincidentsfeed\tpegtec\1.0-SNAPSHOT\tpegtec-1.0-SNAPSHOT.jar"
  File "/oname=TrafficIncidentsFeed\RunTrafficIncidentsFeed.sh" "..\scripts\TrafficIncidentsFeed\RunTrafficIncidentsFeed.sh"
  CopyFiles "$INSTDIR\jars\*.jar" "$INSTDIR\TrafficIncidentsFeed"
  
  CreateDirectory $INSTDIR\TrafficIncidentsConfiguration
  File "/oname=TrafficIncidentsConfiguration\RunTrafficIncidentsConfiguration.sh" "..\scripts\TrafficIncidentsConfiguration\RunTrafficIncidentsConfiguration.sh"
  File "/oname=TrafficIncidentsConfiguration\trafficincidentsconfiguration-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficinfo\trafficincidentsconfiguration\1.0-SNAPSHOT\trafficincidentsconfiguration-1.0-SNAPSHOT.jar"
  CopyFiles "$INSTDIR\jars\*.jar" "$INSTDIR\TrafficIncidentsConfiguration"
  
  CreateDirectory $INSTDIR\TrafficIncidentsListClient
  File "/oname=TrafficIncidentsListClient\RunTrafficIncidentsListClient.sh" "..\scripts\TrafficIncidentsListClient\RunTrafficIncidentsListClient.sh"
  File "/oname=TrafficIncidentsListClient\trafficincidentslistclient-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficinfo\trafficincidentslistclient\1.0-SNAPSHOT\trafficincidentslistclient-1.0-SNAPSHOT.jar"
  CopyFiles "$INSTDIR\jars\*.jar" "$INSTDIR\TrafficIncidentsListClient"
  
  CreateDirectory $INSTDIR\TrafficIncidentsMapClient
  File "/oname=TrafficIncidentsMapClient\RunTrafficIncidentsMapClient.sh" "..\scripts\TrafficIncidentsMapClient\RunTrafficIncidentsMapClient.sh"
  File "/oname=TrafficIncidentsMapClient\trafficincidentsmapclient-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficinfo\trafficincidentsmapclient\1.0-SNAPSHOT\trafficincidentsmapclient-1.0-SNAPSHOT.jar"
  CopyFiles "$INSTDIR\jars\*.jar" "$INSTDIR\TrafficIncidentsMapClient"
  
  CreateDirectory $INSTDIR\TrafficIncidentsWarningClient
  File "/oname=TrafficIncidentsWarningClient\RunTrafficIncidentsWarningClient.sh" "..\scripts\TrafficIncidentsWarningClient\RunTrafficIncidentsWarningClient.sh"
  File "/oname=TrafficIncidentsWarningClient\trafficincidentswarningclient-1.0-SNAPSHOT.jar" "D:\maven_repository\repository\org\genivi\trafficinfo\trafficincidentswarningclient\1.0-SNAPSHOT\trafficincidentswarningclient-1.0-SNAPSHOT.jar"
  CopyFiles "$INSTDIR\jars\*.jar" "$INSTDIR\TrafficIncidentsWarningClient"


  CreateDirectory $INSTDIR\resources
  File "/oname=resources\tomtom_utrecht_2008_04.db3" "..\..\org.genivi.trafficinfo.trafficincidentsexampleclients\resources\tomtom_utrecht_2008_04.db3"

  RMDir /r "$INSTDIR\jars"
  
SectionEnd


Function .onInit
  # the plugins dir is automatically deleted when the installer exits
  InitPluginsDir
  
  StrCpy $INSTDIR "D:\Data\VirtualBoxShare\TrafficInfoPOC"

FunctionEnd

Function .onGUIInit
  # lets extract some bitmaps...
  File /oname=$PLUGINSDIR\TrafficInfoBackground.bmp "TrafficInfoBackground.bmp"
;  File /oname=$PLUGINSDIR\notify.wav "notify.wav"

  # set the initial background for images to be drawn on
  # we will use a gradient from dark blue to a bright blue
  BgImage::SetBg /NOUNLOAD /GRADIENT 0x0 0x0 0x50 0x10 0x10 0xFF

  # create the font for the following text
  CreateFont $R0 "Times New Roman" 50 700
  # add a text with shadow
  BgImage::AddText /NOUNLOAD "Traffic Incidents Proof Of Concept" $R0 50 50 50 328 48 900 198
  BgImage::AddText /NOUNLOAD "Traffic Incidents Proof Of Concept" $R0 80 80 80 327 49 899 199
  BgImage::AddText /NOUNLOAD "Traffic Incidents Proof Of Concept" $R0 110 110 110 326 50 898 200
  BgImage::AddText /NOUNLOAD "Traffic Incidents Proof Of Concept" $R0 150 150 150 325 51 897 201
  BgImage::AddText /NOUNLOAD "Traffic Incidents Proof Of Concept" $R0 190 190 190 324 52 896 202

  # add the background image @ (150,200)
  BgImage::AddImage /NOUNLOAD $PLUGINSDIR\TrafficInfoBackground.bmp 100 250

  # show our creation to the world!
  BgImage::Redraw /NOUNLOAD
  # Refresh doesn't return any value
    
FunctionEnd


Function .onGUIEnd
  # Destroy must not have /NOUNLOAD so NSIS will be able to unload
  # and delete BgImage before it exits
  BgImage::Destroy
FunctionEnd


Function setBrandingImage
    !insertmacro BIMAGE "GENIVI_TomTom_64x64.bmp"
FunctionEnd


Function readySound
;  BgImage::Sound /NOUNLOAD /WAIT $PLUGINSDIR\notify.wav
FunctionEnd

;--------------------------------

