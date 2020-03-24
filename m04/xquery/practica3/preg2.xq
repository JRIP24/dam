for $i in doc("biblioteca.xml")/bib/libro
let $j := $i/@anyo
order by $j
return ($i/titulo, <any>{data($j)}</any>)