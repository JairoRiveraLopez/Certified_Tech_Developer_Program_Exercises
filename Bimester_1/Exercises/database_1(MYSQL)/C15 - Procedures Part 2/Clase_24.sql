

-- 1) Cálculo de edad 
-- a) Crear un SP que muestre apellidos, nombres y edad de cada empleado, debe calcular la edad de los empleados a partir de la fecha de nacimiento y que tengan entre n y n años de edad. 

DROP PROCEDURE sp_empleado_edad;

DELIMITER $$
CREATE PROCEDURE sp_empleado_edad(IN edad1 TINYINT, IN edad2 TINYINT)
BEGIN
	SELECT Nombre, Apellido, (EXTRACT(YEAR FROM CURDATE())-EXTRACT(YEAR FROM FechaNacimiento)) AS Edad
    FROM Empleados
    HAVING Edad BETWEEN edad1 AND edad2;
END $$

-- b) Ejecutar el SP indicando un rango de edad entre 50 y 60 años de edad. 

CALL sp_empleado_edad(60, 70)


/*2 Crear un SP que reciba un porcentaje y un nombre de categoría y actualice los productos pertenecientes a esa categoría,
 incrementando las unidades pedidas según el porcentaje indicado. Por ejemplo: si un producto de la categoría Seafood tiene 30 
 unidades pedidas, al invocar el SP con categoría Seafood y
 porcentaje 10%, el SP actualizará el valor de unidades pedidas con el nuevo valor 33. */
 
 delimiter $$
drop procedure if exists sp_actualizar_producto_categoria $$
create procedure sp_actualizar_producto_categoria (in CategoriaNombre varchar(15), in porcentaje float(7, 2))
begin
SELECT p.UnidadesPedidas * (porcentaje + 1) from productos p join categorias c on c.CategoriaID = p.CategoriaID;
end $$

call sp_actualizar_producto_categoria("Beverages", 0.15);

-- b

DROP PROCEDURE IF EXISTS emarket.sp_listar_beverages  
DELIMITER $$
CREATE PROCEDURE sp_listar_beverages(in categoria varchar(15))
BEGIN
select count(c.CategoriaID) ConteoBeverages from categorias c
inner join productos p on p.CategoriaID = c.CategoriaID
right join facturadetalle fd on fd.ProductoID = p.ProductoID
where c.CategoriaNombre = categoria;
END
$$

-- c) Invocar al SP con los valores Beverages como categoría y 15 como porcentaje. 

call sp_listar_beverages("Beverages");




-- 3) Actualización de empleados 
-- a) Crear un SP que cree una tabla con los nombres, apellidos y teléfono de contacto de todos los empleados que hayan sido contratados con fecha anterior a una fecha dada. 

DELIMITER $$
CREATE PROCEDURE sp_actualizacion_empleados(IN fechaMenorA DATE)
BEGIN
    CREATE TABLE empleadosAnteriorDe
    SELECT Nombre, Apellido, Telefono, FechaContratacion FROM empleados
    WHERE FechaContratacion < fechaMenorA;
END $$

-- b) Ejecutar el SP para generar una tabla de empleados con fecha de contratación anterior a 01/01/1994. 
CALL sp_actualizacion_empleados('1994-01-01')$$

-- c) Consultar la tabla generada y validar los resultados. 
SELECT * FROM empleadosAnteriorDe;
