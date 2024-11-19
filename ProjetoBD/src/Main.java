import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import model.AdmUsuario;
import model.Administrador;
import model.Arquivo;
import model.Instituicao;
import model.Plano;
import model.Usuario;
import util.DBConnection;
import util.DatabaseCreator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Programa iniciado!");

        try (Connection connection = DBConnection.getConnection()) {
            System.out.println("Conexão com o banco de dados estabelecida.");

            // Instanciar o DatabaseCreator e executar a criação das tabelas
            DatabaseCreator databaseCreator = new DatabaseCreator(connection);
            databaseCreator.executeTableCreation();

            System.out.println("Configuração do banco de dados concluída!");
            iniciarMenu(connection);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao configurar o banco de dados.");
        }
    }

    private static void iniciarMenu(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nSistema de Gerenciamento de Arquivos");
            System.out.println("1. Inserir usuário e dados iniciais");
            System.out.println("2. Atualizar arquivo");
            System.out.println("3. Atualizar plano");
            System.out.println("4. Atualizar usuário");
            System.out.println("5. Deletar arquivo");
            System.out.println("6. Deletar plano");
            System.out.println("7. Deletar usuário");
            System.out.println("8. Verificar atividades recentes");
            System.out.println("9. Contar usuários com acesso a um arquivo");
            System.out.println("10. Chavear prioridade de um arquivo");
            System.out.println("11. Remover acessos de arquivo (exceto do proprietário)");
            System.out.println("12. Verificar inatividade de um arquivo");
            System.out.println("13. Buscar Arquivo");
            System.out.println("14. Buscar usuário");
            System.out.println("15. Buscar plano");
            System.out.println("16. Acessar view: Arquivos administrados");
            System.out.println("17. Acessar view: Arquivos do usuário");
            System.out.println("18. Acessar view: Histórico do usuário");
            System.out.println("19. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                switch (choice) {
                    case 1:
                        inserirDadosIniciais(connection);
                        break;
                    case 2:
                        atualizarArquivo(connection, scanner);
                        break;
                    case 3:
                        atualizarPlano(connection, scanner);
                        break;
                    case 4:
                        atualizarUsuario(connection, scanner);
                        break;
                    case 5:
                        deletarArquivo(connection, scanner);
                        break;
                    case 6:
                        deletarPlano(connection, scanner);
                        break;
                    case 7:
                        deletarUsuario(connection, scanner);
                        break;
                    case 8:
                        verificarAtividadesRecentes(connection);
                        break;
                    case 9:
                        contarUsuariosComAcesso(connection, scanner);
                        break;
                    case 10:
                        chavearArquivo(connection, scanner);
                        break;
                    case 11:
                        removerAcessosArquivo(connection, scanner);
                        break;
                    case 12:
                        verificarInatividade(connection, scanner);
                        break;
                    case 13:
                        buscarUsuario(connection, scanner);
                        break;
                    case 14:
                        buscarArquivo(connection, scanner);
                        break;
                    case 15:
                        buscarPlano(connection, scanner);
                        break;
                    case 16:
                        acessarArquivosAdmin(connection);
                    break;
                    case 17:
                        acessarArquivosUsuario(connection);
                    break;
                    case 18:
                        acessarHistoricoUsuario(connection);
                    break;
                    case 19:
                        running = false;
                        System.out.println("Encerrando o programa...");
                        break;


                    default:
                        System.out.println("Opção inválida!");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next(); // Limpar entrada inválida
            }
        }
        scanner.close();
    }

    private static void inserirDadosIniciais(Connection connection) {
      try {
        // Inserção dos planos
        Plano plano1 = new Plano(0, "Plano Básico", 12.0, "2024-01-01", 50.0);
        if (plano1.insertPlano(connection)) {
            System.out.println("Plano Básico inserido com sucesso!");
        }

        Plano plano2 = new Plano(0, "Plano Premium", 24.0, "2024-05-10", 100.0);
        if (plano2.insertPlano(connection)) {
            System.out.println("Plano Premium inserido com sucesso!");
        }

        Plano plano3 = new Plano(0, "Plano Corporativo", 36.0, "2023-10-20", 200.0);
        if (plano3.insertPlano(connection)) {
            System.out.println("Plano Corporativo inserido com sucesso!");
        }

        // Inserção das instituições
        Instituicao instituicao1 = new Instituicao(0, "Instituição A", "Educação", "Rua A, 123", 1);
        if (instituicao1.insertInstituicao(connection)) {
            System.out.println("Instituição A inserida com sucesso!");
        }

        Instituicao instituicao2 = new Instituicao(0, "Instituição B", "Saúde", "Av. Central, 456", 2);
        if (instituicao2.insertInstituicao(connection)) {
            System.out.println("Instituição B inserida com sucesso!");
        }

        Instituicao instituicao3 = new Instituicao(0, "Instituição C", "Meio Ambiente", "Praça Nova, 789", 3);
        if (instituicao3.insertInstituicao(connection)) {
            System.out.println("Instituição C inserida com sucesso!");
        }

        // Inserção dos usuários
        Usuario usuario1 = new Usuario("usuario1", "senha123", "2024-01-15", "usuario1@email.com", 1);
        if (usuario1.insertUsuario(connection)) {
            System.out.println("Usuário 1 inserido com sucesso!");
        }

        Usuario usuario2 = new Usuario("usuario2", "senha456", "2023-11-20", "usuario2@email.com", 2);
        if (usuario2.insertUsuario(connection)) {
            System.out.println("Usuário 2 inserido com sucesso!");
        }

        Usuario usuario3 = new Usuario("usuario3", "senha789", "2024-02-01", "usuario3@email.com", 3);
        if (usuario3.insertUsuario(connection)) {
            System.out.println("Usuário 3 inserido com sucesso!");
        }

        // Inserção do administrador
        Administrador administrador = new Administrador(0, 1);  // Apenas o Usuário 1 será o administrador
        if (administrador.insertAdm(connection)) {
            System.out.println("Administrador inserido com sucesso!");
        }

        // Inserção dos administradores de usuários
        AdmUsuario admUsuario1 = new AdmUsuario(1, 2);  // Usuário 1 administra Usuário 2
        if (admUsuario1.insertAdmUsuario(connection)) {
            System.out.println("Administração de Usuário 2 inserida com sucesso!");
        }

        AdmUsuario admUsuario2 = new AdmUsuario(1, 3);  // Usuário 1 administra Usuário 3
        if (admUsuario2.insertAdmUsuario(connection)) {
            System.out.println("Administração de Usuário 3 inserida com sucesso!");
        }

        // Inserção dos arquivos
        Arquivo arquivo1 = new Arquivo(0, "documento1.pdf", "pdf", "leitura", 1024, "2024-03-01", "local1", "https://example.com/documento1", 1);
        if (arquivo1.insertArquivo(connection)) {
            System.out.println("Arquivo 'documento1.pdf' inserido com sucesso!");
        }

        Arquivo arquivo2 = new Arquivo(0, "planilha1.xlsx", "excel", "leitura/escrita", 2048, "2024-03-10", "local2", "https://example.com/planilha1", 2);
        if (arquivo2.insertArquivo(connection)) {
            System.out.println("Arquivo 'planilha1.xlsx' inserido com sucesso!");
        }

        Arquivo arquivo3 = new Arquivo(0, "imagem1.jpg", "imagem", "leitura", 512, "2024-03-15", "local3", "https://example.com/imagem1", 3);
        if (arquivo3.insertArquivo(connection)) {
            System.out.println("Arquivo 'imagem1.jpg' inserido com sucesso!");
        }


    } catch (Exception e) {
        System.out.println("Erro ao inserir dados: " + e.getMessage());
    }
  }

  private static void atualizarArquivo(Connection connection, Scanner scanner) {
    try {
        System.out.print("Informe o ID do arquivo que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo nome do arquivo: ");
        String nome = scanner.nextLine();

        System.out.print("Novo tipo do arquivo: ");
        String tipo = scanner.nextLine();

        System.out.print("Novas permissões de acesso: ");
        String permissoes = scanner.nextLine();

        System.out.print("Novo tamanho do arquivo: ");
        int tamanho = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nova data de última modificação (YYYY-MM-DD): ");
        String dataMod = scanner.nextLine();

        System.out.print("Nova localização do arquivo: ");
        String localizacao = scanner.nextLine();

        System.out.print("Nova URL do arquivo: ");
        String url = scanner.nextLine();

        System.out.print("Novo ID do usuário responsável: ");
        int idUsuario = scanner.nextInt();

        String sql = "{CALL AtualizarArquivo(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (var callableStatement = connection.prepareCall(sql)) {
            callableStatement.setInt(1, id);
            callableStatement.setString(2, nome);
            callableStatement.setString(3, tipo);
            callableStatement.setString(4, permissoes);
            callableStatement.setInt(5, tamanho);
            callableStatement.setString(6, dataMod);
            callableStatement.setString(7, localizacao);
            callableStatement.setString(8, url);
            callableStatement.setInt(9, idUsuario);
            callableStatement.execute();
            System.out.println("Arquivo atualizado com sucesso!");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao atualizar arquivo: " + e.getMessage());
    }
}

