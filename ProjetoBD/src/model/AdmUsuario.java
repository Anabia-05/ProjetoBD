package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdmUsuario {
    private int idAdm;
    private int idUsuarioAdministrado;

    public AdmUsuario(int idAdm, int idUsuarioAdministrado) {
        this.idAdm = idAdm;
        this.idUsuarioAdministrado = idUsuarioAdministrado;
    }

    public int getIdAdm() {
        return idAdm;
    }

    public void setIdAdm(int idAdm) {
        this.idAdm = idAdm;
    }

    public int getIdUsuarioAdministrado() {
        return idUsuarioAdministrado;
    }

    public void setIdUsuarioAdministrado(int idUsuarioAdministrado) {
        this.idUsuarioAdministrado = idUsuarioAdministrado;
    }

    @Override
    public String toString() {
        return "AdmUsuario{" +
                "idAdm=" + idAdm +
                ", idUsuarioAdministrado=" + idUsuarioAdministrado +
                '}';
    }

    public boolean insertAdmUsuario(Connection connection){
        String sql = "INSERT INTO adm_usuario(id_adm,id_usuario_administrado) VALUES (?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idAdm);
            stmt.setInt(2, idUsuarioAdministrado);
            stmt.executeUpdate();
            System.out.println("Dados inseridos na tabela admUsuario com sucesso!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}