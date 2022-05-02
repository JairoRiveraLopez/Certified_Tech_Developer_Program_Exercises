public class EstadoFinalizado implements Estado{
    @Override
    public Estado pasarSiguienteEstado() {
        return this;
    }
}
