package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Usuario {
    private int idUsuario;
    private String login;
    private String senha;
    private Date dataIngresso;
    private String email;
    private int idInstituicao;

    public Usuario(int idUsuario, String login, String senha, Date dataIngresso, String email, int idInstituicao) {
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

    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Date dataIngresso) {
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
            stmt.setDate(3, (java.sql.Date) dataIngresso);
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
}