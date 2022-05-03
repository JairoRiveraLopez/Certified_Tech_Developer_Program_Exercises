package com.company;

public class EstadoSediento implements Estado {


    @Override
    public Estado comer() {
        System.out.println("me dieron de comer estando sediento me puse triste");

        return new EstadoTriste();
    }

    @Override
    public Estado beber() {

        System.out.println("gracias por la bebida ya estoy feliz");

        return new EstadoFeliz();
    }

    @Override
    public Estado recibirMimos() {
        System.out.println("gracias por los mimos nada cambio");

        return this;
    }
}
