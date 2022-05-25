package Resolucion_ejerciciopreclase_patronfacade;

public class Main {
    public static void main(String[] args) {
        ServicioBancario Bancolombia = new ServicioBancario();
        Bancolombia.agregarCuenta(new Cuenta(1216719942, "abcd123", 1000.0));
        Bancolombia.agregarCuenta(new Cuenta(1063758985, "021458", 2000.0));
        Bancolombia.retirarDinero(1216719942,"abcd123", 1200.0 );
    }
}
