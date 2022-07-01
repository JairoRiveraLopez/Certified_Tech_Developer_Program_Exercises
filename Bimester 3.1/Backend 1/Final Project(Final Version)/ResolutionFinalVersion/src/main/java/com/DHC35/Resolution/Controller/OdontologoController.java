package com.DHC35.Resolution.Controller;

import com.DHC35.Resolution.Entities.Odontologo;
import com.DHC35.Resolution.Service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    private IOdontologoService odontologoService;

    @GetMapping
    public ResponseEntity<List<Odontologo>> traerOdontologos() {
        return ResponseEntity.ok(odontologoService.listarOdontologos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> traerOdontologoPorId(@PathVariable Long id){
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarOdontologoXId(id);
        if(odontologoBuscado.isPresent()){
            return ResponseEntity.ok(odontologoBuscado.get());
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Odontologo> agregarNuevoOdontologo(@RequestBody Odontologo odontologo) {
        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }

    @PutMapping
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo){
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarOdontologoXId(odontologo.getId());
        if (odontologoBuscado.isPresent()){
            return ResponseEntity.ok(odontologoService.actualizarOdontologo(odontologo));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id){
        Optional<Odontologo> pacienteBuscado = odontologoService.buscarOdontologoXId(id);
        if (pacienteBuscado.isPresent()){
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok("Se eliminó al odontologo con ID = " + id + ".");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se realizo la operacion. Verifique el ID ingresado.");
        }
    }

}
