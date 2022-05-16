import java.util.Calendar;

public class Persona {
    private String nombre;
    private String apellido;
    private Integer anioNacimiento;

    public Persona(String nombre, String apellido, Integer anioNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.anioNacimiento = anioNacimiento;
    }

    public String getNombreCompleto() {
        return apellido + ", " + nombre;
    }

    public boolean esMayorDeEdad(){
        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        if ((anioActual - anioNacimiento) > 18) {
            return true;
        }
        return false;
    }
}
