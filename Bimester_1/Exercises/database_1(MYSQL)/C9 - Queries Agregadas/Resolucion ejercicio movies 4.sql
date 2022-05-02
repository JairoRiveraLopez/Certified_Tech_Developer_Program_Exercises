# 1. Utilizando la base de datos de movies, queremos conocer, por un lado, los
-- títulos y el nombre del género de todas las series de la base de datos.

SELECT title, name
FROM series
LEFT JOIN genres ON genre_id = genres.id;

# 2. Por otro, necesitamos listar los títulos de los episodios junto con el nombre y
-- apellido de los actores que trabajan en cada uno de ellos.

SELECT title AS "Titulo", CONCAT(first_name, " ", last_name) AS "Nombre Actor / Actriz"
FROM actors
INNER JOIN actor_episode ON actor_id = actors.id
INNER JOIN episodes ON episodes.id = episode_id;

# 3. Para nuestro próximo desafío, necesitamos obtener a todos los actores o
-- actrices (mostrar nombre y apellido) que han trabajado en cualquier película
-- de la saga de La Guerra de las galaxias

SELECT title AS "Titulo", CONCAT(first_name, " ", last_name) AS "Nombre Actor / Actriz"
FROM actors
INNER JOIN actor_movie ON actor_id = actors.id
INNER JOIN movies ON movies.id = movie_id
WHERE title like "La Guerra de las galaxias%";

# 4. Crear un listado a partir de la tabla de películas, mostrar un reporte de la
-- cantidad de películas por nombre de género.

SELECT name AS NombreGenero, COUNT(movies.id) AS CantidadPeliculas
FROM genres
INNER JOIN movies ON genre_id = genres.id
GROUP BY NombreGenero;
