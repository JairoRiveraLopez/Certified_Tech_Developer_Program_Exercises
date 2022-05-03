public class AlmacenFactory {

    private static AlmacenFactory instance;

    private AlmacenFactory(){
    }

    public static AlmacenFactory getInstance() {
        if(instance == null){
            instance = new AlmacenFactory();
        }
        return instance;
    }

    public Producto generarProducto(String codigo){

        switch (codigo){
            case "CAJA10X10" :
                return new Caja(10.0, 10.0, 10.0);
            case "PELOTAFUTBOL" :
                return new Pelota(11.0);
            case "PELOTATENIS" :
                return new Pelota(0.32);
        }

        return null;
    }
}
