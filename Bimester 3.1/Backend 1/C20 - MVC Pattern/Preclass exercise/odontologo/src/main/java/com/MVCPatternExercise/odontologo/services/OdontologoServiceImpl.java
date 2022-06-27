package com.MVCPatternExercise.odontologo.services;

import com.MVCPatternExercise.odontologo.domain.Odontologo;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class OdontologoServiceImpl implements OdontologoService{

    @Override
    public List<Odontologo> listaOdontologo() {
        return Arrays.asList(new Odontologo("Jairo"), new Odontologo("Alberto"));
    }
}
