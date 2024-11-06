package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;

public class Comentario {
    private int idComent;
    private String conteudo;
    private Date data;
    private Time hora;
    private int idUsuario;
    private int idArquivo;

    public Comentario(int idComent, String conteudo, Date data, Time hora, int idUsuario, int idArquivo) {
        this.idComent = idComent;
        this.conteudo = conteudo;
        this.data = data;
        this.hora = hora;
        this.idUsuario = idUsuario;
        this.idArquivo = idArquivo;
    }

    public int getIdComent() {
        return idComent;
    }

    public void setIdComent(int idComent) {
        this.idComent = idComent;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(int idArquivo) {
        this.idArquivo = idArquivo;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "idComent=" + idComent +
                ", conteudo='" + conteudo + '\'' +
                ", data=" + data +
                ", hora='" + hora + '\'' +
                ", idUsuario=" + idUsuario +
                ", idArquivo=" + idArquivo +
                '}';
    }
    public boolean insertComent(Connection connection){
        String sql = "INSERT INTO comentario(conteudo,data,hora,id_usuario,id_arquivo) VALUES (?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, conteudo);
            stmt.setDate(2, (java.sql.Date) data);
            stmt.setTime(3, hora);
            stmt.setInt(4, idUsuario);
            stmt.setInt(5, idArquivo);
            stmt.executeUpdate();
            System.out.println("Dados inseridos na tabela Comentario com sucesso!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}