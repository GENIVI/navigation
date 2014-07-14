;
; NSIS script om de GENIVI Traffic Info installer te genereren.
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

Name "TomTom GENIVI Traffic Info demo"
Caption "TomTom GENIVI Traffic Info demo"

OutFile "..\target\TomTom-GENIVI-TrafficInfo-Installer.exe"

LicenseText "In order to install this software you have to agree with the following license agreement"
LicenseData "TomTom GENIVI Traffic Info license.rtf"


InstallColors 101010 e0e0e0
XPStyle on

; Add branding image to the installer (an image placeholder on the side).
; It is not enough to just add the placeholder, we must set the image too...
; We will later set the image in every pre-page function.
; We can also set just one persistent image in .onGUIInit
AddBrandingImage left 50 10

InstallDir       "$PROGRAMFILES\TomTom GENIVI Traffic Info demo"


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
  WriteUninstaller "TomTom-GENIVI-TrafficInfo-demo-uninst.exe"  
SectionEnd


Section "!Traffic Info demo program"
  SectionIn RO

  File "TrafficInfo_32x32.ico"
  File "..\resources\Traffic Info demo.sh"
  CreateDirectory $INSTDIR\resources
  File "/oname=resources\tomtom_utrecht_2008_04.db3" "..\resources\tomtom_utrecht_2008_04.db3"
  File "C:\Documents and Settings\pego\.m2\repository\org-genivi\org-genivi-trafficinfo\1.0-SNAPSHOT\org-genivi-trafficinfo-1.0-SNAPSHOT.jar"
  File "C:\Documents and Settings\pego\.m2\repository\com-tomtom\com-tomtom-demo\1.0-SNAPSHOT\com-tomtom-demo-1.0-SNAPSHOT.jar"
  File "C:\Documents and Settings\pego\.m2\repository\com-tomtom\com-tomtom-ti-tecservice\1.0-SNAPSHOT\com-tomtom-ti-tecservice-1.0-SNAPSHOT.jar"
  File "C:\Documents and Settings\pego\.m2\repository\com-tomtom\com-tomtom-ti-tpeg2waycomm-model\1.0-SNAPSHOT\com-tomtom-ti-tpeg2waycomm-model-1.0-SNAPSHOT.jar"
  File "C:\Documents and Settings\pego\.m2\repository\com-tomtom\com-tomtom-ti-tpegfwk\1.0-SNAPSHOT\com-tomtom-ti-tpegfwk-1.0-SNAPSHOT.jar"
  File "C:\Documents and Settings\pego\.m2\repository\com-tomtom\com-tomtom-ti-tpegfwktypes-model\1.0-SNAPSHOT\com-tomtom-ti-tpegfwktypes-model-1.0-SNAPSHOT.jar"
  File "C:\Documents and Settings\pego\.m2\repository\com-tomtom\com-tomtom-ti-tpegtables\1.0-SNAPSHOT\com-tomtom-ti-tpegtables-1.0-SNAPSHOT.jar"
  File "C:\Documents and Settings\pego\.m2\repository\com\tomtom\ti\com.tomtom.ti.tec.event-model\1.0-SNAPSHOT\com.tomtom.ti.tec.event-model-1.0-SNAPSHOT.jar"
  File "C:\Documents and Settings\pego\.m2\repository\commons-logging\commons-logging\1.0.4\commons-logging-1.0.4.jar"
  File "C:\Documents and Settings\pego\.m2\repository\junit\junit\4.3\junit-4.3.jar"
  File "C:\Documents and Settings\pego\.m2\repository\openlr\openlr-cli-sqlite-with-dependencies\1.2.2\openlr-cli-sqlite-with-dependencies-1.2.2.jar"
  File "C:\Documents and Settings\pego\.m2\repository\openlr\openlr-map\1.2.2\openlr-map-1.2.2.jar"
  File "C:\Documents and Settings\pego\.m2\repository\openlr\openlr-map-sqlite-with-dependencies\1.2.2\openlr-map-sqlite-with-dependencies-1.2.2.jar"
  File "C:\Documents and Settings\pego\.m2\repository\org-genivi\org-genivi-basetypes\1.0-SNAPSHOT\org-genivi-basetypes-1.0-SNAPSHOT.jar"
  File "C:\Documents and Settings\pego\.m2\repository\org-genivi\org-genivi-locref-model\1.0-SNAPSHOT\org-genivi-locref-model-1.0-SNAPSHOT.jar"
  File "C:\Documents and Settings\pego\.m2\repository\org-genivi\org-genivi-tpeg-sni-model\1.0-SNAPSHOT\org-genivi-tpeg-sni-model-1.0-SNAPSHOT.jar"
  File "C:\Documents and Settings\pego\.m2\repository\org-genivi\org-genivi-trafficinfo-trafficincident.model\1.0-SNAPSHOT\org-genivi-trafficinfo-trafficincident.model-1.0-SNAPSHOT.jar"
  File "C:\Documents and Settings\pego\.m2\repository\org-genivi\org-genivi-trafficinfo-trafficincidents-model\1.0-SNAPSHOT\org-genivi-trafficinfo-trafficincidents-model-1.0-SNAPSHOT.jar"
  File "C:\Documents and Settings\pego\.m2\repository\org-tisa\org-tisa-tpeg2waycomm\1.0-SNAPSHOT\org-tisa-tpeg2waycomm-1.0-SNAPSHOT.jar"
  File "C:\Documents and Settings\pego\.m2\repository\org\eclipse\emf\org.eclipse.emf.common\2.8.0.v20120606-0717\org.eclipse.emf.common-2.8.0.v20120606-0717.jar"
  File "C:\Documents and Settings\pego\.m2\repository\org\eclipse\emf\org.eclipse.emf.ecore\2.8.0.v20120606-0717\org.eclipse.emf.ecore-2.8.0.v20120606-0717.jar"
  File "C:\Documents and Settings\pego\.m2\repository\org\eclipse\emf\org.eclipse.emf.ecore.xmi\2.8.0.v20120606-0717\org.eclipse.emf.ecore.xmi-2.8.0.v20120606-0717.jar"
  File "C:\Documents and Settings\pego\.m2\repository\org\jdesktop\org.jdesktop.swingx\none\org.jdesktop.swingx-none.jar"
  File "C:\Documents and Settings\pego\.m2\repository\org\jdesktop\org.jdesktop.swingx-ws\2007_10_14\org.jdesktop.swingx-ws-2007_10_14.jar"
  CreateShortCut '$INSTDIR\Traffic Info demo.lnk' 'javaw.exe' \
                 '-jar org-genivi-trafficinfo-1.0-SNAPSHOT.jar' '$INSTDIR\TrafficInfo_32x32.ico' '' SW_SHOWNORMAL '' 'Start Traffic Info demo'
