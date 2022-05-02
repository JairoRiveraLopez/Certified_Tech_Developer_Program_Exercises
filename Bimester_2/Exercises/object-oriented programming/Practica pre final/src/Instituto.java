import java.util.ArrayList;
import java.util.List;

public class Instituto {

    private List<OfertaAcademica> formaciones;

    public Instituto() {
        formaciones = new ArrayList<>();
    }

    public void agregarFormacion(String codigo){
        try {
            formaciones.add(OfertaAcademicaFactory.getInstance().generarOfertaAcademica(codigo));
        } catch (OfertaAcademicaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void generarInforme(){
        for (OfertaAcademica ofertaAcademica : formaciones) {
            System.out.println(ofertaAcademica);
        }
    }
}
