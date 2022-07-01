package com.DHC35.Resolution.Controller;


import com.DHC35.Resolution.Entities.Paciente;
import com.DHC35.Resolution.Service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private IPacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> traerPacientes() {
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> traerPacientePorId(@PathVariable Long id){
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPacienteXId(id);
        if(pacienteBuscado.isPresent()){
            return ResponseEntity.ok(pacienteBuscado.get());
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Paciente> agregarNuevoPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }

    @PutMapping
    public ResponseEntity<Paciente> actualizarPaciente(@RequestBody Paciente paciente){
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPacienteXId(paciente.getId());
        if (pacienteBuscado.isPresent()){
            return ResponseEntity.ok(pacienteService.actualizarPaciente(paciente));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id){
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPacienteXId(id);
        if (pacienteBuscado.isPresent()){
            pacienteService.eliminarPaciente(id);
            return ResponseEntity.ok("Se eliminó al paciente con ID = " + id + ".");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se realizo la operacion. Verifique el ID ingresado.");
        }
    }
}
