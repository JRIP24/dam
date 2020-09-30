#!/bin/bash

if [ $# -eq 2 ];then

    cadena1=$1
    cadena2=$2
    long1=${#cadena1}
    long2=${#cadena2}
    
    if [ $long1 -eq $long2 ];then

        echo "Las cadenas son iguales"

        else

            if [ $long1 -gt $long2 ];then

                echo "La cadena mayor es: $1"

            else
                
                echo "La cadena mayor es: $2"

            fi

    fi

    else
        echo "Error: Introduzca dos parámetros"

fi