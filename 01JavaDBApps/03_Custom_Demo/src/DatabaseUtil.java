import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtil {

    private static final String HOST = "localhost";
    private static final int PORT = 3306;
    private static final String USER = "root";
    private static final String PASSWORD = "23081971";

    public static Connection getConnection(String databaseName) throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, databaseName);

        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASSWORD);

        return DriverManager.getConnection(url, props);
    }
}