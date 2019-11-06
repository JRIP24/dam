#!/bin/bash

clear
echo "Escoge el archivo que quieres modificar

                        ________________________________ 
                       |                                |
                       |         INSERTAR DATOS         |
                       |________________________________|
                       
                          QUÉ ARCHIVO DESEA MODIFICAR?
                        ________________________________
                       |                                |
                       |                                |
                       |       oficinas.dat   --->  1   |
                       |                                |
                       |       repventas.dat  --->  2   |
                       |                                |
                       |   SALIR -------------->  0     |
                       |                                |
                       |________________________________|
"
read opcion

if [ $opcion -eq 1 -o $opcion -eq 2 ] ; then

    if [ $opcion -eq 1 ];then

        archivo=oficinas.dat
    fi

    if [ $opcion -eq 2 ];then

        archivo=repventas.dat
    fi

    echo "Has escogido modificar el archivo $archivo"

elif [ $opcion -eq 0 ]; then

    echo "SALIENDO..."
    sleep 1
    exit 0

else
    echo "Error: opcion $opcion no encontrada"
    echo "Inserte 1 o 2"
    echo "SALIENDO..."
    sleep 1
    exit 1

fi