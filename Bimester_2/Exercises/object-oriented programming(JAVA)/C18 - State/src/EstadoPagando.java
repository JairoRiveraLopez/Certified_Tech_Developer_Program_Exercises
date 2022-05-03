public class EstadoPagando implements Estado{
    @Override
    public  Estado agregar() {
        return this;
    }

    @Override
    public Estado vaciar() {
        return new EstadoVacio();
    }

    @Override
    public Estado avanzar() {
        return new EstadoCancelado();
    }

    @Override
    public Estado volver() {
        return new EstadoCargando();
    }
}
