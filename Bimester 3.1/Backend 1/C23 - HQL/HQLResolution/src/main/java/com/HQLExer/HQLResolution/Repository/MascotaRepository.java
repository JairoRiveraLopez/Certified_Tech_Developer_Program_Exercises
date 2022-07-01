package com.HQLExer.HQLResolution.Repository;

import com.HQLExer.HQLResolution.DTOS.MascotaDTO;
import com.HQLExer.HQLResolution.Entities.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
    @Query("SELECT m FROM mascotas m WHERE m.tipo = ?1")
    Set<MascotaDTO> buscarMascotasPorTipo (String tipo);
}
