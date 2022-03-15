import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStatement {
    public static void main(String[] args) throws SQLException{
        String nome = "Fogão'";
        String descricao = "Fogão a Lenha";

        PreparedStatement statement = createPreparedStatement(nome, descricao);
        statement.execute();

        ResultSet result = statement.getGeneratedKeys();

        while (result.next()) {
            Integer id = result.getInt(1);
            System.out.println("ID " + id + " created.");
        }
    }

    private static PreparedStatement createPreparedStatement(String name, String description) throws SQLException{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, name);
        statement.setString(2, description);

        return statement;
    }
}
