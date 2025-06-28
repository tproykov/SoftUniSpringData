import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DiabloStats {

    public static void main(String[] args) throws SQLException {

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "23081971");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", props);






    }




}
