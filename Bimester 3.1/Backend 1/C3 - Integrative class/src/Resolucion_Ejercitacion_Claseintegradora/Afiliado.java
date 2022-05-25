package Resolucion_Ejercitacion_Claseintegradora;

public class Afiliado extends Vendedor {

    public Afiliado(String nombre){
        super.nombre = nombre;
        super.PUNTOS_POR_VENTA = 15;
    }


    @Override
    protected Integer calcularPuntos() {
        Integer puntosTotales;
        puntosTotales = this.numeroDeVentas * PUNTOS_POR_VENTA;
        return puntosTotales;
    }

}
