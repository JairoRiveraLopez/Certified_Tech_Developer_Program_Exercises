package com.DHC35.Resolution.Service.Impl;

import com.DHC35.Resolution.Entities.Turno;
import com.DHC35.Resolution.Repository.ITurnoRepository;
import com.DHC35.Resolution.Service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServiceImpl implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;

    @Override
    public Turno guardarTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public List<Turno> listarTurnos() {
        return turnoRepository.findAll();
    }
}
