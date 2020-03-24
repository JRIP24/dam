<html>
<head>
</head>
<body>

<h1>Libros de Stevens</h1>

<table border="1">
<tr >
<th>Título</th>
<th>Precio</th>
</tr>

{for $i in doc("biblioteca.xml")/bib/libro
where $i/autor/apellido = "Stevens"
return <tr><td>{data($i/titulo)}</td><td align="right" >{data($i/precio)}</td></tr>}

<tr align="right">
<th>Precio total</th>
{
  let $p := sum(doc("biblioteca.xml")/bib/libro[autor/apellido="Stevens"]/precio)
  
  return <td>{$p}</td>
}
</tr>
</table>

</body>
</html>