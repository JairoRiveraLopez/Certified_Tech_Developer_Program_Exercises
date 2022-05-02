import java.util.ArrayList;
import java.util.List;

public class FiguraGeometricaComposite {
    private List<Armable> figurasGeometricas;

    public FiguraGeometricaComposite() {
        figurasGeometricas = new ArrayList<>();
    }

    public void agregarFiguras (Armable armable){
        figurasGeometricas.add(armable);

    }

    public Double calcularSuperficie(){
        Double AreaConjuntoFiguras = 0.0;

        for (Armable figura: figurasGeometricas) {
            AreaConjuntoFiguras += figura.calcularSuperficie();
        }
        return AreaConjuntoFiguras;
    }
}
