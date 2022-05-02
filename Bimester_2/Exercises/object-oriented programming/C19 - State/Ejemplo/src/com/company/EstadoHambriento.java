package com.company;

public class EstadoHambriento implements Estado {


    @Override
    public Estado comer() {
        System.out.println("gracias por la comida me puse feliz");

        return new EstadoFeliz();
    }

    @Override
    public Estado beber() {
        System.out.println("me dieron de tomar estando hambriento me puse triste");

        return new EstadoTriste();
    }

    @Override
    public Estado recibirMimos() {
        System.out.println("gracias por los mimos nada cambio");

        return this;
    }
}
