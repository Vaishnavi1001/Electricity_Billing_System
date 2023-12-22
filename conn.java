import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conn {

    Connection c;
    Statement s;

    public conn() {
        try {
            // Update the URL, username, and password according to your database configuration
            String url = "jdbc:mysql://localhost:3308/ebs";
            String username = "root";
            String password = "root";

            c = DriverManager.getConnection(url, username, password);
            s = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately (show error message, log, etc.)
        }
    }

    public void close() {
        try {
            if (s != null) {
                s.close();
            }
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately (show error message, log, etc.)
        }
    }
}
