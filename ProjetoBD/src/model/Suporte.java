package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Suporte {
    private int idSuporte;
    private String descricao;
    private String data;
    private String hora;
    private int idUsuario;
    private int idArquivo;
    private int idAdm;

    public Suporte(String descricao, String data, String hora, int idUsuario, int idArquivo, int idAdm) {
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;
        this.idUsuario = idUsuario;
        this.idArquivo = idArquivo;
        this.idAdm = idAdm;
    }

    public int getIdSuporte() {
        return idSuporte;
    }

    public void setIdSuporte(int idSuporte) {
        this.idSuporte = idSuporte;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public int getIdAdm() {
        return idAdm;
    }

    public void setIdAdm(int idAdm) {
        this.idAdm = idAdm;
    }

    @Override
    public String toString() {
        return "Suporte{" +
                "idSuporte=" + idSuporte +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", hora='" + hora + '\'' +
                ", idUsuario=" + idUsuario +
                ", idArquivo=" + idArquivo +
                ", idAdm=" + idAdm +
                '}';
    }

    public boolean insertSuport(Connection connection){
        String sql = "INSERT INTO suporte(descricao,data,hora,id_usuario,id_arquivo,id_adm) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, descricao);
            stmt.setDate(2, java.sql.Date.valueOf(data));
            stmt.setTime(3, java.sql.Time.valueOf(hora));
            stmt.setInt(4, idUsuario);
            stmt.setInt(5, idArquivo);
            stmt.setInt(6, idAdm);
           
            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
            
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        this.idSuporte = generatedKeys.getInt(1); // Obtendo o ID gerado
                        System.out.println("Suporte inserido com ID: " + this.idSuporte);
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