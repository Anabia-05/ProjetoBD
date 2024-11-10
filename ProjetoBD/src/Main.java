import java.sql.Connection;
import java.sql.SQLException;
import util.DBConnection;
import util.DatabaseCreator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Programa iniciado!");

        try (Connection connection = DBConnection.getConnection()) {
            System.out.println("Conexão com o banco de dados estabelecida.");
            String sqlScriptPath = "ProjetoBD/src/db/createTable.sql";
            DatabaseCreator databaseCreator = new DatabaseCreator(connection,sqlScriptPath);
            databaseCreator.executeSqlScript();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao conectar ao banco de dados.");
        }
    }
}