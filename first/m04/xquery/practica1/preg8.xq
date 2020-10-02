for $i in doc("practica1/tenda.xml")/tenda/vehicles/vehicle
let $j := $i/preu
order by number($j)
return if($j > 10000)
then data($j)
else $j