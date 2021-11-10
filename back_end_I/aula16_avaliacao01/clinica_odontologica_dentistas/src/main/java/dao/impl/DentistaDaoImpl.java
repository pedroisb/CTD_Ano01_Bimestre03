package dao.impl;

import dao.ConfigJDBC;
import dao.IDao;
import model.Dentista;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DentistaDaoImpl implements IDao<Dentista> {

    private ConfigJDBC configJDBC;
    final static Logger log = Logger.getLogger(DentistaDaoImpl.class);


    //CONSTRUTORA
    public DentistaDaoImpl(ConfigJDBC configJDBC) {
        this.configJDBC = configJDBC;
    }


    //IMPLEMENTAÇÃO DE MÉTODO PARA CADASTRO DE DENTISTA
    @Override
    public Dentista cadastrar(Dentista dentista) {
        Connection connection = configJDBC.conectarBanco();
        Statement statement = null;
        String query = String.format("INSERT INTO DENTISTAS(matricula, nome, sobrenome) VALUES('%s','%s','%s')", dentista.getMatricula(), dentista.getNome(), dentista.getSobrenome());
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next())
                dentista.setId(keys.getInt(1));
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.debug("Novo(a) Dentista cadastrado(a): " + dentista);
        return dentista;
    }


    //IMPLEMENTAÇÃO DE MÉTODO PARA EXIBIR LISTA COM TODOS OS DENTISTAS CADASTRADOS
    @Override
    public List<Dentista> exibirTodos() {
        Connection connection = configJDBC.conectarBanco();
        Statement statement = null;
        String query = String.format("SELECT *  FROM DENTISTAS");
        List<Dentista> dentistas = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()){
                Integer id = result.getInt("id");
                String matricula = result.getString("matricula");
                String nome = result.getString("nome");
                String sobrenome = result.getString("sobrenome");
                dentistas.add(new Dentista(id, matricula, nome, sobrenome));
            }
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        log.debug("Dentistas cadastrados(as) no sistema: " + dentistas);
        return dentistas;
    }
}
