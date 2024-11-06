package model;

import java.util.Date;

public class Compartilhamento {
    private int idComp;
    private int idArquivo;
    private Date data;
    private int idDono;

    public Compartilhamento(int idComp, int idArquivo, Date data, int idDono) {
        this.idComp = idComp;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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
}