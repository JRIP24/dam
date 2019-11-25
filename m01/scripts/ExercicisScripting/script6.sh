#!/bin/bash


if [ $# -eq 2 ];then

    if [[ $1 =~ ^[0-9]+$ ]] && [[ $2 =~ ^[0-9]+$ ]];then

        if [ $2 -ge $1 ];then

            for i in $(seq $1 $2);do
                echo -n "$i "
                sleep 0.1
            done
            echo ""

        else
            echo "Error: El segundo parámetro debe ser mayor que el primero"

        fi

    else
        echo "Error: Introduce 2 parámetros numéricos"

    fi

else
    echo "Error: Introduce 2 parámetros numéricos"

fi