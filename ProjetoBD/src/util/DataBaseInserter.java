package util;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseInserter {
    private final Connection connection;

    public DataBaseInserter(Connection connection){
        this.connection = connection;
    }

    public void insertPlano(String nome, double duracao, Date data_aquisicao, double espacoUsuario){
        String sql = "INSERT INTO plano(nome,duracao,data_aquisicao,espaco_usuario) VALUES (?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, duracao);
            stmt.setDate(3, new java.sql.Date(data_aquisicao.getTime()));
            stmt.setDouble(4, espacoUsuario);
            stmt.executeUpdate();
            System.out.println("Dados inseridos na tabela plano com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertInstituicao(String nome, String causa_social,  String endereco, int id_plano){
        String sql = "INSERT INTO instituicao(nome,causa_social,endereco,id_plano) VALUES (?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, causa_social);
            stmt.setString(3, endereco);
            stmt.setInt(4, id_plano);
            stmt.executeUpdate();
            System.out.println("Dados inseridos na tabela instituicao com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertUsuario(String nome, String login,  String senha, Date data_ingresso, String email, int id_instituicao){
        String sql = "INSERT INTO usuario(nome,login,senha,data_ingresso,email,id_instituicao) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, login);
            stmt.setString(3, senha);
            stmt.setDate(4, new java.sql.Date(data_ingresso.getTime()));
            stmt.setString(5, email);
            stmt.setInt(6, id_instituicao);
            stmt.executeUpdate();
            System.out.println("Dados inseridos na tabela instituicao com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
