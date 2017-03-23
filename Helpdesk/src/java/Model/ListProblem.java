package Model;

import java.sql.*;
import java.util.ArrayList;

public class ListProblem {
    private long userId;
    private String name;
    private String surname;
    private String status;
    private ArrayList<Problem> list;

    public ListProblem() {
        list = new ArrayList<Problem>();
    }
    public ListProblem(long userId) {
        this();
        try {
            this.userId = userId;
            Connection connect = ConnectionBuilder.getConnection();
            PreparedStatement ps = connect.prepareStatement("SELECT userType, userFirstName, userLastName FORM user WHERE userId = ?");
            ps.setLong(1,userId);
            ResultSet result = ps.executeQuery();
            while(result.next()){
                name = result.getString("userFirstName");
                surname = result.getString("userLastName");
                status = result.getString("userType");
            }
            ps.close();
            if(status.equalsIgnoreCase("student")){
                ps = connect.prepareStatement(
                        "SELECT user.userId, renter.renterId, renter_has_room.Room_roomId, room.roomNo, cause.causeId, cause.Problem_problemId "
                                + "FROM user "
                                + "INNER JOIN renter ON user.userId = renter.renterId "
                                + "INNER JOIN renter_has_room ON renter.renterId = renter_has_room.Renter_renterId "
                                + "INNER JOIN room ON renter_has_room.Room_roomId = room.roomId "
                                + "INNER JOIN cause ON room.roomId = cause.Room_roomId "
                                + "WHERE userId = ? "
                                + "ORDER BY cause.Problem_problemId");
            }
            else {
                ps = connect.prepareStatement(
                        "SELECT user.userId, dormitory.dormId, room.roomNo, cause.causeId, cause.Room_roomId, cause.Problem_problemId "
                                + "FROM user "
                                + "INNER JOIN dormitory ON user.userId = dormitory.User_userId "
                                + "INNER JOIN room ON dormitory.dormId = room.Dormitory_dormId "
                                + "INNER JOIN cause ON room.Dormitory_dormId = cause.Room_Dormitory_dormId "
                                + "WHERE userId = ? "
                                + "ORDER BY cause.Room_roomId, cause.Problem_problemId");
            }
            ps.setLong(1,userId);
            result = ps.executeQuery();
            while(result.next()){
                list.add(new Problem(result.getInt("causeId"), result.getInt("roomId")));
            }
            ps.close();
            connect.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public ArrayList<Problem> getList() {
        return list;
    }
    public void setList(ArrayList<Problem> list) {
        this.list = list;
    }
    
    public static ListProblem getShowListProblem(long userId){
        ListProblem lp = new ListProblem(userId);
        return lp;
    }
}
