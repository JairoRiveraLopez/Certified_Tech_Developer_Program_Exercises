package com.FinalProjectJairoRivera.Resolution.Services;

import com.FinalProjectJairoRivera.Resolution.Domains.Domicilio;

import java.util.List;

public interface IDomicilioService {
    List<Domicilio> listarDomicilios();
    Domicilio buscarXId(int id);
    Domicilio actualizarDomicilio(Domicilio domicilio);
    void eliminarDomicilio(int id);
}
