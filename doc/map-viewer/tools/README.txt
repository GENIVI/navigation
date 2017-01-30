---------------------------------
Document Generation
---------------------------------

0)
Install the following packages:
sudo apt-get install wkhtmltopdf
sudo apt-get install xsltproc
sudo apt-get install pdftk

Download Franca2IDL.jar and Franca2IDLFilter.sh from
https://drive.google.com/open?id=0B7JseVbR6jvhfjNoSnMyc19HV2lGZW1Jay1lUVZ5YU9qN1NBZTZnRGg2emxZS2ZCQWU5VWM
, copy them in the folder /usr/local/bin and allow executing these files as programs.

1) 
Modify the <component name>API-part1.doc as needed.

2)
Convert the <component name>API-part1.doc
into a pdf document with the same name.

3) 
Navigate to the directory 'tools'.

4) 
Generate the documentation:
./generate-doc.sh (generation of API documentation from dbus xml files)
or
./generate-franca-api-doc.sh (generation of API documentation from franca fidl files)
 
A document called <component name>API-part2.pdf will be automatically generated.
The final component documentation (<component name>API.pdf) will be created in 
the parent directory.
