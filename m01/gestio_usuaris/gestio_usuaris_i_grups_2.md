
## Exercici final de gestió de disc

Fa uns temps indeterminat es va crear una petita partició de 100 MB amb un sistema de fitxers *ext4*. 

Després de crear i eliminar fitxers en aquesta partició, es va decidir fer una imatge (d'aquesta partició) per si de cas es volia muntar en algun altre dispositiu o punt de muntatge. 

Com que la partició tenia molt d'espai lliure la imatge resultant, que tenia la mateixa mida de 100 MB, es podia comprimir molt: partition_100M.xz

##### Exercici

A la partició original hi ha un fitxer amb un missatge important, heu de llegir el seu contingut (i tenir curiositat).

Podeu demanar pistes, tot i que no té tant de mèrit com aconseguir resoldre el trencaclosques sols. 

```
[root@j05 Downloads]# xz -d partition_100M.xz
[root@j05 Downloads]# losetup /dev/loop1 partition_100M 
[root@j05 Downloads]# mount /dev/loop1 /media/iso/
[root@j05 Downloads]# 

[root@j05 Downloads]# cd /media/iso/
[root@j05 iso]# ls
dontreadme.md  lost+found
[root@j05 iso]# cat dontreadme.md 
INFO
----

A very important file has been deleted, could you *undelete* it from this ext4 partition?

Hint: getting that will help you with some exercises answers

[root@j05 iso]# 
```