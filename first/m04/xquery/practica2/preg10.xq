declare function local:despeses($num1 as xs:double) as xs:double?
{
  let $taxa := 3
  let $iva := $num1 * 0.08
  return $iva + $taxa
};

declare function local:suma($num1 as xs:double, $num2 as xs:double) as xs:double?
{
  $num1 + $num2
};

for $i in doc("playstore.xml")/playstore/jocs/joc
let $j := (local:despeses($i/preu))
return <paquet>{ $i/nom, $i/preu,<despeses>{$j}</despeses>, <total>{local:suma($j, $i/preu)}</total>}</paquet>