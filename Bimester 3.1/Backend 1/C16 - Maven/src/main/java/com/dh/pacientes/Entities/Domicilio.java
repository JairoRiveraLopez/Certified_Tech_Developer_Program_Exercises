package com.dh.pacientes.Entities;

public class Domicilio {
    private Integer domicilio_id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;

    public Domicilio(Integer id, String calle, Integer numero, String localidad, String provincia) {
        this.domicilio_id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Domicilio(String calle, Integer numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Integer getDomicilio_id() {
        return domicilio_id;
    }

    public void setDomicilio_id(Integer domicilio_id) {
        this.domicilio_id = domicilio_id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
