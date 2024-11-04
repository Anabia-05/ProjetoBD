import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 
public class DatabaseCreator {
 
    // Configurações do MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "seu_user";
    private static final String PASSWORD = "sua_senha";
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // Conectar ao MySQL
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            // Criação do banco de dados
            String sql = "CREATE DATABASE IF NOT EXISTS minha_base_de_dados";
            statement.executeUpdate(sql);
            System.out.println("Banco de dados criado com sucesso!");
            // Seleciona o banco de dados para criar tabelas
            connection.setCatalog("minha_base_de_dados");
            // Criação da tabela de exemplo
            String tabelaSQL = "CREATE TABLE IF NOT EXISTS usuarios (" +
                               "id INT AUTO_INCREMENT PRIMARY KEY, " +
                               "nome VARCHAR(50), " +
                               "email VARCHAR(50) UNIQUE)";
            statement.executeUpdate(tabelaSQL);
            System.out.println("Tabela 'usuarios' criada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

