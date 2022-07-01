package com.FinalProjectJairoRivera.Resolution.Services;

import com.FinalProjectJairoRivera.Resolution.Domains.Turno;

import java.util.List;

public interface ITurnoService {
    Turno guardarTurno(Turno turno);
    List<Turno> listarTurnos();
    Turno buscarTurnoXId(int id);
    Turno buscarTurnoXFecha(String fecha);
    Turno actualizarTurno(Turno turno);
    void eliminarTurno(int id);
}
