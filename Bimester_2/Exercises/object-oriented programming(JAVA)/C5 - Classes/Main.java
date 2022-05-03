package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    UsuarioJuego usuarioJuego1 = new UsuarioJuego("Jairo", "jr1234", 0.0, 0 );

    UsuarioJuego usuarioJuego2 = new UsuarioJuego("Angela", "al1234", 0.0, 0);

        System.out.println(usuarioJuego1.getNombre());
        System.out.println(usuarioJuego2.getNombre());
        System.out.println(usuarioJuego1.getClave());
        System.out.println(usuarioJuego1.getNivel());
        System.out.println(usuarioJuego1.getPuntaje());


        usuarioJuego1.aumentarPuntaje();
        usuarioJuego1.subirNivel();
        System.out.println(usuarioJuego1.getPuntaje());
        System.out.println(usuarioJuego1.getNivel());


        usuarioJuego1.bonus(10);
        System.out.println(usuarioJuego1.getPuntaje());


        usuarioJuego2.aumentarPuntaje();
        usuarioJuego2.subirNivel();
        System.out.println(usuarioJuego2.getPuntaje());
        System.out.println(usuarioJuego2.getNivel());


        usuarioJuego2.bonus(10);
        System.out.println(usuarioJuego2.getPuntaje());



    }
}
