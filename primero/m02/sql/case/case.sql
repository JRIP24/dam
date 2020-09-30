-- CASE. Sentència condicional
--------------------

-- SINTAXI:
--CASE WHEN condition THEN result
--     [WHEN ...]
--     [ELSE result]
--END

-- EXEMPLE 0
--SELECT a,
--       CASE WHEN a=1 THEN 'one'
--            WHEN a=2 THEN 'two'
--            ELSE 'other'
--       END
--    FROM test;

-- EXERCICI 1 
-- Mostreu codi, nom i lloc de treball de cada representant de vendes.
-- Però mostreu el lloc de treball en català i amb l'etiqueta "Lloc"

SELECT repcod, nombre,
                    CASE WHEN puesto = 'Representante Ventas' THEN 'Representant Vendes'
                         WHEN puesto = 'VP Ventas' THEN 'VP Vendes' 
                         WHEN puesto = 'Dir Ventas' THEN 'Dir Vendes' 
                    END as Lloc 
FROM repventa;

-- EXERCICI 2
-- Mostreu en una fila quants empleats hi ha per cada lloc de treball. Ha de quedar així:
-- Representants | Vicepresidents | Directors 
-- --------------+----------------+-----------
--             7 |              1 |         2

-- Nota, s'ha de fer en 2 passos. Aquesta taula solució és la taula resum d'una taula 
-- que haureu de crear prèviament amb una subconsulta;
-- A la subconsulta, farem servir un CASE per crear cada columna

