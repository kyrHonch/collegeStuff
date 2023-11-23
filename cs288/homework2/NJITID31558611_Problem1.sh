#!/bin/bash

echo $(grep -iE "echo" $1 | wc -l)
grep -iE "echo" $1 > echo_log.txt
