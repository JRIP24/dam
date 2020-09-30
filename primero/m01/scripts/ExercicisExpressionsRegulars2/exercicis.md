
## Exercicis d'expressions regulars amb sed i grep

Respongueu amb aquest mateix document, afegint les ordres que es busquen en cada exercici.

### Exercici 1

Del resultat de fer un head de les 15 primeres línies del fitxer `/etc/passwd`
mostraeu les línies que contenen un 2 en algun lloc.

```
head -n 15 /etc/passwd | grep 2
```

### Exercici 2

Del resultat de fer un head de les 15 primeres línies del fitxer `/etc/passwd`
mostreu només les línies que tenen *uid* 2.

```
head -n 15 /etc/passwd | egrep '^[^:]*:[^:]:2:'
```

### Exercici 3

Usant grep valideu si un dni té el format apropiat.

```
egrep "^[0-9]{8}[A-Z]$"
```

### Exercici 4 

Usant grep valideu si una data té un format vàlid. Els formats poden ser: dd-mm-aaaa o dd/mm/aaaa.

```
egrep "^[0-9]{2}[/|-][0-9]{2}[/-][0-9]{4}$"

o

egrep "(^[0-9]{2}/[0-9]{2}/[0-9]{4}$)|(^[0-9]{2}-[0-9]{2}-[0-9]{4}$)"
```

### Exercici 5

Per als següents exercicis, cal utilitzar el fitxer [noms1.txt](noms1.txt)

Busqueu totes les línies del fitxer noms1.txt que tenen la cadena *Anna* o la cadena *Jordi*

```
cat noms.txt | egrep "Anna|Jordi"
```

### Exercici 6

Substituïu del fitxer noms1.txt tots els noms Anna i Jordi per -nou-.

```
sed -i -E 's/Anna|Jordi/-nou-/g' noms.txt
```

### Exercici 7

Obtingueu les 10 primeres línies del fitxer `/etc/passwd` substituint `/sbin/nologin` per `-noshell`.

```
head /etc/passwd | sed 's/\/sbin\/nologin/-noshell/g'
```

### Exercici 8

Ídem que l'exercici anterior però fent la substitució només de les línies 4 a la 8.

```
head /etc/passwd | sed '4,8s/\/sbin\/nologin/-noshell/g'
```

### Exercici 9

Ídem exercici anterior però fent les substitucions des de la línia que conté *adm* fins la línia que conté *halt*.

```
head /etc/passwd | sed '/adm/,/halt/s/\/sbin\/nologin/-noshell/g'
```