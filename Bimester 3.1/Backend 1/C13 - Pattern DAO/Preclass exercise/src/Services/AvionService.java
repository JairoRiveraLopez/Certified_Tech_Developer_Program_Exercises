package Services;

import DAOS.IDao;
import Entities.Avion;

import java.util.List;

public class AvionService {
    private IDao<Avion> avionIDao;

    public AvionService(){

    }

    public IDao<Avion> getAvionIDao() {
        return avionIDao;
    }

    public void setAvionIDao(IDao<Avion> avionIDao) {
        this.avionIDao = avionIDao;
    }

    public Avion guardarAvion(Avion a){
        avionIDao.guardar(a);
        return a;
    }

    public void eliminarAvion(Long id){
        avionIDao.eliminar(id);
    }

    public Avion buscarAvion(Long id){
        return avionIDao.buscar(id);
    }

    public List<Avion> buscarTodos(){
        return avionIDao.buscarTodos();
    }
}
