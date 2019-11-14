#!/bin/bash

fecha=`date +"%Y/%m/%d-%H:%M"`

echo $fecha

git add .
git commit -m "update $fecha"
git push
