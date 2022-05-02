import java.util.Date;

    public class Paciente {
       private String nombre;
       private String apellido;
       private String historiaClinica;
       private Date fechaInternacion;
       private Date fechaAlta;

        public Paciente(String nombre, String apellido) {
            this.nombre = nombre;
            this.apellido = apellido;
        }

        public  Paciente(String nombre, String apellido, String historiaClinica, Date fechaInternacion)
        throws PacienteException{
            Date hoy = new Date(2022, 3, 8);
            this.nombre=nombre;
            this.apellido=apellido;
            this.fechaAlta=null;
            if (fechaInternacion.after(hoy)) {
                throw new PacienteException("La fecha de internacion no puede ser despues de la fecha presente.");
            }
            this.fechaInternacion = fechaInternacion;
        }

        public Date getFechaInternacion() {
            return fechaInternacion;
        }

        public Date getFechaAlta() {
            return fechaAlta;
        }
        public void setFechaAlta(Date fechaAlta) {
            this.fechaAlta = fechaAlta;
        }
        public void darAlta() throws PacienteException{
            setFechaAlta(fechaAlta);
            if (fechaAlta.before(fechaInternacion))
                throw new PacienteException("No se puede dar de alta porque la fecha ingresada es anterior a la fecha de internacion");

            else if(historiaClinica == null){
                throw new PacienteException("La historia clinica debe ser diligenciada para dar de alta.");
            }
            else{
                System.out.println("Paciente puede ser dato de alta");
            }
        }


    }

