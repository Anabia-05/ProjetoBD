package util;
 
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
 
public class TableCreator {
    private Connection connection;
 
    public TableCreator(Connection connection) {
        this.connection = connection;
    }
 
    // Métodos para criação de tabelas
    public void createPlanoTable() {
        String sql = "CREATE TABLE IF NOT EXISTS plano (" +
                "id_plano INT AUTO_INCREMENT, " +
                "nome VARCHAR(40), " +
                "duracao DOUBLE, " +
                "data_aquisicao DATE, " +
                "espaco_usuario DOUBLE, " +
                "PRIMARY KEY(id_plano))";
        executeSQL(sql, "Tabela 'plano' criada com sucesso!");
    }
 
    public void createInstituicaoTable() {
        String sql = "CREATE TABLE IF NOT EXISTS instituicao (" +
                "id_instituicao INT AUTO_INCREMENT, " +
                "nome VARCHAR(30) UNIQUE, " +
                "causa_social VARCHAR(50), " +
                "endereco VARCHAR(50), " +
                "id_plano INT, " +
                "PRIMARY KEY(id_instituicao), " +
                "FOREIGN KEY(id_plano) REFERENCES plano(id_plano))";
        executeSQL(sql, "Tabela 'instituicao' criada com sucesso!");
    }
 
    public void createUsuarioTable() {
        String sql = "CREATE TABLE IF NOT EXISTS usuario (" +
                "id_usuario INT AUTO_INCREMENT, " +
                "login VARCHAR(40) UNIQUE, " +
                "senha VARCHAR(10), " +
                "data_ingresso DATE, " +
                "email VARCHAR(40) UNIQUE, " +
                "id_instituicao INT, " +
                "PRIMARY KEY(id_usuario), " +
                "FOREIGN KEY(id_instituicao) REFERENCES instituicao(id_instituicao))";
        executeSQL(sql, "Tabela 'usuario' criada com sucesso!");
    }
 
    public void createAdministracaoTable() {
        String sql = "CREATE TABLE IF NOT EXISTS administracao (" +
                "id_adm INT, " +
                "id_usuario_administrado INT, " +
                "FOREIGN KEY(id_usuario_administrado) REFERENCES usuario(id_usuario), " +
                "FOREIGN KEY(id_adm) REFERENCES usuario(id_usuario))";
        executeSQL(sql, "Tabela 'administracao' criada com sucesso!");
    }
 
    public void createAdministradorTable() {
        String sql = "CREATE TABLE IF NOT EXISTS administrador (" +
                "id_adm INT AUTO_INCREMENT, " +
                "id_usuario_adm INT, " +
                "PRIMARY KEY(id_adm), " +
                "FOREIGN KEY(id_usuario_adm) REFERENCES usuario(id_usuario))";
        executeSQL(sql, "Tabela 'administrador' criada com sucesso!");
    }
 
    public void createSuporteTable() {
        String sql = "CREATE TABLE IF NOT EXISTS suporte (" +
                "id_suporte INT AUTO_INCREMENT, " +
                "descricao VARCHAR(30), " +
                "data DATE, " +
                "hora TIME, " +
                "id_usuario INT, " +
                "id_arquivo INT, " +
                "id_adm INT, " +
                "PRIMARY KEY(id_suporte), " +
                "FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario), " +
                "FOREIGN KEY(id_arquivo) REFERENCES arquivo(id_arquivo), " +
                "FOREIGN KEY(id_adm) REFERENCES administrador(id_adm))";
        executeSQL(sql, "Tabela 'suporte' criada com sucesso!");
    }
 
    public void createArquivoTable() {
        String sql = "CREATE TABLE IF NOT EXISTS arquivo (" +
                "id_arquivo INT AUTO_INCREMENT, " +
                "nome VARCHAR(30), " +
                "tipo VARCHAR(10), " +
                "permissoes_acesso VARCHAR(50), " +
                "tamanho INT, " +
                "data_ultima_mod DATE, " +
                "localizacao VARCHAR(10), " +
                "URL VARCHAR(50), " +
                "id_usuario INT, " +
                "PRIMARY KEY(id_arquivo), " +
                "FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario))";
        executeSQL(sql, "Tabela 'arquivo' criada com sucesso!");
    }
 
