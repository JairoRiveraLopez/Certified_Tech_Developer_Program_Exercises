package com.company;

public class EstadoTriste implements Estado {


    @Override
    public Estado comer() {
        System.out.println("no quiero comida estoy triste");
        return this;
    }

    @Override
    public Estado beber() {
        System.out.println("no quiero bebida estoy triste");

        return this;
    }

    @Override
    public Estado recibirMimos() {
        System.out.println("ahora toy feliz");

        return new EstadoFeliz();
    }
}
