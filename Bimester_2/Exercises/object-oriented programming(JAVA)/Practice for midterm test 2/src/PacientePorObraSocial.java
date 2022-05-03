public class PacientePorObraSocial extends Paciente implements Comparable{
    private String nombreObraSocial;
    private Integer numeroAsociado;

    public PacientePorObraSocial(String fechaNacimiento, String nombre, String apellido, Boolean esPrimeraConsulta, Consulta consulta, String nombreObraSocial, Integer numeroAsociado) {
        super(fechaNacimiento, nombre, apellido, esPrimeraConsulta, consulta);
        this.nombreObraSocial = nombreObraSocial;
        this.numeroAsociado = numeroAsociado;
    }

    @Override
    public int compareTo(Object object) {

        PacientePorObraSocial otroPaciente = (PacientePorObraSocial) object;

        if(this.numeroAsociado > otroPaciente.numeroAsociado){
            return 1;
        }
        if (this.numeroAsociado < otroPaciente.numeroAsociado){
            return -1;
        }
        return 0;
    }
}
