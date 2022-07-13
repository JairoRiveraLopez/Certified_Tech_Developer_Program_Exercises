package com.DHC35.Resolution.Service;

import com.DHC35.Resolution.Entities.Paciente;
import com.DHC35.Resolution.Entities.Turno;

import java.util.List;
import java.util.Optional;

public interface ITurnoService {
    Turno guardarTurno(Turno turno);
    List<Turno> listarTurnos();
}
