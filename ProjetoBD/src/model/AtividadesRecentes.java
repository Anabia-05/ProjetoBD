package model;

import java.util.Date;

public class AtividadesRecentes {
    private int idArquivo;
    private Date ultimaVersao;
    private String acesso;

    public AtividadesRecentes(int idArquivo, Date ultimaVersao, String acesso) {
        this.idArquivo = idArquivo;
        this.ultimaVersao = ultimaVersao;
        this.acesso = acesso;
    }

    public int getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(int idArquivo) {
        this.idArquivo = idArquivo;
    }

    public Date getUltimaVersao() {
        return ultimaVersao;
    }

    public void setUltimaVersao(Date ultimaVersao) {
        this.ultimaVersao = ultimaVersao;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    @Override
    public String toString() {
        return "AtividadesRecentes{" +
                "idArquivo=" + idArquivo +
                ", ultimaVersao=" + ultimaVersao +
                ", acesso='" + acesso + '\'' +
                '}';
    }
}