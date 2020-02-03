
### Exercicis Gestio de disc II

Col·lecció d'exercicis relatius als temes:
+ 104.5 Administrar permisos i propietaris de fitxers
+ 104.6 Crear i canviar els enllaços durs i simbòlics
+ 104.7 Trobar fitxers del sistema i situar fitxers a la ubicació correcta

#### *Permisos (104.5)*

##### Exercici 1

Tenim la següent situació:

```
# ls -la /home/zoe

drwxrwx--x 2 zoe users 8192 2010-03-14 18:33 .
drwx--x--x 9 zoe users 16384 2010-03-11 08:00 ..
-rw-r--r-- 1 zoe users 2942 2010-03-16 13:45 afile
drwx------ 2 zoe users 4096 2010-03-14 18:33 dir
-rw-r--r-- 1 zoe users 4039 2009-11-22 08:18 .profile 
```

Suposem que un *cracker* aconseguís entrar al nostre sistema amb un compte diferent de *root* i que no és membre de users:

a) Té permís per fer `ls /home`?

No

b) Té permís per fer `cd /home/zoe` i un `ls` dintre?



c) Té permís *lmessi* que és un altre usuari (membre de *users*) per fer `cd /home/zoe`, després `ls` i per últim `rm afile`?

d) Té permís *lmessi* per fer `cd /home/zoe` i després `cd dir`?

##### Exercici 2

Quina ordre aconseguirà que els permisos que tenim al directori `/tmp/pep` i a tot el seu contingut ens quedi de la següent manera:?

```
rwxrw-r--
```
##### Exercici 3

Suposem que un profe vol crear un directori a `/tmp/exercicis/` a on els
alumnes i qui vulgui puguin afegir fitxers, però vigilant que ningú pugui
eliminar un fitxer del qual no sigui el propietari, les úniques excepcions
seran root i el mateix propietari del directori on es desen els fitxers, que en
aquest cas és el profe. Quina serà l'ordre a executar pel profe? Creeu usuaris
i aquest directori `/tmp/exercicis/` i feu proves.

#### *Modes d’accés*

##### Exercici 4

Quina diferència hi ha entre aquestes dues línies:?

```
drwxrwxrwt
drwxrwxrwT
```

##### Exercici 5 

D'una banda tenim la següent informació:

```
[ordinari@asus_f19 ~]$ ls -l /etc/shadow 
---------- 1 root root 1342 Jan 30 11:09 /etc/shadow
```

i de l'altra, sabem que un usuari ordinari pot utilitzar l'ordre `passwd` i
aquesta ordre aconsegueix escriure al fitxer `/etc/shadow`.

Comproveu això fent el següent:

* creeu un usuari com a root
* doneu-li un password a aquest nou usuari local
* comproveu que aquest password s'escriu encriptat al 2on camp del fitxer `/etc/shadow` (no sortiu del fitxer).
* a una altra terminal entreu a una sessió com al nou usuari creat i canvieu la contrasenya.
* compareu l'antic fitxer `/etc/shadow` amb el nou, comprovant que s'ha modificat: s'haurà escrit una cadena al camp del `password` del nou usuari.

Que el root pugui fer de tot, per exemple llegir o escriure d'un fitxer que no
te permisos ja és el que toca, però com és possible que un usuari ordinari
pugui escriure en aquest fitxer sense tenir permisos d'escriptura?

##### Exercici 6 

Suposem que hem creat un fitxer regular. Mirem els permisos i ens mostra:

```
-r--rw-rw-
```

