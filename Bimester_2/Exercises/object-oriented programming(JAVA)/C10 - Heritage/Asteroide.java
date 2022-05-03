package com.company;

public class Asteroide extends Objeto{
    private Integer lesion;

    public Asteroide(Integer posx, Integer posy, String direccion, Integer lesion) {
        super(posx, posy, direccion);
        this.lesion = lesion;
    }
}
