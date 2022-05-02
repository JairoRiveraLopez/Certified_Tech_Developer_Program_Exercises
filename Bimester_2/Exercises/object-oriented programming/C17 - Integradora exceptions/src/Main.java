public class Main {
    public static void main(String[] args) {
        ListaReserva bdd = new ListaReserva();

        Recorrido recorrido1 = new Recorrido("Buenos Aires", "Luján");
        Recorrido recorrido2 = new Recorrido("Luján", "Mercedes");
        Recorrido recorrido3 = new Recorrido("Suipacha", "Chivilcoy");
        Recorrido recorrido4 = new Recorrido("Bragado", "Buenos Aires");

        bdd.agregarReserva(new Reserva(21, 100, recorrido1));
        bdd.agregarReserva(new Reserva(22, 100, recorrido2));
        bdd.agregarReserva(new Reserva(23, 100, recorrido3));
        bdd.agregarReserva(new Reserva(24, 100, recorrido4));

        System.out.println(bdd.recaudacionTotal());

        try {
            System.out.println(bdd.cantidadVecesRecorrida("Medellin"));
        } catch (ListaReservaException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(bdd.cantidadVecesRecorrida("Luján"));
        } catch (ListaReservaException e) {
            e.printStackTrace();
        }



    }
}
