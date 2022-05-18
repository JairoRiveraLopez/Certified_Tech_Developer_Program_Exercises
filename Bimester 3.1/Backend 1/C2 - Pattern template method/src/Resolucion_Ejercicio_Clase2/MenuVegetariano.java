package Resolucion_Ejercicio_Clase2;

public class MenuVegetariano extends Menu{
    private Boolean tieneEspecias;
    private Integer cantidadSalsas;

    public MenuVegetariano(Double precioBase, Boolean tieneEspecias, Integer cantidadSalsas) {
        super(precioBase);
        this.tieneEspecias = tieneEspecias;
        this.cantidadSalsas = cantidadSalsas;
    }

    public Boolean getTieneEspecias() {
        return tieneEspecias;
    }

    public void setTieneEspecias(Boolean tieneEspecias) {
        this.tieneEspecias = tieneEspecias;
    }

    public Integer getCantidadSalsas() {
        return cantidadSalsas;
    }

    public void setCantidadSalsas(Integer cantidadSalsas) {
        this.cantidadSalsas = cantidadSalsas;
    }
}