SectionEnd


sectionGroup Shortcuts

  Section "Shortcuts in Start menu"
    CreateDirectory "$SMPROGRAMS\Traffic Info demo"
    CreateShortCut '$SMPROGRAMS\Traffic Info demo\Traffic Info demo.lnk' 'javaw.exe' \
                 '-jar org-genivi-trafficinfo-1.0-SNAPSHOT.jar' '$INSTDIR\TrafficInfo_32x32.ico' '' SW_SHOWNORMAL '' 'Start Traffic Info demo'
    CreateShortCut "$SMPROGRAMS\Traffic Info demo\Traffic Info demo-uninst.lnk" "$INSTDIR\TomTom-GENIVI-TrafficInfo-demo-uninst.exe" \
                   "" "$INSTDIR\TomTom-GENIVI-TrafficInfo-demo-uninst.exe" "" SW_SHOWNORMAL "" "Remove Traffic Info demo"
  SectionEnd

  Section "Shortcut on Desktop"
    CreateShortCut '$DESKTOP\Traffic Info demo.lnk' 'javaw.exe' \
                 '-jar org-genivi-trafficinfo-1.0-SNAPSHOT.jar' '$INSTDIR\TrafficInfo_32x32.ico' '' SW_SHOWNORMAL '' 'Start Traffic Info demo'
  SectionEnd

  Section "Quick access icon"
    CreateShortCut '$QUICKLAUNCH\Traffic Info demo.lnk' 'javaw.exe' \
                 '-jar org-genivi-trafficinfo-1.0-SNAPSHOT.jar' '$INSTDIR\TrafficInfo_32x32.ico' '' SW_SHOWNORMAL '' 'Start Traffic Info demo'
  SectionEnd

sectionGroupEnd

Function .onInit
  # the plugins dir is automatically deleted when the installer exits
  InitPluginsDir

FunctionEnd

Function .onGUIInit
  # lets extract some bitmaps...
  File /oname=$PLUGINSDIR\TrafficInfoBackground.bmp "TrafficInfoBackground.bmp"
  File /oname=$PLUGINSDIR\notify.wav "notify.wav"

  # set the initial background for images to be drawn on
  # we will use a gradient from dark blue to a bright blue
  BgImage::SetBg /NOUNLOAD /GRADIENT 0x0 0x0 0x50 0x10 0x10 0xFF

  # create the font for the following text
  CreateFont $R0 "Times New Roman" 50 700
  # add a text with shadow
  BgImage::AddText /NOUNLOAD "Traffic Info demo" $R0 50 50 50 328 48 900 198
  BgImage::AddText /NOUNLOAD "Traffic Info demo" $R0 80 80 80 327 49 899 199
  BgImage::AddText /NOUNLOAD "Traffic Info demo" $R0 110 110 110 326 50 898 200
  BgImage::AddText /NOUNLOAD "Traffic Info demo" $R0 150 150 150 325 51 897 201
  BgImage::AddText /NOUNLOAD "Traffic Info demo" $R0 190 190 190 324 52 896 202

  # add the background image @ (150,200)
  BgImage::AddImage /NOUNLOAD $PLUGINSDIR\TrafficInfoBackground.bmp 50 200

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
  BgImage::Sound /NOUNLOAD /WAIT $PLUGINSDIR\notify.wav
