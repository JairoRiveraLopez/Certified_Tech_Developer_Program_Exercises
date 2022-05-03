import java.util.ArrayList;
import java.util.List;


public class ProgramaIntensivo extends OfertaAcademica{
    private Double descuento;
    private List<OfertaAcademica> ofertasAcademicas;

    public ProgramaIntensivo(String nombre, String apellido, Double descuento) {
        super(nombre, apellido);
        this.descuento = descuento;
        ofertasAcademicas = new ArrayList<>();
    }

    public void agregarOfertaAcademica(OfertaAcademica ofertaAcademica){
        ofertasAcademicas.add(ofertaAcademica);
    }


    @Override
    public Double calcularPrecio() {
        Double precioFinal = 0.0;

        for (OfertaAcademica ofertaAcademica: ofertasAcademicas) {
            precioFinal += ofertaAcademica.calcularPrecio();
        }

        return precioFinal - (precioFinal * descuento);
    }
}
