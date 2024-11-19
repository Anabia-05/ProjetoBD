package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;


public class Arquivo {
    private int idArquivo;
    private String nome;
    private String tipo;
    private String permissoesAcesso;
    private int tamanho;
    private String dataUltimaMod;
    private String localizacao;
    private String url;
    private int idUsuario;

    public Arquivo(String nome, String tipo, String permissoesAcesso, int tamanho, String dataUltimaMod, String localizacao, String url, int idUsuario) {
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

    public String getDataUltimaMod() {
        return dataUltimaMod;
    }

    public void setDataUltimaMod(String dataUltimaMod) {
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

        try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nome);
            stmt.setString(2, tipo);
            stmt.setString(3, permissoesAcesso);
            stmt.setInt(4, tamanho);
            stmt.setDate(5, java.sql.Date.valueOf(dataUltimaMod));
            stmt.setString(6, localizacao);
            stmt.setString(7, url);
            stmt.setInt(8, idUsuario);
            int affectedRows = stmt.executeUpdate();

            // Verificando se alguma linha foi afetada
            if (affectedRows > 0) {
                // pegando o id gerado pelo auto increment da insercao
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        this.idArquivo = generatedKeys.getInt(1); // Obtendo o ID gerado
                        System.out.println("Arquivo inserido com ID: " + this.idArquivo);
                    }
                }
                return true;
            } else {
                System.out.println("Erro: Nenhuma linha afetada na inserção.");
                return false;
            }
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
