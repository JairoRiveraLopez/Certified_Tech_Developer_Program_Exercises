package com.DHC35.Resolution.Controller;

import com.DHC35.Resolution.Entities.Odontologo;
import com.DHC35.Resolution.Entities.Paciente;
import com.DHC35.Resolution.Entities.Turno;
import com.DHC35.Resolution.Exceptions.BadRequestException;
import com.DHC35.Resolution.Service.IOdontologoService;
import com.DHC35.Resolution.Service.IPacienteService;
import com.DHC35.Resolution.Service.ITurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/turnos")
public class TurnoController {

    private static final Logger logger = Logger.getLogger(TurnoController.class);
    @Autowired
    private ITurnoService turnoService;

    @Autowired
    private IPacienteService pacienteService;

    @Autowired
    private IOdontologoService odontologoService;

    @GetMapping
    public ResponseEntity<List<Turno>> traerTurnos() throws BadRequestException{
        List<Turno> turnosLista = turnoService.listarTurnos();
        if(turnosLista.isEmpty()){
            logger.error("Error tratando de listar los turnos");
            throw new BadRequestException("Error. No se pudo traer la lista de turnos.");
        } else {
            return ResponseEntity.ok(turnosLista);
        }
    }

    @PostMapping
    public ResponseEntity<Turno> agregarTurno(@RequestBody Turno turno) throws BadRequestException {
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPacienteXId(turno.getPaciente().getId());
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarOdontologoXId(turno.getOdontologo().getId());

        if (pacienteBuscado.isPresent() && odontologoBuscado.isPresent()){
            return ResponseEntity.ok(turnoService.guardarTurno(turno));
        } else{
            logger.error("Error tratando de agregar turno");
            throw new BadRequestException("Por favor revisa tanto el ID del paciente como el ID del odontologo, ya que alguno no existe");
        }
    }
}
