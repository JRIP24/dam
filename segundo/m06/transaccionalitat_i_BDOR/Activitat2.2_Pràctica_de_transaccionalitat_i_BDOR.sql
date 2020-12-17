--Creación de tabla resum_facturació (no es parte del ejercicio)

CREATE TABLE resum_facturacio(
    mes INT,
    any INT,
    dni_client INT (8),
    quantitat DOUBLE(40, 2),
    FOREIGN KEY (dni_client) REFERENCES client(dni)

);

--Exercici 1

DROP PROCEDURE IF EXISTS crea_resum_facturacio();

DELIMITER //
CREATE PROCEDURE crea_resum_facturacio(p_mes INT, p_any INT)
BEGIN
DECLARE v_dni INT;
DECLARE v_total_facturacion DOUBLE(40,2);
DECLARE acaba INT DEFAULT FALSE; 

DECLARE c_comanda CURSOR FOR SELECT SUM(preu_total), dni_client FROM comanda WHERE YEAR(data) = p_any AND MONTH(data) = p_mes GROUP BY dni_client;
--Saber el precio total de compra de un cliente en una mes y año concretos:
--select SUM(preu_total) from comanda WHERE YEAR(data) = 2020 AND MONTH(data) = 08 GROUP BY dni_client;

DECLARE CONTINUE HANDLER FOR NOT FOUND SET acaba = TRUE; 

OPEN c_comanda; 
read_loop: LOOP
    
    FETCH c_comanda INTO v_total_facturacion, v_dni;

    INSERT INTO resum_facturacio (mes, any, dni_client, quantitat ) 
    VALUES (p_mes, p_any, v_dni, v_total_facturacion);

END LOOP;
CLOSE c_comanda;

END;

//

CALL crea_resum_facturacio();