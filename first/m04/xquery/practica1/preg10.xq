let $i := doc("practica1/tenda.xml")/tenda/vehicles/vehicle/preu

let $j := avg($i[. > 10000 and . < 20000])
return $j