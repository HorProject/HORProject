package Model;

import java.sql.*;

public class ConnectionBuilder {
    public static Connection getConnection() throws SQLException {
        Connection con = null;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/horsql","home","0123456789");
        return con;
    }
}
