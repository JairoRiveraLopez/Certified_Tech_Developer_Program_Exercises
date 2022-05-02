package com.company;

public class Tamagochi {

    private String nombre;
    private Estado estadoActual;

    public Tamagochi(String nombre) {
        this.nombre = nombre;
        estadoActual = new EstadoFeliz();
    }

    public void darDeComer(){
        estadoActual = estadoActual.comer();
    }

    public void darDeTomar(){
        estadoActual = estadoActual.beber();
    }

    public void hacerleMimos(){
        estadoActual = estadoActual.recibirMimos();
    }
}
