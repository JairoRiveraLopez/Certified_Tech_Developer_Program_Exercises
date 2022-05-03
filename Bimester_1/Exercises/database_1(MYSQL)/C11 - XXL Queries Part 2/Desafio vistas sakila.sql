#1. a) Crear una vista denominada “vista_mostrar_pais” que devuelva un reporte de los países.
-- b) Invocar la vista creada

#a
CREATE VIEW vista_mostrar_pais AS
SELECT * FROM country;

#b
SELECT * FROM vista_mostrar_pais;

# 2. a) Crear una vista que devuelva un resumen con el apellido y nombre (en una sola columna denominada “artista”) de los artistas 
-- y la cantidad de filmaciones que tienen. Traer solo aquellos que tengan más de 25 filmaciones y ordenarlos por apellido.
-- b) Invocar la vista creada.
-- c) En la misma invocación de la vista, traer aquellos artistas que tienen menos de 33 filmaciones.
-- d) Con la misma sentencia anterior, ahora, mostrar el apellido y nombre de los artistas en minúsculas y traer solo aquellos 
-- artistas cuyo apellido comience con la letra "a".
-- e) Eliminar la vista creada.

#a
CREATE VIEW consulta_artistas AS
SELECT CONCAT(a.last_name, " ", a.first_name) AS Artista, COUNT(f.film_id) AS CantidadFilmaciones FROM actor a
INNER JOIN film_actor AS f ON f.actor_id = a.actor_id
GROUP BY Artista
HAVING CantidadFilmaciones > 25
ORDER BY Artista;

#b
SELECT * FROM consulta_artistas;

#c
SELECT * FROM consulta_artistas
WHERE CantidadFilmaciones > 33;

#d
SELECT LOWER(artista) as Artista, CantidadFilmaciones FROM consulta_artistas
WHERE CantidadFilmaciones > 33
AND Artista LIKE "a%";

#e
DROP VIEW consulta_artistas;

# 3. a) Crear una vista que devuelva un reporte del título de la película, el apellido y nombre (en una sola columna denominada 
-- “artista”) de los artistas y el costo de reemplazo. Traer solo aquellas películas donde su costo de reemplazo es entre 
-- 15 y 27 dólares, ordenarlos por costo de reemplazo.
-- b) Invocar la vista creada.
-- c) En la misma invocación de la vista, traer aquellas películas que comienzan con la letra "b".
-- d) Modificar la vista creada agregando una condición que traiga los artistas cuyo nombre termine con la letra "a" y ordenarlos 
-- por mayor costo de reemplazo.
-- e) Invocar la vista creada.

#a
CREATE VIEW consulta_artistas2 AS
SELECT CONCAT(a.last_name, " ", a.first_name) AS Artista, f.title AS TituloPelicula, f.replacement_cost AS CostoRemplazo
FROM actor a
INNER JOIN film_actor AS fa ON fa.actor_id = a.actor_id
INNER JOIN film AS f ON f.film_id = fa.film_id
WHERE f.replacement_cost BETWEEN 15 AND 27;

#b
SELECT * FROM consulta_artistas2;

#c
SELECT * FROM consulta_artistas2
WHERE Artista LIKE "b%";

#d
ALTER VIEW consulta_artistas2 AS
SELECT CONCAT(a.last_name, " ", a.first_name) AS Artista, f.title AS TituloPelicula, f.replacement_cost AS CostoRemplazo
FROM actor a
INNER JOIN film_actor AS fa ON fa.actor_id = a.actor_id
INNER JOIN film AS f ON f.film_id = fa.film_id
WHERE f.replacement_cost BETWEEN 15 AND 27
AND CONCAT(a.last_name, " ", a.first_name) LIKE "%a"
ORDER BY CostoRemplazo;

#e
SELECT * FROM consulta_artistas2;