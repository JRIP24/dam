for $i in doc("biblioteca.xml")/bib/libro
let $j := $i/@anyo
where $j < 2000
return $i