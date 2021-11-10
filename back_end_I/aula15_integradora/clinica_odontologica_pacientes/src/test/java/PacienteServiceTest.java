import dao.ConfigJDBC;
import dao.impl.EnderecoDaoImpl;
import dao.impl.PacienteDaoImpl;
import model.Endereco;
import model.Paciente;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.PacienteService;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PacienteServiceTest {

    private static PacienteService pacienteService = new PacienteService(new PacienteDaoImpl(new ConfigJDBC(), new EnderecoDaoImpl(new ConfigJDBC())));


    //01. Antes de iniciar os testes, salve no banco de dados 2 ou mais pacientes e seus respectivos endereços

    @BeforeAll
    public static void povoarTabela(){

    //criados endereços
    Endereco endereco01 = new Endereco("Rua dos Búzios", 176, "Salvador", "Bahia");
    Endereco endereco02 = new Endereco("Rua Renato de Menezes", 89, "Salvador", "Bahia");

    //criados pacientes
    Paciente pacienteMargo = new Paciente("Margô", "Brito", "69468435", LocalDate.of(2021, 11, 5),  endereco01);
    Paciente pacienteBarbara = new Paciente("Bárbara", "Brito", "85496136", LocalDate.of(2019, 6, 25),endereco02 );

    //pacientes cadastrados
    pacienteService.cadastrar(pacienteMargo);
    pacienteService.cadastrar(pacienteBarbara);
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

    //02. Adicione um paciente com endereço e pesquise no banco de dados pelo ID;
    @Test
    public void cadastrarBuscar(){

        //criado endereço
        Endereco endereco03 = new Endereco("Avenida Paulo VI", 233, "Salvador", "Bahia");

        //criado paciente
        Paciente pacienteFlorisbela = new Paciente("Florisbela", "Brito", "56411645", LocalDate.of(2018, 7, 15), endereco03);

        //paciente cadastrado
        pacienteService.cadastrar(pacienteFlorisbela);

        //buscando paciente
        assertFalse(pacienteService.buscar(pacienteFlorisbela.getId()).isEmpty());
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

    //03. Exclua o paciente criado anteriormente e procure-o;
    @Test
    public void excluirBuscar(){

        //criado endereço
        Endereco endereco03 = new Endereco("Avenida Paulo VI", 233, "Salvador", "Bahia");

        //criado paciente
        Paciente pacienteFlorisbela = new Paciente("Florisbela", "Brito", "56411645", LocalDate.of(2018, 7, 15), endereco03);

        //paciente cadastrado
        pacienteService.cadastrar(pacienteFlorisbela);

        //paciente excluído
        pacienteService.excluir(pacienteFlorisbela.getId());

        //buscando paciente
        assertTrue(pacienteService.buscar(pacienteFlorisbela.getId()).isEmpty());
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

    //04. Pesquise e imprima no console todos os pacientes com seus endereços, serão listados todos os pacientes que incluímos antes de realizar o primeiro teste
    @Test
    public void exibirTodos() {
        assertFalse(pacienteService.exibirTodos().isEmpty());
    }
}
