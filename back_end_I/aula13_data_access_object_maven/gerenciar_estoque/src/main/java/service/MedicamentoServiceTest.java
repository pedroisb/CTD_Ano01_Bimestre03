package service;

import dao.ConfigJDBC;
import dao.impl.MedicamentoDaoImpl;
import model.Medicamento;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MedicamentoServiceTest {
    private MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoImpl(new ConfigJDBC()));

    @Test
    public void guardarMedicamento() {
        Medicamento medicamento = new Medicamento(1234567890, "Ibuprofeno", "Labt", 1000, 20.0);
        medicamentoService.salvar(medicamento);
        assertTrue(medicamento.getId() != null);
    }
}
