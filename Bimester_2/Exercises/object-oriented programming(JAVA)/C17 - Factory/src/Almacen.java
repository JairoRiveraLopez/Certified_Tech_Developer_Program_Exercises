import java.util.ArrayList;
import java.util.List;

public class Almacen {

    private List<Producto> productos;

    public Almacen() {
       productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    public Double calcularEspacioNecesario(){
        Double espacioAOcupar = 0.0;

        for (Producto producto : productos) {
            espacioAOcupar += producto.calcularEspacio();
        }
        return espacioAOcupar;
    }
}
