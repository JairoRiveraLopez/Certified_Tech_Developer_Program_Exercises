import java.util.Date;

public class Main {

    public static void main(String[] args) {

        try {
            Paciente paciente=new Paciente("Juan","Perez",null ,new Date(2022, 5, 2));
            paciente.setFechaAlta(new Date (2021, 5, 3));
            paciente.darAlta();
        } catch (PacienteException e) {
            e.printStackTrace();
        }



    }
}
