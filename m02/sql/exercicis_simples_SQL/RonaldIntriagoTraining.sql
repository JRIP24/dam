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

SELECT * FROM repventa WHERE ofinum IN (13,12);

--8. Obtener los datos de productos de los que no hay existencias o bien éstas son desconocidas.

SELECT * FROM producto WHERE exist = 0 OR exist IS NULL;

--9. Mostrar los representantes que fueron contratados en el 2003

SELECT * FROM repventa WHERE DATE_PART('year',fcontrato) = '2003';

--10. Mostrar de los representantes el nombre y días que llevan contratados. Mostrad en una tercera columna los años que llevan contratados. Probad current_date.

SELECT nombre, (CURRENT_DATE - fcontrato) AS "dias contratado", (CURRENT_DATE - fcontrato) / 365  AS "años contratado" FROM   repventa;

--11.Mostrar el código de los representantes que son jefe (evitando repeticiones).

SELECT DISTINCT repcod FROM repventa WHERE puesto IN('VP Ventas','Dir Ventas');

--12. Mostrar los nombres de los representantes que tienen jefe.

SELECT * FROM repventa WHERE jefe IS NOT NULL;

--13. Mostrar el nombre del jefe de los representantes (sólo hay un jefe por encima de todos).

SELECT nombre FROM repventa WHERE jefe IS NULL;

--14. Mostrar la ciudad y región de las oficinas de la región OESTE.

SELECT * FROM oficina WHERE region='Oeste';

--15. Mostrar los representantes que han vendido más de lo que tenían estipulado (su cuota). Mostrad el nombre,  ventas y cuota. Ordenad descendentemente por ventas y por nombre alfabéticamente.

SELECT nombre, ventas, cuota FROM repventa WHERE ventas > cuota ORDER BY ventas, nombre;

--16. Mostrar para cada oficina su ciudad, region, ventas, objetivo, porcentaje de ventas sobre el objetivo. Ordena por porcentaje de ventas de mayor a menor.

SELECT ciudad, region, ventas, objetivo, (round((((objetivo - ventas) / objetivo)*100),2) || '%') as porcentaje FROM oficina ORDER BY porcentaje DESC;


--16 bis. Idem, pero si la cuota es desconocida, en el porcentaje ha de aparecer el siguiente texto: "Desconocido"

SELECT nombre, ventas, COALESCE(cuota::text, 'Desconocido') as cuota FROM repventa;

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

