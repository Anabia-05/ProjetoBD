package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Historico {
    private int idHistorico;
    private String conteudoMudado;
    private String data;
    private String hora;
    private int idUsuarioAlterou;
    private int idArquivo;

    public Historico(String conteudoMudado, String data, String hora, int idUsuarioAlterou, int idArquivo) {
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

        try (PreparedStatement stmt = connection.prepareStatement(sql , PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, conteudoMudado);
            stmt.setDate(2, java.sql.Date.valueOf(data));
            stmt.setTime(3, java.sql.Time.valueOf(hora));
            stmt.setInt(4, idUsuarioAlterou);
            stmt.setInt(5, idArquivo);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {

                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        this.idHistorico = generatedKeys.getInt(1); // Obtendo o ID gerado
                        System.out.println("Historico inserido com ID: " + this.idHistorico);
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
