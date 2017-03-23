package Model;

import java.sql.*;

public class ConnectionBuilder {
    private static final String host = "sql12.freemysqlhosting.net";
    private static final String dbName = "sql12164714";
    private static final String username = "sql12164714";
    private static final String password = "KkiSNdavSE";
    public static Connection getConnection() throws SQLException {
        Connection con = null;
        con = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/?characterEncoding=utf8" + dbName, username , password);
        return con;
    }
}
