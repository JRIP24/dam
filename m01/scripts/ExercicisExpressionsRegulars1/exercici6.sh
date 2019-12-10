#!/bin/bash

echo $1 | sed 's;\([A-Z]\);\L\1;g'