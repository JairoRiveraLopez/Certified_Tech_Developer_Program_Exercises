package com.DHC35.Resolution.Service.Impl;

import com.DHC35.Resolution.Entities.Domicilio;
import com.DHC35.Resolution.Repository.IDomicilioRepository;
import com.DHC35.Resolution.Service.IDomicilioService;
import com.DHC35.Resolution.Service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioServiceImpl implements IDomicilioService {

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Override
    public List<Domicilio> listarDomicilios() {
        return domicilioRepository.findAll();
    }

    @Override
    public Optional<Domicilio> buscarDomicilioXId(Long id) {
        return domicilioRepository.findById(id);
    }

    @Override
    public Domicilio actualizarDomicilio(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }

    @Override
    public void eliminarDomicilio(Long id) {
        domicilioRepository.deleteById(id);
    }
}
