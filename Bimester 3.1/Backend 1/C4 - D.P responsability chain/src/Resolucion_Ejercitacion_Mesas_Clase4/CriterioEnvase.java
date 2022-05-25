package Resolucion_Ejercitacion_Mesas_Clase4;

public class CriterioEnvase extends ComprobadorCalidad {
    public static final String envaseSano = "sano";
    public static final String envaseCasiSano= "casi sano";


    @Override
    public String verificarCalidad(Articulo articulo) {
        String mensaje;
        String estado;
        if (articulo.getEnvasado().equals(envaseSano) || articulo.getEnvasado().equals(envaseCasiSano)){
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

