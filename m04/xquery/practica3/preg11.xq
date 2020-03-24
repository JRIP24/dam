<html>
<head>
</head>
<body>

<table border="1">
<tr align="left">
<th>Título</th>
<th>Editorial</th>
<th align="right">Precio</th>
</tr>

{for $i in doc("biblioteca.xml")/bib/libro
return <tr><td>{data($i/titulo)}</td><td>{data($i/editorial)}</td><td align="right" >{data($i/precio)}</td></tr>}

</table>

</body>
</html>