declare function local:maxim($num1 as xs:integer, $num2 as xs:integer?) as xs:integer?
{
  max(($num1, $num2))
};

for $i in doc("playstore.xml")/playstore/jocs/joc
let $j := $i/edat
return <mayor>Entre {data($j)} y 12: {(local:maxim($j,12))}</mayor>