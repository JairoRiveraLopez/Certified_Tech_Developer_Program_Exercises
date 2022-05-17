public class Main {
    public static void main(String[] args){
        try {
            Cuadrado cuadrado = new Cuadrado(10.00);
            System.out.println(cuadrado.calcularArea());
        } catch (FiguraGeometricaException e){
            System.out.println(e);
        }

        try {
            Cuadrado cuadrado2 = new Cuadrado(-10.00);
            System.out.println(cuadrado2.calcularArea());
        } catch (FiguraGeometricaException e){
            System.out.println(e);
        }

        try {
            Cuadrado cuadrado3 = new Cuadrado(20.00);
            System.out.println(cuadrado3.calcularArea());
        } catch (FiguraGeometricaException e){
            System.out.println(e);
        }


    }
}
