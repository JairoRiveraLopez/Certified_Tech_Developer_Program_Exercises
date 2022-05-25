package Resolucion_Ejercitacion_Mesas_Clase4;

public class CriterioPeso extends ComprobadorCalidad{

    public CriterioPeso() {

    }

    @Override
    public String verificarCalidad(Articulo articulo) {
        String mensaje;
        String estado;
        if (entre2Numeros(articulo.getPeso(), 1200, 1300)){
            estado = statusAceptado;
            if(sigCriterio != null){
                return this.sigCriterio.verificarCalidad(articulo);
            }
        }else{
            estado = statusRechazado;
        }
        mensaje = "Verificacion de calidad: %s. Resultado : %s. Articulo: %s."
                .formatted(this.getClass().getSimpleName(), estado, articulo.getNombre());
        return mensaje;
    }
}
