-- 1 Empleados

DROP PROCEDURE IF EXISTS sp_empleados_ordendesc
DELIMITER $$
CREATE PROCEDURE sp_empleados_ordendesc()
BEGIN
SELECT Apellido, Nombre from empleados
order by Apellido, Nombre;
END
$$

call sp_empleados_ordendesc

-- 2 Empleados por ciudad
DROP PROCEDURE IF EXISTS sp_empleados_ciudad()
DELIMITER $$
CREATE PROCEDURE sp_empleados_ciudad(IN filtro_ciudad VARCHAR(15))
BEGIN
SELECT * from empleados
where ciudad = filtro_ciudad;
END
$$

call sp_empleados_ciudad('Seattle')

-- 3 Clientes por país
DROP PROCEDURE IF EXISTS sp_cliente_pais()
DELIMITER $$
CREATE PROCEDURE sp_cliente_pais(IN filtro_pais VARCHAR(15), out cantidad int)
BEGIN
SELECT count(*) into cantidad from clientes
where Pais = filtro_pais;
END
$$

call sp_cliente_pais('Mexico', @cant_clientes);
select @cant_clientes ClientesXPaisFiltrado;

-- 4 Productos sin stock
DROP PROCEDURE IF EXISTS sp_filtro_stock()
DELIMITER $$
CREATE PROCEDURE sp_filtro_stock(in limite_stock int)
BEGIN
SELECT p.ProductoNombre, p.UnidadesStock, c.CategoriaNombre from productos p
inner join categorias c on p.CategoriaID = c.CategoriaID
where p.UnidadesStock <= limite_stock
order by p.UnidadesStock desc;
END

$$

call sp_filtro_stock(9);
call sp_filtro_stock(0);

-- 5 Ventas con descuento
BEGIN 
	SELECT p.ProductoNombre, c.Contacto
    FROM produtos p
    INNER JOIN detallefatura d ON p.ProdutoID = d.ProdutoID
    INNER JOIN facturas f ON d.FacturaId = f.FacturaId
    INNER JOIN clientes c ON f.ClienteID = c.ClienteID
    WHERE d.Descuento >= porcentaje;





