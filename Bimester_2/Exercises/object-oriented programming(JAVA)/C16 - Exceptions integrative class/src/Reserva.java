public class Reserva {
    private Integer codigo;
    private Integer cantidadViajeros;
    private Recorrido recorrido;

    public Reserva(Integer codigo, Integer cantidadViajeros, Recorrido recorrido) {
        this.codigo = codigo;
        this.cantidadViajeros = cantidadViajeros;
        this.recorrido = recorrido;
    }

    public Integer getCantidadViajeros() {
        return cantidadViajeros;
    }

    public Recorrido getRecorrido() {
        return recorrido;
    }
}
