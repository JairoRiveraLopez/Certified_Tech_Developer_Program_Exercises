package Resolucion_Ejercitacion_Claseintegradora;

public class Main {
    public static void main(String[] args) {
        Empleado EMP001 = new Empleado("Oriana", 2);
        Empleado EMP002 = new Empleado("Alberto", 4);
        Pasante PAS001 = new Pasante("Timmy");

        Afiliado AFL001 = new Afiliado("Gertrudis");
        Afiliado AFL002 = new Afiliado("Ramiro");
        Afiliado AFL003 = new Afiliado("Juan");
        Afiliado AFL004 = new Afiliado("Miranda");

        EMP001.conseguirAfiliados(AFL001);
        EMP001.conseguirAfiliados(AFL002);
        EMP002.conseguirAfiliados(AFL003);
        EMP002.conseguirAfiliados(AFL004);

        EMP001.vender();
        EMP001.vender();
        EMP001.vender();
        EMP002.vender();
        EMP002.vender();

        PAS001.vender();
        PAS001.vender();
        PAS001.vender();
        PAS001.vender();
        PAS001.vender();
        PAS001.vender();
        PAS001.vender();
        PAS001.vender();
        PAS001.vender();
        PAS001.vender();
        PAS001.vender();


        AFL001.vender();
        AFL001.vender();


        System.out.println(EMP001.categorizar());
        System.out.println(EMP002.categorizar());
        System.out.println(PAS001.categorizar());
        System.out.println(AFL001.categorizar());
    }
}
