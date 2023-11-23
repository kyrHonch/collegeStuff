#!/bin/bash

traverse() {

    if [ -f "$1" ]
    then
        grep -oE "[a-z0-9]+@[a-z]+\.com" "$1" | sort -u >> unique_emails.txt
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

traverse "$1"


cat unique_emails.txt | sort -u > temp_unique_emails.txt
cat temp_unique_emails.txt > unique_emails.txt
rm temp_unique_emails.txt