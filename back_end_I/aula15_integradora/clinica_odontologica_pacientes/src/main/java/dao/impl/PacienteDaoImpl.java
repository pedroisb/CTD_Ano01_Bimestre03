package dao.impl;

import dao.ConfigJDBC;
import dao.IDao;
import model.Endereco;
import model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class PacienteDaoImpl implements IDao<Paciente> {

    private ConfigJDBC configJDBC;
    private EnderecoDaoImpl enderecoDao;
    final static Logger log = Logger.getLogger(PacienteDaoImpl.class);


    //CONSTRUTORA
    public PacienteDaoImpl(ConfigJDBC configJDBC, EnderecoDaoImpl enderecoDao) {
        this.configJDBC = configJDBC;
        this.enderecoDao = enderecoDao;
    }

    @Override
    public Paciente cadastrar(Paciente paciente) {
        Connection connection = configJDBC.conectarBanco();
        Statement statement = null;
        paciente.setEndereco(enderecoDao.cadastrar((paciente.getEndereco())));
        String query = String.format("INSERT INTO pacientes(nome, sobrenome, rg, dataCadastro, idEndereco) VALUES('%s','%s','%s','%s','%s')", paciente.getNome(), paciente.getSobrenome(), paciente.getRg(), paciente.getDataCadastro(), paciente.getEndereco().getId());
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next())
                paciente.setId(keys.getInt(1));
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.debug("Novo paciente cadastrado: " + paciente+"\n");
        return paciente;
    }


    @Override
    public Optional<Paciente> buscar(Integer id) {
        Connection connection = configJDBC.conectarBanco();
        Statement statement = null;
        String query = String.format("SELECT * FROM pacientes WHERE id = '%s'", id);
        Paciente paciente = null;
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next())
                paciente = obterPaciente(result);
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        log.debug("Buscando por paciente de ID: " + id+"\n"+"Encontrado: "+paciente+"\n");
        return paciente != null ? Optional.of(paciente) : Optional.empty();
    }

    @Override
    public List<Paciente> exibirTodos() {
        Connection connection = configJDBC.conectarBanco();
        Statement statement = null;
        String query = String.format("SELECT * FROM pacientes");
        List<Paciente> pacientes = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next())
                pacientes.add(obterPaciente(result));
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        log.debug("Exibindo lista com todos os pacientes: " + pacientes+"\n");
        return pacientes;
    }

    @Override
    public Paciente modificar(Paciente paciente) {
        Connection connection = configJDBC.conectarBanco();
        Statement statement = null;
        String query = String.format("UPDATE PACIENTES SET nome=?, sobrenome=?, rg=?, dataDeCadastro=?, idEndereco=? WHERE id=?", paciente.getNome(), paciente.getSobrenome(), paciente.getRg(), paciente.getDataCadastro(), paciente.getEndereco(), paciente.getId());
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next())
                paciente = obterPaciente(result);
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        log.debug("Dados do paciente de ID "+paciente.getId()+" modificados. Dados atuais: "+paciente+"\n");
        return paciente;
    }

    @Override
    public void excluir(Integer id) {
        Connection connection = configJDBC.conectarBanco();
        Statement statement = null;
        Paciente paciente = buscar(id).get();
        String query = String.format("DELETE FROM pacientes WHERE id = %s", id);
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            enderecoDao.excluir(paciente.getEndereco().getId());
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        log.debug("Excluído paciente de ID: " + id+"\n");
    }

    private Paciente obterPaciente(ResultSet result) throws SQLException {
        Integer idPaciente = result.getInt("id");
        String nome = result.getString("nome");
        String sobrenome = result.getString("sobrenome");
        String rg = result.getString("rg");
        LocalDate dataCadastro = result.getDate("dataCadastro").toLocalDate();
        Endereco endereco = enderecoDao.buscar(result.getInt("idEndereco")).orElse(null);
        return new Paciente(idPaciente, nome, sobrenome, rg, dataCadastro, endereco);
    }
}
