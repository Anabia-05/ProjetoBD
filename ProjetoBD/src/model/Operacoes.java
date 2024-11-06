package model;

import java.util.Date;

public class Operacoes {
    private int idOp;
    private Date data;
    private String hora;
    private String tipoOperacao;
    private int idUsuario;
    private int idArquivo;

    public Operacoes(int idOp, Date data, String hora, String tipoOperacao, int idUsuario, int idArquivo) {
        this.idOp = idOp;
        this.data = data;
        this.hora = hora;
        this.tipoOperacao = tipoOperacao;
        this.idUsuario = idUsuario;
        this.idArquivo = idArquivo;
    }

    public int getIdOp() {
        return idOp;
    }

    public void setIdOp(int idOp) {
        this.idOp = idOp;
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

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
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

    @Override
    public String toString() {
        return "Operacoes{" +
                "idOp=" + idOp +
                ", data=" + data +
                ", hora='" + hora + '\'' +
                ", tipoOperacao='" + tipoOperacao + '\'' +
                ", idUsuario=" + idUsuario +
                ", idArquivo=" + idArquivo +
                '}';
    }
}