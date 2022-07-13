package com.DHC35.Resolution.Controller;

import com.DHC35.Resolution.Entities.Domicilio;
import com.DHC35.Resolution.Entities.Paciente;
import com.DHC35.Resolution.Service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    private IDomicilioService domicilioService;

    @GetMapping
    public ResponseEntity<List<Domicilio>> traerDomicilios() {
        return ResponseEntity.ok(domicilioService.listarDomicilios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Domicilio> traerDomicilioPorId(@PathVariable Long id){
        Optional<Domicilio> domicilioBuscado = domicilioService.buscarDomicilioXId(id);
        if(domicilioBuscado.isPresent()){
            return ResponseEntity.ok(domicilioBuscado.get());
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<Domicilio> actualizarDomicilio(@RequestBody Domicilio domicilio){
        Optional<Domicilio> domicilioBuscado = domicilioService.buscarDomicilioXId(domicilio.getId());
        if (domicilioBuscado.isPresent()){
            return ResponseEntity.ok(domicilioService.actualizarDomicilio(domicilio));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarDomicilio(@PathVariable Long id){
        Optional<Domicilio> domicilioBuscado = domicilioService.buscarDomicilioXId(id);
        if (domicilioBuscado.isPresent()){
            domicilioService.eliminarDomicilio(id);
            return ResponseEntity.ok("Se eliminó el domicilio con ID = " + id + ".");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se realizo la operacion. Verifique el ID ingresado.");
        }
    }

}
