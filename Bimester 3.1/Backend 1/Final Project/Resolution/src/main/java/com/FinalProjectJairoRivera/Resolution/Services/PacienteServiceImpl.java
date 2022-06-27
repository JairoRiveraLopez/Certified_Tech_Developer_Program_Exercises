package com.FinalProjectJairoRivera.Resolution.Services;

import com.FinalProjectJairoRivera.Resolution.Daos.IDao;
import com.FinalProjectJairoRivera.Resolution.Domains.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteServiceImpl implements IPacienteService{
    private IDao<Paciente> pacienteIDao;

    @Autowired
    public PacienteServiceImpl(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }
    @Override
    public List<Paciente> listarPacientes() {
        return pacienteIDao.listarElementos();
    }

    @Override
    public Paciente buscarXDNI(String DNI) {
        return pacienteIDao.buscarXCriterio(DNI);
    }

    @Override
    public Paciente buscarXId(int id) {
        return pacienteIDao.buscarXId(id);
    }

    @Override
    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteIDao.guardar(paciente);
    }

    @Override
    public Paciente actualizarPaciente(Paciente paciente){
        return pacienteIDao.actualizar(paciente);
    }

    @Override
    public void eliminarPaciente(int id) {
        pacienteIDao.eliminar(id);
    }
}
