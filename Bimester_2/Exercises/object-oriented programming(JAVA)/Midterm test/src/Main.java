public class Main {
    public static void main(String[] args) {
        Persona jairo = new Persona("Jairo", "Rivera", 12167395, 25);
        TituloTerciario filosofia = new TituloTerciario(jairo, 2, "30/09/2021", "30/09/2022", true, true, "NACIONAL");
        TituloLicenciatura titulo1 = new TituloLicenciatura(jairo, 2, "30/09/2021", "30/09/2022", false, false, "Backend", "30/09/2022", 7);
        TituloLicenciatura titulo2 = new TituloLicenciatura(jairo, 2, "30/09/2021", "30/09/2022", false, false, "Backend", "30/09/2022", 6);

        System.out.println(filosofia.esNacional());
        System.out.println(titulo1.compareTo(titulo2));
        System.out.println(filosofia.puedeEjercer());
    }
}
