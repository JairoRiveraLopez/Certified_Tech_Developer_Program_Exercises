import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuadradoTest {

    @Test
    void calcularAreaCuadrado() {
        try {
            Cuadrado cuadrado = new Cuadrado(10.00);
            assertEquals(100.00, cuadrado.calcularArea());
        } catch (FiguraGeometricaException e){
            System.out.println(e);
        }
    }

    @Test
    void calcularAreaCirculo() {
        try {
            Circulo circulo = new Circulo(2.00);
            assertEquals(13.00, Math.round(circulo.calcularArea()));
        } catch (FiguraGeometricaException e){
            System.out.println(e);
        }
    }

    @Test
    void pruebaNegativaFigura() {
        try {
            Cuadrado cuadrado = new Cuadrado(-4.00);
            FiguraGeometricaException exception = assertThrows(FiguraGeometricaException.class, () -> cuadrado.calcularArea());
            assertEquals("Para calcular el area, el dato numerico debe ser mayor a 0.", exception.getMessage());
        }catch (FiguraGeometricaException e){
            System.out.println(e);
        }
    }
}
