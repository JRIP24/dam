#!/bin/bash

fecha=`date +"%Y/%m/%d-%H:%M"`

git add .
git commit -m "update $fecha"
git push
