package Services;
import DAOS.IDao;
import Entities.Medicamento;

import java.util.List;

public class FarmaciaService {
    private IDao<Medicamento> medicamentoIDao;

    public FarmaciaService() {
    }

    public IDao<Medicamento> getMedicamentoIDao() {
        return medicamentoIDao;
    }

    public void setMedicamentoIDao(IDao<Medicamento> medicamentoIDao) {
        this.medicamentoIDao = medicamentoIDao;
    }

    public Medicamento guardarMedicamento(Medicamento m){
        medicamentoIDao.guardar(m);
        return m;
    }

    public void eliminarMedicamento(Long id){
        medicamentoIDao.eliminar(id);
    }

    public Medicamento buscarMedicamento(Long id){
        return medicamentoIDao.buscar(id);
    }

    public List<Medicamento> buscarTodos(){
        return medicamentoIDao.buscarTodos();
    }


}
