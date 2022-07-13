package com.DHC35.Resolution.Service.Impl;

import com.DHC35.Resolution.Entities.Odontologo;
import com.DHC35.Resolution.Repository.IOdontologoRepository;
import com.DHC35.Resolution.Service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServiceImpl implements IOdontologoService {

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Override
    public List<Odontologo> listarOdontologos() {
        return odontologoRepository.findAll();
    }

    @Override
    public Optional<Odontologo> buscarOdontologoXId(Long id) {
        return odontologoRepository.findById(id);
    }

    @Override
    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo actualizarOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }
}
