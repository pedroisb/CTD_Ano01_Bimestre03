import dao.ConfigJDBC;
import dao.impl.DentistaDaoImpl;
import model.Dentista;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.DentistaService;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DentistaServiceTest<dentistaService> {

    private static DentistaService dentistaService = new DentistaService(new DentistaDaoImpl(new ConfigJDBC()));


    //CRIAÇÃO E CADASTRO DE OBJTS DENTISTA
    @BeforeAll
    public static void cadastrarDentistas(){
        Dentista dentista01 = new Dentista("69468435", "Maria", "Goretti");
        Dentista dentista02 = new Dentista("65165", "Lívia", "Silva");
        Dentista dentista03 = new Dentista("98496", "Márcia", "Pereira");
        dentistaService.cadastrar(dentista01);
        dentistaService.cadastrar(dentista02);
        dentistaService.cadastrar(dentista03);
    }

    @Test
    public void exibirTodosDentistas(){
        List<Dentista> dentistas = dentistaService.exibirTodos();
        assertFalse(dentistas.isEmpty());
    }
}
