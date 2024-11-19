package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Compartilhamento {
    private int idComp;
    private int idArquivo;
    private String data;
    private int idDono;

    public Compartilhamento(int idArquivo, String data, int idDono) {
        this.idArquivo = idArquivo;
        this.data = data;
        this.idDono = idDono;
    }

    public int getIdComp() {
        return idComp;
    }

    public void setIdComp(int idComp) {
        this.idComp = idComp;
    }

    public int getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(int idArquivo) {
        this.idArquivo = idArquivo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdDono() {
        return idDono;
    }

    public void setIdDono(int idDono) {
        this.idDono = idDono;
    }

    @Override
    public String toString() {
        return "Compartilhamento{" +
                "idComp=" + idComp +
                ", idArquivo=" + idArquivo +
                ", data=" + data +
                ", idDono=" + idDono +
                '}';
    }

    public boolean insertCompart(Connection connection){
        String sql = "INSERT INTO compartilhamento(id_arquivo,data,id_dono) VALUES (?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, idArquivo);
            stmt.setDate(2, java.sql.Date.valueOf(data));
            stmt.setInt(3, idDono);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {

                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        this.idComp = generatedKeys.getInt(1); // Obtendo o ID gerado
                        System.out.println("Compartilhamento inserido com ID: " + this.idComp);
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
