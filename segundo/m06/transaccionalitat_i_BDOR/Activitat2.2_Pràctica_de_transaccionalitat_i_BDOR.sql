--Creación de tabla resum_facturació (no es parte del ejercicio)

CREATE TABLE resum_facturacio(
    mes INT,
    any INT,
    dni_client INT (8),
    quantitat DOUBLE(40, 2),
    FOREIGN KEY (dni_client) REFERENCES client(dni)

);

--Exercici 1

DROP PROCEDURE IF EXISTS crea_resum_facturacio(p_fecha DATE);
DELIMITER //

DECLARE c_comanda CURSOR FOR SELECT data FROM comanda GROUP BY dni_client;
--DECLARE c_comanda CURSOR FOR SELECT SUM(preu_total), dni_client FROM comanda GROUP BY dni_client
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