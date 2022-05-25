package Resolucion_ejercitacionmesas_patronfacade;

import java.time.LocalDate;

public class Vuelo {
    private LocalDate fechaSalida;
    private LocalDate fechaRegreso;
    private String ciudadOrigen;
    private String ciudadDestino;
    private Integer sillasDisponibles;

    public Vuelo(String ciudadOrigen, String ciudadDestino, int diaSalida, int mesSalida, int anioSalida, int diaRegreso, int mesRegreso, int anioRegreso, Integer sillasDisponibles) {
        this.sillasDisponibles = sillasDisponibles;
        this.fechaSalida = LocalDate.of(anioSalida, mesSalida, diaSalida);
        this.fechaRegreso = LocalDate.of(anioRegreso, mesRegreso, diaRegreso);
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public LocalDate getFechaRegreso() {
        return fechaRegreso;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public Integer getSillasDisponibles() {
        return sillasDisponibles;
    }
}
