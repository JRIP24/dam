
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
11
[root@j05 iso]# mount -o remount,ro /dev/loop0 
[root@j05 iso]# extundelete /dev/loop0 --restore-all
[root@j05 iso]# cd /root/RECOVERED_FILES/
[root@j05 RECOVERED_FILES]# ls
exercicis_gestio_disc_II_solucions.md  xag  xan  xau  xbb  xbi  xbp  xbw  xcd  xck  xcr  xcy  xdf
file.12                                xah  xao  xav  xbc  xbj  xbq  xbx  xce  xcl  xcs  xcz  xdg
xab                                    xai  xap  xaw  xbd  xbk  xbr  xby  xcf  xcm  xct  xda  xdh
xac                                    xaj  xaq  xax  xbe  xbl  xbs  xbz  xcg  xcn  xcu  xdb  xdi
xad                                    xak  xar  xay  xbf  xbm  xbt  xca  xch  xco  xcv  xdc  xdj
xae                                    xal  xas  xaz  xbg  xbn  xbu  xcb  xci  xcp  xcw  xdd  xdk
xaf                                    xam  xat  xba  xbh  xbo  xbv  xcc  xcj  xcq  xcx  xde
[root@j05 RECOVERED_FILES]# 
```