package com.Backend1Ex.ResolucionC32.Services;

import com.Backend1Ex.ResolucionC32.Entities.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService<P> {
    List<Producto> obtenerProductos();
    Optional<Producto> buscarProductoXId(Long id);
    Producto guardarProducto(Producto producto);
    Boolean eliminarProducto(Long id);
    Producto actualizarProducto(Producto producto);
}
