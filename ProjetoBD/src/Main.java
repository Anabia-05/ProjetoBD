import java.sql.Connection;
import java.sql.SQLException;
import util.DBConnection;
import util.DatabaseCreator;
import model.Plano;
import model.Instituicao;
import model.Usuario;
import model.AdmUsuario;
import model.AdmUsuario;
import model.Arquivo;



public class Main {
    public static void main(String[] args) {
        System.out.println("Programa iniciado!");

        try (Connection connection = DBConnection.getConnection()) {
            System.out.println("Conexão com o banco de dados estabelecida.");
            DatabaseCreator databaseCreator = new DatabaseCreator(connection);
            databaseCreator.executeTableCreation();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao conectar ao banco de dados.");
        }
    }
}