for $i in doc("biblioteca.xml")/bib/libro
let $j := $i/titulo
let $x := $i/autor
return <result>Título: {data($j)}, Autor: {data($x/apellido), data($x/nombre)}</result>