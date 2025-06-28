import java.sql.*;
import java.util.Properties;

public class PreparedMain {

    public static void main(String[] args) throws SQLException {

        // connect to SQL server
        String jdbc = "jdbc:mysql://localhost:3306/soft_uni";
        String username = "root";
        String password = "23081971";

        Properties properties = new Properties();
        properties.setProperty("user", username);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection(jdbc, properties);

        System.out.println();

        // execute query
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT * FROM employees WHERE salary > ?");

        preparedStatement.setString(1, "10'; SELECT * FROM employees;");
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println(resultSet.getFetchSize());
        System.out.println(preparedStatement);

        // ResultSet resultSet = preparedStatement.executeQuery();
    }
}