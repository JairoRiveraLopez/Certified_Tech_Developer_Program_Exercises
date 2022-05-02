public class ReparacionFactory {
    public static final String BATIDORA = "BATIDORA";
    private static ReparacionFactory instance;

    private ReparacionFactory() {

    }

    public static ReparacionFactory getInstance() {
        if (instance == null){
            instance = new ReparacionFactory();
        }
        return instance;
    }

    public Reparacion crearReparacion (String e) throws ReparacionFactoryException{
        switch (e) {
            case BATIDORA :
                return new Reparacion("BATIDORA", "CLL 3");
        }
        throw new ReparacionFactoryException(e + "Articulo no válido");

    }
}
