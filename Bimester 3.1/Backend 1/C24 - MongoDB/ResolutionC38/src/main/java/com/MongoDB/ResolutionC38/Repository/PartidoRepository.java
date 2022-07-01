package com.MongoDB.ResolutionC38.Repository;

import com.MongoDB.ResolutionC38.Model.Estado;
import com.MongoDB.ResolutionC38.Model.Partido;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PartidoRepository extends MongoRepository<Partido,Long>{
    List<Partido> findAllByEstado(Estado estado);
}
