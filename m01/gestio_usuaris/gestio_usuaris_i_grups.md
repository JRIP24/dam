
### Exercicis gestió d'usuaris

*Gestió d'usuaris i grups (LPI 107.1)*

##### Exercici 1

Crea l'usuari *usuari1*.

```
[root@j05 gestio_usuaris]# useradd usuari1
```

Per omissió, quin directori personal assigna el sistema a l'usuari?

`/home/[nom_usuari]`

En quin fitxer es troba aquesta informació? (Pensa quina ordre es fa servir i mira la seva ajuda).

`/etc/default/useradd`

Com es pot canviar de manera permanent o temporal?

- Permanente
Asignando el directorio en `/etc/default/useradd`
```
[root@j05 gestio_usuaris]# cat /etc/default/useradd
# useradd defaults file
GROUP=100
HOME=/[directorio]
INACTIVE=-1
EXPIRE=
SHELL=/bin/bash
SKEL=/etc/skel
CREATE_MAIL_SPOOL=yes

[root@j05 gestio_usuaris]# 

```

- Temporal
```
[root@j05 gestio_usuaris]# useradd usuari1 -d /tmp/user
[root@j05 gestio_usuaris]# useradd usuari1 -b /tmp
```

##### Exercici 2

Elimina la contrasenya de l'usuari *usuari1*

```
[root@j05 gestio_usuaris]# passwd -d usuari1 
```

##### Exercici 3

Repeteix les accions anteriors per a *usuari2* i *usuari3*

```
[root@j05 gestio_usuaris]# useradd usuari2
[root@j05 gestio_usuaris]# useradd usuari3

[root@j05 gestio_usuaris]# passwd -d usuari2
Removing password for user usuari2.
passwd: Note: deleting a password also unlocks the password.
passwd: Success

[root@j05 gestio_usuaris]# passwd -d usuari3
Removing password for user usuari3.
passwd: Note: deleting a password also unlocks the password.
passwd: Success
[root@j05 gestio_usuaris]# 
```

##### Exercici 4 

Crea el grup *usuaris*.
```
[root@j05 gestio_usuaris]# groupadd usuaris
```
##### Exercici 5 

Mira quin es el gid de cada usuari?

```
id -g [usuari]
```

En el cuarto campo
```
                --
usuari1:x:1002:1002::/home/usuari1:/bin/bash
usuari2:x:1003:1003::/home/usuari2:/bin/bash
usuari3:x:1004:1004::/home/usuari3:/bin/bash
```

Un usuari pot pertanyer a més d'un grup?

Si

Quin és(són) el(s) seu(s) grup(s) per defecte?

El mismo usuario crea un grupo propio con su nombre

Si un usuari té més d'un grup, hi ha alguna manera de diferenciar-los
jeràrquicament? (És a dir, en importància)

Se diferencian en:
- Grupo principal
- Resto de grupos

##### Exercici 6 

Afegeix *usuari1* i *usuari2* al grup *usuaris*.

```
[root@j05 gestio_usuaris]# usermod -a -G usuaris usuari1
[root@j05 gestio_usuaris]# usermod -a -G usuaris usuari2
[root@j05 gestio_usuaris]# 
```
##### Exercici 7

Quina ordre hauries utilitzat si abans de crear *usuari1* i *usuari2* hagués
existit *usuaris* ?

```
[root@j05 gestio_usuaris]# useradd -G usuaris usuari1
[root@j05 gestio_usuaris]# useradd -G usuaris usuari2
```

##### Exercici 8

Que cal fer per tal de que tots els usuaris que es donin d'alta al sistema,
automàticament tinguin les següents característiques (sense haver d'especificar-les com a paràmetre de adduser)?

* Estructura de directori de l'usuari amb els subdirectoris: projecte (amb
  permisos rwxr-x---), privat (amb permisos rwx------)

```
[root@j05 gestio_usuaris]# mkdir /etc/skel/projecte
[root@j05 gestio_usuaris]# mkdir /etc/skel/privat
[root@j05 gestio_usuaris]# chmod 750 /etc/skel/projecte
[root@j05 gestio_usuaris]# chmod 700 /etc/skel/privat
```

* Els directoris que creï l'usuari tinguin els permisos 750 (rwxr-x---)

En el archivo `/etc/bashrc`
Cambiar en la siguiente sección:
```
if [ $UID -gt 199 ] && [ "`id -gn`" = "`id -un`" ]; then
    umask 002
else
    umask 022
fi
```
El `umask 002` por
```
if [ $UID -gt 199 ] && [ "`id -gn`" = "`id -un`" ]; then
       umask 027
    else
       umask 022
    fi
```

##### Exercici 9

Un treballador d'una empresa intercanvia fitxers entre l'usuari d'un sistema GNU/Linux que té al
treball i el seu usuari personal GNU/Linux que té al seu ordinador domèstic,
amb logins diferents. Gairebé sempre té problemes amb els permisos. No és el
*root* del treball però sí el de casa seva. Quina solució li proposaries?

```
# En casa hacer
usermod -u [UID de feina] [usuari de casa]
```

##### Exercici 10

Com a administradors d'un sistema, ens comuniquen que un cert usuari faltarà a
la feina durant un temps indeterminat i no volem que ningú pugui accedir al seu
compte. Quina solució proposaries?

```
usermod -L [usuari]
```