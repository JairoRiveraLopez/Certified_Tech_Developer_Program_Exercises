package Resolucion_Ejercitacion_Preclase;

public class Presidente extends Gobernante{

    public Presidente() {
        this.nivelGestion = 3;
    }

    @Override
    public String gestionarDocumento(Documento documento) {
        String mensaje = "";
        if(this.esValidoElTipo(documento)){
            mensaje = this.getClass().getSimpleName() + ": Recibido. Proseguire a gestionar el documento.";
        } else{
            if(this.getSigGobernante() != null){
                mensaje = this.getSigGobernante().gestionarDocumento(documento);
            }
        }
        return mensaje;
    }
}
