#!/bin/bash

if [ $# -eq 3 ];then

    if [[ $1 =~ ^[0-9]+$ ]] && [[ $2 =~ ^[0-9]+$ ]] && [[ $3 =~ ^[0-9]+$ ]];then

        if [ $1 -eq $2 ] && [ $2 -eq $3 ];then

            echo "$1 $2 $3"

        else

            if [ $1 -ge $2  ] && [ $1 -ge $3 ];then

                echo $1 #Mayor

                if [ $2 -gt $3 ];then
                
                    echo $2 #Medio
                    echo $3 #Menor

                else
                    echo $3
                    echo $2

                fi

            elif [ $2 -ge $3 ];then

                echo $2

                if [ $3 -gt $1 ];then
                
                    echo $3
                    echo $1

                else
                    echo $1
                    echo $3

                fi


            else

                echo $3
                
                if [ $2 -gt $1 ];then
                
                    echo $2
                    echo $1

                else
                    echo $1
                    echo $2

                fi


            fi


        fi


    else

        echo "Error: Introduzca números"
    fi

else
    echo "Error: Introduzca 3 parámetros"


fi