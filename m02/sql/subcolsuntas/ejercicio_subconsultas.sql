--0. Mostrar el nombre y el puesto de los que son jefe (ya está hecho con self join, ahora con subconsultas)

SELECT nombre, puesto 
FROM repventa 
WHERE repcod  IN (SELECT DISTINCT jefe 
                  FROM repventa);

--1. Obtener una lista de los representantes cuyas cuotas son iguales ó superiores al objetivo de la oficina de Atlanta.

SELECT * 
FROM repventa 
WHERE cuota >= (SELECT objetivo 
                FROM oficina 
                WHERE ciudad = 'Atlanta');

--2. Obtener una lista de todos los clientes (nombre) que fueron contactados por primera vez por Bill Adams.

SELECT nombre 
FROM cliente 
WHERE repcod = (SELECT repcod 
                FROM repventa 
                WHERE nombre = 'Bill Adams');

--3. Obtener una lista de todos los productos del fabricante ACI cuyas existencias superan a las existencias del producto 41004 del mismo fabricante.

SELECT * 
FROM producto 
WHERE upper(fabcod) = 'ACI' and exist > (SELECT exist 
                                  FROM producto 
                                  WHERE fabcod = 'aci' and prodcod = '41004');

--4. Obtener una lista de los representantes que trabajan en las oficinas que han logrado superar su objetivo de ventas.

SELECT * 
FROM repventa 
WHERE ofinum IN (SELECT ofinum 
                 FROM oficina 
                 WHERE ventas > objetivo);

--5. Obtener una lista de los representantes que no trabajan en las oficinas dirigidas por Larry Fitch.

SELECT * 
FROM repventa 
WHERE ofinum NOT IN (SELECT ofinum 
                     FROM oficina 
                     WHERE director = (SELECT repcod 
                                       FROM repventa 
                                       WHERE nombre = 'Larry Fitch'));

--6. Obtener una lista de todos los clientes que han solicitado pedidos del fabricante ACI entre enero y junio de 2003.

SELECT * 
FROM cliente 
WHERE cliecod IN (SELECT cliecod 
                  FROM pedido 
                  WHERE fabcod = 'aci' AND fecha BETWEEN '2003-01-01' AND '2003-06-30');

--7. Obtener una lista de los productos de los que se ha tomado un pedido de 150 euros ó mas.

SELECT * 
FROM producto 
WHERE prodcod IN (SELECT prodcod 
                  FROM pedido 
                  WHERE importe >= 150);

--8. Obtener una lista de los clientes contactados por Sue Smith que no han solicitado pedidos con importes superiores a 18 euros.

SELECT * 
FROM cliente 
WHERE repcod = (SELECT repcod 
                FROM repventa 
                WHERE nombre = 'Sue Smith') 
      AND cliecod NOT IN (SELECT cliecod 
                          FROM pedido 
                          WHERE importe > 18);


--9. Obtener una lista de las oficinas en donde haya algún representante cuya cuota sea más del 55% del objetivo de la oficina.

SELECT * 
FROM oficina as of1 
WHERE ofinum IN (SELECT ofinum 
                 FROM repventa 
                 WHERE cuota > ((of1.objetivo * 55) / 100));

--10. Obtener una lista de los representantes que han tomado algún pedido cuyo importe sea más del 10% de de su cuota.

 SELECT * 
 FROM repventa as rep 
 WHERE repcod IN (SELECT repcod 
                  FROM pedido 
                  WHERE importe > ((rep.cuota * 10)/100));

--11. Obtener una lista de las oficinas en las cuales el total de ventas de sus representantes han alcanzado un importe de ventas que supera el 50% del objetivo de la oficina. Mostrar también el objetivo de cada oficina (suponed que el campo ventas de oficina no existe).

SELECT * 
FROM oficina as of
WHERE ofinum IN (SELECT ofinum 
                 FROM repventa 
                 WHERE ((of.objetivo * 50) / 100) < (SELECT SUM(ventas) 
                                                     FROM repventa ));


--12. Mostrar el nombre y ventas del representante/s contratado más recientemente.

SELECT nombre, ventas
FROM repventa 
WHERE fcontrato = (SELECT MAX(fcontrato) 
                   FROM repventa);

--13.1 Mostrar el director de la oficina que vende más.

SELECT * 
FROM repventa 
WHERE repcod = (SELECT director 
                FROM oficina 
                WHERE ventas = (SELECT MAX(ventas) 
                                FROM oficina));

--13.2 Mostrar el director que vende más.

SELECT * 
FROM repventa 
WHERE repcod = (SELECT repcod 
                FROM repventa 
                WHERE ventas = (SELECT MAX(ventas) 
                                FROM repventa));

--14. Lista de representantes que nunca han realizado un pedido (el campo ventas no lo tengais en cuenta).

SELECT * 
FROM repventa 
WHERE repcod NOT IN (SELECT repcod 
                      FROM pedido);

--15 Lista de productos que nunca han sido solicitados.

SELECT * 
FROM producto 
WHERE prodcod NOT IN (SELECT prodcod 
                      FROM pedido);

--16.1. Mostrar por cliente, su gasto en la empresa (funcion de grupo). Mostar nombre y el montante de la facturacion, ordenado de mejor a peor cliente (no subconsulta).



--16.2 Mostrar los 10 mejores clientes (no subconsulta).



--16.3 Clientes que gastan más de la media.


--17. Mostrar por cada oficina cuál és su representante estrella (el que vende más). Mostrar código de oficina, ciudad, Nombre del representan


--Agrupar primero por oficinas
--SELECT of.ofinum, ciudad, (SELECT nombre FROM repventa WHERE ventas = (SELECT MAX(ventas) FROM repventa) AND ofinum = of.ofinum)
--FROM oficina as of;

--18. Clientes que nunca han hecho un pedido

SELECT * 
FROM cliente 
WHERE cliecod NOT IN (SELECT cliecod 
                      FROM pedido);
