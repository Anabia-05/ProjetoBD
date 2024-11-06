package util;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DatabaseCreator {
    public static void main(String[] args) {
        String sqlScriptPath = "ProjetoBD/src/db/createTable.sql";

        try (Connection connection = DBConnection.getConnection()) {
            System.out.println("Conexão com o banco de dados bem-sucedida!");

            executeSqlScript(connection, sqlScriptPath);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void executeSqlScript(Connection connection, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sql.append(line).append("\n");
            }

            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql.toString());
                System.out.println("Script SQL executado com sucesso!");
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}