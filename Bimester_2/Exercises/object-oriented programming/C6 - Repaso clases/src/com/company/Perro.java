package com.company;

public class Perro {

    private String nombre;
    private String raza;
    private Integer añoEstimadoNacimiento;
    private Double peso;
    private Boolean tieneChip;
    private Boolean estaLastimado;


    public Perro (String nombre, String raza, Integer añoEstimadoNacimiento, Double peso, Boolean tieneChip, Boolean estaLastimado){
        this.nombre = nombre;
        this.raza = raza;
        this.añoEstimadoNacimiento = añoEstimadoNacimiento;
        this.peso = peso;
        this.estaLastimado = estaLastimado;
        this.tieneChip = tieneChip;
    }

    public Perro (String nombre, String raza, Integer añoEstimadoNacimiento){
        this.nombre = nombre;
        this.raza = raza;
        this.añoEstimadoNacimiento = 0;
        this.peso = 0.0;
        this.estaLastimado = false;
        this.tieneChip = false;
    }

    public Integer edad(){
        return (2022 - this.añoEstimadoNacimiento);
    }

    public Boolean puedePerderse (){
        return this.tieneChip != true;
    }

    public Boolean puedeAdoptarse (){
        return this.peso > 5 && this.estaLastimado == false;
    }

    public String getNombre(){
        return this.nombre;
    }
}


