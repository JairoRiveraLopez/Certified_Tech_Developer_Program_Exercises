public class Contenedor implements Comparable<Contenedor>{
    private Integer numeroId;
    private String paisProcedencia;
    private Boolean contieneMaterialPeligroso;

    public Contenedor(Integer numeroId, String paisProcedencia, Boolean contieneMaterialPeligroso) {
        this.numeroId = numeroId;
        this.paisProcedencia = paisProcedencia;
        this.contieneMaterialPeligroso = contieneMaterialPeligroso;
    }

    @Override
    public int compareTo(Contenedor contenedor) {
        return this.numeroId.compareTo(contenedor.numeroId);
    }

    public Boolean getContieneMaterialPeligroso() {
        return contieneMaterialPeligroso;
    }

    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    public Integer getNumeroId() {
        return numeroId;
    }
}
