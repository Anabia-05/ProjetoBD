package model;

public class Instituicao {
    private int idInstituicao;
    private String nome;
    private String causaSocial;
    private String endereco;
    private int idPlano;

    public Instituicao(int idInstituicao, String nome, String causaSocial, String endereco, int idPlano) {
        this.idInstituicao = idInstituicao;
        this.nome = nome;
        this.causaSocial = causaSocial;
        this.endereco = endereco;
        this.idPlano = idPlano;
    }

    public int getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(int idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCausaSocial() {
        return causaSocial;
    }

    public void setCausaSocial(String causaSocial) {
        this.causaSocial = causaSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(int idPlano) {
        this.idPlano = idPlano;
    }

    @Override
    public String toString() {
        return "Instituicao{" +
                "idInstituicao=" + idInstituicao +
                ", nome='" + nome + '\'' +
                ", causaSocial='" + causaSocial + '\'' +
                ", endereco='" + endereco + '\'' +
                ", idPlano=" + idPlano +
                '}';
    }
}