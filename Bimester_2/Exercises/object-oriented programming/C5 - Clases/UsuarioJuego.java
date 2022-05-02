package com.company;

public class UsuarioJuego{
    //atributos
    private String nombre;
    private String clave;
    private Double puntaje;
    private Integer nivel;

    //constructor
   public UsuarioJuego (String nombre, String clave, Double puntaje, Integer nivel){
       this.nombre = nombre;
       this.clave = clave;
       this.puntaje = 0.0;
       this.nivel = 0;
   }

    //metodos
   public void aumentarPuntaje() {
       this.puntaje++;
   }

   public void subirNivel(){
       this.nivel++;
   }

   public void bonus(Integer valor) {
       if (valor > 0) {
           System.out.println(" El puntaje actual del usuario es " + puntaje);
           this.puntaje += valor;
           System.out.println(" El nuevo puntaje es " + puntaje);
       } else {
           System.out.println("valor invalido");
       }
   }

   public String getNombre(){
       return nombre;
   }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave(){
       return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Double getPuntaje(){
       return  puntaje;
    }

    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }

    public Integer getNivel(){
       return  nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}

