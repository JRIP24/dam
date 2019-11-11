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
        echo "Has escogido modificar el archivo $archivo"
        echo -e "NumOficina \t Ciutat \t Regió \t NumDirector \t Objectiu \t Vendes"
        
        echo "Introduzca los datos correspondientes: "
        read -p "NumOficina: " NumOficina
        read -p "Ciutat: " Ciutat
        read -p "Regió: " Regio
        read -p "NumDirector: " NumDirector
        read -p "Objectius: " Objectiu
        read -p "Vendes: " Vendes

        datos="$NumOficina\t$Ciutat\t$Regio\t$NumDirector\t$Objectiu\t$Vendes"
    fi

    if [ $opcion -eq 2 ];then

        archivo=repventas.dat
        echo "Has escogido modificar el archivo $archivo"
        echo -e "NumPersonal \t Nom \t Codi \t NumOficina \t Treball \t DataContractació \t Projecte \t Objectius \t Vendes"

        echo "Introduzca los datos correspondientes: "
        read -p "Numpersonal: " NumPersonal
        read -p "Nom: " Nom
        read -p "Codi: " Codi
        read -p "NumOficina: " NumOficina
        read -p "Treball: " Treball
        read -p "DataContractació: " DataContractacio
        read -p "Projecte: " Projecte
        read -p "Objectius: " Objectius
        read -p "Vendes: " Vendes

        datos="$NumPersonal\t$Nom\t$Codi\t$NumOficina\t$Treball\t$DataContractacio\t$Projecte\t$Objectius\t$Vendes"

    fi

    echo "Se guardarán los siguientes datos: "
    echo -e $datos
    read -p "Está seguro de que quiere continuar?(s/n): " guardar
    
    #Control de errores

    if [ $guardar != "s" ] && [ $guardar != "n" ];then
        
        echo "Error: escriba s o n"
        exit 1
    
    elif [ $guardar == "s" ];then

        echo "Guardando..."
        echo -e $datos >> $archivo
        sleep 2
        exit 0

    elif [ $guardar == "n" ];then

        echo "Saliendo..."
        sleep 2
        exit 0

    fi


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