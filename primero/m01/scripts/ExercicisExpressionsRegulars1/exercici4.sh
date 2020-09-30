#!/bin/bash

cat /etc/passwd | cut -d ":" -f 1,3 | egrep "99[0-9]|1000"

