package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConfigJDBC {

    private String jdbcDriver;
    private String dbUrl;
    private String nomeUsuario;
    private String senha;


    //CRIA TABELA DENTISTAS
    private static final String SQL_CREATE_TABLE_DENTISTAS =
            "DROP TABLE IF EXISTS DENTISTAS; CREATE TABLE DENTISTAS " +
            "(id int auto_increment primary key, " +
            "matricula varchar(255), " +
            "nome varchar(255), " +
            "sobrenome varchar(255))";

    //CONSTRUTORA
    public ConfigJDBC(String jdbcDriver, String dbUrl, String nomeUsuario, String senha) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    //CONSTRUTORA INICIALIZADA
    public ConfigJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/test";
        this.nomeUsuario = "sa";
        this.senha = "";
        criarTabela();
    }

    //CRIA AS TABELAS PACIENTES E ENDERECOS
    private void criarTabela(){
        try{
            Connection connection = conectarBanco();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE_DENTISTAS);
            statement.close();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection conectarBanco() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbUrl, nomeUsuario, senha);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
