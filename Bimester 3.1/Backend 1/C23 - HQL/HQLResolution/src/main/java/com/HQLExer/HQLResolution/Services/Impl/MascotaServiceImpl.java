package com.HQLExer.HQLResolution.Services.Impl;

import com.HQLExer.HQLResolution.DTOS.MascotaDTO;
import com.HQLExer.HQLResolution.Entities.Mascota;
import com.HQLExer.HQLResolution.Entities.Veterinaria;
import com.HQLExer.HQLResolution.Repository.MascotaRepository;
import com.HQLExer.HQLResolution.Services.IMascotaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MascotaServiceImpl implements IMascotaService {
    @Autowired
    private final MascotaRepository mascotaRepository;

    @Autowired
    ObjectMapper mapper;

    public MascotaServiceImpl(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    @Override
    public void crearMascota(MascotaDTO mascotaDTO) {
        Mascota mascota = mapper.convertValue(mascotaDTO, Mascota.class);
        mascotaRepository.save(mascota);
    }

    @Override
    public Set<MascotaDTO> listarMascotas() {
        List<Mascota> mascotas = mascotaRepository.findAll();
        Set<MascotaDTO> mascotaDTOS = new HashSet<>();

        for (Mascota mascota:mascotas) {
            mascotaDTOS.add(mapper.convertValue(mascota, MascotaDTO.class));
        }
        return mascotaDTOS;
    }

    @Override
    public Set<MascotaDTO> listarMascotasPorTipo(String tipo) {
        return mascotaRepository.buscarMascotasPorTipo(tipo);
    }
}
