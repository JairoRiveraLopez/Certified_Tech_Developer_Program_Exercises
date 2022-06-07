import java.io.*;
import java.util.*;


public class EmpresaBuffer {
    public static void main(String[] args) {
        List<Empleado> listaEmpleados= new ArrayList<>();

        listaEmpleados.add(new Empleado("Mercedes", "Iracheta", 98457, 100.0));
        listaEmpleados.add(new Empleado("Jairo", "Rivera", 2244, 100.0));
        listaEmpleados.add(new Empleado("Diego", "Yepes", 65643, 100.0));
        listaEmpleados.add(new Empleado("Daniel", "Arcila", 134454, 100.0));
        listaEmpleados.add(new Empleado("Cinthia", "Garrido", 434332, 100.0));

        FileOutputStream fos= null;
        try{
            fos= new FileOutputStream("EmpleadosBuffer.txt");

            BufferedOutputStream bos=new BufferedOutputStream(fos);

            for (Empleado empleado:listaEmpleados) {

                String linea=empleado.getNombre()+";"+empleado.getApellido()+";"+
                        empleado.getLegajo()+";"+empleado.getSueldo()+"\n";

                bos.write(linea.getBytes());

                System.out.println(linea);
            }
            bos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
