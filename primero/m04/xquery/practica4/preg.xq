<html>
<head>
  <link href="estil_SOLUCIO.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<table border="0" align="center">
{
  let $t := doc("submaris.xml")/submarinos/titulo
  
  return <tr><th><h1>{data($t)}</h1></th></tr>
}
{
  let $l := doc("submaris.xml")/submarinos/logo
  return <tr><td><img id="esquinarImage" align="center" src="banderes/{data($l)}"/></td></tr>
}

</table>

<table id="t01" border="1" align="center">
<tr >
<th class="normal" align="center">Nom</th>
<th class="normal" align="center" width="410">Propulsió</th>
<th class="normal" align="center" width="220">Torpedes</th>
<th class="normal" align="center" width="250">Missils</th>
</tr>

{
for $i in doc("submaris.xml")/submarinos/submarino

return <tr><td><img width="256" src="imatges/{data($i/imatges/foto)}"/><br/><a align="center" href="{data($i/pag_web)}">{data($i/nombre)}</a></td><td>{data($i/caracteristicas_generales/propulsion)} de {data($i/caracteristicas_generales/potencia_watios)} ({data($i/caracteristicas_generales/potencia_caballos)})</td><td align="right">{
  
  let $a := $i/armamento/armas
  for $x in $a /torpedos/torpedo_identificador
  return <span>{data($x/nombre/@cantidad)} del tipus {data($x/nombre)} <br/></span>}
  
</td><td align="right">
{
  let $a := $i/armamento/armas
  for $x in $a /misiles/misil_identificador
  return <span>{data($x/nombre/@cantidad)} del tipus {data($x/nombre)} <br/></span>}
  
</td></tr>
}

{
  let $j := sum(doc("submaris.xml")//unidades_planeadas)
  let $p := sum(doc("submaris.xml")//unidades_construidas)
  
  return <tr><td colspan="2"><b>Unitats totals plantejades: </b>{$j}</td><td colspan="2" align="right"><b>Unitats totals construides: </b>{$p}</td></tr>
  
  
}



</table>

</body>
</html>