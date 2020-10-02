## Exercicis expressions regulars (I) 

### Exercici 1

Practiqueu amb etructures com

```
if [[ "$A" =~ ^[A-Za-z]$ ]]
then
    echo "Una lletra"
else
    echo "No és una lletra"
fi
```

o (optativament) també

```
n="0"
while [[ "$n" =~ ^[[:digit:]]$ ]]
do 
    echo "$n és un nombre d'una xifra"
    let n++
done
```

### Exercici 2

Feu un script que rebi un argument numèric, controlant que hi hagi un únic argument, 
en cas contrari sortirem de l'script, com sempre.

Volem que també controli que el que li passem sigui un número natural (enter, sense signe). 
En cas contrari sortim de l'script adequadament.

Finalment mostrarem una cadena indicant si és parell o senar.

```
#!/bin/bash

if [ $# -eq 1 ];then

    if [[ $1 =~ ^[0-9]+$ ]];then

        let resultado=$1%2

        if [ $resultado -eq 0 ];then
        
            echo "El número $1 es par"
        
        else
            echo "El número $1 es impar"

        fi

    else
        echo "Error: El parámetro introducido no es un número entero y positivo"

    fi

else

    echo "Error: Introduzca solo un parámetro"

    exit 1

fi
```

### Exercici 3

Feu el mateix que abans però ara el número serà real. Penseu que el número
podrà tenir signe positiu/negatiu o no tenir signe, i tanmbé recordeu que els
reals poden tenir un separador decimal `.`. En aquest exercici de números
reals no mostrarem si és parell o senar; només direm si és un nombre o no.

```
#!/bin/bash

if [ $# -eq 1 ];then

    if [[ $1 =~ ^[-+]?[0-9]+([.][0-9]+)?$ ]];then

        echo "El parámetro $1 es un número"

    else

        echo "El parámetro introducido no es un número"

    fi

else

    echo "Error: Introduzca solo un parámetro"

    exit 1

fi
```

### Exercici 4

Trobeu tots els *usuaris* amb un numero id més gran que 990 i més petit que
1000.

```
#!/bin/bash

cat /etc/passwd | cut -d ":" -f 1,3 | egrep "99[0-9]|1000"


```

### Exercici 5

Volem canviar de l'usuari amb uid 1000 (si no teniu aquest id feu-lo amb un
altre) el camp GECOS posant únicament "usuari local". Primer obteniu el
resultat per pantalla i despres ja pensareu com canviar-ho directament al
fitxer. Per cert si torneu a executar l'ordre amb la qual heu solucionat el
problema anterior segueix funcionant bé.

Naturalment, no utilitzeu el fitxer ```/etc/passwd```, feu una còpia.

En el fitxer `/etc/passwd`, el format de cada línia del fitxer és:

```
username:password:UID:GID:GECOS:homedir:shell
```

_GECOS_ és un camp que es manté per raons històriques, normalment s'aprofita
per donar informació addicional de l'usuari.

```
#!/bin/bash

#SIN GUARDAR CAMBIOS
#sed 's;\([^:]*:1000:[^:]*:\)\([^:]*\)\(:[^:]*:[^:]*\);\1usuari local\3;' copia_etc_passwd.txt


#GUARDANDO CAMBIOS
sed -i 's;\([^:]*:1000:[^:]*:\)\([^:]*\)\(:[^:]*:[^:]*\);\1usuari local\3;' copia_etc_passwd.txt
```

### Exercici 6

Com passarieu una certa cadena de majúscules a minúscules o a l'inrevés?

```
#!/bin/bash

echo $1 | sed 's;\([A-Z]\);\L\1;g'
```