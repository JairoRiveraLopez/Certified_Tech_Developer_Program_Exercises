public class EstadoParaEnvio implements Estado{
    @Override
    public Estado pasarSiguienteEstado() {
        return new EstadoFinalizado();
    }
}
