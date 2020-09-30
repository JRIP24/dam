#!/bin/bash

n="0"
while [[ $n =~ ^[[:digit:]]$ ]]
do
    echo "$n és un nombre d'una xifra"
    let n++
done
