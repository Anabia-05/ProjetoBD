package model;

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
}