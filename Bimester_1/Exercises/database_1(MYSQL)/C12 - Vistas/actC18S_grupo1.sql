/*Ejercicio 1

1. Crear una vista para poder organizar los envíos de las facturas. Indicar número
de factura, fecha de la factura y fecha de envío, ambas en formato dd/mm/yyyy,
valor del transporte formateado con dos decimales, y la información del
domicilio del destino incluyendo dirección, ciudad, código postal y país, en una
columna llamada Destino.
2. Realizar una consulta con todos los correos y el detalle de las facturas que
usaron ese correo. Utilizar la vista creada.
3. ¿Qué dificultad o problema encontrás en esta consigna? Proponer alguna
alternativa o solución.

Ejercicio 2

1. Crear una vista con un detalle de los productos en stock. Indicar id, nombre del
producto, nombre de la categoría y precio unitario.
2. Escribir una consulta que liste el nombre y la categoría de todos los productos
vendidos. Utilizar la vista creada.
3. ¿Qué dificultad o problema encontrás en esta consigna? Proponer alguna
alternativa o solución.*/
-- Punto 1.1
create view v_EnviosFacturas as select FacturaID,  date_format(FechaFactura, '%D %M %Y') as FechaFactura, 
date_format(FechaEnvio, '%D %M %Y') FechaEnvio, 
round(Transporte,2) Transporte, 
concat(DireccionEnvio, 
CiudadEnvio, 
CodigoPostalEnvio,PaisEnvio) as Destino from facturas;
alter view v_EnviosFacturas as select FacturaID,  date_format(FechaFactura, '%D %M %Y') as FechaFactura, 
date_format(FechaEnvio, '%D %M %Y') FechaEnvio, 
round(Transporte,2) Transporte, 
concat(DireccionEnvio, 
CiudadEnvio, 
CodigoPostalEnvio,PaisEnvio) as Destino, EnvioVia from facturas;
select * from v_EnviosFacturas;
-- Punto 2
-- Realizar una consulta con todos los correos y el detalle de las facturas que usaron ese correo. Utilizar la vista creada.
select * from v_enviosfacturas as vf
right join correos c on vf.EnvioVia = c.CorreoID;
-- 2.1Crear una vista con un detalle de los productos en stock. Indicar id, nombre del producto, nombre de la categoría y precio unitario.*/
CREATE VIEW v_stock_productos AS 
SELECT p.ProductoID id, p.ProductoNombre nombre_producto, c.CategoriaNombre nombre_categoria, p.PrecioUnitario precio_unitario
FROM productos p
JOIN categorias c ON p.CategoriaID= c.CategoriaID
WHERE p.UnidadesStock != 0;
-- 2.2
select nombre_categoria, id from v_stock_productos vs
inner join productos p on vs.id = p.ProductoID;
 /*Dificultades que encontramos en las actividades: incluir siempre las claves foráneas en las vistas para luego poder relacionarlas con otras tablas*/
