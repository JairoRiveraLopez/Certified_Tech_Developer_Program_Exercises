public class EstadoReparacion implements Estado{
    @Override
    public Estado pasarSiguienteEstado() {
        return new EstadoParaEnvio();
    }
}
