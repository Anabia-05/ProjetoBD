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
}
