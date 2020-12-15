--Creación de tabla resum_facturació (no es parte del ejercicio)

CREATE TABLE resum_facturacio(
    mes INT,
    any INT,
    dni_client INT (8),
    quantitat DOUBLE(40, 2),
    FOREIGN KEY (dni_client) REFERENCES client(dni)

);

--Exercici 1

DROP PROCEDURE IF EXISTS crea_resum_facturacio(p_mes, p_any DATE);
DELIMITER //

DECLARE c_comanda CURSOR FOR SELECT SUM(preu_total), dni_client FROM comanda WHERE YEAR(data) = p_any AND MONTH(data) = p_mes GROUP BY dni_client;
--Saber el precio total de compra de un cliente en una mes y año concretos:
--select SUM(preu_total) from comanda WHERE YEAR(data) = 2020 AND MONTH(data) = 08 GROUP BY dni_client;

OPEN c_comanda; 
read_loop: LOOP 
    FETCH c_comanda INTO v_dni, v_data_naixement;
    IF acaba THEN
        LEAVE read_loop;
    END IF;
    IF v_data_naixement > CURRENT_DATE() - INTERVAL 18 YEAR THEN
        SET v_menor = 'S';
    ELSE
        SET v_menor = 'N';
    END IF;
    UPDATE persona SET menor = v_menor WHERE dni = v_dni;
END LOOP;
CLOSE c_comanda;

DELIMITER ;