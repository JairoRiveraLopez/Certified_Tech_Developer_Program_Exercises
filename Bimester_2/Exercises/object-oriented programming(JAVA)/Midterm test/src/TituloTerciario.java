public class TituloTerciario extends Titulo{
    private String tipo;

    public TituloTerciario(Persona persona, Integer cantidadMateriasCarrera, String fechaInicioEstudios, String fechaFinalizacionCarrera, Boolean selladoPorElMinisterio, Boolean selladoPorElInstituto, String tipo) {
        super(persona, cantidadMateriasCarrera, fechaInicioEstudios, fechaFinalizacionCarrera, selladoPorElMinisterio, selladoPorElInstituto);
        this.tipo = tipo;
    }

    public Boolean esNacional (){
        return this.tipo == "NACIONAL";
    }
}
