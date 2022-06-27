package com.Backend1Ex.ResolucionC32.Services;


import com.Backend1Ex.ResolucionC32.Entities.Producto;
import com.Backend1Ex.ResolucionC32.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService<Producto> {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> buscarProductoXId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Boolean eliminarProducto(Long id) {
        if(productoRepository.findById(id).isPresent()){
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return productoRepository.save(producto);
    }
}
