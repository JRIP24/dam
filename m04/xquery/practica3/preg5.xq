for $i in doc("biblioteca.xml")/bib/libro
let $j := $i/@anyo
where $j > 1992 and $i/editorial = 'Addison-Wesley'
return $i