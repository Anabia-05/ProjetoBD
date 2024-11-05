import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {
    private Connection connection;

    public TableCreator(Connection connection){
        this.connection = connection;
    }
    
    public void createPlanoTable(){
        String sql = "CREATE TABLE IF NOT EXISTS plano (" +
        "id_plano INT AUTO_INCREMENT" +
        "nome VARCHAR(40)" +
        "duracao DOUBLE" +
        "data_aquisicao DATA"+
        "espaco_usuario DOUBLE" +
        "PRIMARY KEY(id_plano))";

        executeSQL(sql,"Tabela planp criada com sucesso!");
    }
    
    public void createInstituicaoTable(){
        String sql = "CREATE TABLE IF NOT EXISTS instituicao (" +
        "id_instuicao INT AUTO_INCREMENT" +
        "nome VARCHAR(30) UNIQUE" +
        "causa_social VARCHAR(50)" +
        "endereco VARCHAR(50)"+
        "id_plano INT" +
        "PRIMARY KEY(id_instuicao) "+
        "FOREIGN KEY(id_plano) REFERENCES plano(id_plano))";

        executeSQL(sql,"Tabela instituicao criada com sucesso!");
    }
    
    public void createUsusarioTable(){
        String sql = "CREATE TABLE IF NOT EXISTS usuario (" +
        "id_usuario INT AUTO_INCREMENT" +
        "login VARCHAR(40) UNIQUE" +
        "senha VARCHAR(10)" +
        "data_ingresso DATA"+
        "email VARCHAR(40) UNIQUE" +
        "id_instituicao INT" +
        "PRIMARY KEY(id_usuario) "+
        "FOREIGN KEY(id_instituicao) REFERENCES instituicao(id_instituicao))";

        executeSQL(sql,"Tabela usuario criada com sucesso!");
    }

    public void createAdminitracaoTable(){
        String sql = "CREATE TABLE IF NOT EXISTS administracao (" +
        "id_adm INT " +
        "id_usuario_adminstrado INT" +
        "FOREIGN KEY(id_usuario_admistrado) REFERENCES usuario(id_usuario)" +
        "FOREIGN KEY(id_adm) REFERENCES usuario(id_adm))";

        executeSQL(sql,"Tabela adminstracao criada com sucesso!");
    }
    public void createAdministradorTable(){
        String sql = "CREATE TABLE IF NOT EXISTS administrador (" +
        "id_adm INT AUTO_INCREMENT" +
        "id_usuario_adm INT" +
        "PRIMARY KEY(id_adm) "+
        "FOREIGN KEY(id_usuario_adm) REFERENCES usuario(id_usuario))";

        executeSQL(sql,"Tabela administrador criada com sucesso!");
    }
    public void createSuporteTable(){
        String sql = "CREATE TABLE IF NOT EXISTS suporte (" +
        "id_suporte INT AUTO_INCREMENT" +
        "descricao VARCHAR(30)" +
        "data DATA"+
        "hora TIME"+
        "id_usuario INT" +
        "id_arquivo INT" +
        "id_adm INT" +
        "PRIMARY KEY(id_suporte)" + 
        "FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario)"+
        "FOREIGN KEY(id_arquivo) REFERENCES arquivo(id_arquivo)"+
        "FOREIGN KEY(id_adm) REFERENCES admistrador(id_adm))"
        ;

        executeSQL(sql,"Tabela suporte criada com sucesso!");
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
    public void createHistoricoTable(){
        String sql = "CREATE TABLE IF NOT EXISTS historico (" +
        "id_historico INT AUTO_INCREMENT" +
        "conteudo_mudado VARCHAR(30)" +
        "data DATA"+
        "hora TIME"+
        "id_usuario_alterou INT" +
        "id_arquivo INT" +
        "PRIMARY KEY(id_coment)" + 
        "FOREIGN KEY(id_usuario_alterou) REFERENCES usuario(id_usuario)"+
        "FOREIGN KEY(id_arquivo) REFERENCES arquivo(id_arquivo))";

        executeSQL(sql,"Tabela historico criada com sucesso!");
    }
    public void createOperacoesTable(){
        String sql = "CREATE TABLE IF NOT EXISTS operacoes (" +
        "id_op INT AUTO_INCREMENT" +
        "data DATA"+
        "hora TIME"+
        "tipo_operacao VARCHAR(30) CHECK(tipo_operacao = 'carregar' OR tipo_operacao = 'atualizar' OR tipo_operacao = 'remover')" +
        "id_usuario INT" +
        "id_arquivo INT" +
        "PRIMARY KEY(id_op)" + 
        "FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario)"+
        "FOREIGN KEY(id_arquivo) REFERENCES arquivo(id_arquivo))";

        executeSQL(sql,"Tabela operacoes criada com sucesso!");
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
