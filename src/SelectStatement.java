import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectStatement {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        PreparedStatement statement = createPreparedStatement();
        statement.execute();

        ResultSet result = statement.getResultSet();

        while (result.next()) {
            Integer id = result.getInt("id");
            System.out.println(id);
            String nome = result.getString("nome");
            System.out.println(nome);
            String description = result.getString("descricao");
            System.out.println(description);
        }

        connection.close();
    }

    private static PreparedStatement createPreparedStatement() throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM PRODUTO",
                Statement.RETURN_GENERATED_KEYS);

        return statement;
    }
}