Quina és la màscara (és a dir, el valor que ens mostraria l'ordre `umask`)?

##### Exercici 7

Suposem que hem creat un directori al nostre *$HOME*. Mirem els permisos i ens mostra:

```
drwxr-xr-x
```

Quina és la màscara (és a dir, el valor que ens mostraria l'ordre `umask`)?

#### *Canvi de propietari i de grup*

##### Exercici 8

Hem creat un fitxer regular. Mirem el propietari i el grup. Volem que pertanyi a l'usuari *usuari1* i grup *usuaris*. Amb quina ordre ho aconseguiries? Comprova-ho.

##### Exercici 9

I si volem canviar de nou només el propietari a *usuari2*?

##### Exercici 10

Ara el volem canviar només de grup, al grup principal de l’*usuari2*.


#### *Enllaços durs i simbòlics (104.6)*

> Crea un directori de prova i dintre seu crea un fitxer amb alguna frase dintre. Després juga amb les ordres `ln` (amb l'opció *-s* i sense) amb `du` (opcions *-h* o potser en aquest cas millor *-b*) amb `ls` (opcions *-l* i *-i*) o fins i tot podries fer servir l'ordre `stat`, per resoldre si les següents qüestions són certes o no: 

##### Exercici 11

Tots els enllaços *soft* a un fitxer concret tenen el mateix inode.

##### Exercici 12

Quan fem ls -l es mostrem la quantitat de enllaços simbòlics (just després dels permisos i
abans de la columna de propietari de fitxer)

##### Exercici 13

Si modifiquem el fitxer (mitjançant el mateix destí o un enllaç soft o hard) els canvis són
visibles des de qualsevol enllaç/fitxer.

##### Exercici 14

Els enllaços durs tenen el mateix contingut que els fitxers al que apunten.

##### Exercici 15

Si eliminem el fitxer destí (al qual apunta un enllaç dur) ja no podrem veure el contingut
del fitxer.

##### Exercici 16

Si eliminem l'últim enllaç simbòlic cap a un fitxer, ja no podrem veure el fitxer al qual
apuntava.

##### Exercici 17

Un enllaç dur no pot apuntar a un sistema de fitxers diferents.

##### Exercici 18

Els enllaços soft són més lents a l'hora d'accedir al contingut del fitxer.

##### Exercici 19

Els enllaços durs no poden apuntar a un directori. (Feu un cop d'ull al `man` o a `info`)

##### Exercici 20
	
Si canviem els permisos d'un fitxer (mitjançant el mateix destí o un enllaç *soft* o *hard*)
també canvien els permisos dels enllaços.

##### Exercici 21

Quina ordre ens mostra tots els enllaços durs que apunten a un fitxer anomenat fitxer1.txt? 

##### Exercici 22

I si coneixem l'inode? 

##### Exercici 23
	
Executa les següents ordres: 

```
touch k1 k2 k3 k4 k5 k6 
```

Mostra els seus inodes 

```
ls -li k1 k2 k3 k4 k5 k6 
```

És gairebé segur (sempre que no es tracti d'un dispositiu gairebé verge) que els fitxers tindran els inodes quasi consecutius: 
perquè són "quasi" i no consecutius? 

##### Exercici 24

Donades les següents ordres: 
```
[eva@h27 ~]$ echo "hola" > /tmp/a.txt
[eva@h27 ~]$ ln -s /tmp/a.txt a-link.txt
[eva@h27 ~]$ ls -l a-link.txt
lrwxrwxrwx. 1 eva inf 10 feb 10 12:32 a-link.txt -> /tmp/a.txt
[eva@h27 ~]$ 
```

Que vol dir el valor 10, que trobem a la cinquena columna i d'on surt? 

#### *FHS i ordre find (104.6)*

##### Exercici 25
	
Tenint en compte l'estàndard que descriu el contingut dels directoris d'un sistema de fitxers a *GNU/LINUX*, o sigui l'estàndard *FHS*:
	
- on posa un usuari la versió que s'ha fabricat de l'ordre `ls`? (un binari executable en C).
	
- on instal·la l'usuari el programa GoogleEarth?
	
- on trobem la documentació pdf del Postgres?

##### Exercici 26
	
Practica cada un dels exemples del find que hi ha al manual pdf i a més a més fes:

- llistar tots els fitxers fets en les últimes 6 hores.

- llistar tots els fitxers fets els últims 3 dies.

- llistar tots els fitxers amb permisos d'execució de l'última setmana.

- llistar tots els fitxers del sistema que tenen el bit d'executable `suid` i `sgid` activat (individualment o els dos).

- Llistar tots els directoris del sistema que tenen l'*sticky bit* activat.

- Llistar tots els fitxers d'en pere fets des del 1 de gener.

#### Links:

* [Soft & Hard Links](https://linuxgazette.net/105/pitcher.html)
* [SETGID](http://www.toptip.ca/2010/03/linux-setgid-on-directory.html)

