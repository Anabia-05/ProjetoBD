package model;

import java.util.Date;

public class Arquivo {
    private int idArquivo;
    private String nome;
    private String tipo;
    private String permissoesAcesso;
    private int tamanho;
    private Date dataUltimaMod;
    private String localizacao;
    private String url;
    private int idUsuario;

    public Arquivo(int idArquivo, String nome, String tipo, String permissoesAcesso, int tamanho, Date dataUltimaMod, String localizacao, String url, int idUsuario) {
        this.idArquivo = idArquivo;
        this.nome = nome;
        this.tipo = tipo;
        this.permissoesAcesso = permissoesAcesso;
        this.tamanho = tamanho;
        this.dataUltimaMod = dataUltimaMod;
        this.localizacao = localizacao;
        this.url = url;
        this.idUsuario = idUsuario;
    }

    public int getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(int idArquivo) {
        this.idArquivo = idArquivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPermissoesAcesso() {
        return permissoesAcesso;
    }

    public void setPermissoesAcesso(String permissoesAcesso) {
        this.permissoesAcesso = permissoesAcesso;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public Date getDataUltimaMod() {
        return dataUltimaMod;
    }

    public void setDataUltimaMod(Date dataUltimaMod) {
        this.dataUltimaMod = dataUltimaMod;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Arquivo{" +
                "idArquivo=" + idArquivo +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", permissoesAcesso='" + permissoesAcesso + '\'' +
                ", tamanho=" + tamanho +
                ", dataUltimaMod=" + dataUltimaMod +
                ", localizacao='" + localizacao + '\'' +
                ", url='" + url + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}