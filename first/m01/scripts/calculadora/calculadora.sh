#!/bin/bash

clear

salir="n"
salir_calc="n"

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
    salir_calc="n"

    if [ $operacion != "0" ];then

        case $operacion in

            "+")
            read -p "Introduzca el primer número: " num1
            read -p "Introduzca el segundo número: " num2
            let resultado=$num1+$num2
            echo $resultado

            ;;

            "-")
            read -p "Introduzca el primer número: " num1
            read -p "Introduzca el segundo número: " num2
            let resultado=$num1-$num2
            echo $resultado
                
            ;;

            "*")
            read -p "Introduzca el primer número: " num1
            read -p "Introduzca el segundo número: " num2
            let resultado=$num1*$num2
            echo $resultado
                
            ;;

            "/")
            read -p "Introduzca el primer número: " num1
            read -p "Introduzca el segundo número: " num2
            
            if [ $num2 -eq 0 ]; then

                echo "Error: no se puede dividir por 0"

                else
                    let resultado=$num1/$num2
                    echo $resultado

            fi
                
            ;;

            *)
                echo "Error: opción no encontrada: "
                exit 1
            ;;
        esac

        read -p "Desea hacer otra operación?(s/n): " continuar

        case $continuar in
            "s")
                clear
            ;;
            
            "n")
                salir_calc="y"
            ;;

            *)
                echo "Error: escriba s o n"
                exit 1
            ;;
        esac


        else #El usuario decide salir de la calculadora

            salir_calc="y"

    fi
    
    
    if [ $salir_calc == "y" ]; then

        salir="s"
        echo "Saliendo..."
        sleep 1

    fi
    
done
