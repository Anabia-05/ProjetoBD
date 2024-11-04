import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {
    private Connection connection;

    public TableCreator(Connection connection){
        this.connection = connection;
    }
    
    public void createUsusarioTable(){
        String sql = "CREATE TABLE IF NOT EXISTS usuario (" +
        "id_usuario INT AUTO_INCREMENT" +
        "login VARCHAR(40) UNIQUE" +
        "senha VARCHAR(10)" +
        "data_ingresso DATA"+
        "email VARCHAR(40) UNIQUE" +
        "PRIMARY KEY(id_usuario) )";

        executeSQL(sql,"Tabela usuario criada com sucesso!");
    }

    public void createArquivoTable(){
        String sql = "CREATE TABLE IF NOT EXISTS arquivo (" +
        "id_arquivo INT AUTO_INCREMENT" +
        "nome VARCHAR(30)" +
        "tipo VARCHAR(10)" +
        "permissoes_acesso VARCHAR(50)" +
        "tamanho INT" +
        "data_ultima_mod DATA"+
        "localizacao VARCHAR(10)" +
        "URL VARCHAR(50)" +
        "id_usuario INT" +
        "PRIMARY KEY(id_arquivo)" + 
        "FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario))"
        ;

        executeSQL(sql,"Tabela arquivo criada com sucesso!");

    }

    public void createInstituicaoTable(){
        String sql = "CREATE TABLE IF NOT EXISTS instituicao (" +
        "id_instuicao INT AUTO_INCREMENT" +
        "nome VARCHAR(30) UNIQUE" +
        "causa_social VARCHAR(50)" +
        "endereco VARCHAR(50)"+
        "PRIMARY KEY(id_instuicao) )";

        executeSQL(sql,"Tabela usuario criada com sucesso!");
    }




    public void createCompartilhamentoTable(){
        String sql = "CREATE TABLE IF NOT EXISTS compartilhamento (" +
        "id_comp INT AUTO_INCREMENT" +
        "id_arquivo INT" +
        "data DATA"+
        "id_dono INT" +
        "PRIMARY KEY(id_comp)" + 
        "FOREIGN KEY(id_dono) REFERENCES usuario(id_usuario)"+
         "FOREIGN KEY(id_arquivo) REFERENCES arquivo(id_arquivo))"
        ;

        executeSQL(sql,"Tabela compartilhamento criada com sucesso!");

    }

    public void createComentarioTable(){
        String sql = "CREATE TABLE IF NOT EXISTS comentario (" +
        "id_coment INT AUTO_INCREMENT" +
        "conteudo VARCHAR(30)" +
        "data DATA"+
        "hora TIME"+
        "id_usuario INT" +
        "id_arquivo INT" +
        "PRIMARY KEY(id_coment)" + 
        "FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario)"+
         "FOREIGN KEY(id_arquivo) REFERENCES arquivo(id_arquivo))"
        ;

        executeSQL(sql,"Tabela comentario criada com sucesso!");

    }

    private void executeSQL(String sql, String successMessage) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println(successMessage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
