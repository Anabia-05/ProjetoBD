package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {
    private Connection connection;

    public TableCreator(Connection connection) {
        this.connection = connection;
    }

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
                "FOREIGN KEY(id_plano) REFERENCES plano(id_plano) ON DELETE CASCADE)";
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
                "FOREIGN KEY(id_instituicao) REFERENCES instituicao(id_instituicao) ON DELETE CASCADE)";
        executeSQL(sql, "Tabela 'usuario' criada com sucesso!");
    }

    public void createAdministracaoTable() {
        String sql = "CREATE TABLE IF NOT EXISTS administracao (" +
                "id_adm INT, " +
                "id_usuario_administrado INT, " +
                "FOREIGN KEY(id_usuario_administrado) REFERENCES usuario(id_usuario) ON DELETE CASCADE, " +
                "FOREIGN KEY(id_adm) REFERENCES usuario(id_usuario) ON DELETE CASCADE)";
        executeSQL(sql, "Tabela 'administracao' criada com sucesso!");
    }

    public void createAdministradorTable() {
        String sql = "CREATE TABLE IF NOT EXISTS administrador (" +
                "id_adm INT AUTO_INCREMENT, " +
                "id_usuario_adm INT, " +
                "PRIMARY KEY(id_adm), " +
                "FOREIGN KEY(id_usuario_adm) REFERENCES usuario(id_usuario) ON DELETE CASCADE)";
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
                   "FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE, " +
                   "FOREIGN KEY(id_arquivo) REFERENCES arquivo(id_arquivo) ON DELETE CASCADE, " +
                   "FOREIGN KEY(id_adm) REFERENCES administrador(id_adm) ON DELETE CASCADE)";
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
                   "FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE)";
      executeSQL(sql, "Tabela 'arquivo' criada com sucesso!");
  }

  public void createCompartilhamentoTable() {
    String sql = "CREATE TABLE IF NOT EXISTS compartilhamento (" +
                 "id_comp INT AUTO_INCREMENT, " +
                 "id_arquivo INT, " +
                 "id_dono INT, " +
                 "PRIMARY KEY(id_comp), " +
                 "FOREIGN KEY(id_arquivo) REFERENCES arquivo(id_arquivo) ON DELETE CASCADE, " +
                 "FOREIGN KEY(id_dono) REFERENCES usuario(id_usuario) ON DELETE CASCADE)";
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
                "FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE, " +
                "FOREIGN KEY(id_arquivo) REFERENCES arquivo(id_arquivo) ON DELETE CASCADE)";
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
                   "FOREIGN KEY(id_usuario_alterou) REFERENCES usuario(id_usuario) ON DELETE CASCADE, " +
                   "FOREIGN KEY(id_arquivo) REFERENCES arquivo(id_arquivo) ON DELETE CASCADE)";
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
                "FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE, " +
                "FOREIGN KEY(id_arquivo) REFERENCES arquivo(id_arquivo) ON DELETE CASCADE)";
        executeSQL(sql, "Tabela 'operacoes' criada com sucesso!");
    }

    public void createAtividadesRecentesTable() {
        String sql = "CREATE TABLE IF NOT EXISTS atividades_recentes (" +
                "id_arquivo INT, " +
                "ultima_versao DATE, " +
                "acesso VARCHAR(20) CHECK(acesso IN ('prioritário', 'não_prioritário')), " +
                "FOREIGN KEY (id_arquivo) REFERENCES arquivo(id_arquivo) ON DELETE CASCADE)";
        executeSQL(sql, "Tabela 'atividades_recentes' criada com sucesso!");
    }

    // Métodos para criação de views
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

    public void createProcedures() {
      String atualizarArquivo = "CREATE PROCEDURE AtualizarArquivo(IN p_id_arquivo INT, IN p_nome VARCHAR(30), " +
              "IN p_tipo VARCHAR(10), IN p_permissoes_acesso VARCHAR(50), IN p_tamanho INT, " +
              "IN p_data_ultima_mod DATE, IN p_localizacao VARCHAR(10), IN p_url VARCHAR(50), " +
              "IN p_id_usuario INT) " +
              "BEGIN " +
              "UPDATE arquivo SET nome = p_nome, tipo = p_tipo, permissoes_acesso = p_permissoes_acesso, " +
              "tamanho = p_tamanho, data_ultima_mod = p_data_ultima_mod, localizacao = p_localizacao, " +
              "URL = p_url, id_usuario = p_id_usuario WHERE id_arquivo = p_id_arquivo; " +
              "END;";
      executeSQL(atualizarArquivo, "Procedure 'AtualizarArquivo' criada com sucesso!");

      String atualizarPlano = "CREATE PROCEDURE AtualizarPlano(IN p_id_plano INT, IN p_nome VARCHAR(40), " +
              "IN p_duracao DOUBLE, IN p_data_aquisicao DATE, IN p_espaco_usuario DOUBLE) " +
              "BEGIN " +
              "UPDATE plano SET nome = p_nome, duracao = p_duracao, data_aquisicao = p_data_aquisicao, " +
              "espaco_usuario = p_espaco_usuario WHERE id_plano = p_id_plano; " +
              "END;";
      executeSQL(atualizarPlano, "Procedure 'AtualizarPlano' criada com sucesso!");

      String atualizarUsuario = "CREATE PROCEDURE AtualizarUsuario(IN p_id_usuario INT, IN p_login VARCHAR(40), " +
              "IN p_senha VARCHAR(10), IN p_data_ingresso DATE, IN p_email VARCHAR(40), " +
              "IN p_id_instituicao INT) " +
              "BEGIN " +
              "UPDATE usuario SET login = p_login, senha = p_senha, data_ingresso = p_data_ingresso, " +
              "email = p_email, id_instituicao = p_id_instituicao WHERE id_usuario = p_id_usuario; " +
              "END;";
      executeSQL(atualizarUsuario, "Procedure 'AtualizarUsuario' criada com sucesso!");

      String contaUsuarios = "CREATE PROCEDURE conta_usuarios(IN idArquivoEscolhido INT) " +
              "BEGIN " +
              "DECLARE contUsuario INT DEFAULT 0; " +
              "SELECT COUNT(DISTINCT id_usuario) INTO contUsuario FROM compartilhamento WHERE id_arquivo = idArquivoEscolhido; " +
              "SELECT contUsuario AS resultados; " +
              "END;";
      executeSQL(contaUsuarios, "Procedure 'conta_usuarios' criada com sucesso!");

      String removerAcessoUsuarios = "CREATE PROCEDURE RemoverAcessoUsuarios(IN idArquivoEscolhido INT) " +
        "BEGIN " +
        "DECLARE idDono INT; " +
        "SELECT id_dono INTO idDono FROM compartilhamento WHERE id_arquivo = idArquivoEscolhido LIMIT 1; " +
        "DELETE FROM compartilhamento " +
        "WHERE id_arquivo = idArquivoEscolhido AND id_dono != idDono; " +
        "END;";
      executeSQL(removerAcessoUsuarios, "Procedure 'RemoverAcessoUsuarios' criada com sucesso!");

      String removerArquivo = "CREATE PROCEDURE RemoverArquivo(IN p_id_arquivo INT) " +
              "BEGIN " +
              "DELETE FROM arquivo WHERE id_arquivo = p_id_arquivo; " +
              "END;";
      executeSQL(removerArquivo, "Procedure 'RemoverArquivo' criada com sucesso!");

      String removerPlano = "CREATE PROCEDURE RemoverPlano(IN p_id_plano INT) " +
              "BEGIN " +
              "DELETE FROM plano WHERE id_plano = p_id_plano; " +
              "END;";
      executeSQL(removerPlano, "Procedure 'RemoverPlano' criada com sucesso!");

      String removerUsuario = "CREATE PROCEDURE RemoverUsuario(IN p_id_usuario INT) " +
              "BEGIN " +
              "DELETE FROM usuario WHERE id_usuario = p_id_usuario; " +
              "END;";
      executeSQL(removerUsuario, "Procedure 'RemoverUsuario' criada com sucesso!");

      String verificarAtividades = "CREATE PROCEDURE verificar_atividades() " +
              "BEGIN " +
              "UPDATE atividades_recentes SET ultima_versao = CURRENT_DATE; " +
              "END;";
      executeSQL(verificarAtividades, "Procedure 'verificar_atividades' criada com sucesso!");

      String chavearArquivo = "CREATE PROCEDURE chavear_arquivo(IN arquivo_id INT) " +
              "BEGIN " +
              "DECLARE novo_acesso VARCHAR(20); " +
              "SELECT acesso INTO novo_acesso FROM atividades_recentes WHERE id_arquivo = arquivo_id; " +
              "IF novo_acesso = 'prioritário' THEN " +
              "UPDATE atividades_recentes SET acesso = 'não_prioritário' WHERE id_arquivo = arquivo_id; " +
              "ELSEIF novo_acesso = 'não_prioritário' THEN " +
              "UPDATE atividades_recentes SET acesso = 'prioritário' WHERE id_arquivo = arquivo_id; " +
              "END IF; " +
              "END;";
      executeSQL(chavearArquivo, "Procedure 'chavear_arquivo' criada com sucesso!");
  }


  public void createTriggers() {
    String afterArquivoDelete = "CREATE TRIGGER after_arquivo_delete AFTER DELETE ON arquivo FOR EACH ROW " +
            "BEGIN " +
            "INSERT INTO historico (conteudo_mudado, data, hora, id_usuario_alterou, id_arquivo) " +
            "VALUES ('Arquivo removido', CURDATE(), CURTIME(), OLD.id_usuario, OLD.id_arquivo); " +
            "END;";
    executeSQL(afterArquivoDelete, "Trigger 'after_arquivo_delete' criada com sucesso!");

    String afterArquivoUpdate = "CREATE TRIGGER after_arquivo_update AFTER UPDATE ON arquivo FOR EACH ROW " +
            "BEGIN " +
            "INSERT INTO historico (conteudo_mudado, data, hora, id_usuario_alterou, id_arquivo) " +
            "VALUES ('Arquivo atualizado', CURDATE(), CURTIME(), OLD.id_usuario, NEW.id_arquivo); " +
            "END;";
    executeSQL(afterArquivoUpdate, "Trigger 'after_arquivo_update' criada com sucesso!");

    String afterPlanoDelete = "CREATE TRIGGER after_plano_delete AFTER DELETE ON plano FOR EACH ROW " +
            "BEGIN " +
            "INSERT INTO historico (conteudo_mudado, data, hora, id_usuario_alterou, id_arquivo) " +
            "VALUES ('Plano removido', CURDATE(), CURTIME(), 1, OLD.id_plano); " +
            "END;";
    executeSQL(afterPlanoDelete, "Trigger 'after_plano_delete' criada com sucesso!");

    String afterPlanoUpdate = "CREATE TRIGGER after_plano_update AFTER UPDATE ON plano FOR EACH ROW " +
            "BEGIN " +
            "INSERT INTO historico (conteudo_mudado, data, hora, id_usuario_alterou, id_arquivo) " +
            "VALUES ('Plano atualizado', CURDATE(), CURTIME(), 1, NEW.id_plano); " +
            "END;";
    executeSQL(afterPlanoUpdate, "Trigger 'after_plano_update' criada com sucesso!");

    String afterUsuarioDelete = "CREATE TRIGGER after_usuario_delete AFTER DELETE ON usuario FOR EACH ROW " +
            "BEGIN " +
            "INSERT INTO historico (conteudo_mudado, data, hora, id_usuario_alterou, id_arquivo) " +
            "VALUES ('Usuário removido', CURDATE(), CURTIME(), OLD.id_usuario, NULL); " +
            "END;";
    executeSQL(afterUsuarioDelete, "Trigger 'after_usuario_delete' criada com sucesso!");

    String afterUsuarioUpdate = "CREATE TRIGGER after_usuario_update AFTER UPDATE ON usuario FOR EACH ROW " +
            "BEGIN " +
            "INSERT INTO historico (conteudo_mudado, data, hora, id_usuario_alterou, id_arquivo) " +
            "VALUES ('Usuário atualizado', CURDATE(), CURTIME(), OLD.id_usuario, NULL); " +
            "END;";
    executeSQL(afterUsuarioUpdate, "Trigger 'after_usuario_update' criada com sucesso!");
        // Safe Security Trigger
    String safeSecurityTrigger = "CREATE TRIGGER safe_security " +
        "BEFORE INSERT ON arquivo " +
        "FOR EACH ROW " +
        "BEGIN " +
        "IF NEW.tipo IN ('exe', 'bat', 'sh', 'cmd', 'com') THEN " +
        "SIGNAL SQLSTATE '45000' " +
        "SET MESSAGE_TEXT = 'Inserção de arquivos executáveis não é permitida.'; " +
        "END IF; " +
        "END;";
    executeSQL(safeSecurityTrigger, "Trigger 'safe_security' criada com sucesso!");

// Registrar Operacao Trigger
    String registrarOperacaoTrigger = "CREATE TRIGGER registrar_operacao " +
        "AFTER INSERT ON operacoes " +
        "FOR EACH ROW " +
        "BEGIN " +
        "UPDATE atividades_recentes " +
        "SET ultima_versao = NEW.data " +
        "WHERE id_arquivo = NEW.id_arquivo; " +
        "END;";
    executeSQL(registrarOperacaoTrigger, "Trigger 'registrar_operacao' criada com sucesso!");

// Atualizar Acesso Trigger
    String atualizarAcessoTrigger = "CREATE TRIGGER atualizar_acesso " +
        "AFTER INSERT ON compartilhamento " +
        "FOR EACH ROW " +
        "BEGIN " +
        "UPDATE arquivo " +
        "SET data_ultima_mod = CURRENT_DATE " +
        "WHERE id_arquivo = NEW.id_arquivo; " +
        "END;";
    executeSQL(atualizarAcessoTrigger, "Trigger 'atualizar_acesso' criada com sucesso!");
}




