import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DeleteStatement {

    public static void main(String args[]) throws SQLException {
        PreparedStatement statement = createPreparedStatement(2);

        statement.execute();

        Integer deletedLines = statement.getUpdateCount();
        System.out.println(deletedLines + " lines were deleted");
    }

    private static PreparedStatement createPreparedStatement(Integer id) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        PreparedStatement statement = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?",
                Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, id);

        return statement;
    }
}
