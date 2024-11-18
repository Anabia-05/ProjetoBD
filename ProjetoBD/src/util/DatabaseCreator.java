package util;
 
import java.sql.Connection;
import java.sql.SQLException;
import util.TableCreator;
 
public class DatabaseCreator {
    private Connection connection;
 
    public DatabaseCreator(Connection connection) {
        this.connection = connection;
    }
 
    public void executeTableCreation() {
        try {
            TableCreator tableCreator = new TableCreator(connection);
 
            // Chamando os métodos de criação das tabelas
            tableCreator.createPlanoTable();
            tableCreator.createInstituicaoTable();
            tableCreator.createUsuarioTable();
            tableCreator.createAdmUsuarioTable();;
            tableCreator.createAdministradorTable();
            tableCreator.createSuporteTable();
            tableCreator.createArquivoTable();
            tableCreator.createCompartilhamentoTable();
            tableCreator.createComentarioTable();
            tableCreator.createHistoricoTable();
            tableCreator.createOperacoesTable();
            tableCreator.createAtividadesRecentTable();
            tableCreator.createViews();
            tableCreator.createProcedures();
            tableCreator.createRolePapelUsuario();
            tableCreator.createRolePapelInst();
            tableCreator.createRolePapelAdm();
 
            System.out.println("Todas as tabelas foram criadas com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao executar a criação de tabelas: " + e.getMessage());
        }
    }
}
 