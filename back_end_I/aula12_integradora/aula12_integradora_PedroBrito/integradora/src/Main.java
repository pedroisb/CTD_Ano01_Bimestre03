import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class Main {
    private static final String Create_Table = "DROP TABLE IF EXISTS FUNCIONARIOS; CREATE TABLE FUNCIONARIOS" +
            "(ID INT PRIMARY KEY, " +
            "NOME varchar(255) NOT NULL," +
            "SOBRENOME varchar(255) NOT NULL, " +
            "IDADE INT NOT NULL," +
            "FUNCAO varchar(255))";

    private static final String sqlInsert = "INSERT INTO FUNCIONARIOS (ID, NOME, SOBRENOME, IDADE, FUNCAO) VALUES (1, 'Maria', 'Jaquina', 20, 'Contadora')";
    private static final String sqlInsert1 = "INSERT INTO FUNCIONARIOS (ID, NOME, SOBRENOME, IDADE, FUNCAO) VALUES (2, 'Carlota', 'Josefa', 32, 'Supervisora')";
    private static final String sqlInsert2 = "INSERT INTO FUNCIONARIOS (ID, NOME, SOBRENOME, IDADE, FUNCAO) VALUES (3, 'Edvandro', 'Rodrigues', 52, 'Gerente')";
    private static final String sqlInsert3 = "INSERT INTO FUNCIONARIOS (ID, NOME, SOBRENOME, IDADE, FUNCAO) VALUES (4, 'Adalgisa', 'Silveira', 44, 'Chefe de Departamento')";

    private static final String delete = "DELETE FROM FUNCIONARIOS WHERE id = 4";

    private static final String update = "UPDATE FUNCIONARIOS SET FUNCAO = 'Gerente de setor' WHERE id = 2";

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        Connection connection = null;

        try{
            connection = getConnection();

            Statement statement = connection.createStatement();

            insertingData(Create_Table, statement, "Tabela criada");
            insertingData(sqlInsert, statement, "Cadastrado id 1");
            insertingData(sqlInsert1, statement, "Cadastrado id 2");
            insertingData(sqlInsert2, statement, "Cadastrado id 2");
            insertingData(sqlInsert3, statement, "Cadastrado id 4");

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(connection != null){
                connection.close();
            }
        }
    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }

    private static void insertingData(String connection, Statement statement, String message){
        try{
            statement.execute(connection);
            logger.info(message);
        } catch (Exception e){
            logger.error("Unique index or primary key violation");
        }
    }
}
