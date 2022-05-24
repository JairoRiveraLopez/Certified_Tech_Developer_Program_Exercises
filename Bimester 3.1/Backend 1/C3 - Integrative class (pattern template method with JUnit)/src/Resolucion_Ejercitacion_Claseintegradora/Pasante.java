package Resolucion_Ejercitacion_Claseintegradora;

public class Pasante extends Vendedor{

    public Pasante(String nombre){
        super.nombre = nombre;
        super.PUNTOS_POR_VENTA = 5;

    }

    @Override
    protected Integer calcularPuntos() {
        Integer puntosTotales;
        puntosTotales = this.numeroDeVentas * PUNTOS_POR_VENTA;
        return puntosTotales;

    }



}
