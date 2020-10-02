#!/bin/bash

taula_ventes=repventas.dat
taula_oficines=oficinas.dat
echo "Introduce el número de trabajador:"
read num_treballador

echo "" #Salto de línea
echo "Escribe el número de la opción que quieres
1: número de oficina
2: ciudad de la oficina
3: región de la oficina
4: número de director de la oficina
5: objetivo de la oficina
6: ventas de la oficina"
read campoOficina

echo "Cat del fitxer $taula_oficines"
cat $taula_oficines
sleep 2

echo -e "\n\nCat del fitxer $taula_oficines amb l'ordre awk filtre venedor num $num_treballador"
cat $taula_oficines | awk -F'\t' -v var=$num_treballador '$1 == var'
sleep 2
echo -e "\n\nCat del fitxer $taula_oficines amb l'ordre awk filtre venedor num $num_treballador i cut $campoOficina"

cat $taula_oficines | awk -v var=$num_treballador '$1 == var' | cut -f 1,$campoOficina

