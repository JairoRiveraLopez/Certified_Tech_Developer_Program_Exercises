import java.io.*;
import java.util.*;

public class Programa {
    public static void main(String[] args) {
        List<Contacto> contactos = new ArrayList<>();

        contactos.add(new Contacto("Ketty", "kettypineda@digitalhouse.com", 3589651));
        contactos.add(new Contacto("Federico", "federicomarin@digitalhouse.com", 75673435));
        contactos.add(new Contacto("Pablo", "pablopantoleo@digitalhouse.com", 43273435));

        FileOutputStream fos=null;
        try{
            fos= new FileOutputStream("ContactosFile.txt");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(contactos);
            oos.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        List<Contacto> contactosRecuperados=null;
        FileInputStream fis=null;

        try{
            fis=new FileInputStream("ContactosFile.txt");
            ObjectInputStream ois= new ObjectInputStream(fis);
            contactosRecuperados=(ArrayList)ois.readObject();
            ois.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }

        for (Contacto contacto:contactosRecuperados) {
            System.out.println("Nombre: " + contacto.getNombre() + " Email: " + contacto.getEmail() + " Telefono: " + contacto.getTelefono());
        }

    }
}
