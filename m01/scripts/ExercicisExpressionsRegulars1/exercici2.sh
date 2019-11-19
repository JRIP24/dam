#!/bin/bash

if [ $# -eq 1 ];then

    if [[ $1 =~ [0-9] ]];then

        echo $1

    fi

else

    exit 1

fi