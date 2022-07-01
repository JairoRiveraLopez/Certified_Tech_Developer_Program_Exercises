package com.FinalProjectJairoRivera.Resolution.Services;

import com.FinalProjectJairoRivera.Resolution.Domains.Paciente;

import java.util.List;

public interface IPacienteService {
    List<Paciente> listarPacientes();
    Paciente buscarXDNI(String DNI);
    Paciente buscarXId(int id);
    Paciente guardarPaciente(Paciente paciente);
    Paciente actualizarPaciente(Paciente paciente);
    void eliminarPaciente(int id);
}
