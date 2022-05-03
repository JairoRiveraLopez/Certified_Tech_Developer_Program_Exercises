import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        juego();
    }

    public static String pedirNombreJugador1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el nombre del jugador 1: ");
        return scanner.nextLine();
    }

    public static String pedirNombreJugador2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el nombre del jugador 2: ");
        return scanner.nextLine();
    }

    public static Integer pedirDecision(String jugador){
        Scanner scanner = new Scanner(System.in);
        System.out.println(jugador + " por favor elige un número entero entre : " +
                "(1) Spock, (2) Piedra, (3) Tijera, (4)Lagarto, (5) Papel.");
        return scanner.nextInt();
    }
    public static int elegirGanador(int opcionJugador1, int opcionJugador2) {
        int ganador = 0;
        if(opcionJugador1 == 5 && opcionJugador2 == 1){
            ganador = 1;
        } else if (opcionJugador1 == 1 && opcionJugador2 == 5){
            ganador = 2;
        } else if ((opcionJugador1 < opcionJugador2)){
            ganador = 1;
        } else if(opcionJugador2 < opcionJugador1){
            ganador = 2;
        } else{
            ganador = 0;
        }
        return ganador;
    }
    public static void puntos(String jugador1, int puntosJugador1, String jugador2, int puntosJugador2) {
        System.out.println("¡Este es el puntaje hasta ahora!");
        System.out.println(jugador1 + ": " + puntosJugador1);
        System.out.println(jugador2 + ": " + puntosJugador2);
    }
    public static void juego() {
        Scanner scanner = new Scanner(System.in);
        String jugador1 = pedirNombreJugador1();
        String jugador2 = pedirNombreJugador2();
        String seguirJugando = "";
        int puntosJugador1 = 0;
        int puntosJugador2 = 0;
        int empate;

        do{
            int opcionJ1 = pedirDecision(jugador1);
            int opcionJ2 = pedirDecision(jugador2);
            int ganador = elegirGanador(opcionJ1, opcionJ2);
            if(ganador == 1){
                puntosJugador1++;
            }else if (ganador == 0){
                empate = 0;
            }else{
                puntosJugador2++;
            }
            puntos(jugador1, puntosJugador1, jugador2, puntosJugador2);
            System.out.println("Presiona cualquier tecla si desea seguir, o asterísco [*] para salir: ");
            seguirJugando = scanner.next();
        } while (seguirJugando.charAt(0) != '*');
        System.out.println("¡Gracias por jugar piedra, papel, tijera, Lagarto y Spock!");
    }
}