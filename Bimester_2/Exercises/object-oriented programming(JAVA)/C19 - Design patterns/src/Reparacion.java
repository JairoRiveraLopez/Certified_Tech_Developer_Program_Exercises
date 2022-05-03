public class Reparacion {
    private Estado estadoActual;
    private String nombreArticulo;
    private Double costo;
    private String direccionEntrega;

    public Reparacion() {

    }

    public Reparacion(String nombreArticulo, String direccionEntrega) {
        estadoActual = new EstadoPresupuesto();
        this.nombreArticulo = nombreArticulo;
        this.costo = 0.0;
        this.direccionEntrega = direccionEntrega;
    }

    public void cambiarDireccion(String direccion){
        if(estadoActual instanceof EstadoParaEnvio) {
            this.direccionEntrega = direccion;
        } else {
            System.out.println("No se puede cambiar la direccion en este estado de la reparacion");
        }
    }

    public void darValorPresupuesto(Double valor){
        if(estadoActual instanceof EstadoPresupuesto) {
            this.costo += valor;
        } else {
            System.out.println("No se puede agregar presupuesto en este estado de la reparacion");
        }
    }

    public void agregarRepuestos (Double valor){
        if(estadoActual instanceof EstadoReparacion) {
            this.costo += valor;
        } else {
            System.out.println("No se puede agregar respuestos en este estado de la reparacion");
        }
    }

    public void pasarSiguientePaso (){
        estadoActual = estadoActual.pasarSiguienteEstado();
        System.out.println(this.nombreArticulo + ". El estado del producto es " + this.estadoActual + ". El presupuesto es: " + this.costo + ". La direccion de entrega es " + this.direccionEntrega);
    }


}
