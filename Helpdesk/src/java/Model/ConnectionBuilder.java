package Model;

import java.sql.*;

public class ConnectionBuilder {
    public static Connection getConnection() throws Exception {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/horsql","root","");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            return con;
        }
    }
}
