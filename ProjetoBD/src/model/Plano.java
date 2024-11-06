package model;

import java.util.Date;

public class Plano {
    private int idPlano;
    private String nome;
    private double duracao;
    private Date dataAquisicao;
    private double espacoUsuario;

    public Plano(int idPlano, String nome, double duracao, Date dataAquisicao, double espacoUsuario) {
        this.idPlano = idPlano;
        this.nome = nome;
        this.duracao = duracao;
        this.dataAquisicao = dataAquisicao;
        this.espacoUsuario = espacoUsuario;
    }

    public int getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(int idPlano) {
        this.idPlano = idPlano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public double getEspacoUsuario() {
        return espacoUsuario;
    }

    public void setEspacoUsuario(double espacoUsuario) {
        this.espacoUsuario = espacoUsuario;
    }

    @Override
    public String toString() {
        return "Plano{" +
                "idPlano=" + idPlano +
                ", nome='" + nome + '\'' +
                ", duracao=" + duracao +
                ", dataAquisicao=" + dataAquisicao +
                ", espacoUsuario=" + espacoUsuario +
                '}';
    }
}