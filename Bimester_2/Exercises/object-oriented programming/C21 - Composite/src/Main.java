public class Main {

    public static void main(String[] args) {
        Rectangulo rec1 = new Rectangulo(5.0, 4.0);
        Circulo cir1 = new Circulo(1.0);


        System.out.println("La superficie del rectangulo1 es: " + rec1.calcularSuperficie());
        System.out.println("La superficie del circulo1 es: " +cir1.calcularSuperficie());


        FiguraGeometricaComposite Vagon1 = new FiguraGeometricaComposite();


        Vagon1.agregarFiguras(rec1);
        Vagon1.agregarFiguras(cir1);
        Vagon1.agregarFiguras(cir1);
        Vagon1.agregarFiguras(cir1);

        System.out.println("La superficie del Vagon1 es: " + Vagon1.calcularSuperficie());


    }
}
