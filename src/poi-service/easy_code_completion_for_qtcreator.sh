#!/bin/bash

echo 'add some spaces to easy code completion for qtcreator'
find build/poi-server-capi/src-gen/v4/org/genivi/. -type f -not -name  '*DBus*' |
while read filename 
do
	echo $filename
	sed -i -e 's/<::v4::/< ::v4::/g' $filename 
done


