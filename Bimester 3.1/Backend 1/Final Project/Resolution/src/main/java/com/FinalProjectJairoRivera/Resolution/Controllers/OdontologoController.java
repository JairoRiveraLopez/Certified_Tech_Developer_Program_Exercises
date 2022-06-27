package com.FinalProjectJairoRivera.Resolution.Controllers;

import com.FinalProjectJairoRivera.Resolution.Domains.Odontologo;
import com.FinalProjectJairoRivera.Resolution.Services.OdontologoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private OdontologoServiceImpl odontologoService;

    @Autowired
    public OdontologoController(OdontologoServiceImpl odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping
    public List<Odontologo> traerOdontologos() {
        return odontologoService.listaOdontologos();
    }

    @GetMapping("/{id}")
    public Odontologo traerOdontologoPorId(@PathVariable int id){
        return odontologoService.buscarXId(id);
    }

    @GetMapping("/odontologoXMatricula")
    public Odontologo traerOdontologoXMatricula(@RequestParam String matricula){
        Odontologo odontologo=odontologoService.buscarXMatricula(matricula);
        return odontologo;
    }

    @PostMapping
    public ResponseEntity<Odontologo> registrarNuevoOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }

    @GetMapping("/traerListaOdontologos")
    public ResponseEntity<List<Odontologo>> buscarOdontologos(){
        return ResponseEntity.ok(odontologoService.listaOdontologos());
    }

    @PutMapping
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo){
        if (odontologoService.buscarXId(odontologo.getId())!=null){
            return ResponseEntity.ok(odontologoService.actualizarOdontologo(odontologo));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/eliminarOdontologo/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable int id){
        if (odontologoService.buscarXId(id)!=null){
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok("Se eliminó el odontólogo con id=" + id + ".");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo" +
                    "eliminar al odontólogo con id = " + id +" al no ser encontrado");
        }
    }

}
