package com.DHC35.Resolution.Controller;


import com.DHC35.Resolution.Entities.Odontologo;
import com.DHC35.Resolution.Exceptions.BadRequestException;
import com.DHC35.Resolution.Service.IOdontologoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/odontologos")
public class OdontologoController {
    private static final Logger logger = Logger.getLogger(OdontologoController.class);
    @Autowired
    private IOdontologoService odontologoService;


    @GetMapping
    public ResponseEntity<List<Odontologo>> traerOdontologos() throws BadRequestException{
        List<Odontologo> odontologoLista = odontologoService.listarOdontologos();
        if(odontologoLista.isEmpty()){
            logger.error("Error tratando de listar los odontologos");
            throw new BadRequestException("Error. No se pudo traer la lista de odontólogos.");
        } else {
            return ResponseEntity.ok(odontologoLista);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> traerOdontologoPorId(@PathVariable Long id) throws BadRequestException {
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarOdontologoXId(id);
        if(odontologoBuscado.isPresent()){
            return ResponseEntity.ok(odontologoBuscado.get());
        } else{
            logger.error("Error tratando de buscar odontologo por id");
            throw new BadRequestException("El ID del odontólogo ingresado no existe.");
        }
    }

    @PostMapping
    public ResponseEntity<Odontologo> agregarNuevoOdontologo(@RequestBody Odontologo odontologo) {
        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }

    @PutMapping
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo) throws BadRequestException {
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarOdontologoXId(odontologo.getId());
        if (odontologoBuscado.isPresent()){
            return ResponseEntity.ok(odontologoService.actualizarOdontologo(odontologo));
        }
        else {
            logger.error("Error tratando de modificar odontologo");
            throw new BadRequestException("El odontólogo que intenta modificar no ha sido creado previamente.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) throws BadRequestException {
        Optional<Odontologo> pacienteBuscado = odontologoService.buscarOdontologoXId(id);
        if (pacienteBuscado.isPresent()){
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok("Se eliminó al odontologo con ID = " + id + ".");
        }
        else {
            logger.error("Error tratando de eliminar odontologo");
            throw new BadRequestException("El ID del odontólogo ingresado no existe.");
        }
    }

}
