import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreator {

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE_NAME = "webdriver";

    public void createDatabase() {
        String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS " + DATABASE_NAME;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement()) {

            statement.executeUpdate(createDatabaseQuery);
            System.out.println("Database " + DATABASE_NAME + " created successfully!");

            createTablesInDatabase();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error creating database.");
        }
    }

    private void createTablesInDatabase() {
        String dbUrl = URL + DATABASE_NAME;

        try (Connection connection = DriverManager.getConnection(dbUrl, USER, PASSWORD)) {

            TableCreator tableCreator = new TableCreator(connection);
            tableCreator.createPlanoTable();
            tableCreator.createInstituicaoTable();
            tableCreator.createUsuarioTable();
            tableCreator.createAdmUsuarioTable();
            tableCreator.createAdministradorTable();
            tableCreator.createSuporteTable();
            tableCreator.createArquivoTable();
            tableCreator.createCompartilhamentoTable();
            tableCreator.createComentarioTable();
            tableCreator.createHistoricoTable();
            tableCreator.createOperacoesTable();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error creating tables in the database.");
        }
    }
}

//     private Connection connection;

//     public DatabaseCreator() {
//         try {
//             // Carregar o driver MySQL
//             Class.forName("com.mysql.cj.jdbc.Driver");

//             // Conectar ao MySQL
//             connection = DriverManager.getConnection(URL, USER, PASSWORD);
//             Statement statement = connection.createStatement();
            
//             // Criação do banco de dados
//             String sql = "CREATE DATABASE IF NOT EXISTS sistema";
//             statement.executeUpdate(sql);
//             System.out.println("Banco de dados criado com sucesso!");
            
//             // Seleciona o banco de dados para uso
//             connection.setCatalog("sistema");
            
//             statement.close();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         } catch (ClassNotFoundException e) {
//             System.err.println("Driver MySQL não encontrado!");
//             e.printStackTrace();
//         }
//     }

//     // Retorna a conexão para ser usada pela TableCreator
//     public Connection getConnection() {
//         return connection;
//     }

//     // Método para fechar a conexão
//     public void closeConnection() {
//         try {
//             if (connection != null) connection.close();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }
// }
