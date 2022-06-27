package com.MVCPatternExercise.odontologo.controller;

import com.MVCPatternExercise.odontologo.domain.Odontologo;
import com.MVCPatternExercise.odontologo.services.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController

public class OdontologoController {
    private final OdontologoService odontologoService;

    @Autowired
    public OdontologoController (OdontologoService odontologoService){
        this.odontologoService = odontologoService;
    }

    @GetMapping("odontologos")
    public List<Odontologo> getOdontologos(){
        return odontologoService.listaOdontologo();
    }

}
