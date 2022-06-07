package com.dh.pacientes.Services;




import com.dh.pacientes.DAO.IDao;
import com.dh.pacientes.Entities.Domicilio;

import java.util.List;

public class ServiceDomicilio {
    private IDao<Domicilio> domicilioIdao;

    public ServiceDomicilio() {
    }

    public IDao<Domicilio> getDomicilioIdao() {
        return domicilioIdao;
    }

    public void setDomicilioIdao(IDao<Domicilio> domicilioIDaoIdao) {
        this.domicilioIdao = domicilioIDaoIdao;
    }

    public Domicilio guardarDomicilio(Domicilio d){
        domicilioIdao.guardar(d);
        return d;
    }

    public void eliminarDomicilio(Integer id){
        domicilioIdao.eliminar(id);
    }

    public Domicilio buscarDomicilio(Integer id){
        return domicilioIdao.buscar(id);
    }

    public List<Domicilio> buscarTodos(){
        return domicilioIdao.buscarTodos();
    }


}