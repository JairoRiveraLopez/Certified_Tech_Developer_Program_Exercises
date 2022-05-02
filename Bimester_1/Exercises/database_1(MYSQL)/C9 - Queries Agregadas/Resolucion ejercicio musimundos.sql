-- G3 C15S Introducción a base de datos

-- 1. Listar las canciones cuya duración sea mayor a 2 minutos.
Select Nombre, (milisegundos / 60000) DuracionMinutos from canciones
having DuracionMinutos  > 2;

-- 2 Listar las canciones cuyo nombre comience con una vocal.
Select nombre from canciones
where nombre REGEXP "^[aeiou].*";

-- 3 Listar las canciones ordenadas por compositor en forma descendente. Luego, por nombre en forma ascendente. Incluir únicamente aquellas canciones que tengan compositor
SELECT * FROM canciones WHERE compositor IS NOT NULL ORDER BY nombre ASC;

-- 4 (a) Listar la cantidad de canciones de cada compositor.
-- 4 (b) Modificar la consulta para incluir únicamente los compositores que tengan más de 10 canciones.
select count(id) cantidad_canciones, compositor  from canciones 
where compositor !="" 
group by compositor ;

-- 5.A Listar el total facturado agrupado por ciudad
select ciudad_de_facturacion Ciudad, sum(total) TotalFacturasPorCiudad from facturas
group by ciudad_de_facturacion
order by TotalFacturasPorCiudad;

-- 5.B Modificar el listado del punto (a) mostrando únicamente las ciudades de Canadá.
select ciudad_de_facturacion Ciudad, sum(total) TotalFacturasPorCiudad from facturas
where pais_de_facturacion like "Canada"
group by ciudad_de_facturacion
order by TotalFacturasPorCiudad;

-- 5.C Modificar el listado del punto (a) mostrando únicamente las ciudades con una facturación mayor a 38.
select ciudad_de_facturacion Ciudad, sum(total) TotalFacturasPorCiudad from facturas
group by ciudad_de_facturacion
having TotalFacturasPorCiudad > 38
order by TotalFacturasPorCiudad;

-- 5.D d) Modificar el listado del punto (a) agrupando la facturación por país, y luego por ciudad.
select pais_de_facturacion Pais, ciudad_de_facturacion Ciudad, sum(total) TotalFacturasPorCiudad from facturas
group by Pais, Ciudad
order by Pais;

-- 6.A Listar la duración mínima, máxima y promedio de las canciones.
select min(milisegundos/60000) minima_duracion, max(milisegundos/60000) maxima_duracion,avg(milisegundos/60000) promedio from canciones;
-- 6.B Listar la duración mínima, máxima y promedio de las canciones.

select min(milisegundos/60000) minima_duracion, max(milisegundos/60000) maxima_duracion,avg(milisegundos/60000) promedio_duracion, g.nombre genero from canciones c 
join generos g on c.id_genero =g.id group by g.nombre;
