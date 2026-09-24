import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 public class ConnectionFactory {
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            Protect.DB_URL, 
            Protect.DB_USER, 
            Protect.DB_PASSWORD
        );
    }
}
