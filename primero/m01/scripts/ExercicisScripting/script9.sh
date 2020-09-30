#!/bin/bash


if [ $# -eq 1 ];then

	if [[ $1 =~ ^[0-9]+$ ]];then
	
		for i in {1..10};do
		
			echo "$1 * $i =  $(($1 * $i))"
				
		done
		
	else
		echo "Error: Introduzca un número"
		exit 1
	
	fi

else
	echo "Error: Debe introducir un parámetro numérico"
	exit 1

fi