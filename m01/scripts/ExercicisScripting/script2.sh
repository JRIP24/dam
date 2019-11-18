#!/bin/bash

if [ $# -eq 2 ];then

    if [ $1 -gt $2 ];then

        echo "El número mayor es: $1"

        else
            echo "El número mayor es: $2"

    fi

    else
        echo "Error: Introduzca dos parámetros"

fi