public class PacienteParticular extends Paciente{
    private Double valorConsulta;
    private Integer DNI;

    public PacienteParticular(String fechaNacimiento, String nombre, String apellido, Boolean esPrimeraConsulta, Consulta consulta, Double valorConsulta, Integer DNI) {
        super(fechaNacimiento, nombre, apellido, esPrimeraConsulta, consulta);
        this.valorConsulta = valorConsulta;
        this.DNI = DNI;
    }
}
