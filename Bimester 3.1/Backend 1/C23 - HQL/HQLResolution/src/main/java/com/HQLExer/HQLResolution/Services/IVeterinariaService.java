package com.HQLExer.HQLResolution.Services;

import com.HQLExer.HQLResolution.DTOS.VeterinariaDTO;
import com.HQLExer.HQLResolution.Entities.Mascota;
import com.HQLExer.HQLResolution.Entities.Veterinaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVeterinariaService {
    void crearVeterinaria(VeterinariaDTO veterinariaDTO);

}
