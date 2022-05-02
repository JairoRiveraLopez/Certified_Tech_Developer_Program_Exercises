import java.util.ArrayList;
import java.util.List;


public class Tren {
    private List<Armable> componentes;

    public Tren() {
        componentes = new ArrayList<>();
    }

    public Double calcularSuperficieTren(){
        Double superficieTotal = 0.0;

        for (Armable componente: componentes) {
            superficieTotal += componente.calcularSuperficie();
        }
        return superficieTotal;
    }
}
