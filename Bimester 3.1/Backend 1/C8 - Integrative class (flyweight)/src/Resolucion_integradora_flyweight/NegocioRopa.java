package Resolucion_ejercitacionmesasclaseintegradora_flyweight;

import java.util.ArrayList;
import java.util.List;

public class NegocioRopa {
    private List<Ropa> listaTallaXS;
    private List<Ropa> listaTallaS;
    private List<Ropa> listaTallaM;
    private List<Ropa> listaRopaImportada;
    private List<Ropa> listaRopaEnMalasCondiciones;

    public NegocioRopa() {
        this.listaTallaXS = new ArrayList<>();
        this.listaTallaS = new ArrayList<>();
        this.listaTallaM = new ArrayList<>();
        this.listaRopaImportada = new ArrayList<>();
        this.listaRopaEnMalasCondiciones = new ArrayList<>();
    }

    public void agregarALista(Ropa ropa){

        if(ropa.getEsImportada()){
            listaRopaImportada.add(ropa);
        }

        if(ropa.getEstaDeteriorada()){
            listaRopaEnMalasCondiciones.add(ropa);
        }

        switch (ropa.getTalla()) {
            case "XS" -> listaTallaXS.add(ropa);
            case "S" -> listaTallaS.add(ropa);
            case "M" -> listaTallaM.add(ropa);
        }
    }

    public List<Ropa> getListaTallaXS() {
        return listaTallaXS;
    }

    public List<Ropa> getListaTallaS() {
        return listaTallaS;
    }

    public List<Ropa> getListaTallaM() {
        return listaTallaM;
    }

    public List<Ropa> getListaRopaImportada() {
        return listaRopaImportada;
    }

    public List<Ropa> getListaRopaEnMalasCondiciones() {
        return listaRopaEnMalasCondiciones;
    }

    public void mostrarContenidoLista (List<Ropa> listaX){
        for (Ropa r: listaX) {
            System.out.println("Talla: " + r.getTalla() + ". Tipo: " + r.getTipo() + ". esImportada : " + r.getEsImportada() + ". estaDeteriorada : " + r.getEstaDeteriorada() + ".");
        }
    }
}
