package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Administrador {
    private int idAdm;
    private int idUsuarioAdm;

    public Administrador(int idUsuarioAdm) {
        this.idUsuarioAdm = idUsuarioAdm;
    }

    public int getIdAdm() {
        return idAdm;
    }

    public void setIdAdm(int idAdm) {
        this.idAdm = idAdm;
    }

    public int getIdUsuarioAdm() {
        return idUsuarioAdm;
    }

    public void setIdUsuarioAdm(int idUsuarioAdm) {
        this.idUsuarioAdm = idUsuarioAdm;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "idAdm=" + idAdm +
                ", idUsuarioAdm=" + idUsuarioAdm +
                '}';
    }
    public boolean insertAdm(Connection connection){
        String sql = "INSERT INTO administrador(id_usuario_adm) VALUES (?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, idUsuarioAdm);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                // pegando o id gerado pelo auto increment da insercao
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        this.idAdm = generatedKeys.getInt(1); // Obtendo o ID gerado
                        System.out.println("Administrador inserido com ID: " + this.idAdm);
                    }
                }
                return true;
            } else {
                System.out.println("Erro: Nenhuma linha afetada na inserção.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void printFilesAdminHasAccessTo(Connection connection) {
        String sql = "SELECT nome, tipo, permissoes_acesso, tamanho, data_ultima_mod, localizacao, URL FROM acesso_arquivos_admin";  //coloquei cada nome ao invés de * para deixar mais claro

        try (PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            System.out.println("Arquivos que o administrador tem acesso:");

            while (rs.next()) {

                String nome = rs.getString("nome");
                String tipo = rs.getString("tipo");
                String permissoesAcesso = rs.getString("permissoes_acesso");
                long tamanho = rs.getLong("tamanho");
                String dataUltimaMod = rs.getString("data_ultima_mod");
                String localizacao = rs.getString("localizacao");
                String url = rs.getString("URL");

                System.out.println("Nome: " + nome);
                System.out.println("Tipo: " + tipo);
                System.out.println("Permissões de Acesso: " + permissoesAcesso);
                System.out.println("Tamanho: " + tamanho + " bytes");
                System.out.println("Data da Última Modificação: " + dataUltimaMod);
                System.out.println("Localização: " + localizacao);
                System.out.println("URL: " + url);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
