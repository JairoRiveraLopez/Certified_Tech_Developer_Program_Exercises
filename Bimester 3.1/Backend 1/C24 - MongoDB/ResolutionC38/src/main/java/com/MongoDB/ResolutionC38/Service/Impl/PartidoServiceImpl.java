package com.MongoDB.ResolutionC38.Service.Impl;

import com.MongoDB.ResolutionC38.Model.Estado;
import com.MongoDB.ResolutionC38.Model.Partido;
import com.MongoDB.ResolutionC38.Repository.PartidoRepository;
import com.MongoDB.ResolutionC38.Service.IPartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoServiceImpl implements IPartidoService {
    private PartidoRepository partidoRepository;

    @Autowired
    public PartidoServiceImpl(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }


    @Override
    public Partido guardarPartido(Partido partido) {
        return partidoRepository.save(partido);
    }

    @Override
    public List<Partido> listarPartidos() {
        return partidoRepository.findAll();
    }

    @Override
    public List<Partido> buscarPartidoPorEstado(Estado estado) {
        return partidoRepository.findAllByEstado(estado);
    }

}
