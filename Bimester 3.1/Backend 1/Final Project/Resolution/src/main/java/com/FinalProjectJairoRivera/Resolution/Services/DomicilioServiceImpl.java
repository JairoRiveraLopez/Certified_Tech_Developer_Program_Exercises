package com.FinalProjectJairoRivera.Resolution.Services;

import com.FinalProjectJairoRivera.Resolution.Daos.IDao;
import com.FinalProjectJairoRivera.Resolution.Domains.Domicilio;
import com.FinalProjectJairoRivera.Resolution.Domains.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioServiceImpl implements IDomicilioService{

    private IDao<Domicilio> domicilioIDao;

    @Autowired
    public DomicilioServiceImpl(IDao<Domicilio> domicilioIDao) {
        this.domicilioIDao = domicilioIDao;
    }

    @Override
    public List<Domicilio> listarDomicilios() {
        return domicilioIDao.listarElementos();
    }

    @Override
    public Domicilio buscarXId(int id) {
        return domicilioIDao.buscarXId(id);
    }

    @Override
    public Domicilio actualizarDomicilio(Domicilio domicilio) {
        return domicilioIDao.actualizar(domicilio);
    }

    @Override
    public void eliminarDomicilio(int id) {
        domicilioIDao.eliminar(id);
    }
}
