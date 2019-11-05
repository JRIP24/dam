#!/bin/bash


echo "Introduce el número de trabajador:"
read num_treballador

echo "" #Salto de línea
echo "Escribe el número de la opción que quieres
1: número de oficina
2: ciudad de la oficina
3: región de la oficina
4: número de director de la oficina
5: objetivo de la oficina
6: ventas de la oficina
"
read columna

#read $columna
echo $num_treballador

#cat oficinas.dat | awk -F '\t' -v var= $num_treballador '$1 == var' | cut -d $'\t' -f 1,$columna
