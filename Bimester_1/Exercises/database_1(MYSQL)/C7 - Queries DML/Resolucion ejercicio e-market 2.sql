										-- Consigna / Categorías y productos

#1. Queremos tener un listado de todas las categorías.#
-- SELECT * FROM categorias; --
#2. Cómo las categorías no tienen imágenes, solamente interesa obtener un listado de CategoriaNombre y Descripcion.#
-- SELECT CategoriaNombre, Descripcion FROM categorias; --
#3. Obtener un listado de los productos.#
-- SELECT * FROM productos; --
#4. ¿Existen productos discontinuados? (Discontinuado = 1).#
-- SELECT Discontinuado FROM productos --
-- where Discontinuado = "1"; --
#5. Para el viernes hay que reunirse con el Proveedor 8. ¿Qué productos son los que nos provee?#
-- SELECT * FROM productos
-- where ProveedorID = 8;
#6. Queremos conocer todos los productos cuyo precio unitario se encuentre entre 10 y 22.#
-- SELECT * FROM productos
-- where PrecioUnitario between 10 and 22;
#7. Se define que un producto hay que solicitarlo al proveedor si sus unidades en stock son menores al Nivel de Reorden. ¿Hay productos por solicitar?
-- SELECT * FROM productos
-- where UnidadesStock < NivelReorden;
#8. Se quiere conocer todos los productos del listado anterior, pero que unidades pedidas sea igual a cero.#
-- SELECT * FROM productos
-- where UnidadesStock < NivelReorden
-- and UnidadesPedidas = 0;

									-- Consigna / Clientes
                                    
#1. Obtener un listado de todos los clientes con Contacto, Compania, Título, País. Ordenar el listado por País.
-- SELECT Contacto, Compania, Titulo, Pais from clientes
-- order by Pais;
# 2. Queremos conocer a todos los clientes que tengan un título “Owner”.
-- SELECT * from clientes
-- where titulo = "Owner";
#3. El operador telefónico que atendió a un cliente no recuerda su nombre. Solo sabe que comienza con “C”. ¿Lo ayudamos a obtener un listado con todos los contactos que inician con la letra “C”?
-- SELECT * from clientes
-- where contacto like "c%";
                                    
											-- Consigna / Facturas
#1. Obtener un listado de todas las facturas, ordenado por fecha de factura ascendente.
-- Select * from facturas
-- order by FechaFactura;
#2. Ahora se requiere un listado de las facturas con el país de envío “USA” y que su correo (EnvioVia) sea distinto de 3.
-- Select * from facturas
-- where PaisEnvio = "USA"
-- and EnvioVia <> 3;
#3. ¿El cliente 'GOURL' realizó algún pedido?
-- select * from facturas
-- where ClienteID = "GOURL"
#4. Se quiere visualizar todas las facturas de los empleados 2, 3, 5, 8 y 9.
-- select * from facturas
-- where EmpleadoID in (2, 3, 5, 8, 9);


