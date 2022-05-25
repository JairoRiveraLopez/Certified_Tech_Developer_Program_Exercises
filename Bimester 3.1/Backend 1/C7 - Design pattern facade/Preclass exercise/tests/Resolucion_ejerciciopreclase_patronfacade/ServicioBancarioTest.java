package Resolucion_ejerciciopreclase_patronfacade;

import org.junit.jupiter.api.*;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

class ServicioBancarioTest {
    ServicioBancario Bancolombia = new ServicioBancario();
    Cuenta cuenta1 = new Cuenta(1216719942, "abcd123", 1000.0);
    Cuenta cuenta2 = new Cuenta(1063758985, "021458", 2000.0);

    @BeforeEach
    void init(){
        Bancolombia.agregarCuenta(cuenta1);
        Bancolombia.agregarCuenta(cuenta2);
    }

    @Test
    void retirarDinero_ResultadoExitoso() {
        Bancolombia.retirarDinero(1216719942, "abcd123", 200.0);
        assertEquals(cuenta1.getSaldo(), 800.0);
    }

    @Test
    void retirarDinero_ResultadoFallido() {
        Bancolombia.retirarDinero(1216719942, "abcd123", 1200.0);
        assertEquals(cuenta1.getSaldo(), 1000.0);
    }
}