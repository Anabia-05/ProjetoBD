package model;

import java.util.Date;

public class Comentario {
    private int idComent;
    private String conteudo;
    private Date data;
    private String hora;
    private int idUsuario;
    private int idArquivo;

    public Comentario(int idComent, String conteudo, Date data, String hora, int idUsuario, int idArquivo) {
        this.idComent = idComent;
        this.conteudo = conteudo;
        this.data = data;
        this.hora = hora;
        this.idUsuario = idUsuario;
        this.idArquivo = idArquivo;
    }

    public int getIdComent() {
        return idComent;
    }

    public void setIdComent(int idComent) {
        this.idComent = idComent;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
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

    @Override
    public String toString() {
        return "Comentario{" +
                "idComent=" + idComent +
                ", conteudo='" + conteudo + '\'' +
                ", data=" + data +
                ", hora='" + hora + '\'' +
                ", idUsuario=" + idUsuario +
                ", idArquivo=" + idArquivo +
                '}';
    }
}