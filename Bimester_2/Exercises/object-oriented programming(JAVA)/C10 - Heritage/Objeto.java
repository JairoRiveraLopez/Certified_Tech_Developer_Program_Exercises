package com.company;

public class Objeto {
    private Integer posx;
    private  Integer posy;
    private String direccion;

    public Objeto(Integer posx, Integer posy, String direccion) {
        this.posx = posx;
        this.posy = posy;
        this.direccion = direccion;
    }

    public void irA(Integer x, Integer y, String direccion){
        switch (direccion){
            case "N" :
                this.posy += y;
                break;
            case "S" :
                this.posy -= y;
                break;
            case "E" :
                this.posx += x;
                break;
            case "O" :
                this.posx -= x;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + direccion);
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
