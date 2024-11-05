import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreator {

    // Configurações do MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    
    private Connection connection;

    public DatabaseCreator() {
        try {
            // Carregar o driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conectar ao MySQL
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            
            // Criação do banco de dados
            String sql = "CREATE DATABASE IF NOT EXISTS sistema";
            statement.executeUpdate(sql);
            System.out.println("Banco de dados criado com sucesso!");
            
            // Seleciona o banco de dados para uso
            connection.setCatalog("sistema");
            
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL não encontrado!");
            e.printStackTrace();
        }
    }

    // Retorna a conexão para ser usada pela TableCreator
    public Connection getConnection() {
        return connection;
    }

    // Método para fechar a conexão
    public void closeConnection() {
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
