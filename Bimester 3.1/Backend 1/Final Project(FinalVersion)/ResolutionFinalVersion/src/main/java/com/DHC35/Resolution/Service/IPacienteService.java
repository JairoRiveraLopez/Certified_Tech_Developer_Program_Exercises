package com.DHC35.Resolution.Service;



import com.DHC35.Resolution.Entities.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {
    List<Paciente> listarPacientes();
    Optional<Paciente> buscarPacienteXId(Long id);
    Paciente guardarPaciente(Paciente paciente);
    Paciente actualizarPaciente(Paciente paciente);
    void eliminarPaciente(Long id);
}
