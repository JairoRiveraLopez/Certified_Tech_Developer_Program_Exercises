# 1. Obtener el nombre y apellido de los primeros 5 actores disponibles. Utilizar
-- alias para mostrar los nombres de las columnas en español.

SELECT CONCAT(first_name, " ", last_name) AS "NombreCompleto" FROM actor
ORDER BY last_update
LIMIT 5; 

# 2. Obtener un listado que incluya nombre, apellido y correo electrónico de los
-- clientes (customers) inactivos. Utilizar alias para mostrar los nombres de las
-- columnas en español.

SELECT first_name AS Nombre, last_name AS Apellidos, email AS CorreoElectronico FROM customer
WHERE active = 0;

# 3. Obtener un listado de films incluyendo título, año y descripción de los films
-- que tienen un rental_duration mayor a cinco. Ordenar por rental_duration de
-- mayor a menor. Utilizar alias para mostrar los nombres de las columnas en
-- español.

SELECT title AS Titulo, release_year AS Año, description AS "Descripción" FROM film
WHERE rental_duration > 5
ORDER BY rental_duration DESC;

# 4. Obtener un listado de alquileres (rentals) que se hicieron durante el mes de
-- mayo de 2005, incluir en el resultado todas las columnas disponibles.

SELECT * FROM rental
WHERE MONTH(rental_date) = 5 AND YEAR(rental_date) = 2005;

# 5. Obtener la cantidad TOTAL de alquileres (rentals). Utilizar un alias para
-- mostrarlo en una columna llamada “cantidad”.

SELECT COUNT(rental_id) as TotalAlquileres FROM rental;

# 6. Obtener la suma TOTAL de todos los pagos (payments). Utilizar un alias para
-- mostrarlo en una columna llamada “total”, junto a una columna con la
-- cantidad de alquileres con el alias “Cantidad” y una columna que indique el
-- “Importe promedio” por alquiler.

SELECT SUM(amount) AS Total, COUNT(DISTINCT rental_id) AS Cantidad, AVG(amount) AS "Importe promedio" FROM payment;

# 7. Generar un reporte que responda la pregunta: ¿cuáles son los diez clientes
-- que más dinero gastan y en cuántos alquileres lo hacen?
SELECT CONCAT(first_name, " ", last_name) as NombreCliente, SUM(p.amount) AS TotalDineroInvertido, 
COUNT(r.rental_id) AS AlquileresTotales FROM customer AS c
INNER JOIN rental AS r ON c.customer_id = r.customer_id
INNER JOIN payment AS p ON r.rental_id = p.rental_id
GROUP BY NombreCliente;

# 8. Generar un reporte que indique: ID de cliente, cantidad de alquileres y monto
-- total para todos los clientes que hayan gastado más de 150 dólares en
-- alquileres.
SELECT c.customer_id AS IDCliente, SUM(p.amount) AS TotalDineroInvertido, 
COUNT(r.rental_id) AS AlquileresTotales FROM customer AS c
INNER JOIN rental AS r ON c.customer_id = r.customer_id
INNER JOIN payment AS p ON r.rental_id = p.rental_id
GROUP BY IDCliente
HAVING TotalDineroInvertido > 150
ORDER BY TotalDineroInvertido;

# 9. Generar un reporte que muestre por mes de alquiler (rental_date de tabla rental), 
-- la cantidad de alquileres y la suma total pagada (amount de tabla payment) 
-- para el año de alquiler 2005 (rental_date de tabla rental).

SELECT DATE_FORMAT(r.rental_date, '%M %Y') AS MesAlquiler, COUNT(r.rental_id) AS AlquileresTotales, 
SUM(p.amount) AS TotalDineroInvertido FROM rental r
INNER JOIN payment AS p ON r.rental_id = p.rental_id
GROUP BY MesAlquiler;

# 10. Generar un reporte que responda a la pregunta: ¿cuáles son los 5
-- inventarios más alquilados? (columna inventory_id en la tabla rental). Para
-- cada una de ellas indicar la cantidad de alquileres.
SELECT inventory_id, COUNT(rental_id) AS TotalAlquileres FROM rental
GROUP BY inventory_id
ORDER BY TotalAlquileres DESC
LIMIT 5;
