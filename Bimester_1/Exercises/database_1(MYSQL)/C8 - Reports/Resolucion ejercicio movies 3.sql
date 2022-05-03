# 1. ¿Cuántas películas hay?
SELECT COUNT(*) as totalPeliculas FROM movies;

# 2. ¿Cuántas películas tienen entre 3 y 7 premios?
SELECT COUNT(*) as conteoPeliculas FROM movies
WHERE awards BETWEEN 3 AND 7;

# 3. ¿Cuántas películas tienen entre 3 y 7 premios y un rating mayor a 7?
SELECT COUNT(*) as conteoPeliculas FROM movies
WHERE awards BETWEEN 3 AND 7
AND rating > 7;

# 4. Crear un listado a partir de la tabla de películas, mostrar un reporte de la cantidad de películas por id. de género.
SELECT genre_id, COUNT(*) FROM movies
GROUP BY genre_id;

# 5. De la consulta anterior, listar sólo aquellos géneros que tengan como suma de premios un número mayor a 5.
SELECT genre_id, COUNT(*) FROM movies
WHERE awards > 5
GROUP BY genre_id;

