/*Clientes
1) ¿Cuántos clientes existen?
select Count(ClienteID) as cantidadClientes from clientes;

2) ¿Cuántos clientes hay por ciudad?
select Ciudad, Count(clienteID) as cantdidadClientes from clientes
group by ciudad;


Facturas
1) ¿Cuál es el total de transporte?
SELECT SUM(Transporte) as totalTransorte FROM facturas;


2) ¿Cuál es el total de transporte por EnvioVia (empresa de envío)?
SELECT EnvioVia, SUM(Transporte) FROM facturas GROUP BY EnvioVia;

3) Calcular la cantidad de facturas por cliente. Ordenar descendentemente por
cantidad de facturas.
SELECT ClienteID, COUNT(FacturaID) AS factura from facturas group by ClienteID order by factura DESC;

4) Obtener el Top 5 de clientes de acuerdo a su cantidad de facturas.
SELECT ClienteID, COUNT(FacturaID) AS factura from facturas GROUP BY ClienteID order by factura DESC LIMIT 5;

5) ¿Cuál es el país de envío menos frecuente de acuerdo a la cantidad de facturas?
SELECT PaisEnvio,COUNT(FacturaID) AS cantidadFacturas FROM Facturas GROUP BY PaisEnvio order by cantidadFacturas LIMIT 1;

6) Se quiere otorgar un bono al empleado con más ventas. ¿Qué ID de empleado
realizó más operaciones de ventas?
SELECT EmpleadoID,COUNT(FechaEnvio) AS ventas FROM Facturas GROUP BY EmpleadoID ORDER BY ventas LIMIT 1; 

Factura detalle
1) ¿Cuál es el producto que aparece en más líneas de la tabla Factura Detalle?
2) ¿Cuál es el total facturado? Considerar que el total facturado es la suma de
cantidad por precio unitario.
SELECT SUM(PrecioUnitario) FROM facturadetalle;

3) ¿Cuál es el total facturado para los productos ID entre 30 y 50?
SELECT SUM(ProductoID) FROM facturadetalle
WHERE ProductoID BETWEEN 30 AND 50;

4) ¿Cuál es el precio unitario promedio de cada producto?
SELECT AVG(PrecioUnitario) AS promedio
FROM facturadetalle;

5) ¿Cuál es el precio unitario máximo?
select max(PrecioUnitario) from productos;

Join
1) Generar un listado de todas las facturas del empleado 'Buchanan'.
SELECT facturas.FacturaID, empleados.Apellido, empleados.Nombre
FROM facturas
INNER JOIN empleados ON facturas.EmpleadoID = empleados.EmpleadoID
WHERE apellido LIKE 'Buchanan';

2) Generar un listado con todos los campos de las facturas del correo 'Speedy
Express'.
select f.FacturaID, f.Enviovia
from facturas f
inner join correos c on c.CorreoID = f.EnvioVia
where c.Compania like "Speedy Express";  

3) Generar un listado de todas las facturas con el nombre y apellido de los
empleados.
select  f.FacturaID, f.ClienteID, f.PaisEnvio
from facturas 
inner join facturadetalle fd on f.FacturaID = fd.FacturaID
inner join empleados e on f.FacturaID = e.EmpleadoID;

4) Mostrar un listado de las facturas de todos los clientes “Owner” y país de envío
“USA”.
SELECT  f.FacturaID, f.ClienteID, f.PaisEnvio
from facturas f
inner join clientes c on c.ClienteID = f.ClienteID
where c.Titulo like "owner" and c.Pais like "usa"; 

5) Mostrar todos los campos de las facturas del empleado cuyo apellido sea
“Leverling” o que incluyan el producto id = “42”.
select f.FacturaID, f.EmpleadoID
from facturas f
right join empleados e on e.EmpleadoID = f.EmpleadoID
left join facturadetalle fd on fd.FacturaID = f.FacturaID
where e.Apellido = 'Leverling' and fd.ProductoID = '42';

6) Mostrar todos los campos de las facturas del empleado cuyo apellido sea
“Leverling” y que incluya los producto id = “80” o ”42”.
SELECT * FROM empleados
INNER JOIN facturas ON empleados.EmpleadoID = facturas.EmpleadoID
INNER JOIN facturadetalle ON facturas.FacturaID = facturadetalle.FacturaID
WHERE empleados.Apellido = 'Leverling' AND facturadetalle.ProductoID IN (80, 42)
GROUP BY facturas.FacturaID;

7) Generar un listado con los cinco mejores clientes, según sus importes de
compras total (PrecioUnitario * Cantidad).
SELECT c.ClienteID, (fd.PrecioUnitario * fd.Cantidad) AS 'Importe de los mejores 5' FROM clientes c 
INNER JOIN facturas f ON c.ClienteID = f.ClienteID
INNER JOIN facturadetalle fd ON fd.FacturaID = f.FacturaID 
GROUP BY c.ClienteID ORDER BY c.ClienteID, (fd.PrecioUnitario * fd.Cantidad) DESC LIMIT 5;

8) Generar un listado de facturas, con los campos id, nombre y apellido del cliente,
fecha de factura, país de envío, Total, ordenado de manera descendente por
fecha de factura y limitado a 10 filas.
select f.FacturaID, f.ClienteID, f.FechaFactura, f.PaisEnvio, c.ClienteID, c.Titulo as 'Nombre y Apellido'
from facturas f
inner join clientes c on c.ClienteID=f.ClienteID
order by f.FechaFactura
limit 10;*/










