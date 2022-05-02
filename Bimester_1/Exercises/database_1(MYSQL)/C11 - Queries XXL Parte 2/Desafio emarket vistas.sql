														# CLIENTES

# 1. Crear una vista con los siguientes datos de los clientes: ID, contacto, y el
-- Fax. En caso de que no tenga Fax, colocar el teléfono, pero aclarándolo. Por
-- ejemplo: “TEL: (01) 123-4567”.

CREATE VIEW consulta_clientes AS
SELECT ClienteID,
	Contacto,
	CASE 
		WHEN Fax = '' THEN CONCAT('TEL: ', Telefono)
		ELSE FAX
	END AS telefono_fax
FROM clientes;

SELECT * FROM consulta_clientes;

# 2. Se necesita listar los números de teléfono de los clientes que no tengan fax. Hacerlo de dos formas distintas:
-- a. Consultando la tabla de clientes.

SELECT Contacto, Telefono FROM clientes
WHERE fax = '';

-- b. Consultando la vista de clientes.

SELECT Contacto, telefono_fax FROM consulta_clientes
WHERE telefono_fax LIKE 'TEL:%';

														# PROVEEDORES
                                                        
# 1. Crear una vista con los siguientes datos de los proveedores: ID, contacto, compañía y dirección. 
-- Para la dirección tomar la dirección, ciudad, código postal y país.
CREATE VIEW proveedores_direccion AS
SELECT ProveedorID AS ID, Contacto, Compania, CONCAT(Direccion, " / ", Ciudad, " / ", CodigoPostal, " / ", Pais) AS Direccion FROM proveedores;

SELECT * FROM proveedores_direccion;

# 2. Listar los proveedores que vivan en la calle Americanas en Brasil. Hacerlo de dos formas distintas:
-- a. Consultando la tabla de proveedores.

SELECT * from proveedores
WHERE direccion LIKE "%Americanas%"
AND pais LIKE "%Brazil%";

-- b. Consultando la vista de proveedores.

SELECT 
    *
FROM
    proveedores_direccion
WHERE
    Direccion LIKE '%Americanas%Brazil%';

													# Vistas - Parte II

# 1. Crear una vista de productos que se usará para control de stock. Incluir el ID y nombre del producto, el precio unitario 
-- redondeado sin decimales, las unidades en stock y las unidades pedidas. Incluir además una nueva columna PRIORIDAD con los 
-- siguientes valores:
-- ■ BAJA: si las unidades pedidas son cero.
-- ■ MEDIA: si las unidades pedidas son menores que las unidades en stock.
-- ■ URGENTE: si las unidades pedidas no duplican el número de unidades.
-- ■ SUPER URGENTE: si las unidades pedidas duplican el número de unidades en caso contrario.

CREATE VIEW consulta_productos AS
SELECT ProductoID AS ID, ProductoNombre, ROUND(PrecioUnitario) AS Precio, UnidadesStock, UnidadesPedidas,
	CASE
		WHEN UnidadesPedidas = 0 THEN "BAJA"
        WHEN UnidadesPedidas < UnidadesStock THEN "MEDIA"
        WHEN UnidadesPedidas < 2*UnidadesStock THEN "URGENTE"
        ELSE "SUPER URGENTE"
		END AS Prioridad
from productos
ORDER BY Prioridad;

SELECT * from consulta_productos;

# 2. Se necesita un reporte de productos para identificar problemas de stock. Para cada prioridad indicar cuántos productos 
-- hay y su precio promedio. No incluir las prioridades para las que haya menos de 5 productos.

SELECT Prioridad, count(*) AS CantidadProductos,
ROUND (AVG(Precio), 2) AS PrecioPromedio
FROM consulta_productos 
GROUP BY Prioridad
HAVING count(*)>5