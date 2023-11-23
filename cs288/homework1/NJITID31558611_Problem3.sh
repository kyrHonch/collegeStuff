#!/bin/bash

fname="$1"
if [ -d $fname ]
then
	echo "$fname is a directory"
elif [ -f $fname ]
then
	echo "$fname is a file"
	size="$(du -b $fname | cut -f 1)"

	if [ $size -gt 1048576 ]
	then
		echo "$fname is a large file"
	elif [ $size -eq 1048576 ] || [ $size -gt 102400 ]
	then
		echo "$fname is a medium file"
	else
		echo "$fname is a small file"
	fi

fi


perm=$(ls -dl $fname | cut -c2-4)

if echo $perm | grep -q "r" 
then
	echo "User has read permissions"
fi

if echo $perm | grep -q "w"
then
	echo "User has write permissions"
fi

if echo $perm | grep -q "x"
then
	echo "User has execute permissions"
fi
