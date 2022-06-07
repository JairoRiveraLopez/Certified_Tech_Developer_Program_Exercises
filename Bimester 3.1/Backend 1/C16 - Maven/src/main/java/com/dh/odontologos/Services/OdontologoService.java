package com.dh.odontologos.Services;


import com.dh.odontologos.DAOS.IDao;
import com.dh.odontologos.Entities.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService() {
    }

    public IDao<Odontologo> getOdontologoIDao() {
        return odontologoIDao;
    }

    public void setOdontologoIDao(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        odontologoIDao.guardar(odontologo);
        return odontologo;
    }

    public List<Odontologo> buscarTodosLosOdontologos(){
        return odontologoIDao.buscarTodos();
    }
}
