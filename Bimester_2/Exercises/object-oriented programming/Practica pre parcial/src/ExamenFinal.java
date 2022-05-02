public class ExamenFinal extends Examen implements Comparable{
    private Double notaOral;
    private String descripcionTemaOral;

    public ExamenFinal(String enunciado, Double nota, Double notaOral, String descripcionTemaOral) {
        super(enunciado, nota);
        this.notaOral = notaOral;
        this.descripcionTemaOral = descripcionTemaOral;
    }

    @Override
    public int compareTo(Object object){
        ExamenFinal otroExamen = (ExamenFinal) object;
        if(((this.notaOral + this.getNota()) / 2) > ((otroExamen.notaOral + otroExamen.getNota()) / 2)){
            return 1;
        }
        if(((this.notaOral + this.getNota()) / 2) < ((otroExamen.notaOral + otroExamen.getNota()) / 2)) {
            return -1;
        }
        return 0;
        }
    }
