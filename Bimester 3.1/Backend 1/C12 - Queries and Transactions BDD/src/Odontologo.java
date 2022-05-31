public class Odontologo {
    private Long ID;
    private String apellido;
    private String nombre;
    private String matricula;

    public Odontologo(Long id, String apellido, String nombre, String matricula) {
        this.ID = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public Long getID() {
        return ID;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public String setMatricula(String matricula) {
       return this.matricula = matricula;
    }
}
