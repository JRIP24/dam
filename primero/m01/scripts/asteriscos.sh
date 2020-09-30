#!/bin/bash

contador=0
salir="n"

while [ $salir == "n" ]; do

    echo -n "*"

    let contador=$contador+1

    #Condición de salida
    if [ $contador -eq $1 ]; then

        salir="s"
        echo ""

    fi

done