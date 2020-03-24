for $i in doc("biblioteca.xml")/bib/libro
let $j := $i/titulo
let $x := count($i/autor)
return <llibre>Título: {data($j)}, Num. autores: {data($x)}</llibre>