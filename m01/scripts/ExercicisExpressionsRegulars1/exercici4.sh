#!/bin/bash

cat /etc/passwd | cut -d ":" -f 3 | egrep [990-1000]

