#!/bin/bash


traverse() {

	size=$(du -b "$1" | cut -f 1)
	if [ "$size" == 0 ]
	then
		echo "$1 has a size of $size"
		rm "$1"
	fi
	if [ ! -d "$1" ]; then
	    return
	fi
	if [ `ls "$1" | wc -l` -eq 0 ]; then
   		return
	fi

	local entries=("$1"/*)
	local entry
	for entry in "${entries[@]}"
	do
	    traverse "$entry"
	done
}


if [ $# == 0 ]
then
	dir="."
else
	dir="$1"
fi

traverse "$dir"

