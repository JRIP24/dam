#!/bin/bash

num=0

for i in {1..100};do

    let num=($num + $i)
    echo $num

done