public void createConfereDataFunction() {
  String confereDataFunction = "CREATE FUNCTION confere_data(idArquivoEscolhido INT) " +
          "RETURNS BOOLEAN " +
          "DETERMINISTIC " +
          "BEGIN " +
          "DECLARE confere BOOLEAN; " +
          "SET confere = ( " +
          "SELECT DATEDIFF(CURRENT_DATE, data_ultima_mod) > 100 " +
          "FROM arquivo " +
          "WHERE id_arquivo = idArquivoEscolhido " +
          "); " +
          "RETURN confere; " +
          "END;";
  executeSQL(confereDataFunction, "Função 'confere_data' criada com sucesso!");
}
public void createRolePapelUsuario(int idUsuario){

  String CreateRolePU = "CREATE ROLE IF NOT EXISTS PapelUsuario";
  executeSQL(CreateRolePU, "Role 'PapelUsuario' criada com sucesso!");

  String createViewSQL = "CREATE VIEW arquivos_usuario AS " +
                         "SELECT * FROM arquivo WHERE id_usuario = " + idUsuario;


  executeSQL(createViewSQL, "View 'arquivos_usuario' criada com sucesso!");

  String grantPermissionsSQL = "GRANT SELECT, INSERT, UPDATE ON arquivos_usuario TO PapelUsuario";
  executeSQL(grantPermissionsSQL, "Permissões concedidas para 'PapelUsuario'.");
  // SQL para conceder o papel ao usuário 'webdriver_user'
  String grantRoleToUserSQL = "GRANT PapelUsuario TO 'webdriver_user'@'localhost'";
  executeSQL(grantRoleToUserSQL, "Role concedida ao usuário 'webdriver_user'.");

}

