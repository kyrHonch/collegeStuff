#!/bin/bash

fDate=$(date +%Y%m%d)
bDir="backup_$fDate"

mkdir $bDir

for i in $*
do
	cp $i "./$bDir/$i.bak.$fDate"
done
