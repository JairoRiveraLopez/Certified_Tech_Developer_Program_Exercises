package com.company;

public class Main {

    public static void main(String[] args) {

        Perro mascota1 = new Perro("Firulais", "Schnauzer", 2005, 18.0, false, true);
        Perro mascota2 = new Perro("Mia", "Criolla", 2018, 4.0, true, false);

        System.out.println(mascota1.getNombre() + " tiene " +  mascota1.edad() + " años");
        System.out.println(mascota2.getNombre() + " tiene " +  mascota2.edad() + " años");

        System.out.println("¿Puede perderse " +  mascota1.getNombre() + "?: " + mascota1.puedePerderse());
        System.out.println("¿Puede perderse " +  mascota2.getNombre() + "?: " + mascota2.puedePerderse());

        System.out.println("¿Puede adoptarse " +  mascota1.getNombre() + "?: " + mascota1.puedeAdoptarse());
        System.out.println("¿Puede adoptarse " +  mascota2.getNombre() + "?: " + mascota2.puedeAdoptarse());
    }
}
