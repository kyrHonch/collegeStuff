#!/bin/bash

if [ -e "./$1" ]
then
	sed '1!G;h;$!d' "$1"
fi
