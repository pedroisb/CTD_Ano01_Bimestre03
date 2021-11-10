package dao.impl;

import dao.ConfigJDBC;
import dao.IDao;
import model.Endereco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class EnderecoDaoImpl implements IDao<Endereco> {

    private ConfigJDBC configJDBC;

    //CONSTRUTORA
    public EnderecoDaoImpl(ConfigJDBC configJDBC) {
        this.configJDBC = configJDBC;
    }


    @Override
    public Endereco cadastrar(Endereco endereco) {
        Connection connection = configJDBC.conectarBanco();
        Statement statement = null;
        String query = String.format("INSERT INTO ENDERECOS(rua, numero ,cidade ,estado) VALUES('%s','%s','%s','%s')", endereco.getRua(), endereco.getNumero(), endereco.getCidade(), endereco.getEstado());
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next())
                endereco.setId(keys.getInt(1));
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return endereco;
    }

    @Override
    public Optional<Endereco> buscar(Integer id) {
        Connection connection = configJDBC.conectarBanco();
        Statement statement = null;
        String query = String.format("SELECT * FROM enderecos WHERE id = '%s'", id);
        Endereco endereco = null;
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next())
                endereco = obterEndereco(result);
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return endereco != null ? Optional.of(endereco) : Optional.empty();
    }

    @Override
    public List<Endereco> exibirTodos() {
        Connection connection = configJDBC.conectarBanco();
        Statement statement = null;
        String query = "SELECT *  FROM enderecos";
        List<Endereco> enderecos = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next())
                enderecos.add(obterEndereco(result));
                statement.close();
                connection.close();
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return enderecos;
    }

    @Override
    public Endereco modificar(Endereco endereco) {
        Connection connection = configJDBC.conectarBanco();
        Statement statement = null;
        String query = String.format("UPDATE enderecos SET rua=?, numero=?, cidade=?, estado=? WHERE id=?", endereco.getRua(), endereco.getNumero(), endereco.getCidade(), endereco.getEstado(), endereco.getId());
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next())
                endereco = obterEndereco(result);
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return endereco;
    }


    @Override
    public void excluir(Integer id) {
        Connection connection = configJDBC.conectarBanco();
        Statement statement = null;
        String query = String.format("DELETE FROM ENDERECOS WHERE id = %s", id);
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private Endereco obterEndereco(ResultSet result) throws SQLException {
        Integer idEndereco = result.getInt("id");
        String rua = result.getString("rua");
        Integer numero = result.getInt("numero");
        String cidade = result.getString("cidade");
        String estado = result.getString("estado");
        return new Endereco(idEndereco, rua, numero, cidade, estado);
    }
}
