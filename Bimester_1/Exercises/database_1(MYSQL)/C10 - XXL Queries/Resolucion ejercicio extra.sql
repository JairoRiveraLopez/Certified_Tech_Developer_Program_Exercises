# 1. Obtener los artistas que han actuado en una o más películas.
SELECT CONCAT(a.nombre, " ", a.apellido) AS NombreArtista, COUNT(ap.pelicula_id) AS CantidadPeliculas FROM artista AS a
INNER JOIN artista_x_pelicula AS ap ON a.id = ap.artista_id
GROUP BY NombreArtista;

# 2. Obtener las películas donde han participado más de un artista según nuestra base de datos.
SELECT p.titulo AS Titulo, COUNT(ap.artista_id) AS CantidadArtistas FROM pelicula p
INNER JOIN artista_x_pelicula AS ap ON p.id = ap.pelicula_id
GROUP BY Titulo
HAVING CantidadArtistas >= 2;

# 3. Obtener aquellos artistas que han actuado en alguna película, incluso
-- aquellos que aún no lo han hecho, según nuestra base de datos.
SELECT CONCAT(a.nombre, " ", a.apellido) AS NombreArtista, COUNT(ap.pelicula_id) AS CantidadPeliculas FROM artista AS a
LEFT JOIN artista_x_pelicula AS ap ON a.id = ap.artista_id
GROUP BY NombreArtista;

# 4. Obtener las películas que no se le han asignado artistas en nuestra base de datos.
SELECT titulo as Titulo FROM pelicula p
LEFT JOIN artista_x_pelicula AS ap ON p.id = ap.pelicula_id
WHERE ap.artista_id IS NULL;

# 5. Obtener aquellos artistas que no han actuado en alguna película, según
-- nuestra base de datos.
SELECT CONCAT(a.nombre, " ", a.apellido) AS NombreArtista, ap.pelicula_id as PeliculaActuacion FROM artista AS a
LEFT JOIN artista_x_pelicula AS ap ON a.id = ap.artista_id
WHERE ap.pelicula_id IS NULL;

# 6. Obtener aquellos artistas que han actuado en dos o más películas según
-- nuestra base de datos.
SELECT CONCAT(a.nombre, " ", a.apellido) AS NombreArtista, COUNT(ap.pelicula_id) AS CantidadPeliculas FROM artista AS a
INNER JOIN artista_x_pelicula AS ap ON a.id = ap.artista_id
GROUP BY NombreArtista
HAVING CantidadPeliculas >= 2;

# 7. Obtener aquellas películas que tengan asignado uno o más artistas, incluso 
-- aquellas que aún no le han asignado un artista en nuestra base de datos.
SELECT CONCAT(a.nombre, " ", a.apellido) AS NombreArtista, COUNT(ap.pelicula_id) AS CantidadPeliculas FROM artista AS a
LEFT JOIN artista_x_pelicula AS ap ON a.id = ap.artista_id
GROUP BY NombreArtista;



