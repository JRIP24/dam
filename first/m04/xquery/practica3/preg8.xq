for $i in distinct-values(doc("biblioteca.xml")/bib/libro/autor/apellido)
return $i