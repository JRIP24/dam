#!/bin/bash

num=0

<<!

for i in {1..100};do


    let par=( $i % 2 )

    if [ $par -eq 1 ];then
        
        let num=($num + $i)
        echo $num

    fi

done
!



for i in {1..100..2};do
    
    let num=($num + $i)
    echo $num

done