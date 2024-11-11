package util;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DatabaseCreator {
    Connection connection;
    String sqlScriptPath = "ProjetoBD/src/db/createTable.sql";

    public DatabaseCreator(Connection connection, String sqlScriptPath) {
        this.connection = connection;
        this.sqlScriptPath = sqlScriptPath;
    }

    public void executeSqlScript() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.sqlScriptPath))) {
            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sql.append(line).append("\n");
            }

            try (Statement statement = this.connection.createStatement()) {
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