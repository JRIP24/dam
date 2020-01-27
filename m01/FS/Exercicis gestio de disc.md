
### Exercicis del LPI 104.2-104.3

*Busqueu als enllaços corresponents que teniu al moodle les respostes a les següents preguntes:*

##### Exercici 1

Enumereu quina és la informació referent a un fitxer que conté l'estructura anomenada inode.(104.2)

- Mida del fitxer
- Propietari (userid o uid) i grup (groupid o gid)
- Permisos d'accés al fitxer.
- Tipus de fitxers (fitxer regular, carpeta, dispositiu, socket, enllaç)
- Timestamps
- Un comptador de quants enllaços hi ha a aquest fitxer. Vegeu Hard Links
- Punters al blocs de disc amb el contingut del fitxer.

##### Exercici 2.

L'inode conté el nom del fitxer? Quan executem alguna de les ordres al bash
què ens proporciona algun tipus d'informació d'un fitxer, com s'ho fa el kernel
de linux per arribar a aquesta informació? *104.2*

No contiene el nombre el archivo.
El kernel obtiene la información del archivo a partir de los inodos.

##### Exercici 3.

Com es diu a la propietat que tenen alguns sistemes de fitxers per poder implementar transaccions i poder restablir les dades del sistema de fitxers en cas de corrupció d'aquestes dades (com es fa a una base de dades). *104.2*

Journaling

##### Exercici 4.
   
Mostreu en ordre els directoris que ocupen més espai del vostre directori i subdirectoris. *104.2*

```
[iam2671090@j05 ~]$ du -h | sort -h
```

##### Exercici 5. 

Mostreu els fitxers que ocupen al menys un *MB* al vostre *HOME* *104.2*
```
[iam2671090@j05 ~]$ find . -type f -size +1M
[iam2671090@j05 ~]$ du -ah $HOME | egrep '^[0-9]*..?[0-9]?[MG]'
[iam2671090@j05 ~]$ du -ht1M $HOME | sort -h
```

##### Exercici 6. 

O si ho teniu en castellà (amb coma enlloc de punt):

```
[iam2671090@j05 ~]$ du -ah $HOME | egrep '^[0-9]*,?[0-9]?[MG]'
```

##### Exercici 7. 
	
Mostreu ara un resum *humà*, o sigui el total ocupat al nostre directori. *104.2*

```
[iam2671090@j05 ~]$ du -hs $HOME
```

##### Exercici 8. 

Quina ordre ens mostrarà l'espai lliure i ocupat de totes les particions que
tinguem en format *llegible per humans*? I si volguéssim que al mesurar les
particions s'utilitzés que *1k* en comptes de ser 2¹⁰ (o sigui 1024) fos 10³ (o
sigui 1000), ja que hi ha alguns fabricants que ho fan d'aquesta manera,
sistema internacional, i així ens poden *vendre* menys espai del que ens
pensàvem ? *104.2*

##### Exercici 9. 

Si hi ha una caiguda de tensió i s'apaga/reinicia el S.O., hi ha alguna eina
que ens ajudi a solucionar el possible problema d'inconsistència de dades? (Ens
referim a que hi hagi dades que no s'hagi acabat d'escriure a disc)  *104.2*

##### Exercici 10. 
	
Suposem que volem que en arrencar el sistema es faci un xequeig automàtic
d'una partició on tenim un sistema de fitxers *ext4* (per exemple a `/dev/sda6`).
Com ho faràs? Recorda `man ordre/fitxer` *104.3*

##### Exercici 11. 

De vegades intentem desmuntar un dispositiu i el sistema no en deixa perquè diu
que el dispositiu està ocupat. Amb quina ordre podria saber quins són els
fitxers oberts o quin procés té fitxers oberts? *104.3* 


