package com.FinalProjectJairoRivera.Resolution.Services;

import com.FinalProjectJairoRivera.Resolution.Domains.Odontologo;

import java.util.List;

public interface IOdontologoService {
    List<Odontologo> listaOdontologos();
    Odontologo buscarXMatricula(String matricula);
    Odontologo buscarXId(int id);
    Odontologo guardarOdontologo(Odontologo odontologo);
    Odontologo actualizarOdontologo(Odontologo odontologo);

    void eliminarOdontologo(int id);
}
