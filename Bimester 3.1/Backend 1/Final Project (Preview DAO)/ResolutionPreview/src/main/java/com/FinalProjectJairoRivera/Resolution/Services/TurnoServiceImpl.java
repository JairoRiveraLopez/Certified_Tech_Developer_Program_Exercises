package com.FinalProjectJairoRivera.Resolution.Services;


import com.FinalProjectJairoRivera.Resolution.Daos.IDao;
import com.FinalProjectJairoRivera.Resolution.Domains.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoServiceImpl implements ITurnoService {

    private IDao<Turno> turnoIDao;

    @Autowired
    public TurnoServiceImpl(IDao<Turno> turnoIDao) {
        this.turnoIDao = turnoIDao;
    }

    @Override
    public Turno guardarTurno(Turno turno) {
        return turnoIDao.guardar(turno);
    }

    @Override
    public List<Turno> listarTurnos() {
        return turnoIDao.listarElementos();
    }

    @Override
    public Turno buscarTurnoXId(int id) {
        return turnoIDao.buscarXId(id);
    }

    @Override
    public Turno buscarTurnoXFecha(String fecha) {
        return turnoIDao.buscarXCriterio(fecha);
    }

    @Override
    public Turno actualizarTurno(Turno turno) {
        return turnoIDao.actualizar(turno);
    }

    @Override
    public void eliminarTurno(int id) {
        turnoIDao.eliminar(id);
    }
}