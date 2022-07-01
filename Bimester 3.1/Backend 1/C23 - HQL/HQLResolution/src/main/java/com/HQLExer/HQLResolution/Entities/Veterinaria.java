package com.HQLExer.HQLResolution.Entities;

import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "veterinarias")
public class Veterinaria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private Double costo;

    @OneToMany(mappedBy = "veterinaria", fetch = FetchType.LAZY)
    private Set<Mascota> mascotas;

    public Veterinaria() {
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Set<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(Set<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
