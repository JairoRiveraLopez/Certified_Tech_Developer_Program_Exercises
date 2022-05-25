package Resolucion_Ejercitacion_Claseintegradora;

import java.util.ArrayList;
import java.util.List;

public class Empleado extends Vendedor{

    private List<Afiliado> listaAfiliados;
    private Integer aniosDeAntiguedad;

    public Empleado(String nombre, Integer aniosDeAntiguedad) {
        super.nombre = nombre;
        super.PUNTOS_POR_VENTA = 5;
        listaAfiliados = new ArrayList<>();
        this.aniosDeAntiguedad = aniosDeAntiguedad;
    }

    public void conseguirAfiliados (Afiliado afiliado){
        listaAfiliados.add(afiliado);
    }


    @Override
    protected Integer calcularPuntos() {
        Integer puntosTotales;
        puntosTotales = ((this.numeroDeVentas * PUNTOS_POR_VENTA) + (aniosDeAntiguedad * 5) + (listaAfiliados.size() * 10));
        return puntosTotales;
    }
}
