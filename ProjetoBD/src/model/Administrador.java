package model;

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
}