for $i in doc("playstore.xml")/playstore/jocs/joc
where($i/edat >= 18)
return <joc_adult>{$i/nom,$i/preu}</joc_adult>