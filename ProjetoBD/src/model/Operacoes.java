package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Operacoes {
    private int idOp;
    private String data;
    private String hora;
    private String tipoOperacao;
    private int idUsuario;
    private int idArquivo;

    public Operacoes(int idOp, String data, String hora, String tipoOperacao, int idUsuario, int idArquivo) {
        this.idOp = idOp;
        this.data = data;
        this.hora = hora;
        this.tipoOperacao = tipoOperacao;
        this.idUsuario = idUsuario;
        this.idArquivo = idArquivo;
    }

    public int getIdOp() {
        return idOp;
    }

    public void setIdOp(int idOp) {
        this.idOp = idOp;
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

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
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
        return "Operacoes{" +
                "idOp=" + idOp +
                ", data=" + data +
                ", hora='" + hora + '\'' +
                ", tipoOperacao='" + tipoOperacao + '\'' +
                ", idUsuario=" + idUsuario +
                ", idArquivo=" + idArquivo +
                '}';
    }

    public boolean insertOperacoes(Connection connection){
        String sql = "INSERT INTO operacoes(data,hora,tipo_operacao,id_usuario,id_arquivo) VALUES (?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, java.sql.Date.valueOf(data));
            stmt.setTime(2, java.sql.Time.valueOf(hora));
            stmt.setString(3, tipoOperacao);
            stmt.setInt(4, idUsuario);
            stmt.setInt(5, idArquivo);
            stmt.executeUpdate();
            System.out.println("Dados inseridos na tabela operacoes com sucesso!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}