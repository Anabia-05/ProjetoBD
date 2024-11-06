package model;

import java.util.Date;

public class Historico {
    private int idHistorico;      
    private String conteudoMudado;
    private Date data;           
    private String hora;         
    private int idUsuarioAlterou;
    private int idArquivo;

    public Historico(int idHistorico, String conteudoMudado, Date data, String hora, int idUsuarioAlterou, int idArquivo) {
        this.idHistorico = idHistorico;
        this.conteudoMudado = conteudoMudado;
        this.data = data;
        this.hora = hora;
        this.idUsuarioAlterou = idUsuarioAlterou;
        this.idArquivo = idArquivo;
    }

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public String getConteudoMudado() {
        return conteudoMudado;
    }

    public void setConteudoMudado(String conteudoMudado) {
        this.conteudoMudado = conteudoMudado;
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

    public int getIdUsuarioAlterou() {
        return idUsuarioAlterou;
    }

    public void setIdUsuarioAlterou(int idUsuarioAlterou) {
        this.idUsuarioAlterou = idUsuarioAlterou;
    }

    public int getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(int idArquivo) {
        this.idArquivo = idArquivo;
    }

    @Override
    public String toString() {
        return "Historico{" +
                "idHistorico=" + idHistorico +
                ", conteudoMudado='" + conteudoMudado + '\'' +
                ", data=" + data +
                ", hora='" + hora + '\'' +
                ", idUsuarioAlterou=" + idUsuarioAlterou +
                ", idArquivo=" + idArquivo +
                '}';
    }
}