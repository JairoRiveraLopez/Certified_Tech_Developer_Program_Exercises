package Resolucion_ejercitacion_clase5;

public class servicioDescargaProxy implements servicioDescarga{
    @Override
    public String descargarCancion(Usuario usuario) {

        if(comprobarTipoUsuario(usuario)){
            return "Descargando cancion...pronto lo veras en tu lista de canciones.";
        }
        return "Adquiere Spotify Premium para poder descargar canciones";
    }

    public Boolean comprobarTipoUsuario (Usuario usuario){
        if(usuario.getTipoUsuario().equals("Premium")){
            return true;
        } else{
            return false;
        }
    }
}
