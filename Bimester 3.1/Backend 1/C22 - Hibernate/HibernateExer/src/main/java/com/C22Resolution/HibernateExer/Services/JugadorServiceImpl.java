package com.C22Resolution.HibernateExer.Services;

import com.C22Resolution.HibernateExer.Entities.Jugador;
import com.C22Resolution.HibernateExer.Repository.IJugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorServiceImpl implements IJugadorService {

    @Autowired
    private IJugadorRepository jugadorRepository;

    @Override
    public Jugador guardarJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    @Override
    public List<Jugador> obtenerJugadores() {
        return jugadorRepository.findAll();
    }
}
