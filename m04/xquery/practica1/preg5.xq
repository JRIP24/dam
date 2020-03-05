for $i in doc("practica1/tenda.xml")/tenda/vehicles/vehicle
let $j := $i/any
let $x := $i/marca_model
where $j > 2008 and $j < 2011
order by $x
return $x