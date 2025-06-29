import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class DiabloStats {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        Connection connection = DatabaseUtil.getConnection("soft_uni");

        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT * FROM employees WHERE salary > 100000 LIMIT 10");
        ResultSet resultSet = preparedStatement.executeQuery();


        // boolean hasAtLeastOneRow = resultSet.next();
        // System.out.println(hasAtLeastOneRow);

        // parse results
        while (resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String jobTitle = resultSet.getString("job_title");
            double salary = resultSet.getDouble("salary");
            System.out.printf("%s %s - %s  - %.2f\n", firstName, lastName, jobTitle, salary);
        }
    }
}