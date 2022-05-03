package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scaner = new Scanner (System.in);
        System.out.println("Ingrese 3 números...");
        //Integer numero = scaner.nextInt();
        //esPrimo(numero);
        Integer num1 = scaner.nextInt();
        Integer num2 = scaner.nextInt();
        Integer num3 = scaner.nextInt();
        mayorNum(num1,num2, num3);

        System.out.println("ingrese dos cadenas:");
        String cad1 = scaner.nextLine();
        String cad2 = scaner.nextLine();
        comparacion(cad1, cad2);
    }
    public static boolean comparacion(String cad1, String cad2){
        if ((cad1.equals(cad2))){
            System.out.println("son iguales");
            return true;
        }else {
            System.out.println("son diferentes");
            return false;
        }

    }

    public static int mayorNum (Integer num1, Integer num2, Integer num3){
        if (num1 > num2 && num1 > num3){
            System.out.println(num1 + " Es mayor");
            return num1;
        }else if (num2 > num1 && num2 > num3) {
            System.out.println(num2 + " Es mayor");
            return num2;
        }else if (num3 > num1 && num3 > num2){
            System.out.println(num3 + " Es mayor");
            return num3;
        }
        else{
            System.out.println("Son los tre números iguales.");
            return num3;
        }
    };

    public static boolean esPrimo(Integer numero){
        if(numero == 0 || numero == 1) {
            System.out.println("No es primo");
            return false;
        }
        for (int i = 2; i < numero ; i++) {
            if (numero % i == 0){
                System.out.println("No es primoo");
                return false;
            }
        }
        System.out.println("Es primo");
        return true;
    };

}




