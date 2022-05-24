
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        CentralItinerarios aeroPuertoBogotá = new CentralItinerarios();

        Vuelo ABC123 = new Vuelo("Bogotá", "Medellín", 20, 10);
        Vuelo XYZ789 = new Vuelo("Lima", "Buenos Aires", 6, 18);

        aeroPuertoBogotá.agregar(ABC123);
        aeroPuertoBogotá.agregar(XYZ789);

        Portal notificaciones = new Portal(aeroPuertoBogotá);



    }
}
