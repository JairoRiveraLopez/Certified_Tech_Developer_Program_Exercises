package com.FinalProjectJairoRivera.Resolution.Controllers;

import com.FinalProjectJairoRivera.Resolution.Domains.Paciente;
import com.FinalProjectJairoRivera.Resolution.Services.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
    private PacienteServiceImpl pacienteService;

    @Autowired
    public PacienteController(PacienteServiceImpl pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<Paciente> traerPacientes() {
        return pacienteService.listarPacientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> traerPacientePorId(@PathVariable int id){
        if (pacienteService.buscarXId(id)!=null){
            return ResponseEntity.ok(pacienteService.buscarXId(id));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/buscarXDNI")
    @ResponseBody
    public Paciente traerPacienteXDNI(@RequestParam("DNI") String DNI){
        Paciente paciente=pacienteService.buscarXDNI(DNI);
        return paciente;
    }

    @PostMapping("/agregarPaciente")
    public Paciente agregarNuevoPaciente(@RequestBody Paciente paciente) {
        return pacienteService.guardarPaciente(paciente);
    }

    @PutMapping
    public ResponseEntity<Paciente> actualizarPaciente(@RequestBody Paciente paciente){
        if (pacienteService.buscarXId(paciente.getId())!=null){
            return ResponseEntity.ok(pacienteService.actualizarPaciente(paciente));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/borrarPaciente/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable int id){
        if (pacienteService.buscarXId(id)!=null){
            pacienteService.eliminarPaciente(id);
            return ResponseEntity.ok("Se eliminó al paciente con Id = " + id + ".");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
