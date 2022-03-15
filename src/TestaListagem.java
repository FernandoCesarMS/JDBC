import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        Statement statement = connection.createStatement();
        statement.execute("SELECT * FROM PRODUTO");
        ResultSet result = statement.getResultSet();

        while (result.next()) {
            Integer id = result.getInt("id");
            System.out.println(id);
            String nome = result.getString("nome");
            System.out.println(nome);
            String descricao = result.getString("descricao");
            System.out.println(descricao);
        }

        connection.close();
    }
}
