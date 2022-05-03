public class TituloLicenciatura extends Titulo implements Comparable{
    private String temaTesis;
    private String fechaEntregaTesis;
    private Integer cantidadTrabajosInvestigacion;

    public TituloLicenciatura(Persona persona, Integer cantidadMateriasCarrera, String fechaInicioEstudios, String fechaFinalizacionCarrera, Boolean selladoPorElMinisterio, Boolean selladoPorElInstituto, String temaTesis, String fechaEntregaTesis, Integer cantidadTrabajosInvestigacion) {
        super(persona, cantidadMateriasCarrera, fechaInicioEstudios, fechaFinalizacionCarrera, selladoPorElMinisterio, selladoPorElInstituto);
        this.temaTesis = temaTesis;
        this.fechaEntregaTesis = fechaEntregaTesis;
        this.cantidadTrabajosInvestigacion = cantidadTrabajosInvestigacion;
    }
    @Override
    public int compareTo (Object object){
        TituloLicenciatura otroTitulo = (TituloLicenciatura) object;
        if (this.cantidadTrabajosInvestigacion > otroTitulo.cantidadTrabajosInvestigacion){
            return 1;
        } if (this.cantidadTrabajosInvestigacion < otroTitulo.cantidadTrabajosInvestigacion){
            return -1;
        }
        return 0;
    }
}
