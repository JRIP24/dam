for $i in doc("practica1/tenda.xml")/tenda/vehicles/vehicle
let $j := $i/preu
order by number($j)
return data($j)
