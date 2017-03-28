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
        this.userId = userId;
        try {
            Connection connect = ConnectionBuilder.getConnection();
            PreparedStatement ps = connect.prepareStatement("SELECT userType, userFirstName, userLastName FROM User WHERE userId = ?");
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
                        "SELECT User.userId, Room.roomNo, Cause.causeId, Cause.Problem_problemId "
                                + "FROM User "
                                + "INNER JOIN Renter ON User.userId = Renter.User_userId "
                                + "INNER JOIN Renter_has_Room ON Renter.renterId = Renter_has_Room.Renter_renterId "
                                + "INNER JOIN Room ON Renter_has_Room.Room_roomId = Room.roomId "
                                + "INNER JOIN Cause ON Room.roomId = Cause.Room_roomId "
                                + "WHERE User.userId = ? "
                                + "ORDER BY Cause.Problem_problemId");
            }
            else {
                ps = connect.prepareStatement(
                        "SELECT User.userId, Dormitory.dormId, Room.roomNo, Cause.causeId, Cause.Room_roomId, Cause.Problem_problemId "
                                + "FROM User "
                                + "INNER JOIN Dormitory ON User.userId = Dormitory.User_userId "
                                + "INNER JOIN Room ON Dormitory.dormId = Room.Dormitory_dormId "
                                + "INNER JOIN Cause ON Room.Dormitory_dormId = Cause.Room_Dormitory_dormId "
                                + "WHERE userId = ? "
                                + "ORDER BY Cause.Room_roomId, Cause.Problem_problemId");
            }
            ps.setLong(1,userId);
            result = ps.executeQuery();
            while(result.next()){
                list.add(new Problem(result.getInt("causeId"), result.getInt("roomNo")));
            }
            ps.close();
            connect.close();
        }
        catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
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
