import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Programa iniciado!");

        String jdbcUrl = "jdbc:mysql://localhost:3306/webdriver";
        String username = "webdriver_user";
        String password = "S3curE!pAs$w0rD";
        String sqlFilePath = "/Users/guilhermecavalcantidesabarreto/code/unicap/ProjetoBD/ProjetoBD/src/db/createTable.sql";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Conexão com o banco de dados estabelecida.");
            executarArquivoSQL(connection, sqlFilePath);
            System.out.println("Arquivo SQL executado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao conectar ao banco de dados.");
        }
    }

    public static void executarArquivoSQL(Connection connection, String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             Statement stmt = connection.createStatement()) {

            String linha;
            StringBuilder sql = new StringBuilder();

            while ((linha = br.readLine()) != null) {
                sql.append(linha).append(" ");
                if (linha.trim().endsWith(";")) {
                    stmt.execute(sql.toString());
                    sql.setLength(0);
                }
            }
            System.out.println("Comandos SQL do arquivo executados.");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao ler o arquivo SQL.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao executar comandos SQL.");
        }
    }
}
