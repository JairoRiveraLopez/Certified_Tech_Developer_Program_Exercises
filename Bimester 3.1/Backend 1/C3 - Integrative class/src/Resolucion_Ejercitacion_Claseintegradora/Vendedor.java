package Resolucion_Ejercitacion_Claseintegradora;

public abstract class Vendedor {
    protected String nombre;
    protected Integer numeroDeVentas = 0;
    protected int PUNTOS_POR_VENTA;


    public void vender (){
        this.numeroDeVentas++;
    }

    public String categorizar(){
        Integer puntosDelVendedor = calcularPuntos();
        return this.nombre + " tiene un total de " + puntosDelVendedor + " puntos y se categoriza como " + getNombreCategoria();
    }

    protected abstract Integer calcularPuntos();

    public static boolean entre2Numeros(int num, int menor, int mayor) {
        return menor <= num && num <= mayor;
    }

    private String getNombreCategoria(){
        Integer puntosDelVendedor = calcularPuntos();

        if (this.getClass().getSimpleName().equals("Pasante")){
            if (entre2Numeros(puntosDelVendedor, 0, 50)){
                return "Pasante novato";
            } else{
                return "Pasante experimentado";
            }
        } else{
            if (entre2Numeros(puntosDelVendedor, 0, 20)){
                return "Novato";
            }
            else if (entre2Numeros(puntosDelVendedor, 21, 30)){
                return "Aprendiz";
            } else if (entre2Numeros(puntosDelVendedor, 31, 40)){
                return "Bueno";
            }
            else
                return "Maestro";
        }
    }

    public void setNumeroDeVentas(Integer numeroDeVentas) {
        this.numeroDeVentas = numeroDeVentas;
    }
}