package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConfigJDBC {

    private String jdbcDriver;
    private String dbUrl;
    private String nomeUsuario;
    private String senha;


    //CRIA TABELA ENDERECOS
    private static final String SQL_CREATE_ENDERECOS =
            "DROP TABLE IF EXISTS ENDERECOS CASCADE; CREATE TABLE ENDERECOS " +
                    "(id int auto_increment primary key, " +
                    "rua varchar(255), " +
                    "numero int, " +
                    "cidade varchar(255), " +
                    "estado varchar(255))";


    //CRIA TABELA PACIENTES
    private static final String SQL_CREATE_PACIENTES =
            "DROP TABLE IF EXISTS PACIENTES; CREATE TABLE PACIENTES " +
            "(id int auto_increment primary key, " +
            "nome varchar(255), " +
            "sobrenome varchar(255), " +
            "rg varchar(255), " +
            "dataCadastro date, " +
            "idEndereco int, " +
            "foreign key (idEndereco) references enderecos(id))";

    //CONSTRUTORA
    public ConfigJDBC(String jdbcDriver, String dbUrl, String nomeUsuario, String senha) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    //CONSTRUTORA DEFAULT COM ATRIBUTOS INICIALIZADOS
    public ConfigJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/test";
        this.nomeUsuario = "sa";
        this.senha = "";
        criarTabelas();
    }

    //CRIA AS TABELAS PACIENTES E ENDERECOS
    private void criarTabelas(){
        try{
            Connection connection = conectarBanco();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_ENDERECOS);
            statement.execute(SQL_CREATE_PACIENTES);
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
