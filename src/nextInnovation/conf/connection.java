package nextInnovation.conf;

/**
 *
 * @author root
 */
import java.sql.*;
import javax.swing.*;

public class connection {
    Connection connect=null;
    
    public static Connection ConnectDB() throws SQLException {
        try {
            String userDb="root";
            String passDb="toor";
            String urlDb ="jdbc:mysql://localhost:3306/nextInn";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect=DriverManager.getConnection(urlDb, userDb, passDb);
            System.out.println("Connected");
            return connect;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
        public static void main(String[] args) {
        }
}
