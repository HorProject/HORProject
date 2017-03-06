package helpdesk.database;

import java.sql.*;
public class Database {
    Connection connect;
    PreparedStatement ps;
    ResultSet result;
    
    public Database() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
    }
    
    public void connect() throws Exception {
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc?useUnicode=true&characterEncoding=UTF-8","smit","admin");
    }
    public void statement(String select) throws Exception {
        ps = connect.prepareStatement(select);
        result = ps.executeQuery();
    }
    public String getProblem(){
        return "";
    }
    public void close() throws Exception {
        ps.close();
        connect.close();
    }
}
