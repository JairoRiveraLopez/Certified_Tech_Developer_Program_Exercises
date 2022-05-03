public abstract class Paciente {
    private String fechaNacimiento;
    private String nombre;
    private String apellido;
    private Boolean esPrimeraConsulta;
    private Consulta consulta;

    public Paciente(String fechaNacimiento, String nombre, String apellido, Boolean esPrimeraConsulta, Consulta consulta) {
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.esPrimeraConsulta = esPrimeraConsulta;
        this.consulta = consulta;
    }

    public Boolean seHaceEvaluacionInicial (){
        return esPrimeraConsulta == true;
    }
}
