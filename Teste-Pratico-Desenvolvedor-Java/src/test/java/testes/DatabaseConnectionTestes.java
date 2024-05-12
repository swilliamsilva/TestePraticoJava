package testes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionTestes {

    public static void main(String[] args) {
        try {
            // Estabelecer conexão com o banco de dados
            Connection connection = DriverManager.getConnection("jdbc:hsqldb:mem:testdb", "SA", "");
            System.out.println("Conexão com o banco de dados estabelecida.");

            // Criar tabela se não existir
            createTableIfNotExists(connection);

            // Teste de gravação
            testInsert(connection);

            // Teste de exclusão
            testDelete(connection);

            // Fechar conexão com o banco de dados
            connection.close();
            System.out.println("Conexão com o banco de dados fechada.");
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro ao conectar-se ao banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createTableIfNotExists(Connection connection) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            // Verificar se a tabela existe
            boolean tableExists = false;
            try {
                ResultSet rs = connection.getMetaData().getTables(null, null, "SOLICITANTE", null);
                if (rs.next()) {
                    tableExists = true;
                }
            } catch (SQLException ex) {
                // Ignorar exceção se a tabela não existir
            }

            // Criar tabela se não existir
            if (!tableExists) {
                String createTableQuery = "CREATE TABLE SOLICITANTE (coluna1 VARCHAR(255), coluna2 VARCHAR(255))";
                stmt.executeUpdate(createTableQuery);
                System.out.println("Tabela SOLICITANTE criada com sucesso.");
            }
        }
    }

    private static void testInsert(Connection connection) throws SQLException {
        // Preparar uma instrução SQL para inserir dados
        String insertQuery = "INSERT INTO SOLICITANTE (coluna1, coluna2) VALUES (?, ?)";
        PreparedStatement insertStatement = connection.prepareStatement(insertQuery);

        // Definir os valores dos parâmetros
        insertStatement.setString(1, "valor1");
        insertStatement.setString(2, "valor2");

        // Executar a inserção
        int rowsInserted = insertStatement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Dados inseridos com sucesso.");
        } else {
            System.out.println("Nenhum dado foi inserido.");
        }

        // Fechar a instrução de inserção
        insertStatement.close();
    }

    private static void testDelete(Connection connection) throws SQLException {
        // Preparar uma instrução SQL para excluir dados
        String deleteQuery = "DELETE FROM SOLICITANTE WHERE coluna1 = ?";
        PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);

        // Definir o valor do parâmetro
        deleteStatement.setString(1, "valor1");

        // Executar a exclusão
        int rowsDeleted = deleteStatement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Dados excluídos com sucesso.");
        } else {
            System.out.println("Nenhum dado foi excluído.");
        }

        // Fechar a instrução de exclusão
        deleteStatement.close();
    }
}
