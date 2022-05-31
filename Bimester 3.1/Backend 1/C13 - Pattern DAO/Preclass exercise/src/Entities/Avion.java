package Entities;

import java.sql.Date;

public class Avion {
    private Long ID;
    private String marca;
    private String modelo;
    private String matricula;
    private Date fechaEntradaServicio;

    public Avion(Long id, String marca, String modelo, String matricula, String fechaEntradaServicio) {
        this.ID = id;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.fechaEntradaServicio = Date.valueOf(fechaEntradaServicio);
    }

    public Long getID() {
        return ID;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public Date getFechaEntradaServicio() {
        return fechaEntradaServicio;
    }
}
