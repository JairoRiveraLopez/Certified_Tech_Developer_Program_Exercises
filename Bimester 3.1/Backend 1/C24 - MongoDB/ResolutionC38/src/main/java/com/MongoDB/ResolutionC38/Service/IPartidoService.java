package com.MongoDB.ResolutionC38.Service;

import com.MongoDB.ResolutionC38.Model.Estado;
import com.MongoDB.ResolutionC38.Model.Partido;

import java.util.List;
public interface IPartidoService {
    Partido guardarPartido(Partido partido);
    List<Partido> listarPartidos();
    List<Partido> buscarPartidoPorEstado(Estado estado);
}
