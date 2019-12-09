#!/bin/bash

#cat copia_etc_passwd.txt | egrep "[a-z]:x:1000" | cut -d ":" -f 5 | sed 's/guest/usuari local/'

sed 's;\([^:]*\):x:1000;\1usuari local;' copia_etc_passwd.txt

#cat copia_etc_passwd.txt | egrep "[a-z]:x:1000" | awk -F :  '$5==gueckos' | sed 's/$gueckos/usuari local/2'
