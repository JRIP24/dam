for $i in doc("playstore.xml")/playstore/jocs/joc
order by $i/preu
return if($i/preu >= 50)
then <car>{data($i/nom)}</car>
else <barat>{data($i/nom)}</barat>