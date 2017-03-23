package Model;

import java.sql.*;

public class ConnectionBuilder {
    private static final String host = "sql12.freemysqlhosting.net";
    private static final String dbName = "sql12164714";
    private static final String username = "sql12164714";
    private static final String password = "KkiSNdavSE";
    private static Connection con;
    public ConnectionBuilder() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + dbName + "?characterEncoding=utf8", username , password);
        }
        catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
            return con;
    }
}
