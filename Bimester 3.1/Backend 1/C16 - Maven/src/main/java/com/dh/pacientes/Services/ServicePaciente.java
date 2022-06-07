package com.dh.pacientes.Services;


import com.dh.pacientes.DAO.IDao;
import com.dh.pacientes.Entities.Paciente;

import java.util.List;

public class ServicePaciente {
    private IDao<Paciente> pacienteIdao;

    public ServicePaciente() {
    }

    public IDao<Paciente> getPacienteIdao() {
        return pacienteIdao;
    }

    public void setPacienteIdao(IDao<Paciente> pacienteIdao) {
        this.pacienteIdao = pacienteIdao;
    }

    public Paciente guardarPaciente(Paciente p){
        pacienteIdao.guardar(p);
        return p;
    }

    public void eliminarPaciente(Integer id){
        pacienteIdao.eliminar(id);
    }

    public Paciente buscarPaciente(Integer id){
        return pacienteIdao.buscar(id);
    }

    public List<Paciente> buscarTodos(){
        return pacienteIdao.buscarTodos();
    }


}
