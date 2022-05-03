public abstract class Examen {
    private String enunciado;
    private Double nota;


    public Examen(String enunciado, Double nota) {
        this.enunciado = enunciado;
        this.nota = nota;
    }

    public boolean esAprobado(){
        return nota >= 4;
    }

    public Double getNota() {
        return nota;
    }
}
