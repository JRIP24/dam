#!/bin/bash

#SIN GUARDAR CAMBIOS
#sed 's;\([^:]*:1000:[^:]*:\)\([^:]*\)\(:[^:]*:[^:]*\);\1usuari local\3;' copia_etc_passwd.txt


#GUARDANDO CAMBIOS
sed -i 's;\([^:]*:1000:[^:]*:\)\([^:]*\)\(:[^:]*:[^:]*\);\1usuari local\3;' copia_etc_passwd.txt