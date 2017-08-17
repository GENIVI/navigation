#!/bin/bash

build_option=""
positioning_version='9725fe1f553197042d6445997690d452a73490c0'
navit_version='28478e7f26c1a0eedc06fb4765e2f736079c6f0c'

echo "version of positioning is: $positioning_version"
echo "version of navit is: $navit_version"

echo "This script deletes and reloads all the third party software"
read -r -p "Are you sure ? [y/N] " input

case "$input" in
	[y/Y])
	./update_navit $navit_version
	./update_positioning $positioning_version
	echo "Please rebuild with at least -c option"
	;;
	*)
	exit 1
	;;
esac





