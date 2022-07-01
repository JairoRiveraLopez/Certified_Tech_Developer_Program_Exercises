package com.MongoDB.ResolutionC38.Controller;



import com.MongoDB.ResolutionC38.Model.Estado;
import com.MongoDB.ResolutionC38.Model.Partido;
import com.MongoDB.ResolutionC38.Service.IPartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController {
    @Autowired
    private IPartidoService partidoService;

    @GetMapping
    public ResponseEntity<List<Partido>> traerPartidos() {
        return ResponseEntity.ok(partidoService.listarPartidos());
    }

    @GetMapping("/estado")
    public ResponseEntity<List<Partido>> traerPartidosPorEstado(Estado estado){
        return ResponseEntity.ok(partidoService.buscarPartidoPorEstado(Estado.EN_VIVO));
    }

    @PostMapping
    public ResponseEntity<Partido> agregarPartido(@RequestBody Partido partido){
        return ResponseEntity.ok(partidoService.guardarPartido(partido));
    }
}
