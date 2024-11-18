package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Usuario {
    private int idUsuario;
    private String login;
    private String senha;
    private String dataIngresso;
    private String email;
    private int idInstituicao;

    public Usuario(int idUsuario, String login, String senha, String dataIngresso, String email, int idInstituicao) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.senha = senha;
        this.dataIngresso = dataIngresso;
        this.email = email;
        this.idInstituicao = idInstituicao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(String dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(int idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", dataIngresso=" + dataIngresso +
                ", email='" + email + '\'' +
                ", idInstituicao=" + idInstituicao +
                '}';
    }

    public boolean insertUsuario(Connection connection){
        String sql = "INSERT INTO usuario(login,senha,data_ingresso,email,id_instituicao) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, login);
            stmt.setString(2, senha);
            stmt.setDate(3, java.sql.Date.valueOf(dataIngresso));
            stmt.setString(4, email);
            stmt.setInt(5, idInstituicao);
            stmt.executeUpdate();
            System.out.println("Dados inseridos na tabela instituicao com sucesso!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void printFilesUserHasAccessTo(Connection connection) {

        String sql = "SELECT nome, tipo, permissoes_acesso, tamanho, data_ultima_mod, localizacao, URL " + //coloquei cada nome ao invés de * para deixar mais claro
        "FROM acesso_arquivos_usuario " +
        "WHERE id_usuario = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, this.idUsuario);

            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("Arquivos que o usuário tem acesso:");

                boolean hasAccess = false;

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

                    hasAccess = true;
                }

                if (!hasAccess) {
                    System.out.println("Este usuário não tem acesso a nenhum arquivo.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printOperationHistory(Connection connection) {
        String sql = "SELECT conteudo_mudado, data, hora, usuario_que_alterou " +
        "FROM historico_usuario " +
        "WHERE id_usuario = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, this.idUsuario);

            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("Histórico de Operações:");

                boolean hasHistory = false;

                while (rs.next()) {
                    String conteudoMudado = rs.getString("conteudo_mudado");
                    String data = rs.getString("data");
                    String hora = rs.getString("hora");
                    String usuarioQueAlterou = rs.getString("usuario_que_alterou");

                    System.out.println("Conteúdo alterado: " + conteudoMudado);
                    System.out.println("Data: " + data);
                    System.out.println("Hora: " + hora);
                    System.out.println("Alterado por: " + usuarioQueAlterou);

                    hasHistory = true;
                }

                if (!hasHistory) {
                    System.out.println("Este usuário não possui histórico de operações.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}