package Resolucion_ejercitacionmesas_patronfacade;

import java.time.LocalDate;

public class Hotel {
    private LocalDate fechaSalida;
    private LocalDate fechaRegreso;
    private String ciudad;
    private Integer habitacionesDisponibles;

    public Hotel(String ciudad, int diaSalida, int mesSalida, int anioSalida, int diaRegreso, int mesRegreso, int anioRegreso, Integer habitacionesDisponibles) {
        this.habitacionesDisponibles = habitacionesDisponibles;
        this.fechaSalida = LocalDate.of(anioSalida, mesSalida, diaSalida);
        this.fechaRegreso = LocalDate.of(anioRegreso, mesRegreso, diaRegreso);
        this.ciudad = ciudad;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public LocalDate getFechaRegreso() {
        return fechaRegreso;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Integer getHabitacionesDisponibles() {
        return habitacionesDisponibles;
    }
}
