																-- Parte 1. 

select f.FacturaID, f.FechaFactura, f.Transporte, f.ClienteID, p.ProductoNombre, p.CategoriaID, p.PrecioUnitario, p.CantidadPorUnidad
from facturas f
inner join facturadetalle fd on fd.FacturaID = f.FacturaID
inner join productos p on p.ProductoID = fd.ProductoID;

																-- Parte 2
                                                                
-- 1 Listar todas las categorías junto con información de sus productos. Incluir todas las categorías aunque no tengan productos.
select * from categorias c
left join productos p on c.CategoriaID = p.CategoriaID;

-- 2 Listar la información de contacto de los clientes que no hayan comprado nunca en emarket. 
SELECT Contacto FROM clientes c
LEFT JOIN facturas f ON c.ClienteID = f.ClienteID
WHERE f.FacturaID IS NULL;

-- 3. Realizar un listado de productos. Para cada uno indicar su nombre, categoría, y la información de contacto de su proveedor. Tener en cuenta que puede haber productos para los cuales no se indicó quién es el proveedor
select d.ProductoNombre, d.CategoriaID, d.ProveedorID from productos d
left join proveedores v on d.ProveedorID = v.ProveedorID;

-- 4. Para cada categoría listar el promedio del precio unitario de sus productos.
select p.CategoriaID, AVG(p.PrecioUnitario)
from productos p
inner join categorias c
On c.CategoriaID = p.CategoriaID
group by p.CategoriaID ;

-- 5. Para cada cliente, indicar la última factura de compra. Incluir a los clientes que nunca hayan comprado en e-market.
select c.ClienteID, Max(f.FechaFactura) from clientes c
left join facturas f on c.ClienteID = f.ClienteID
group by c.ClienteID;

-- 6 Todas las facturas tienen una empresa de correo asociada (enviovia). Generar un listado con todas las empresas de correo, y la cantidad de facturas correspondientes. Realizar la consulta utilizando RIGHT JOIN.
select f.EnvioVia, c.Compania, count(f.FacturaID) cantidadFacturas from facturas f
right join correos c on f.EnvioVia = c.CorreoID
group by f.EnvioVia, c.Compania;


