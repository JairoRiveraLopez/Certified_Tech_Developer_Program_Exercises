package com.HQLExer.HQLResolution.Services.Impl;

import com.HQLExer.HQLResolution.DTOS.VeterinariaDTO;
import com.HQLExer.HQLResolution.Entities.Mascota;
import com.HQLExer.HQLResolution.Entities.Veterinaria;
import com.HQLExer.HQLResolution.Repository.VeterinariaRepository;
import com.HQLExer.HQLResolution.Services.IVeterinariaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeterinariaServiceImpl implements IVeterinariaService {

    private final VeterinariaRepository veterinariaRepository;

    @Autowired
    public VeterinariaServiceImpl(VeterinariaRepository veterinariaRepository) {
        this.veterinariaRepository = veterinariaRepository;
    }

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearVeterinaria(VeterinariaDTO veterinariaDTO) {
        Veterinaria veterinaria = mapper.convertValue(veterinariaDTO, Veterinaria.class);
        veterinariaRepository.save(veterinaria);
    }

}
