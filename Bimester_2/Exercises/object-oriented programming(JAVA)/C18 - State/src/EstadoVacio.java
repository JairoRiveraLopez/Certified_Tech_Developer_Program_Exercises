public class EstadoVacio implements Estado{
    @Override
    public Estado agregar() {
        return new EstadoCargando();
    }

    @Override
    public Estado vaciar() {
        return this;
    }

    @Override
    public Estado avanzar() {
        return new EstadoCargando();
    }

    @Override
    public Estado volver() {
        return this;
    }
}