public void createRolePapelInst(){

  String CreateRolePU = "CREATE ROLE IF NOT EXISTS PapelInstituicao";
  executeSQL(CreateRolePU, "Role 'PapelInstituicao' criada com sucesso!");

  String grantSelectInst = " GRANT SELECT ON instituicao TO PapelInstituicao";
  executeSQL(grantSelectInst, "Permissões de visuializacao da insituicao.");

  String grantSelectUsuario = " GRANT SELECT ON usuario TO PapelInstituicao";
  executeSQL(grantSelectUsuario, "Permissões de visuializacao dos usuarios.");

  String grantSelectArq = " GRANT SELECT ON usuario TO PapelInstituicao";
  executeSQL(grantSelectArq, "Permissões de visuializacao dos arquivos.");

  String grantRoleToUserSQL = "GRANT PapelInstituicao TO 'webdriver_user'@'localhost'";
  executeSQL(grantRoleToUserSQL, "Role concedida ao usuário 'webdriver_user'.");

}

public void createRolePapelAdm(){

  String CreateRolePU = "CREATE ROLE IF NOT EXISTS PapelAdm";
  executeSQL(CreateRolePU, "Role 'PapelAdm' criada com sucesso!");

  String grantPermission = "GRANT SELECT, INSERT, UPDATE, DELETE ON webdriver.* TO PapelAdm";
  executeSQL(grantPermission, " Conceder permissões de leitura, inserção, atualização e exclusão em todas as tabelas do banco de dados.");


  String grantRoleToUserSQL = "GRANT PapelAdm TO 'webdriver_user'@'localhost'";
  executeSQL(grantRoleToUserSQL, "Role concedida ao usuário 'webdriver_user'.");

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
