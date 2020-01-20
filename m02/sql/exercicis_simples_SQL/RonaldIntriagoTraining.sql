--1. Obtener los códigos de los representantes que han tomado algún pedido (evitando su repetición).

SELECT DISTINCT repcod FROM pedido

--2. Obtener los datos de los pedidos realizados por el cliente cuyo código es el 2111.

SELECT * FROM pedido WHERE cliecod=2111;

--3. Obtener los datos de los productos cuyas existencias estén entre 25 y 40 unidades.

SELECT * FROM producto WHERE exist BETWEEN 25 AND 40;

--4. Obtener los datos de los pedidos realizados por el cliente cuyo código es el 2111 y que han sido tomados por el representante cuyo código es el 103.

SELECT * FROM pedido WHERE cliecod=2111 AND repcod=103;

--5. Obtener los datos de los pedidos realizados por el cliente cuyo código es el 2111, que han sido tomados por el representante cuyo código es el 103 y que solicitan artículos del fabricante cuyo código es ACI.

SELECT * FROM pedido WHERE cliecod=2111 AND repcod=103 AND fabcod='aci';

--6. Obtener una lista de todos los pedidos ordenados por cliente y, para cada cliente, ordenados por la fecha del pedido (ascendentemente)

SELECT * FROM pedido ORDER BY cliecod, fecha ASC;

--7. Obtener los datos de los representantes que pertenecen a la oficina de código 12 o 13 (cada representante solo pertenece a una oficina).

SELECT * FROM repventa WHERE oficina IN (13,12);

--8. Obtener los datos de productos de los que no hay existencias o bien éstas son desconocidas.

SELECT * FROM producto WHERE exist = 0 OR exist IS NULL;

--9. Mostrar los representantes que fueron contratados en el 2003



--10. Mostrar de los representantes el nombre y días que llevan contratados. Mostrad en una tercera columna los años que llevan contratados. Probad current_date.



--11.Mostrar el código de los representantes que son jefe (evitando repeticiones).



--12. Mostrar los nombres de los representantes que tienen jefe.



--13. Mostrar el nombre del jefe de los representantes (sólo hay un jefe por encima de todos).



--14. Mostrar la ciudad y región de las oficinas de la región OESTE.



--15. Mostrar los representantes que han vendido más de lo que tenían estipulado (su cuota). Mostrad el nombre,  ventas y cuota. Ordenad descendentemente por ventas y por nombre alfabéticamente.



--16. Mostrar para cada oficina su ciudad, region, ventas, objetivo, porcentaje de ventas sobre el objetivo. Ordena por porcentaje de ventas de mayor a menor.



--16 bis. Idem, pero si la cuota es desconocida, en el porcentaje ha de aparecer el siguiente texto: "Desconocido"



--17. Mostrad para cada representante su nombre, su puesto, sus ventas, su cuota y la diferencia de las ventas respecto su cuota (podrá ser positiva o negativa). Ordenad por este último campo.



--18. Mostrad los representantes que han alcanzado el 50% de su cuota. Por pantalla además aparecerá el 50% de la cuota.



--19. Mostrar los clientes cuyo nombre empieza por A.



--20. Mostrar los productos cuya descripción incluya la palabra articulo.



--21. Mostrad la descripción de los productos cuyo código de fabricante acabe con la letra I.



--22. Mostrar de los representantes su nombre y oficina donde trabajan. Si alguno de ellos no la tiene asignada, se ha de mostrar "Sin asignar".  Utilizar cásting explícito de tipos de datos con cast (campo as text). Su uso es el siguiente: con la función coalesce, en lugar de poner el campo que contiene valores nulos, se ha de poner literalmente cast (campo as text), sustituyendo campo por el correspondiente.



--23. Mostrad los pedidos que tienen importe que oscilan entre 1000 y 2000 que han sido tomandos por los siguientes representantes: 105, 106 y 108. Ordena por codigo de representante ascendentemente y por importe descendentemente.



--24. Mostrad los clientes que fueron contactados por primera vez por los representantes 101, 102 y 106 (haced el ejercicio de las dos maneras posibles).



--25. Mostrad el codigo de pedido, fecha, importe de los pedidos que fueron solicitados el año 1990 en los meses de enero, abril, julio y octubre (hacedlo de dos maneras posibles).



--26. Mostrar los directores de oficinas (evitando repeticiones).



--27. Mostrad los pedidos de todos los clientes excepto el 2117, 2118 y cuyo importe es inferior a 1000, tomados en el mes de febrero. Mostrad numero pedido, importe, cliente y mes en que se ha hecho el pedido. Hacedlo de dos maneras posibles.



--28. Muestra un listado de pedidos que han solicitado una cantidad de producto superior al 75% de su stock.

