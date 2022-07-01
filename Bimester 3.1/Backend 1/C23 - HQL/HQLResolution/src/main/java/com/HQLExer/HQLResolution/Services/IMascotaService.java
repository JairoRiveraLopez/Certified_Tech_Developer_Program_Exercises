package com.HQLExer.HQLResolution.Services;

import com.HQLExer.HQLResolution.DTOS.MascotaDTO;

import java.util.List;
import java.util.Set;

public interface IMascotaService {
    void crearMascota (MascotaDTO mascotaDTO);
    Set<MascotaDTO> listarMascotas ();
    Set<MascotaDTO> listarMascotasPorTipo (String tipo);

}
