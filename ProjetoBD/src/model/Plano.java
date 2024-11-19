package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Plano {
    private int idPlano;
    private String nome;
    private double duracao;
    private String dataAquisicao;
    private double espacoUsuario;

    public Plano(String nome, double duracao, String dataAquisicao, double espacoUsuario) {
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

    public String getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(String dataAquisicao) {
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

    public boolean insertPlano(Connection connection){
        String sql = "INSERT INTO plano(nome,duracao,data_aquisicao,espaco_usuario) VALUES (?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, duracao);
            stmt.setDate(3, java.sql.Date.valueOf(dataAquisicao));
            stmt.setDouble(4, espacoUsuario);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {

                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        this.idPlano = generatedKeys.getInt(1); // Obtendo o ID gerado
                        System.out.println("Plano inserido com ID: " + this.idPlano);
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
}
