package com.C22Resolution.HibernateExer.Entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "equipos")
public class Equipo {

    @Id
    @SequenceGenerator(name = "equipo_sequence",sequenceName = "equipo_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "equipo_sequence")
    private long id;

    @Column
    private String nombreEquipo;

    @Column
    private String ciudad;

    @OneToMany(mappedBy = "equipo",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Set<Jugador> jugadores = new HashSet<>();

    public long getId() {
        return id;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Set<Jugador> getAlumnos() {
        return jugadores;
    }

    public void setAlumnos(Set<Jugador> alumnos) {
        this.jugadores = alumnos;
    }
}
