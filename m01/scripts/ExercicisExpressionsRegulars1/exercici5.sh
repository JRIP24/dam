#!/bin/bash

cat copia_etc_passwd.txt | egrep "[a-z]:x:1000" | cut -d ":" -f 5 | sed 's/guest/usuari local/'