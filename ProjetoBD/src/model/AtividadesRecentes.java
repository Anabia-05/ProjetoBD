package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AtividadesRecentes {
    private int idArquivo;
    private String ultimaVersao;
    private String acesso;

    public AtividadesRecentes(int idArquivo, String ultimaVersao, String acesso) {
        this.idArquivo = idArquivo;
        this.ultimaVersao = ultimaVersao;
        this.acesso = acesso;
    }

    public int getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(int idArquivo) {
        this.idArquivo = idArquivo;
    }

    public String getUltimaVersao() {
        return ultimaVersao;
    }

    public void setUltimaVersao(String ultimaVersao) {
        this.ultimaVersao = ultimaVersao;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    @Override
    public String toString() {
        return "AtividadesRecentes{" +
                "idArquivo=" + idArquivo +
                ", ultimaVersao=" + ultimaVersao +
                ", acesso='" + acesso + '\'' +
                '}';
    }

    public boolean insertAtividades(Connection connection){
        String sql = "INSERT INTO atividades_recentes(id_arquivo,ultima_versao,acesso) VALUES (?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1,idArquivo);
            stmt.setDate(2, java.sql.Date.valueOf(ultimaVersao));
            stmt.setString(3, acesso);
            stmt.executeUpdate();
            System.out.println("Dados inseridos na tabela atividades com sucesso!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}