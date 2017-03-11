package helpdesk.database;

import java.sql.*;
public class Database {
    private Connection connect;
    private Statement stmt;
    private ResultSet rs;
    
    public Database() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
    }
    
    public void connect() throws Exception {
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc?useUnicode=true&characterEncoding=UTF-8","smit","admin");
        stmt = connect.createStatement();
    }
    public void statement(String select) throws Exception {
        rs = stmt.executeQuery(select);
    }
    public String getUsername() throws Exception {
        return rs.getString("usernane");
    }
    public String getPassword() throws Exception {
        return rs.getString("password");
    }
    public String getHName() throws Exception {
        return rs.getString("hName");
    }
    public String getRoom() throws Exception {
        return rs.getString("room");
    }
    public String[] getProblem(){
        String[] problem = new String[27];
        return problem;
    }
    public void nextRow() throws Exception {
        rs.next();
    }
    public void close() throws Exception {
        rs.close();
        connect.close();
    }
}
