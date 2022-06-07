import java.io.*;
import java.util.*;

public class Empresa {

    public static void main(String[] args) {
        List<Empleado> listaEmpleados= new ArrayList<>();

        listaEmpleados.add(new Empleado("Mercedes", "Iracheta", 98457, 100.0));
        listaEmpleados.add(new Empleado("Jairo", "Rivera", 2244, 100.0));
        listaEmpleados.add(new Empleado("Diego", "Yepes", 65643, 100.0));
        listaEmpleados.add(new Empleado("Daniel", "Arcila", 134454, 100.0));
        listaEmpleados.add(new Empleado("Cinthia", "Garrido", 434332, 100.0));

        FileOutputStream fos=null;
        try{
            fos= new FileOutputStream("EmpleadosFile.txt");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(listaEmpleados);
            oos.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        List<Empleado> empleadosGuardados=null;
        FileInputStream fis=null;

        try{
            fis=new FileInputStream("EmpleadosFile.txt");
            ObjectInputStream ois= new ObjectInputStream(fis);
            empleadosGuardados=(ArrayList)ois.readObject();
            ois.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }

        for (Empleado empleado:empleadosGuardados) {
            System.out.println("Nombre: " + empleado.getNombre() + " Apellido: " + empleado.getApellido() + " Legajo: " + empleado.getLegajo() + " Sueldo: " + empleado.getSueldo());
        }
    }
}
