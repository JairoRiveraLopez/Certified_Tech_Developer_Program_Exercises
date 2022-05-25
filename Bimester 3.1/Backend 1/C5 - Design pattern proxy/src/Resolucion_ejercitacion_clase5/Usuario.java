package Resolucion_ejercitacion_clase5;

public class Usuario {
    private Integer identificador;
    private String tipoUsuario;

    public Usuario(Integer identificador, String tipoUsuario) {
        this.identificador = identificador;
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

}
