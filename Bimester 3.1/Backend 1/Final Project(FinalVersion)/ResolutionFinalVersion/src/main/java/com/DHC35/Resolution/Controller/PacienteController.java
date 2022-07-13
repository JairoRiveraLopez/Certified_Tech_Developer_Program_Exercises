package com.DHC35.Resolution.Controller;

import com.DHC35.Resolution.Entities.Paciente;
import com.DHC35.Resolution.Exceptions.BadRequestException;
import com.DHC35.Resolution.Service.IPacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    private static final Logger logger = Logger.getLogger(PacienteController.class);
    @Autowired
    private IPacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> traerPacientes() throws BadRequestException{
        List<Paciente> pacienteLista = pacienteService.listarPacientes();
        if(pacienteLista.isEmpty()){
            logger.error("Error tratando de listar los pacientes");
            throw new BadRequestException("Error. No se pudo traer la lista de pacientes.");
        } else {
            return ResponseEntity.ok(pacienteLista);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> traerPacientePorId(@PathVariable Long id) throws BadRequestException {
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPacienteXId(id);
        if(pacienteBuscado.isPresent()){
            return ResponseEntity.ok(pacienteBuscado.get());
        } else{
            logger.error("Error tratando de buscar paciente por id");
            throw new BadRequestException("El ID ingreso no corresponde a ningun paciente creado previamente.");
        }
    }

    @PostMapping
    public ResponseEntity<Paciente> agregarNuevoPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }

    @PutMapping
    public ResponseEntity<Paciente> actualizarPaciente(@RequestBody Paciente paciente) throws BadRequestException {
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPacienteXId(paciente.getId());
        if (pacienteBuscado.isPresent()){
            return ResponseEntity.ok(pacienteService.actualizarPaciente(paciente));
        }
        else {
            logger.error("Error tratando de modificar paciente");
            throw new BadRequestException("El paciente que intenta modificar no ha sido creado previamente.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) throws BadRequestException {
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPacienteXId(id);
        if (pacienteBuscado.isPresent()){
            pacienteService.eliminarPaciente(id);
            return ResponseEntity.ok("Se eliminó al paciente con ID = " + id + ".");
        }
        else {
            logger.error("Error tratando de eliminar paciente");
            throw new BadRequestException("El ID del paciente ingresado no existe.");
        }
    }
}
