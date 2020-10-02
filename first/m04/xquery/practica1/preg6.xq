for $i in doc("practica1/tenda.xml")/tenda/vehicles/vehicle
let $j := $i/any
let $x := $i/marca_model
where $j > 2007
order by $j descending
return ($x , $j)