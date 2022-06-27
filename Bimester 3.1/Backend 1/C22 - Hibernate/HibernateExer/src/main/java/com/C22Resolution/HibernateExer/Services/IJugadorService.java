package com.C22Resolution.HibernateExer.Services;

import com.C22Resolution.HibernateExer.Entities.Jugador;

import java.util.List;

public interface IJugadorService {
    Jugador guardarJugador(Jugador jugador);
    List<Jugador> obtenerJugadores();
}
