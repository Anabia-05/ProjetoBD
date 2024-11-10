package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.CallableStatement;
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
    public boolean insertArquivo(Connection connection){
        String sql = "INSERT INTO arquivo(nome,tipo,permissoes_acesso,tamanho,data_ultima_mod,localizacao,URL,id_usuario) VALUES (?,?,?,?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, tipo);
            stmt.setString(3, permissoesAcesso);
            stmt.setInt(4, tamanho);
            stmt.setDate(5,(java.sql.Date) dataUltimaMod);
            stmt.setString(6, localizacao);
            stmt.setString(7, url);
            stmt.setInt(8, idUsuario);
            stmt.executeUpdate();
            System.out.println("Dados inseridos na tabela arquivo com sucesso!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean chavearArquivo(Connection connection) {
        String sql = "{CALL chavear_arquivo(?)}";
        
        try (CallableStatement stmt = connection.prepareCall(sql)) {
            stmt.setInt(1, this.idArquivo);
    
            stmt.executeUpdate();
    
            System.out.println("Stored procedure executed successfully!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}