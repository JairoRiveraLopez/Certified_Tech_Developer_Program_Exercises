import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTestTest {
@Test
    void getNombreCompleto (){
    Persona persona = new Persona("Jairo", "Rivera", 1996);
    assertEquals("Rivera, Jairo", persona.getNombreCompleto());
}

@Test
    void esMayorDeEdad () {
    Persona persona = new Persona("Jairo", "Rivera", 1996);
    assertTrue(persona.esMayorDeEdad());
}

    @Test
    void noEsMayorDeEdad () {
        Persona persona2 = new Persona("Oriana", "Ortega", 2010);
        assertFalse(persona2.esMayorDeEdad());
    }



}