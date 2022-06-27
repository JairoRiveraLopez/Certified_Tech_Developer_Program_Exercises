package com.FinalProjectJairoRivera.Resolution.Controllers;

import com.FinalProjectJairoRivera.Resolution.Domains.Domicilio;
import com.FinalProjectJairoRivera.Resolution.Services.DomicilioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/domicilios")
public class DomiciliosController {
    private DomicilioServiceImpl domicilioService;

    @Autowired
    public DomiciliosController(DomicilioServiceImpl domicilioService) {
        this.domicilioService = domicilioService;
    }

    @GetMapping
    public List<Domicilio> traerDomicilios() {
        return domicilioService.listarDomicilios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Domicilio> traerDomicilioPorId(@PathVariable int id){
        if (domicilioService.buscarXId(id)!=null){
            return ResponseEntity.ok(domicilioService.buscarXId(id));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<Domicilio> actualizarDomicilio(@RequestBody Domicilio domicilio){
        if (domicilioService.buscarXId(domicilio.getId())!=null){
            return ResponseEntity.ok(domicilioService.actualizarDomicilio(domicilio));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/borrarDomicilio/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable int id){
        if (domicilioService.buscarXId(id)!=null){
            domicilioService.eliminarDomicilio(id);
            return ResponseEntity.ok("Se eliminó el domicilio con Id = " + id +".");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
