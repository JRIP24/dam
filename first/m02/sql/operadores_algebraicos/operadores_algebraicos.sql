--1. Obtener una lista de todos los     productos cuyo precio exceda de 3500 y de los cuales hay algún pedido con un importe superior a 35000.

SELECT * 
FROM producto 
WHERE precio > 3500
INTERSECT
SELECT *
FROM producto 
WHERE prodcod = (SELECT prodcod 
                 FROM pedido 
                 WHERE importe > 35000);

--2. Obtener una lista de todos los productos cuyo precio más IVA exceda de 3.500 o bien haya algún pedido cuyo importe más IVA exceda de 30.000.

SELECT * 
FROM producto
WHERE (precio + (precio * 0.21)) > 3500
UNION
SELECT *
FROM producto 
WHERE prodcod IN (SELECT prodcod 
                 FROM pedido 
                 WHERE (importe + (importe * 0.21)) > 30000);

--3. Obtener los códigos de los representantes que son directores de oficina y que no han tomado ningún pedido.

--EXCEPT

SELECT director
FROM oficina
EXCEPT
SELECT repcod
FROM pedido;