public class EstadoCargando implements Estado{
    @Override
    public Estado agregar() {
        return this;
    }

    @Override
    public Estado vaciar() {
        return new EstadoVacio();
    }

    @Override
    public Estado avanzar() {
        return new EstadoPagando();
    }

    @Override
    public Estado volver() {
        return new EstadoVacio();
    }
}
