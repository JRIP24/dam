Durant les jornades de treball poden ocórrer events que poden afectar als usuaris i gestió
del sistema. Respon als events amb les accions pertinents per solucionar-los. A cada una
de les situacions cal que indiqueu les comandes utilitzades i un print de pantalla amb el
resultat final d’allò que s’ha vist afectat.
Abans de començar, cal deixar-hi constància de la data actual del sistema.
Data: 01-04-2020


#### 1. El treballador Enrique Gallego ha patit una caiguda a les escales i s’ha torçat el turmell. El metge li ha fet una baixa de 60 dies per tal que es recuperi. Insisteix en poder treballar-hi remotament.

- Comando usado `sudo usermod -e 1 egallego`

```
ronald@VBox:~/practica/events$ sudo usermod -e 1 egallego
[sudo] contraseña para ronald:      
ronald@VBox:~/practica/events$ su - egallego
Contraseña: 
La cuenta ha caducado, póngase en contacto con el administrador del sistema
su: Fallo de autenticación
ronald@VBox:~/practica/events$ 

```

#### 2. 15 dies després han aconseguit que algú cobrexi la baixa de l’Enrique. La nova treballadora serà Miriam Armas, i estarà a l’empresa fins que torni Enrique.

- Comando usado `sudo useradd -e 2020-05-31 -m -s /bin/bash marmas`
- Comando para añadirla al grupo `sudo usermod -a -G recursoshumans marmas` o se puede usar el script hecho en la practica anterior

```
ronald@VBox:~/practica/events$ sudo useradd -e 2020-05-31 -m -s /bin/bash marmas[sudo] contraseña para ronald:      
ronald@VBox:~/practica/events$ sudo usermod -a -G recursoshumans marmas
ronald@VBox:~/practica/events$ groups marmas
marmas : marmas recursoshumans
ronald@VBox:~/practica/events$ 
```
#### 3. (3 mesos després de l’event 2) Després d’anys treballats Helena Morales es jubila.


- Comando usado `sudo usermod -e 1 hmorales` la fecha en ese entonces sería 2020-07-16
```
ronald@VBox:~/practica/events$ sudo usermod -e 2020-07-16 hmorales
ronald@VBox:~/practica/events$ 
```

#### 4. (15 dies després de l’event 3)A l’ajuntament s’ha decidit entrar al programa de Formació a Centres de Treball. El primer usuari serà Xavier Mur. (Caldrà separar als becaris d’alguna manera de la resta de treballadors) També es vol modificar el home dels nous usuaris perquè hi trobin un document amb les normatives de l’Ajuntament a una nova carpeta ​ Normatives. ​ (no cal que empleneu el document però si crear-lo, pot ser un ​ normatives.txt o readme.txt​ )

- Fecha: 2020-07-31
`sudo useradd -m -s /bin/bash xmur`


```
#Añadir la carpeta y archivo de las normativas
ronald@VBox:~/practica/cas$ sudo mkdir /etc/skel/normatives
ronald@VBox:~/practica/cas$ sudo touch /etc/skel/normatives/normatives.txt

#Crear el grupo becarios y el nuevo usuario
ronald@VBox:~/practica/cas$ sudo groupadd becaris
ronald@VBox:~/practica/cas$ sudo useradd -m -s /bin/bash xmur
ronald@VBox:~/practica/cas$ tree /home/xmur/
/home/xmur/
└── normatives
    └── normatives.txt

1 directory, 1 file
ronald@VBox:~/practica/cas$ 
ronald@VBox:~/practica/cas$ sudo usermod -a -G becaris xmur 
ronald@VBox:~/practica/cas$ groups xmur 
xmur : xmur becaris
ronald@VBox:~/practica/cas$ 


```

#### 5. (1 mes després de l’event 4)Un nou becari, específicament d’administració ha arribat a l’ajuntament. Pedro Cordón, necessitarà també accés a secretaria.

- Fecha 2020-08-31
```
ronald@VBox:~/practica/events$ sudo useradd -m -s /bin/bash pcordon
ronald@VBox:~/practica/events$ sudo usermod -a -G becaris pcordon 
ronald@VBox:~/practica/events$ sudo usermod -a -G secretaria pcordon

ronald@VBox:~/practica/events$ groups pcordon 
pcordon : pcordon secretaria becaris
ronald@VBox:~/practica/events$ tree /home/pcordon
/home/pcordon
└── normatives
    └── normatives.txt

1 directory, 1 file
ronald@VBox:~/practica/events$ 

```

#### 6. (3 dies de l’event 5) Saray Casas i Paola Cortes, son parella i van a tenir un nen. Saray, qui està prenyada agafa la baixa un mes abans, 30 dies, de tenir la criatura. En naixer, ambós es repartiran el permís per 50/50. (cerqueu el temps que estaran de baixa.)

 - Tienen que estar casadas para que las dos puedan tener baja
 - Baja de Saray: 30 + 8 semanas, Fecha 2020-09-03
 - Estará de baja hasta el 2020-10-29
```
ronald@VBox:~$ sudo usermod -e 1 scasas
```
 - Baixa de Paola 8 semanas, Fecha de baja: 2020-08-04
 - Estará de baja hasta el 2020-09-29
```
ronald@VBox:~$ sudo usermod -e 1 pcortes
```


#### 7. Afortunadament en tan sols 5 dies hem pogut cobrir la baixa de Saray amb Laura Tejeda. Com la baixa de Paola Cortes és programada el mateix dia entrarà a treballar Daniel Paños.

 - Fecha: 2020-08-09

```
ronald@VBox:~$ sudo useradd -e 2020-10-29 -m -s /bin/bash ltejeda
ronald@VBox:~$ sudo useradd -e 2020-09-29 -m -s /bin/bash dpanyos
ronald@VBox:~$ 
```

#### 8. Després d’unes oposicions, 45 dies després de la jubilació de Helena, una persona entra per cobrir la vacant. Maria Rosa Elizalde ha sigut qui ha tret la plaça.

 - Fecha: 2020-08-30
```
ronald@VBox:~$ sudo useradd -m -s /bin/bash melizalde
ronald@VBox:~$ 
```