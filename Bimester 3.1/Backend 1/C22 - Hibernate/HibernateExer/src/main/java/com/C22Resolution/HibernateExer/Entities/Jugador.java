package com.C22Resolution.HibernateExer.Entities;

import javax.persistence.*;

@Entity
@Table(name = "jugadores")

public class Jugador {

    @Id
    @SequenceGenerator(name = "jugador_sequence",sequenceName = "jugador_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "jugador_sequence")
    private long id;

    @Column
    private String nombre;

    @Column
    private String puesto;

    @Column
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    public Jugador() {
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
