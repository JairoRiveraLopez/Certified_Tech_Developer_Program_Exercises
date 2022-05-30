
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Paciente {
    private Long id;
    private String nombre;
    private String apellido;
    private String domicilio;
    private Integer DNI;
    private Date fechaDeAlta;
    private String usuario;
    private String password;

    public Paciente(String nombre, String apellido, String domicilio, Integer DNI, String usuario, String password, String date) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.DNI = DNI;
        this.usuario = usuario;
        this.password = password;
        this.fechaDeAlta = Date.valueOf(date);
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public Integer getDNI() {
        return DNI;
    }

    public Date getFechaDeAlta() {
        return fechaDeAlta;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String setDomicilio(String domicilio) {
        return this.domicilio = domicilio;
    }

    public void setFechaDeAlta(int anio, int mes, int dia) {
        this.fechaDeAlta = new Date(anio, mes, dia);
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
