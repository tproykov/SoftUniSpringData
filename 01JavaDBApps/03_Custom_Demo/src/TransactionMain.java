import java.sql.*;
import java.util.Properties;

public class TransactionMain {

    public static void main(String[] args) throws SQLException {

        // connect to SQL server
        String jdbc = "jdbc:mysql://localhost:3306/soft_uni";
        String username = "root";
        String password = "23081971";

        Properties properties = new Properties();
        properties.setProperty("user", username);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection(jdbc, properties);
        connection.setAutoCommit(false);

        // execute query
        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE employees SET salary = 123456 WHERE employee_id = 12");

        preparedStatement.executeUpdate();

        connection.commit();
        //connection.rollback();



    }
}