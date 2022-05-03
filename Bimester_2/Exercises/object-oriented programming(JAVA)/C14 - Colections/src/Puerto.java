import java.util.ArrayList;
import java.util.List;

public class Puerto {

    private List<Contenedor> contenedores;

    public Puerto() {
        contenedores = new ArrayList<>();
    }

    public void addContenedor (Contenedor contenedor){
        contenedores.add(contenedor);
    }

    public void mostrarContenedores(){
        contenedores.sort(null);
        for (Contenedor contenedor : contenedores) {
            System.out.println("id: " + contenedor.getNumeroId()+ ", " + "PaisProcedencia : " + contenedor.getPaisProcedencia());
        }
    }

    public Integer calcularContenedoresPeligrosos(){
        Integer contadorContenedoresPeligrosos = 0;
        for (Contenedor contenedor : contenedores) {
            if(contenedor.getContieneMaterialPeligroso() == true && contenedor.getPaisProcedencia() == "Desconocida") {
                contadorContenedoresPeligrosos++;
            }
        }
        return contadorContenedoresPeligrosos;
    }
}
