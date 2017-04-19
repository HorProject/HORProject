package Model;
import java.sql.*;
public class ConnectionBuilder {
    public static Connection getConnection(){
        Connection connect = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://10.4.56.26:3306/Finding?characterEncoding=UTF-8", "team006" , "14141414");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(SQLException e){
            System.out.println(e);
        }
        return connect;
        }
    public static void main(String[] args) throws SQLException {
        Connection con = getConnection();
        PreparedStatement state = con.prepareStatement("SELECT * FROM dormitory");
        ResultSet result = state.executeQuery();
        while(result.next()){
                System.out.println(result.getString("dormName")+" "+result.getNString("dormType")+" "+result.getNString("dormAddress")+" "
                +result.getNString("countRoom"));
            }
    }
}
