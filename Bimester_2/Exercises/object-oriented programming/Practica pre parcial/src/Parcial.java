public class Parcial extends Examen {
    private Integer numeroUnidad;
    private Integer numeroIntentos;

    public Parcial(String enunciado, Double nota, Integer numeroUnidad) {
        super(enunciado, nota);
        this.numeroUnidad = numeroUnidad;
        this.numeroIntentos = 0;
    }


    public void calcularNumRecuperaciones (){

        if (this.numeroUnidad <= 3){
            System.out.println("El parcial se puede recuperar hasta 3 veces.");
            this.numeroIntentos = 3;
        } else if (this.numeroUnidad > 3){
            System.out.println("El parcial se puede recuperar hasta 2 veces.");
            this.numeroIntentos = 2;
        }
    }

    public Integer getNumeroIntentos() {
        return numeroIntentos;
    }
}
