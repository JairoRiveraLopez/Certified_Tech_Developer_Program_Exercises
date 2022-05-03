public class EstadoPresupuesto implements Estado{
    @Override
    public Estado pasarSiguienteEstado() {
        return new EstadoReparacion();
    }
}
