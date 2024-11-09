package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Administrador {
    private int idAdm;
    private int idUsuarioAdm;

    public Administrador(int idAdm, int idUsuarioAdm) {
        this.idAdm = idAdm;
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
        String sql = "INSERT INTO admistrador(id_usuario_adm) VALUES (?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idUsuarioAdm);
            stmt.executeUpdate();
            System.out.println("Dados inseridos na tabela adminstrador com sucesso!");
            return true;
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