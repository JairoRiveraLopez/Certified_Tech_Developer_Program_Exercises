import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Puerto BuenosAires = new Puerto();

        BuenosAires.addContenedor(new Contenedor(30, "Argentina", false));
        BuenosAires.addContenedor(new Contenedor(45, "Colombia", false));
        BuenosAires.addContenedor(new Contenedor(10, "Arabia Saudita", true));
        BuenosAires.addContenedor(new Contenedor(60, "Desconocida", true));
        BuenosAires.addContenedor(new Contenedor(20, "Desconocida", true));
        BuenosAires.addContenedor(new Contenedor(102, "Desconocida", true));

        System.out.println(BuenosAires.calcularContenedoresPeligrosos());
        BuenosAires.mostrarContenedores();
    }
}
