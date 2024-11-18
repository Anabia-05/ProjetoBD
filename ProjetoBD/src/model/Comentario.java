package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Comentario {
    private int idComent;
    private String conteudo;
    private String data;
    private String hora;
    private int idUsuario;
    private int idArquivo;

    public Comentario(String conteudo, String data, String hora, int idUsuario, int idArquivo) {
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
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
            stmt.setDate(2, java.sql.Date.valueOf(data));
            stmt.setTime(3, java.sql.Time.valueOf(hora));
            stmt.setInt(4, idUsuario);
            stmt.setInt(5, idArquivo);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
            
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        this.idComent = generatedKeys.getInt(1); // Obtendo o ID gerado
                        System.out.println("Comentario inserido com ID: " + this.idComent);
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
}