package com.HQLExer.HQLResolution.DTOS;

import com.HQLExer.HQLResolution.Entities.Mascota;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VeterinariaDTO {
    private Long id;
    private String nombre;
    private Double costo;

    private List<Mascota> mascotas;

    public VeterinariaDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getCosto() {
        return costo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
}
