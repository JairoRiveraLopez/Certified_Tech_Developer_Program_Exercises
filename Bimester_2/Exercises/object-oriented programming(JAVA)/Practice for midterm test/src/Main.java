public class Main {

    public static void main(String[] args) {
        Parcial parcialPoo = new Parcial("UML", 4.0, 4);
        ExamenFinal finalPoo = new ExamenFinal("Final", 4.5, 5.0, "Filosofia de UML");
        ExamenFinal Testing = new ExamenFinal("Final", 4.0, 4.0, "Debugging");
        parcialPoo.calcularNumRecuperaciones();

        System.out.println(Testing.compareTo(finalPoo));


    }

}
