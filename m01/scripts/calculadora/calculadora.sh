#!/bin/bash

clear

salir="n"

while [ $salir == "n" ]; do

    echo ' 

                        ________________________________ 
                       |                                |
                       |           CALCULADORA          |
                       |________________________________|
                       
                            INDIQUE LA OPERACIÓN QUE 
                                 DESEA REALIZAR
                        ________________________________ 
                       |                                |
                       |    SUMA             -->    +   |
                       |                                |
                       |    RESTA            -->    -   |
                       |                                |
                       |    MULTIPLICACIÓN   -->    *   |
                       |                                |
                       |    DIVISIÓN         -->    /   |
                       |                                |
                       |    SALIR            -->    0   |
                       |________________________________|

        '

    read operacion

    case $operacion in

        "+")
           read -p "Introduzca el primer número" num1
           read -p "Introduzca el segundo número" num2

        ;;

        "-")
           read -p "Introduzca el primer número" num1
           read -p "Introduzca el segundo número" num2
            
        ;;

        "*")
           read -p "Introduzca el primer número" num1
           read -p "Introduzca el segundo número" num2
            
        ;;

        "/")
           read -p "Introduzca el primer número" num1
           read -p "Introduzca el segundo número" num2
            
        ;;

        "0")
            salir_calc="y"
        ;;
        *)
            echo "Error: opción no encontrada"
            exit 1
        ;;
    esac

    
    
    if [ salir_calc == "y" ]; then

        salir="s"
        echo "Saliendo..."
        sleep 2

    fi
    
done
