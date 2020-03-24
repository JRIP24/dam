for $i in doc("biblioteca.xml")/bib/libro
let $j := count($i/autor)
where $j > 2
return $i