package com.C22Resolution.HibernateExer.Controller;


import com.C22Resolution.HibernateExer.Entities.Jugador;
import com.C22Resolution.HibernateExer.Services.IJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {
    @Autowired
    private IJugadorService jugadorService;

    @GetMapping
    public ResponseEntity<List<Jugador>> traerJugadores(){
        return ResponseEntity.ok(jugadorService.obtenerJugadores());
    }
    @PostMapping
    public ResponseEntity<Jugador> crearJugador(@RequestBody Jugador jugador){
        return ResponseEntity.ok(jugadorService.guardarJugador(jugador));
    }
}
