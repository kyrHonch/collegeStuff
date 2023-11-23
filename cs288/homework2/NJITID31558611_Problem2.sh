#!/bin/bash

sed -nE 's/[^@]+@([a-z]+\.com).*$/\1/p' data.txt > domains.txt
