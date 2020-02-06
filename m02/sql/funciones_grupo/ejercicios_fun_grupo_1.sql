
-- 4.1- Quina és la quota promig mostrada com a "prom_cuota" i la venda promig mostrades com a "prom_ventas" dels venedors?

SELECT ROUND(AVG(cuota), 2) as prom_cuota, ROUND(AVG(ventas), 2) as prom_ventas FROM repventa;

-- 4.2- Quin és el rendiment de quota promig dels venedors (percentatge de les vendes respecte la quota)?

SELECT (ROUND(((AVG(ventas) / AVG(cuota)) * 100),2) || '%') as rendimiento_promedio FROM repventa;

-- 4.3- Quines són les quotes totals com a "t_cuota" i vendes totals com a "t_ventas" de tots els venedors?

SELECT SUM(cuota) as t_cuota, SUM(ventas) as t_ventas FROM repventa;

-- 4.4- Calcula el preu mig dels productes del fabricant amb identificador "aci".

SELECT ROUND(AVG(precio), 2) as precio_medio FROM producto WHERE fabcod='aci';

-- 4.5- Quines són les quotes assignades mínima i màxima?

SELECT MIN(cuota) as cuota_minima, MAX(cuota) as cuota_máxima FROM repventa;

-- 4.6- Quina és la data de comanda més antiga?

SELECT MIN(fecha) FROM pedido;

-- 4.8- Quants clients hi ha?

SELECT COUNT(cliecod) FROM cliente;

-- 4.9- Quants venedors superen la seva quota?

SELECT COUNT(repcod) FROM repventa WHERE ventas > cuota;

-- 4.10- Quantes comandes amb un import superior a 25000 hi ha en els registres?

SELECT COUNT(pednum) FROM pedido WHERE importe > 25000;




-- 4.12- Trobar l'import mitjà de les comandes, l'import total de les comandes, l'import mitjà de les comandes com a percentatge del límit de crèdit del client i l'import mitjà de comandes com a percentatge de la quota del venedor.

-- 4.13- Compta les files que hi ha a repventas, les files del camp vendes i les del camp quota.

-- 4.14- Mostra que la suma de restar (vendes menys quota) és diferent que sumar vendes i restar-li la suma de quotes.

-- 4.15- Quants títols diferents tenen els venedors?

-- 4.16- Quantes oficines de vendes tenen venedors que superen les seves quotes?

-- 4.17- De la taula clients quants clients diferents i venedors diferents hi ha.

-- 4.19- Calcular la mitjana dels imports de les comandes.

--(GROUP BY)

-- 4.21- Quina és l'import promig de les comandes de cada venedor?

SELECT repcod, ROUND(AVG(importe), 2) as importe from pedido GROUP BY repcod;

-- 4.22- Quin és el rang (màxim i mínim) de quotes dels venedors per cada oficina?



-- 4.23- Quants venedors estan asignats a cada oficina?





-- 4.24- Per cada venedor calcular quants clients diferents ha atès (ha fet comandes)?

-- 4.25- Calcula el total dels imports de les comandes fetes per cada client a cada vendedor.

-- 4.26- El mateix que a la qüestió anterior, però ordenat per client i dintre de client per venedor.

-- 4.27- Calcula les comandes totals per a cada venedor. Mostra també el nom del venedor.

--(HAVING)

-- 4.28- Quin és l'import promig de les comandes per cada venedor que les seves comandes sumen més de 30000? Mostreu el codi del venedor i el promig de les comandes.

-- 4.29- Per cada oficina amb dos o més empleats, calcular la quota total i les vendes totals per a tots els venedors que treballen a la oficina (volem que mostrar la ciutat de l'oficina a la consulta)

-- 4.30- Mostra el preu, les existències i la quantitat total de les comandes de cada producte per als quals la quantitat total demanada està per sobre del 75% de les existències.

-- 4.31- Es desitja un llistat d'identificadors de fabricants de productes. Només volem tenir en compte els productes de preu superior a 54. Només volem que apareguin els fabricants amb un nombre total d'unitats superior a 300.

-- 4.32- Es desitja un llistat dels productes amb les seves descripcions, ordenat per la suma total d'imports facturats (pedidos) de cada producte de l'any 1989.

-- 4.33- Per a cada director (de personal, no d'oficina) excepte per al gerent (el venedor que no té director), vull saber el total de vendes dels seus subordinats. Mostreu codi i nom dels directors.

-- 4.34- Quins són els 5 productes que han estat venuts a més clients diferents? Mostreu el número de clients per cada producte. A igualtat de nombre de clients es volen ordenats per ordre decreixent d'existències i, a igualtat d'existències, per descripció. Mostreu tots els camps pels quals s'ordena.

-- 4.35- Es vol llistar el clients (codi i empresa) tals que no hagin comprat cap tipus de frontissa ("bisagra" en castellà, figura a la descripció) i hagin comprat articles de més d'un fabricant diferent.

-- 4.36- Llisteu les oficines per ordre descendent de nombre total de clients diferents amb comandes (pedidos) realizades pels venedors d'aquella oficina, i, a igualtat de clients, ordenat per ordre ascendent del nom del director de l'oficina. Només s'ha de mostrar el codi i la ciutat de l'oficina.