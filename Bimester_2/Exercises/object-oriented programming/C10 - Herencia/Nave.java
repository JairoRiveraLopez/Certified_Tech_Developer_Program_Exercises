package com.company;

public class Nave extends Objeto{
    private double velocidad;
    private Integer vida = 100;

    public Nave(Integer posx, Integer posy, String direccion, double velocidad) {
        super(posx, posy, direccion);
        this.velocidad = velocidad;
    }

    public void girar(String direccion){
        super.setDireccion(direccion);
    }

    public Integer restaVida(Integer daño){
        return this.vida -= daño;
    }
}
