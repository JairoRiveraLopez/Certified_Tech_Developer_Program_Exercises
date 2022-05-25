package Resolucion_Ejercitacion_Preclase;

public abstract class Gobernante {
    protected Integer nivelGestion;
    private Gobernante sigGobernante;
    public abstract String gestionarDocumento (Documento documento);

    public Gobernante setGobernante (Gobernante gob){
        sigGobernante = gob;
        return sigGobernante;
    }

    public Gobernante getSigGobernante(){
        return sigGobernante;
    }

    public boolean esValidoElTipo(Documento documento){
        return (documento.getTipo() <= this.nivelGestion);
    }

}
