public class Main {
    public static void main(String[] args) throws ReparacionFactoryException {
        ReparacionFactory reparacionFactory = ReparacionFactory.getInstance();

        Reparacion batidora = reparacionFactory.crearReparacion(ReparacionFactory.BATIDORA);

        batidora.darValorPresupuesto(100.0);
        batidora.pasarSiguientePaso();
        batidora.agregarRepuestos(50.0);
        batidora.pasarSiguientePaso();
        batidora.cambiarDireccion("CRA 50");
        batidora.pasarSiguientePaso();

    }
}
