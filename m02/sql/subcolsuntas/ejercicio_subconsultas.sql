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
WHERE fabcod = 'aci' and exist > (SELECT exist 
                                  FROM producto 
                                  WHERE fabcod = 'aci' and prodcod = '41004');

--4. Obtener una lista de los representantes que trabajan en las oficinas que han logrado superar su objetivo de ventas.

SELECT * 
FROM repventa 
WHERE ofinum IN (SELECT ofinum 
                 FROM oficina 
                 WHERE objetivo > ventas);

--5. Obtener una lista de los representantes que no trabajan en las oficinas dirigidas por Larry Fitch.

SELECT * 
FROM repventa 
WHERE ofinum NOT IN (SELECT ofinum 
                     FROM oficina 
                     WHERE director = (SELECT repcod 
                                       FROM repventa 
                                       WHERE nombre = 'Larry Fitch'));

--6. Obtener una lista de todos los clientes que han solicitado pedidos del fabricante ACI entre enero y junio de 2003.



--7. Obtener una lista de los productos de los que se ha tomado un pedido de 150 euros ó mas.



--8. Obtener una lista de los clientes contactados por Sue Smith que no han solicitado pedidos con importes superiores a 18 euros.



--9. Obtener una lista de las oficinas en donde haya algún representante cuya cuota sea más del 55% del objetivo de la oficina.


--10. Obtener una lista de los representantes que han tomado algún pedido cuyo importe sea más del 10% de de su cuota.


--11. Obtener una lista de las oficinas en las cuales el total de ventas de sus representantes han alcanzado un importe de ventas que supera el 50% del objetivo de la oficina. Mostrar también el objetivo de cada oficina (suponed que el campo ventas de oficina no existe).


--12. Mostrar el nombre y ventas del representante/s contratado más recientemente.


--13.1 Mostrar el director de la oficina que vende más.


--13.2 Mostrar el director que vende más.


--14. Lista de representantes que nunca han realizado un pedido (el campo ventas no lo tengais en cuenta).


--15 Lista de productos que nunca han sido solicitados.


--16.1. Mostrar por cliente, su gasto en la empresa (funcion de grupo). Mostar nombre y el montante de la facturacion, ordenado de mejor a peor cliente (no subconsulta).


--16.2 Mostrar los 10 mejores clientes (no subconsulta).


--16.3 Clientes que gastan más de la media.


--17. Mostrar por cada oficina cuál és su representante estrella (el que vende más). Mostrar código de oficina, ciudad, Nombre del representan



--18. Clientes que nunca han hecho un pedido