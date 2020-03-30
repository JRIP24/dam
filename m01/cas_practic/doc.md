#### Script para crear usuarios
###### Se debe ejecutar con permisos administrativos

```
ronald@VBox:~/practica$ cat crear_usuarios.sh 
#!/bin/bash

lista=usuarios2.txt

#Contraseña por defecto
password="1234"


while IFS= read -r i
do

    n=${i:0:1} #extraemos la primera letra del nombre
    c=$(echo $i | cut -d "," -f 2) #Extraemos el apellido

    #Pasamos todo a minúscula
    c=$(echo $c | tr '[:upper:]' '[:lower:]')
    n=$(echo $n | tr '[:upper:]' '[:lower:]')

    usuario=$n$c
    echo $usuario >> lista.txt
    useradd -m -s /bin/bash $usuario
    echo -e "$usuario:$password" | chpasswd

done < $lista

ronald@VBox:~/practica
```

#### Lista de usuarios
###### Se ha usado el comando `sed` para poner las comas
```
ronald@VBox:~/practica$ cat usuarios2.txt 
Ian,Molina
Oriol,Muñoz
Saray,Casas
Jan,Martin
Helena,Morales
Sandra,Ibañez
Aina,Sole
Enrique,Gallego
Éric,Riera
Paola,Cortes
Candela,Rovira
Miquel,Carmona
Aitor,Garrido
Sara,Bosch
Laura,Muñoz
Jesús,Herrera
Nayara,Ferrer
Ismael,Diaz
Iris,Herrera
Isaac,Cabrera
ronald@VBox:~/practica$ 
```

#### Script para crear grupos
###### Se debe ejecutar con permisos administrativos

```
ronald@VBox:~/practica$ cat crear_grupos.sh 
#!/bin/bash

lista=grupos.txt

while IFS= read -r i
do

    grupo=$(echo $i | tr '[:upper:]' '[:lower:]')
    groupadd $grupo
    
done < $lista

ronald@VBox:~/practica
```

#### Lista de grupos
###### Se ha usado el comando `sed` para dar el formato (también se ha quitado el ' en Regidoria d’Urbanisme i Medi Ambient para evitar problemas)

```
ronald@VBox:~/practica$ cat grupos.txt 
Alcaldia
Secretaria
RegidoriadeJoventutiCultura
RegidoriadUrbanismeiMediAmbient
RegidoriadeBenestarSocial
PoliciaLocal
RecursosHumans
ronald@VBox:~/practica$ 
```


#### Script para asignación de grupos

```
ronald@VBox:~/practica$ cat asignar.sh
#!/bin/bash

#$1 Se pasa el grupo como parámetro
clear
if [ -n "$1" ]; then #Hay un parámetro

    if grep -q "$1:" /etc/group
    then #Existe el grupo

        salir="n"

        while [ $salir != "s" ]; do

            echo "*****************************************************"
            echo "*                                                   *"
            echo "*                                                   *"
            echo "* Introduzca el nombre del usuario o 's' para salir *"
            echo "*                                                   *"
            echo "*                                                   *"
            echo "*****************************************************"
            read user
            
            if [ $user == "s" ]; then #El usuario quiere salir
                
                echo "Saliendo..."
                sleep 1 
                salir=$user

            else

                if grep -q "^$user:" /etc/passwd
                
                then #Existe el usuario
                    
                    #usermod -a -G $1 $user
                    echo "Se ha añadido el usuario $user al grupo $1 correctamente"
                    sleep 1.7

                else #No existe el usuario

                    echo "No se ha encontrado el usuario $user"
                    sleep 1.5
                fi

                
                clear
            fi


        done
    else #NO existe el grupo
        echo "El grupo $1 no se ha encontrado en el sistema"

    fi

else 
    echo "Inrtroduzca por el primer parámetro el grupo al que quiere asignar usuarios"
fi
ronald@VBox:~/practica$ 

```

