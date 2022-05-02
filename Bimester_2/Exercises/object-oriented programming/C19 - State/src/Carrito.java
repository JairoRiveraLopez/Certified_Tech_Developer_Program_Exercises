import java.util.List;
import java.util.ArrayList;

public class Carrito{
    private List<Producto> productos;
    private Estado estadoActual;

    public Carrito() {
        this.productos = new ArrayList<>();
        estadoActual = new EstadoVacio();
    }

    public void agregarProductos(Producto producto){
        productos.add(producto);
        estadoActual = estadoActual.agregar();
    }

    public void cancelarTodo(){
        productos = new ArrayList<>();
        estadoActual = estadoActual.vaciar();
    }

    public void volverAtras(){
        estadoActual = estadoActual.volver();
    }

    public void pasarSiguienteEstado(){
        estadoActual = estadoActual.avanzar();
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }
}
