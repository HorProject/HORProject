package Model;

import java.sql.*;
import java.util.ArrayList;

public class ReportProblem {
    private long userId;
    private int roomId;
    private int roomNo;
    private int dormId;
    private String name;
    private String surname;
    private ArrayList<Problem> list;
    
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
            ps = connect.prepareStatement(
                    "SELECT user.userId, room.roomId, room.roomNo, room.Dormitory_dormId "
                            + "FROM user "
                            + "INNER JOIN renter ON user.userId = renter.User_userId "
                            + "INNER JOIN renter_has_room ON renter.renterId = renter_has_room.Renter_renterId "
                            + "INNER JOIN room ON renter_has_room.Room_roomId = room.roomId "
                            + "WHERE userId = ?");
            ps.setLong(1,userId);
            result = ps.executeQuery();
            while(result.next()){
                roomId = result.getInt("roomId");
                roomNo = result.getInt("roomNo");
                dormId = result.getInt("Dormitory_dormId");
            }
            ps.close();
            connect.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        list = new ListProblem(userId).getList();
    }   
    
    public void report(int problemId){
        
        
            
            
    }  
        
}
    


