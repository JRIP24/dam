#!/bin/bash

if [ $# -eq 2 ];then

    if [ "$1" > "$2" ];then

        echo "La cadena mayor es: $1"

    else
            echo "La cadena mayor es: $2"

    fi

    else
        echo "Error: Introduzca dos parámetros"

fi