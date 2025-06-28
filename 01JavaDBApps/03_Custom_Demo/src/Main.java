import java.sql.*;
import java.util.Properties;

public class Main {

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
                .prepareStatement("SELECT * FROM employees LIMIT 10");

        ResultSet resultSet = preparedStatement.executeQuery();


        // parse results



    }


}