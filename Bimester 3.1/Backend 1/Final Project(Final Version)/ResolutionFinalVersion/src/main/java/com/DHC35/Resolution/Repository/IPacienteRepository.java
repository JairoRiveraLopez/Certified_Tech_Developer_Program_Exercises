package com.DHC35.Resolution.Repository;

import com.DHC35.Resolution.Entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
}
