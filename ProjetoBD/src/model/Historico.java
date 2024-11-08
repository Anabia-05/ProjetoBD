package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;

public class Historico {
    private int idHistorico;      
    private String conteudoMudado;
    private Date data;           
    private Time hora;         
    private int idUsuarioAlterou;
    private int idArquivo;

    public Historico(int idHistorico, String conteudoMudado, Date data, Time hora, int idUsuarioAlterou, int idArquivo) {
        this.idHistorico = idHistorico;
        this.conteudoMudado = conteudoMudado;
        this.data = data;
        this.hora = hora;
        this.idUsuarioAlterou = idUsuarioAlterou;
        this.idArquivo = idArquivo;
    }

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public String getConteudoMudado() {
        return conteudoMudado;
    }

    public void setConteudoMudado(String conteudoMudado) {
        this.conteudoMudado = conteudoMudado;
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

    public int getIdUsuarioAlterou() {
        return idUsuarioAlterou;
    }

    public void setIdUsuarioAlterou(int idUsuarioAlterou) {
        this.idUsuarioAlterou = idUsuarioAlterou;
    }

    public int getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(int idArquivo) {
        this.idArquivo = idArquivo;
    }

    @Override
    public String toString() {
        return "Historico{" +
                "idHistorico=" + idHistorico +
                ", conteudoMudado='" + conteudoMudado + '\'' +
                ", data=" + data +
                ", hora='" + hora + '\'' +
                ", idUsuarioAlterou=" + idUsuarioAlterou +
                ", idArquivo=" + idArquivo +
                '}';
    }

    public boolean insertHistorico(Connection connection){
        String sql = "INSERT INTO historico(conteudo_mudado,data,hora,id_usuario_alterou,id_arquivo) VALUES (?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, conteudoMudado);
            stmt.setDate(2, (java.sql.Date) data);
            stmt.setTime(3, hora);
            stmt.setInt(4, idUsuarioAlterou);
            stmt.setInt(5, idArquivo);
            stmt.executeUpdate();
            System.out.println("Dados inseridos na tabela historico com sucesso!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}