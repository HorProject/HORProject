package Model;

import java.sql.*;

public class ConnectionBuilder {
    private static final String host = "10.4.56.26";
    private static final String dbName = "hor";
    private static final String username = "hor";
    private static final String password = "hor";

    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + dbName + "?characterEncoding=utf8", username , password);
        return con;
    }
}
