package model;

import java.util.Date;

public class Suporte {
    private int idSuporte;
    private String descricao;
    private Date data;
    private String hora;
    private int idUsuario;
    private int idArquivo;
    private int idAdm;

    public Suporte(int idSuporte, String descricao, Date data, String hora, int idUsuario, int idArquivo, int idAdm) {
        this.idSuporte = idSuporte;
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;
        this.idUsuario = idUsuario;
        this.idArquivo = idArquivo;
        this.idAdm = idAdm;
    }

    public int getIdSuporte() {
        return idSuporte;
    }

    public void setIdSuporte(int idSuporte) {
        this.idSuporte = idSuporte;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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

    public int getIdAdm() {
        return idAdm;
    }

    public void setIdAdm(int idAdm) {
        this.idAdm = idAdm;
    }

    @Override
    public String toString() {
        return "Suporte{" +
                "idSuporte=" + idSuporte +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", hora='" + hora + '\'' +
                ", idUsuario=" + idUsuario +
                ", idArquivo=" + idArquivo +
                ", idAdm=" + idAdm +
                '}';
    }
}