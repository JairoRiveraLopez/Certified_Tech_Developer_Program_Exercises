package Services;
import BDDAux.BDDAuxCreateTable;
import DAOS.MedicamentoDAOH2;
import Entities.Medicamento;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import java.util.List;


class FarmaciaServiceTest {
    private static final Logger logger = Logger.getLogger(FarmaciaServiceTest.class);
    private FarmaciaService farmaciaService = new FarmaciaService();

    @Test
    void guardarMedicamento() {
        BDDAuxCreateTable.crearTabla();
        farmaciaService.setMedicamentoIDao(new MedicamentoDAOH2());

        farmaciaService.guardarMedicamento(new Medicamento(1L, "IBU-001", "Ibuprofeno", "Genfar", 500, 10D));
        farmaciaService.guardarMedicamento(new Medicamento(2L, "DOL-001", "Dolex", "J&Q", 1000, 12D));
        farmaciaService.guardarMedicamento(new Medicamento(3L, "DOX-001", "Doxicilina", "Generico", 100, 5D));

        Medicamento medicamentoPrueba = farmaciaService.buscarMedicamento(1L);
        Assertions.assertEquals(medicamentoPrueba.getCodigoNumerico(), "IBU-001");
        Assertions.assertEquals(medicamentoPrueba.getNombre(), "Ibuprofeno");
        Assertions.assertEquals(medicamentoPrueba.getLaboratorioDeProduccion(), "Genfar");
    }

    @Test
    void eliminarMedicamento() {
        BDDAuxCreateTable.crearTabla();
        farmaciaService.setMedicamentoIDao(new MedicamentoDAOH2());

        farmaciaService.guardarMedicamento(new Medicamento(1L, "IBU-001", "Ibuprofeno", "Genfar", 500, 10D));
        farmaciaService.guardarMedicamento(new Medicamento(2L, "DOL-001", "Dolex", "J&Q", 1000, 12D));
        farmaciaService.guardarMedicamento(new Medicamento(3L, "DOX-001", "Doxicilina", "Generico", 100, 5D));

        farmaciaService.eliminarMedicamento(3L);
        List<Medicamento> medicamentos = farmaciaService.buscarTodos();
        Assertions.assertEquals(medicamentos.size(), 2);
    }

    @Test
    void buscarMedicamento() {
        BDDAuxCreateTable.crearTabla();
        farmaciaService.setMedicamentoIDao(new MedicamentoDAOH2());

        farmaciaService.guardarMedicamento(new Medicamento(1L, "IBU-001", "Ibuprofeno", "Genfar", 500, 10D));
        farmaciaService.guardarMedicamento(new Medicamento(2L, "DOL-001", "Dolex", "J&Q", 1000, 12D));
        farmaciaService.guardarMedicamento(new Medicamento(3L, "DOX-001", "Doxicilina", "Generico", 100, 5D));

        Medicamento medicamentoPrueba = farmaciaService.buscarMedicamento(1L);
        Assertions.assertEquals(medicamentoPrueba.getCodigoNumerico(), "IBU-001");
        Assertions.assertEquals(medicamentoPrueba.getNombre(), "Ibuprofeno");
        Assertions.assertEquals(medicamentoPrueba.getLaboratorioDeProduccion(), "Genfar");

    }

    @Test
    void buscarTodos() {
        BDDAuxCreateTable.crearTabla();
        farmaciaService.setMedicamentoIDao(new MedicamentoDAOH2());

        farmaciaService.guardarMedicamento(new Medicamento(1L, "IBU-001", "Ibuprofeno", "Genfar", 500, 10D));
        farmaciaService.guardarMedicamento(new Medicamento(2L, "DOL-001", "Dolex", "J&Q", 1000, 12D));
        farmaciaService.guardarMedicamento(new Medicamento(3L, "DOX-001", "Doxicilina", "Generico", 100, 5D));

        List<Medicamento> medicamentos = farmaciaService.buscarTodos();
        Assertions.assertEquals(medicamentos.size(), 3);
    }
}