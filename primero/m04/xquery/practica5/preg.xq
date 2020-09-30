<html>
<head>
  <link href="css/estil_SOLUCIO.css" rel="stylesheet" type="text/css"/>
  <title>{
    let $t := doc("The_Expanse.xml")/the_expanse/dades/titol
    return data($t)
  }</title>
</head>
<body>

<table border="0" align="center">
{
  let $t := doc("The_Expanse.xml")/the_expanse/dades/titol
  
  return <tr><th><h1>{data($t)}</h1></th></tr>
}
{
  let $l := doc("The_Expanse.xml")/the_expanse/dades/logo
  let $web := doc("The_Expanse.xml")/the_expanse/dades/pag_web
  return <tr><td><a href="{data($web)}"><img id="esquinarImage" align="center" src="logos/{data($l)}"/></a></td></tr>
}

</table>

<table id="t01" border="1" align="center">
<tr >
<th class="normal" align="center" width="320">Nom</th>
<th class="normal" align="center" width="120">Bandol</th>
<th class="normal" align="center" width="400">Característiques</th>
<th class="normal" align="center" width="240">Noms coneguts</th>
</tr>

{
for $i in doc("The_Expanse.xml")/the_expanse/Martian_Congressional_Republic_Navy/nau

let $foto := $i/imatge
let $clase := $i/classe
let $w := $i/web
let $b := $i/logo
let $t := $i/tipus

return <tr>
<td><img width="320" src="imatges/{data($foto)}"/><br/><a align="center" href="{data($w)}">{data($clase)}</a>
</td>
<td>
<img width="256" src="logos/{data($b)}"/>
</td>
<td>
  
  <span>Tipus de nau: {data($t)}<br/></span>
  
  <span>Tonelatge: {data($i/caracteristiques/tonelatge)} de {data($i/caracteristiques/tonelatge/@unitat)}<br/></span>
  
  <span>Longitud: {data($i/caracteristiques/longitud)} {data($i/caracteristiques/longitud/@unitat)}<br/></span>
  
  <span>Tripulació: {data($i/capacitat_humana/tripulacio)}<br/></span>
  
  
  {
  if ($i/capacitat_humana/tropes/@enPorta = "Si")
  then
  <b>Tropes: {data($i/capacitat_humana/tropes/@quantitat)} de {data($i/capacitat_humana/tropes)} <br/></b>
  else ()
  }
  
  <span>Propulsió: {data($i/propulsio/numero_de_motors_impulsio)} {data($i/propulsio/motors_impulsio)}<br/></span>
  
</td>
<td>
{
  let $d := $i/designacions
  for $x in $d/nom
  return <p>{data($x)}</p>
  
}

<p>(Nº de noms = {count($i/designacions/nom)})</p>
  
</td>
</tr>
}


</table>

</body>
</html>