FunctionEnd

;--------------------------------

; Uninstaller

UninstallText "This program removes the TomTom GENIVI Traffic Info demo from your computer. Click 'Uninstall' to continue."

Section "Uninstall"
  Delete "$INSTDIR\TrafficInfo_32x32.ico"
  Delete "$INSTDIR\Traffic Info demo.sh"
  Delete "$INSTDIR\resources\tomtom_utrecht_2008_04.db3"
  Delete "$INSTDIR\org-genivi-trafficinfo-1.0-SNAPSHOT.jar"
  Delete "$INSTDIR\com-tomtom-demo-1.0-SNAPSHOT.jar"
  Delete "$INSTDIR\com-tomtom-ti-tecservice-1.0-SNAPSHOT.jar"
  Delete "$INSTDIR\com-tomtom-ti-tpeg2waycomm-model-1.0-SNAPSHOT.jar"
  Delete "$INSTDIR\com-tomtom-ti-tpegfwk-1.0-SNAPSHOT.jar"
  Delete "$INSTDIR\com-tomtom-ti-tpegfwktypes-model-1.0-SNAPSHOT.jar"
  Delete "$INSTDIR\com-tomtom-ti-tpegtables-1.0-SNAPSHOT.jar"
  Delete "$INSTDIR\com.tomtom.ti.tec.event-model-1.0-SNAPSHOT.jar"
  Delete "$INSTDIR\commons-logging-1.0.4.jar"
  Delete "$INSTDIR\junit-4.3.jar"
  Delete "$INSTDIR\openlr-cli-sqlite-with-dependencies-1.2.2.jar"
  Delete "$INSTDIR\openlr-map-1.2.2.jar"
  Delete "$INSTDIR\openlr-map-sqlite-with-dependencies-1.2.2.jar"
  Delete "$INSTDIR\org-genivi-basetypes-1.0-SNAPSHOT.jar"
  Delete "$INSTDIR\org-genivi-locref-model-1.0-SNAPSHOT.jar"
  Delete "$INSTDIR\org-genivi-tpeg-sni-model-1.0-SNAPSHOT.jar"
  Delete "$INSTDIR\org-genivi-trafficinfo-trafficincident.model-1.0-SNAPSHOT.jar"
  Delete "$INSTDIR\org-genivi-trafficinfo-trafficincidents-model-1.0-SNAPSHOT.jar"
  Delete "$INSTDIR\org-tisa-tpeg2waycomm-1.0-SNAPSHOT.jar"
  Delete "$INSTDIR\org.eclipse.emf.common-2.8.0.v20120606-0717.jar"
  Delete "$INSTDIR\org.eclipse.emf.ecore-2.8.0.v20120606-0717.jar"
  Delete "$INSTDIR\org.eclipse.emf.ecore.xmi-2.8.0.v20120606-0717.jar"
  Delete "$INSTDIR\org.jdesktop.swingx-none.jar"
  Delete "$INSTDIR\org.jdesktop.swingx-ws-2007_10_14.jar"
  Delete "$INSTDIR\Traffic Info demo.lnk"
  Delete "$INSTDIR\TomTom-GENIVI-TrafficInfo-demo-uninst.exe"
  Delete "$INSTDIR\OpenLR-encoder.log"
  RMDir "$INSTDIR\resources"
  RMDir "$INSTDIR"
  Delete "$SMPROGRAMS\Traffic Info demo\Traffic Info demo.lnk"
  Delete "$SMPROGRAMS\Traffic Info demo\Traffic Info demo-uninst.lnk"
  RMDir  "$SMPROGRAMS\Traffic Info demo"
  Delete "$DESKTOP\Traffic Info demo.lnk"
  Delete "$QUICKLAUNCH\Traffic Info demo.lnk"

  IfFileExists "$INSTDIR" 0 InstDirRemoved
    MessageBox MB_OK "Note: $INSTDIR could not be removed!" IDOK 0
  InstDirRemoved:

  IfFileExists "$SMPROGRAMS\Traffic Info demo" 0 ProgramsDirRemoved
    MessageBox MB_OK "Note: $SMPROGRAMS\Traffic Info demo could not be removed!" IDOK 0
  ProgramsDirRemoved:

SectionEnd

