public class Main {

    public static void main(String[] args) {
        Carrito carrito = new Carrito();

        carrito.agregarProductos(new Producto("Bicicleta", 1000.0));
        carrito.agregarProductos(new Producto("TV", 5000.0));

        System.out.println(carrito.getEstadoActual());

        carrito.pasarSiguienteEstado();
        System.out.println(carrito.getEstadoActual());
        carrito.volverAtras();
        System.out.println(carrito.getEstadoActual());
        carrito.cancelarTodo();
        System.out.println(carrito.getEstadoActual());

    }
}
