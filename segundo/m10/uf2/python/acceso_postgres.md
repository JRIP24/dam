#### En bash
# 
```bash

[ronald@i30 python]$ docker exec -u root -ti odoo bash

root@802873a60a17:/mnt/extra-addons/directorio# pwd
/mnt/extra-addons/directorio

root@802873a60a17:/mnt/extra-addons/directorio# ls
prueba.py
```


#### Código de conección a BBDD postgres
# 
```python
import psycopg2

try:
    conn = psycopg2.connect("dbname='EXAMENRIP' user='odoo' host='172.17.0.1' password='odoo'")
    cur = conn.cursor()
    cur.execute("SELECT * from account_account")
    rows = cur.fetchall()
    
    for row in rows:
        print (row)
except (Exception, psycopg2.DatabaseError) as error:
    print(error)
finally:
    if conn is not None:
        conn.close()
```