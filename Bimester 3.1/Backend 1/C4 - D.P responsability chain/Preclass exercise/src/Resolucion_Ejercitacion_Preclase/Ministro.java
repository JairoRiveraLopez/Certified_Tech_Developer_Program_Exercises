package Resolucion_Ejercitacion_Preclase;

public class Ministro extends Gobernante{

    public Ministro() {
        this.nivelGestion = 2;
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
