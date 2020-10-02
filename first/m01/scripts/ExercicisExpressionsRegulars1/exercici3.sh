#!/bin/bash

if [ $# -eq 1 ];then

    if [[ $1 =~ ^[-+]?[0-9]+([.][0-9]+)?$ ]];then

        echo "El parámetro $1 es un número"

    else

        echo "El parámetro introducido no es un número"

    fi

else

    echo "Error: Introduzca solo un parámetro"

    exit 1

fi