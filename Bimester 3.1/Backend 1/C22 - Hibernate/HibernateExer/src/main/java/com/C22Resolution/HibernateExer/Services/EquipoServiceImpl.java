package com.C22Resolution.HibernateExer.Services;
import com.C22Resolution.HibernateExer.Entities.Equipo;
import com.C22Resolution.HibernateExer.Repository.IEquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EquipoServiceImpl implements IEquipoService{

    @Autowired
    private IEquipoRepository equipoRepository;

    @Override
    public Equipo guardarEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Override
    public List<Equipo> obtenerEquipos() {
        return equipoRepository.findAll();
    }

    @Override
    public Boolean eliminarEquipo(Long id) {
        if(equipoRepository.findById(id).isPresent()){
            equipoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
