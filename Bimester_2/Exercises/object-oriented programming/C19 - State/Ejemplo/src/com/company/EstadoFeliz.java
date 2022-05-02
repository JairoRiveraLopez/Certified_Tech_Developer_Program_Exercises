package com.company;

public class EstadoFeliz implements Estado {


    @Override
    public Estado comer() {
        System.out.println("me dieron de comer estando feliz ahora tengo sed");
        return new EstadoSediento();
    }

    @Override
    public Estado beber() {
        System.out.println("me dieron de tomar estando feliz ahora tengo hambre");

        return new EstadoHambriento();
    }

    @Override
    public Estado recibirMimos() {

        System.out.println("gracias por los mimos nada cambio");

        return this;
    }
}
