for $i in doc("biblioteca.xml")/bib/libro
let $j := $i/precio
where $j = 65.95
return $i