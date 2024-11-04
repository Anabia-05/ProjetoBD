public class App {
    public static void main(String[] args) throws Exception {
       // Cria o banco de dados
       DatabaseCreator databaseCreator = new DatabaseCreator();

      TableCreator tables = new TableCreator(databaseCreator.getConnection());

      tables.createUsusarioTable();
         
      databaseCreator.closeConnection();
    }
}
