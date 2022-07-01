package com.FinalProjectJairoRivera.Resolution.Services;

import com.FinalProjectJairoRivera.Resolution.Daos.IDao;
import com.FinalProjectJairoRivera.Resolution.Domains.Odontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class OdontologoServiceImpl implements IOdontologoService{
    private IDao<Odontologo> odontologoIDao;

    @Autowired
    public OdontologoServiceImpl (IDao<Odontologo> odontologoIDao){
        this.odontologoIDao = odontologoIDao;
    }

    @Override
    public List<Odontologo> listaOdontologos() {
        return odontologoIDao.listarElementos();
    }

    @Override
    public Odontologo buscarXMatricula(String matricula) {
        return odontologoIDao.buscarXCriterio(matricula);
    }

    @Override
    public Odontologo buscarXId(int id) {
        return odontologoIDao.buscarXId(id);
    }

    @Override
    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoIDao.guardar(odontologo);
    }

    @Override
    public Odontologo actualizarOdontologo(Odontologo odontologo) {
        return odontologoIDao.actualizar(odontologo);
    }

    @Override
    public void eliminarOdontologo(int id) {
        odontologoIDao.eliminar(id);
    }
}