private static void atualizarPlano(Connection connection, Scanner scanner) {
    try {
        System.out.print("Informe o ID do plano que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo nome do plano: ");
        String nome = scanner.nextLine();

        System.out.print("Nova duração do plano (em meses): ");
        double duracao = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nova data de aquisição (YYYY-MM-DD): ");
        String dataAquisicao = scanner.nextLine();

        System.out.print("Novo espaço para o usuário (em GB): ");
        double espacoUsuario = scanner.nextDouble();
        scanner.nextLine();

        String sql = "{CALL AtualizarPlano(?, ?, ?, ?, ?)}";
        try (var callableStatement = connection.prepareCall(sql)) {
            callableStatement.setInt(1, id);
            callableStatement.setString(2, nome);
            callableStatement.setDouble(3, duracao);
            callableStatement.setString(4, dataAquisicao);
            callableStatement.setDouble(5, espacoUsuario);
            callableStatement.execute();
            System.out.println("Plano atualizado com sucesso!");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao atualizar plano: " + e.getMessage());
    }
}

private static void atualizarUsuario(Connection connection, Scanner scanner) {
    try {
        System.out.print("Informe o ID do usuário que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo login do usuário: ");
        String login = scanner.nextLine();

        System.out.print("Nova senha do usuário: ");
        String senha = scanner.nextLine();

        System.out.print("Nova data de ingresso (YYYY-MM-DD): ");
        String dataIngresso = scanner.nextLine();

        System.out.print("Novo e-mail do usuário: ");
        String email = scanner.nextLine();

        System.out.print("Novo ID da instituição: ");
        int idInstituicao = scanner.nextInt();

        String sql = "{CALL AtualizarUsuario(?, ?, ?, ?, ?, ?)}";
        try (var callableStatement = connection.prepareCall(sql)) {
            callableStatement.setInt(1, id);
            callableStatement.setString(2, login);
            callableStatement.setString(3, senha);
            callableStatement.setString(4, dataIngresso);
            callableStatement.setString(5, email);
            callableStatement.setInt(6, idInstituicao);
            callableStatement.execute();
            System.out.println("Usuário atualizado com sucesso!");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao atualizar usuário: " + e.getMessage());
    }
}

private static void deletarArquivo(Connection connection, Scanner scanner) {
  try {
      System.out.print("Informe o ID do arquivo que deseja deletar: ");
      int id = scanner.nextInt();

      String sql = "{CALL RemoverArquivo(?)}";
      try (var callableStatement = connection.prepareCall(sql)) {
          callableStatement.setInt(1, id);
          callableStatement.execute();
          System.out.println("Arquivo deletado com sucesso!");
      }
  } catch (SQLException e) {
      System.out.println("Erro ao deletar arquivo: " + e.getMessage());
  }
}


private static void deletarPlano(Connection connection, Scanner scanner) {
  try {
      System.out.print("Informe o ID do plano que deseja deletar: ");
      int id = scanner.nextInt();

      String sql = "{CALL RemoverPlano(?)}";
      try (var callableStatement = connection.prepareCall(sql)) {
          callableStatement.setInt(1, id);
          callableStatement.execute();
          System.out.println("Plano deletado com sucesso!");
      }
  } catch (SQLException e) {
      System.out.println("Erro ao deletar plano: " + e.getMessage());
  }
}


private static void deletarUsuario(Connection connection, Scanner scanner) {
  try {
      System.out.print("Informe o ID do usuário que deseja deletar: ");
      int id = scanner.nextInt();

      String sql = "{CALL RemoverUsuario(?)}";
      try (var callableStatement = connection.prepareCall(sql)) {
          callableStatement.setInt(1, id);
          callableStatement.execute();
          System.out.println("Usuário deletado com sucesso!");
      }
  } catch (SQLException e) {
      System.out.println("Erro ao deletar usuário: " + e.getMessage());
  }
}

private static void verificarAtividadesRecentes(Connection connection) {
    try {
        String sql = "{CALL verificar_atividades()}";
        try (var callableStatement = connection.prepareCall(sql)) {
            callableStatement.execute();
            System.out.println("Atividades recentes verificadas com sucesso!");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao verificar atividades recentes: " + e.getMessage());
    }
}

private static void contarUsuariosComAcesso(Connection connection, Scanner scanner) {
    try {
        System.out.print("Informe o ID do arquivo para contar usuários com acesso: ");
        int id = scanner.nextInt();

        String sql = "{CALL conta_usuarios(?)}";
        try (var callableStatement = connection.prepareCall(sql)) {
            callableStatement.setInt(1, id);
            callableStatement.execute();
            System.out.println("Contagem de usuários com acesso realizada!");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao contar usuários: " + e.getMessage());
    }
}
private static void chavearArquivo(Connection connection, Scanner scanner) {
  try {
      System.out.print("Informe o ID do arquivo que deseja chavear: ");
      int id = scanner.nextInt();

      // Chamar procedure para chavear prioridade
      String sql = "{CALL chavear_arquivo(?)}";
      try (var callableStatement = connection.prepareCall(sql)) {
          callableStatement.setInt(1, id);
          callableStatement.execute();
          System.out.println("Prioridade do arquivo atualizada com sucesso!");
      }
  } catch (SQLException e) {
      System.out.println("Erro ao chavear prioridade do arquivo: " + e.getMessage());
  }
}
private static void removerAcessosArquivo(Connection connection, Scanner scanner) {
  try {
      System.out.print("Informe o ID do arquivo para remover acessos: ");
      int idArquivo = scanner.nextInt();

      // Chamar a procedure no banco de dados
      String sql = "{CALL RemoverAcessoUsuarios(?)}";
      try (var callableStatement = connection.prepareCall(sql)) {
          callableStatement.setInt(1, idArquivo);
          callableStatement.execute();
          System.out.println("Acessos removidos com sucesso, exceto o do proprietário!");
      }
  } catch (SQLException e) {
      System.out.println("Erro ao remover acessos do arquivo: " + e.getMessage());
  }
}
private static void verificarInatividade(Connection connection, Scanner scanner) {
  try {
      System.out.print("Informe o ID do arquivo que deseja verificar: ");
      int idArquivo = scanner.nextInt();

      // Chamar a função confere_data
      String sql = "SELECT confere_data(?) AS resultado";
      try (var preparedStatement = connection.prepareStatement(sql)) {
          preparedStatement.setInt(1, idArquivo);

          try (var resultSet = preparedStatement.executeQuery()) {
              if (resultSet.next()) {
                  boolean resultado = resultSet.getBoolean("resultado");
                  if (resultado) {
                      System.out.println("O arquivo está inativo há mais de 100 dias.");
                  } else {
                      System.out.println("O arquivo foi modificado recentemente.");
                  }
              } else {
                  System.out.println("Arquivo não encontrado.");
              }
          }
      }
  } catch (SQLException e) {
      System.out.println("Erro ao verificar inatividade do arquivo: " + e.getMessage());
  }
}
private static void buscarUsuario(Connection connection, Scanner scanner) {
  try {
      System.out.print("Informe o ID do usuário que deseja buscar: ");
      int id = scanner.nextInt();

      String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
      try (var preparedStatement = connection.prepareStatement(sql)) {
          preparedStatement.setInt(1, id);

          var resultSet = preparedStatement.executeQuery();
          if (resultSet.next()) {
              System.out.println("ID: " + resultSet.getInt("id_usuario"));
              System.out.println("Login: " + resultSet.getString("login"));
              System.out.println("Email: " + resultSet.getString("email"));
              System.out.println("Data de Ingresso: " + resultSet.getDate("data_ingresso"));
              System.out.println("ID da Instituição: " + resultSet.getInt("id_instituicao"));
          } else {
              System.out.println("Usuário não encontrado.");
          }
      }
  } catch (SQLException e) {
      System.out.println("Erro ao buscar usuário: " + e.getMessage());
  }
}
private static void buscarArquivo(Connection connection, Scanner scanner) {
  try {
      System.out.print("Informe o ID do arquivo que deseja buscar: ");
      int id = scanner.nextInt();

      String sql = "SELECT * FROM arquivo WHERE id_arquivo = ?";
      try (var preparedStatement = connection.prepareStatement(sql)) {
          preparedStatement.setInt(1, id);

          var resultSet = preparedStatement.executeQuery();
          if (resultSet.next()) {
              System.out.println("ID: " + resultSet.getInt("id_arquivo"));
              System.out.println("Nome: " + resultSet.getString("nome"));
              System.out.println("Tipo: " + resultSet.getString("tipo"));
              System.out.println("Permissões: " + resultSet.getString("permissoes_acesso"));
              System.out.println("Tamanho: " + resultSet.getInt("tamanho"));
              System.out.println("Data Última Modificação: " + resultSet.getDate("data_ultima_mod"));
              System.out.println("Localização: " + resultSet.getString("localizacao"));
              System.out.println("URL: " + resultSet.getString("URL"));
              System.out.println("ID do Usuário: " + resultSet.getInt("id_usuario"));
          } else {
              System.out.println("Arquivo não encontrado.");
          }
      }
  } catch (SQLException e) {
      System.out.println("Erro ao buscar arquivo: " + e.getMessage());
  }
}
private static void buscarPlano(Connection connection, Scanner scanner) {
  try {
      System.out.print("Informe o ID do plano que deseja buscar: ");
      int id = scanner.nextInt();

      String sql = "SELECT * FROM plano WHERE id_plano = ?";
      try (var preparedStatement = connection.prepareStatement(sql)) {
          preparedStatement.setInt(1, id);

          var resultSet = preparedStatement.executeQuery();
          if (resultSet.next()) {
              System.out.println("ID: " + resultSet.getInt("id_plano"));
              System.out.println("Nome: " + resultSet.getString("nome"));
              System.out.println("Duração: " + resultSet.getDouble("duracao"));
              System.out.println("Data de Aquisição: " + resultSet.getDate("data_aquisicao"));
              System.out.println("Espaço de Usuário: " + resultSet.getDouble("espaco_usuario"));
          } else {
              System.out.println("Plano não encontrado.");
          }
      }
  } catch (SQLException e) {
      System.out.println("Erro ao buscar plano: " + e.getMessage());
  }
}
private static void acessarArquivosAdmin(Connection connection) {
  String sql = "SELECT * FROM acesso_arquivos_admin";

  try (var statement = connection.createStatement();
       var resultSet = statement.executeQuery(sql)) {

      System.out.println("Arquivos administrados:");
      while (resultSet.next()) {
          String nome = resultSet.getString("nome");
          String tipo = resultSet.getString("tipo");
          String permissoes = resultSet.getString("permissoes_acesso");
          int tamanho = resultSet.getInt("tamanho");
          String dataMod = resultSet.getString("data_ultima_mod");
          String localizacao = resultSet.getString("localizacao");
          String url = resultSet.getString("URL");

          System.out.printf("Nome: %s, Tipo: %s, Permissões: %s, Tamanho: %d, Data Modificação: %s, Localização: %s, URL: %s%n",
                            nome, tipo, permissoes, tamanho, dataMod, localizacao, url);
      }
  } catch (SQLException e) {
      System.out.println("Erro ao acessar view 'acesso_arquivos_admin': " + e.getMessage());
  }
}
private static void acessarArquivosUsuario(Connection connection) {
  String sql = "SELECT * FROM acesso_arquivos_usuario";

  try (var statement = connection.createStatement();
       var resultSet = statement.executeQuery(sql)) {

      System.out.println("Arquivos do usuário atual:");
      while (resultSet.next()) {
          String nome = resultSet.getString("nome");
          String tipo = resultSet.getString("tipo");
          String permissoes = resultSet.getString("permissoes_acesso");
          int tamanho = resultSet.getInt("tamanho");
          String dataMod = resultSet.getString("data_ultima_mod");
          String localizacao = resultSet.getString("localizacao");
          String url = resultSet.getString("URL");

          System.out.printf("Nome: %s, Tipo: %s, Permissões: %s, Tamanho: %d, Data Modificação: %s, Localização: %s, URL: %s%n",
                            nome, tipo, permissoes, tamanho, dataMod, localizacao, url);
      }
  } catch (SQLException e) {
      System.out.println("Erro ao acessar view 'acesso_arquivos_usuario': " + e.getMessage());
  }
}
private static void acessarHistoricoUsuario(Connection connection) {
  String sql = "SELECT * FROM historico_usuario";

  try (var statement = connection.createStatement();
       var resultSet = statement.executeQuery(sql)) {

      System.out.println("Histórico de alterações do usuário:");
      while (resultSet.next()) {
          String conteudo = resultSet.getString("conteudo_mudado");
          String data = resultSet.getString("data");
          String hora = resultSet.getString("hora");
          String usuario = resultSet.getString("usuario_que_alterou");

          System.out.printf("Conteúdo: %s, Data: %s, Hora: %s, Usuário: %s%n",
                            conteudo, data, hora, usuario);
      }
  } catch (SQLException e) {
      System.out.println("Erro ao acessar view 'historico_usuario': " + e.getMessage());
  }
}

}
