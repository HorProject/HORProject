package Model;
import java.sql.*;

public class ReportProblem {
    private long userId;
    private int roomId;
    private int roomNo;
    private int dormId;
    private String name;
    private String surname;
    
    public ReportProblem(long userId){    
           this.userId = userId;
        try{
            Connection connect = ConnectionBuilder.getConnection();
            PreparedStatement ps = connect.prepareStatement("SELECT  user.userFirstName , user.userLastName FROM user WHERE userId = ?");
            ps.setLong(1,userId);
            ResultSet result = ps.executeQuery();
            while(result.next()){
                name = result.getString("userFirstName");
                surname = result.getString("userLastName");
            }
            ps.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    
    }    
    public void report(int userId){
        
            
            
    }  
        
}
    


