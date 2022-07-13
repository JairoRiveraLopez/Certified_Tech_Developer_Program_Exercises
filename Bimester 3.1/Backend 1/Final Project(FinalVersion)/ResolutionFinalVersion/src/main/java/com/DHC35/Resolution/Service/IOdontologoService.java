package com.DHC35.Resolution.Service;

import com.DHC35.Resolution.Entities.Odontologo;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService {
    List<Odontologo> listarOdontologos();
    Optional<Odontologo> buscarOdontologoXId(Long id);
    Odontologo guardarOdontologo(Odontologo odontologo);
    Odontologo actualizarOdontologo(Odontologo odontologo);
    void eliminarOdontologo(Long id);
}
