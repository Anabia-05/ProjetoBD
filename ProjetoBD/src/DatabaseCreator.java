import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreator {

    // Configurações do MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "sua_senha";
    
    private Connection connection;

    public DatabaseCreator() {
        try {
            // Conectar ao MySQL
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            
            // Criação do banco de dados
            String sql = "CREATE DATABASE IF NOT EXISTS minha_base_de_dados";
            statement.executeUpdate(sql);
            System.out.println("Banco de dados criado com sucesso!");
            
            // Seleciona o banco de dados para uso
            connection.setCatalog("minha_base_de_dados");
            
            statement.close();
        } catch (SQLException e) {
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
