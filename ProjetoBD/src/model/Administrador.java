package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Administrador {
    private int idAdm;
    private int idUsuarioAdm;

    public Administrador(int idAdm, int idUsuarioAdm) {
        this.idAdm = idAdm;
        this.idUsuarioAdm = idUsuarioAdm;
    }

    public int getIdAdm() {
        return idAdm;
    }

    public void setIdAdm(int idAdm) {
        this.idAdm = idAdm;
    }

    public int getIdUsuarioAdm() {
        return idUsuarioAdm;
    }

    public void setIdUsuarioAdm(int idUsuarioAdm) {
        this.idUsuarioAdm = idUsuarioAdm;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "idAdm=" + idAdm +
                ", idUsuarioAdm=" + idUsuarioAdm +
                '}';
    }
    public boolean insertAdm(Connection connection){
        String sql = "INSERT INTO admistrador(id_usuario_adm) VALUES (?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idUsuarioAdm);
            stmt.executeUpdate();
            System.out.println("Dados inseridos na tabela adminstrador com sucesso!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}