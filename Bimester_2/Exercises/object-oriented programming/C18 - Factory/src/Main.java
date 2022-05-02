public class Main {

    public static void main(String[] args) {
        AlmacenFactory almacenFactory = AlmacenFactory.getInstance();
        Almacen almacenPepe = new Almacen();

        almacenPepe.agregarProducto(almacenFactory.generarProducto("PELOTATENIS"));
        almacenPepe.agregarProducto(almacenFactory.generarProducto("PELOTAFUTBOL"));
        almacenPepe.agregarProducto(almacenFactory.generarProducto("CAJA10X10"));

        System.out.println(almacenPepe.calcularEspacioNecesario());
    }
}
