#!/bin/bash

if [ $# -eq 1 ];then

    if [[ $1 =~ ^[0-9]+$ ]];then

        let resultado=$1%2

        if [ $resultado -eq 0 ];then
        
            echo "El número $1 es par"
        
        else
            echo "El número $1 es impar"

        fi

    else
        echo "Error: El parámetro introducido no es un número entero y positivo"

    fi

else

    echo "Error: Introduzca solo un parámetro"

    exit 1

fi