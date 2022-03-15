import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

    public static void main(String args[]) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        Statement statement = connection.createStatement();
        String query = "DELETE FROM PRODUTO WHERE id>2";
        statement.execute(query);

        Integer deletedLines = statement.getUpdateCount();
        System.out.println(deletedLines + " lines were deleted");
    }
}
