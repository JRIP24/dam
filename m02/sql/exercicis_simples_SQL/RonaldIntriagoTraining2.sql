--1. Mostrar la fecha de los pedidos con la descripción, cantidad, precio e importe de los artículos de dichos pedidos añadiendo además  el nombre del representante que tomó el pedido para los pedidos cuyo importe del pedido sea superior a 25.000.

SELECT pe.fecha, pr.descrip, pe.cant, pr.precio, pe.importe, re.nombre FROM pedido as pe JOIN producto as pr ON pe.prodcod = pr.prodcod JOIN repventa as re ON re.repcod = pe.repcod WHERE pe.importe > 25000;

--2. Mostrar un listado de los representantes con su jefe, es decir,  código y nombre de representante y lo mismo para su jefe.

SELECT rep1.repcod, rep1.nombre as representante, rep2. repcod, rep2.nombre as director FROM repventa as rep1 JOIN repventa as rep2 ON rep1.jefe = rep2.repcod;

--3. Mostrar todos los representantes (incluyendo los que no tienen asignada una oficina). Nombre del representante, puesto, ventas, código de oficina y ciudad.



--4. Como la 2 pero mostrando todos los representantes.



--5. Obtener una lista de los pedidos con importes superiores a 150 euros, mostrando el código del pedido, el importe, el nombre del cliente que lo solicitó, el nombre del representante que contactó con él por primera vez y la ciudad de la oficina donde el representante trabaja.



--6. Lista los pedidos tomados durante el mes de octubre del año 1989 (any modificat perquè surti algun resultat) , mostrando solamente el número del pedido, su importe, el nombre del cliente que lo realizó, la fecha y la descripción del producto solicitado.



--7. Obtener una lista de todos los pedidos tomados por representantes de oficinas de la región Este, mostrando solamente el número del pedido, la descripción del producto, nombre del representante que lo tomó y la región de su oficina. (Afegeixo al select el camp region perquè es vegi be i ordeno per representant).

SELECT pednum, descrip, nombre, region FROM pedido as pe JOIN producto as pr ON pr.prodcod = pe.prodcod JOIN repventa as re ON re.repcod = pe.repcod JOIN oficina as of ON of.ofinum = re.ofinum WHERE region = 'Este' ORDER BY nombre;

--8. Obtener una lista con parejas de representantes y oficinas en donde la cuota del representante es mayor o igual que el objetivo de la oficina, sea o no la oficina en la que trabaja. Mostrar Nombre del representante, cuota del mismo, Ciudad de la oficina, objetivo de la misma.

SELECT nombre, cuota, ciudad, objetivo FROM repventa as re JOIN oficina as of ON of.ofinum = re.ofinum WHERE cuota > objetivo;

--9. Muestra el nombre, las ventas y la ciudad de la oficina de cada representante de la empresa (cal tenir en compte que hi ha algun representant que no té oficina)

SELECT nombre, re.ventas, ciudad FROM repventa as re LEFT JOIN oficina as of ON of.ofinum = re.ofinum;

--10. Obtener una lista de la descripción de los productos para los que existe algún pedido en el que se solicita una cantidad mayor a las existencias de dicho producto.

SELECT descrip FROM pedido as pe LEFT JOIN producto as pr ON pr.prodcod = pe.prodcod WHERE cant > exist;

--11. Lista los nombres de los representantes que tienen una cuota superior a la de su director de oficina. (Mostrar nombre representante, cuota, nombre director y cuota del mismo)

SELECT rep1.nombre as representante, rep1.cuota, rep2.nombre as director, rep2.cuota FROM repventa as rep1 JOIN repventa as rep2 ON rep1.jefe = rep2.repcod WHERE rep1.cuota > rep2.cuota;

--12. Obtener una lista de los representantes que trabajan en una oficina distinta de la oficina en la que trabaja su JEFE (enunciat modificat perquè sigui algo diferent a l’anterior), mostrando también el nombre del director y el código de la oficina donde trabaja cada uno de ellos.

SELECT rep1.nombre as representante, rep1.ofinum, rep2.nombre as director, rep2.ofinum FROM repventa as rep1 JOIN repventa as rep2 ON rep1.jefe = rep2.repcod WHERE rep1.ofinum != rep2.ofinum;

--13. El mismo ejercicio anterior, mostrando en lugar de códigos de oficinas, ciudad del representante y su jefe (exercici avançat).

SELECT rep1.nombre as representante, of.ciudad, rep2.nombre as director, of2.ciudad FROM repventa as rep1 JOIN repventa as rep2 ON rep1.jefe = rep2.repcod JOIN oficina as of ON of.ofinum = rep1.ofinum JOIN oficina as of2 ON of2.ofinum = rep2.ofinum WHERE rep1.ofinum != rep2.ofinum;

--14. Mostrar todos los datos de los representantes que son jefe (evitando repeticiones).

SELECT DISTINCT rep2.* FROM repventa as rep1 JOIN repventa as rep2 ON rep1.jefe = rep2.repcod;

--15. Obtener los pedidos tomados en los mismos días en que un nuevo representante fue contratado. Mostrar número de pedido, importe, fecha pedido (y fecha de contrato)