    public void createCompartilhamentoTable() {
        String sql = "CREATE TABLE IF NOT EXISTS compartilhamento (" +
                "id_comp INT AUTO_INCREMENT, " +
                "id_arquivo INT, " +
                "data DATE, " +
                "id_dono INT, " +
                "PRIMARY KEY(id_comp), " +
                "FOREIGN KEY(id_dono) REFERENCES usuario(id_usuario), " +
                "FOREIGN KEY(id_arquivo) REFERENCES arquivo(id_arquivo))";
        executeSQL(sql, "Tabela 'compartilhamento' criada com sucesso!");
    }
 
    public void createComentarioTable() {
        String sql = "CREATE TABLE IF NOT EXISTS comentario (" +
                "id_coment INT AUTO_INCREMENT, " +
                "conteudo VARCHAR(30), " +
                "data DATE, " +
                "hora TIME, " +
                "id_usuario INT, " +
                "id_arquivo INT, " +
                "PRIMARY KEY(id_coment), " +
                "FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario), " +
                "FOREIGN KEY(id_arquivo) REFERENCES arquivo(id_arquivo))";
        executeSQL(sql, "Tabela 'comentario' criada com sucesso!");
    }
 
    public void createHistoricoTable() {
        String sql = "CREATE TABLE IF NOT EXISTS historico (" +
                "id_historico INT AUTO_INCREMENT, " +
                "conteudo_mudado VARCHAR(30), " +
                "data DATE, " +
                "hora TIME, " +
                "id_usuario_alterou INT, " +
                "id_arquivo INT, " +
                "PRIMARY KEY(id_historico), " +
                "FOREIGN KEY(id_usuario_alterou) REFERENCES usuario(id_usuario), " +
                "FOREIGN KEY(id_arquivo) REFERENCES arquivo(id_arquivo))";
        executeSQL(sql, "Tabela 'historico' criada com sucesso!");
    }
 
    public void createOperacoesTable() {
        String sql = "CREATE TABLE IF NOT EXISTS operacoes (" +
                "id_op INT AUTO_INCREMENT, " +
                "data DATE, " +
                "hora TIME, " +
                "tipo_operacao VARCHAR(30) CHECK(tipo_operacao IN ('carregar', 'atualizar', 'remover')), " +
                "id_usuario INT, " +
                "id_arquivo INT, " +
                "PRIMARY KEY(id_op), " +
                "FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario), " +
                "FOREIGN KEY(id_arquivo) REFERENCES arquivo(id_arquivo))";
        executeSQL(sql, "Tabela 'operacoes' criada com sucesso!");
    }
 
    
    public void createViews() {
        String view1 = "CREATE VIEW acesso_arquivos_admin AS " +
                "SELECT a.nome, a.tipo, a.permissoes_acesso, a.tamanho, a.data_ultima_mod, a.localizacao, a.URL " +
                "FROM arquivo a;";
        executeSQL(view1, "View 'acesso_arquivos_admin' criada com sucesso!");
 
        String view2 = "CREATE VIEW acesso_arquivos_usuario AS " +
                "SELECT a.nome, a.tipo, a.permissoes_acesso, a.tamanho, a.data_ultima_mod, a.localizacao, a.URL " +
                "FROM arquivo a " +
                "JOIN compartilhamento c ON a.id_arquivo = c.id_arquivo " +
                "JOIN usuario u ON u.id_usuario = c.id_dono " +
                "WHERE u.id_usuario = CURRENT_USER();";
        executeSQL(view2, "View 'acesso_arquivos_usuario' criada com sucesso!");
 
        String view3 = "CREATE VIEW historico_usuario AS " +
                "SELECT h.conteudo_mudado, h.data, h.hora, u.login AS usuario_que_alterou " +
                "FROM historico h " +
                "JOIN usuario u ON u.id_usuario = h.id_usuario_alterou " +
                "WHERE h.id_arquivo IN (SELECT id_arquivo FROM arquivo WHERE id_usuario = CURRENT_USER());";
        executeSQL(view3, "View 'historico_usuario' criada com sucesso!");
    }
 
    
 
 
  

 
 
    private void executeSQL(String sql, String successMessage) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println(successMessage);
        } catch (SQLException e) {
            System.err.println("Erro ao executar SQL: " + e.getMessage());
        }
    }
}
 