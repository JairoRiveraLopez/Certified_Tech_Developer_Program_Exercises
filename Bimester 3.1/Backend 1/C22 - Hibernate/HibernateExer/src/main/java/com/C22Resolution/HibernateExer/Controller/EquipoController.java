package com.C22Resolution.HibernateExer.Controller;

import com.C22Resolution.HibernateExer.Entities.Equipo;
import com.C22Resolution.HibernateExer.Services.IEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class EquipoController {
    @Autowired
    private IEquipoService equipoService;

    @GetMapping
    public ResponseEntity<List<Equipo>> traerEquipos(){
        return ResponseEntity.ok(equipoService.obtenerEquipos());
    }
    @PostMapping
    public ResponseEntity<Equipo> crearEquipo(@RequestBody Equipo equipo){
        return ResponseEntity.ok(equipoService.guardarEquipo(equipo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarEquipo(@PathVariable long id){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<>(equipoService.eliminarEquipo(id), headers, HttpStatus.OK);
    }

}
