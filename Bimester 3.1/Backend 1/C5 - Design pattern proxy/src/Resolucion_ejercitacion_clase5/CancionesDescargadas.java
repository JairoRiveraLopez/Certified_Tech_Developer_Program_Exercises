package Resolucion_ejercitacion_clase5;

public class CancionesDescargadas implements servicioDescarga{

    @Override
    public String descargarCancion(Usuario usuario) {
        String mensaje = "";
        servicioDescargaProxy proxySpotify = new servicioDescargaProxy();
        if (proxySpotify.descargarCancion(usuario).equals("Descargando cancion...pronto lo veras en tu lista de canciones.")){
            mensaje = "Cancion descargada. Ve a tu lista de canciones";
        } else{
            mensaje = "Adquiere Spotify Premium para poder descargar canciones";
        }
        return mensaje;
    }
}
