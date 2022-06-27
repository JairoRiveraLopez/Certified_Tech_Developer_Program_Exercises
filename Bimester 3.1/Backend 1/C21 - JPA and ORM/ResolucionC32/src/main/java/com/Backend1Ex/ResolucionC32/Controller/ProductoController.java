package com.Backend1Ex.ResolucionC32.Controller;

import com.Backend1Ex.ResolucionC32.Entities.Producto;
import com.Backend1Ex.ResolucionC32.Services.IProductoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final IProductoService<Producto> productoService;

    public ProductoController(IProductoService<Producto> productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<>(productoService.obtenerProductos(), headers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> traerProducto(@PathVariable long id){
        HttpHeaders headers = new HttpHeaders();

        if(productoService.buscarProductoXId(id).isPresent())
        {
            headers.add("Content-Type", "application/json");
            return new ResponseEntity<>(productoService.buscarProductoXId(id), headers, HttpStatus.OK);
        }

        headers.add("Content-Type", "application/json");
        String mensaje = "No se encontró producto por el id especificado.";
        return new ResponseEntity<>(mensaje, headers, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<>(productoService.guardarProducto(producto), headers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarProducto(@PathVariable long id){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<>(productoService.eliminarProducto(id), headers, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        return new ResponseEntity<>(productoService.guardarProducto(producto), headers, HttpStatus.OK);
    }
}
