public abstract class Titulo {
    Persona persona;
    private Integer cantidadMateriasCarrera;
    private String fechaInicioEstudios;
    private String fechaFinalizacionCarrera;
    private Boolean selladoPorElMinisterio;
    private Boolean selladoPorElInstituto;

    public Titulo(Persona persona, Integer cantidadMateriasCarrera, String fechaInicioEstudios, String fechaFinalizacionCarrera, Boolean selladoPorElMinisterio, Boolean selladoPorElInstituto) {
        this.persona = persona;
        this.cantidadMateriasCarrera = cantidadMateriasCarrera;
        this.fechaInicioEstudios = fechaInicioEstudios;
        this.fechaFinalizacionCarrera = fechaFinalizacionCarrera;
        this.selladoPorElMinisterio = selladoPorElMinisterio;
        this.selladoPorElInstituto = selladoPorElInstituto;
    }

    public Boolean puedeEjercer(){
        return this.selladoPorElInstituto == true && this.selladoPorElMinisterio == true;
    }
}
