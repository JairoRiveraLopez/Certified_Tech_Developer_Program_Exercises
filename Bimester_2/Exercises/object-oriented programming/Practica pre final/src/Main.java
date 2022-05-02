public class Main {
    public static void main(String[] args) {
        Instituto DH = new Instituto();

        DH.agregarFormacion(OfertaAcademicaFactory.FRONT_END);
        DH.agregarFormacion(OfertaAcademicaFactory.BACK_END);

        DH.agregarFormacion(OfertaAcademicaFactory.FULL_STACK);

        DH.agregarFormacion("Data Analysis");

        DH.generarInforme();
    }
}
