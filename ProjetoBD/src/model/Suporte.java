package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;

public class Suporte {
    private int idSuporte;
    private String descricao;
    private Date data;
    private Time hora;
    private int idUsuario;
    private int idArquivo;
    private int idAdm;

    public Suporte(int idSuporte, String descricao, Date data, Time hora, int idUsuario, int idArquivo, int idAdm) {
        this.idSuporte = idSuporte;
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
            stmt.setDate(2, (java.sql.Date) data);
            stmt.setTime(3, hora);
            stmt.setInt(4, idUsuario);
            stmt.setInt(5, idArquivo);
            stmt.setInt(6, idAdm);
            stmt.executeUpdate();
            System.out.println("Dados inseridos na tabela suporte com sucesso!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}