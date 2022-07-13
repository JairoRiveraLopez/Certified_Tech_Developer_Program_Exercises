package com.DHC35.Resolution.Service;


import com.DHC35.Resolution.Entities.Domicilio;

import java.util.List;
import java.util.Optional;

public interface IDomicilioService {
    List<Domicilio> listarDomicilios();
    Optional<Domicilio> buscarDomicilioXId(Long id);
    Domicilio actualizarDomicilio(Domicilio domicilio);
    void eliminarDomicilio(Long id);
}
