#!/bin/bash

echo $1 | sed 's/[a-z]/\U&/g'