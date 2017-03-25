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
        catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        list = new ListProblem(userId).getList();
    }   
    
    public void report(int problemId){
        boolean have = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProblemId() == problemId) {
                have = true;
                break;
            }
        }
        try {
            Connection connect = ConnectionBuilder.getConnection();
            PreparedStatement ps;
            if (have) {
                int causeId = 0;
                int problemC = 0;
                int problemN = 0;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getProblemId() == problemId) {
                        causeId = list.get(i).getCauseId();
                        problemC = list.get(i).getProblemC();
                        problemN = list.get(i).getProblemN();
                        break;
                    }
                }
                ps = connect.prepareStatement(
                        "UPDATE cause "
                                + "SET status_statusId = ? "
                                + "WHERE = ?");
                ps.setInt(1, 1);
                ps.setInt(2, causeId);
                int record = ps.executeUpdate();
                ps.close();
                problemC += problemN;
                ps = connect.prepareStatement(
                        "UPDATE recordProblem "
                                + "SET problemCurrent = ? , problemNow = ? "
                                + "WHERE = ?");
                ps.setInt(1,problemC);
                ps.setInt(2,1);
                ps.setInt(3,causeId);
                record = ps.executeUpdate();
                ps.close();
            }
            else {
                ps = connect.prepareStatement(
                        "INSERT INTO expense(expensesId , expensePrice , expenseDes )"
                                + "VALUES (null,null,null)");
                int record = ps.executeUpdate();
                ps.close();
                ps = connect.prepareStatement(
                        "INSERT INTO cause(causeId , expense_expensesId , Problem_problemId , status_statusId , Room_roomId , Room_Dormitory_dormId)"
                                + "VALUES (null,(SELECT MAX(expensesId) FROM expense),?,?,?,?)");
                ps.setInt(1, problemId);
                ps.setInt(2, 1);
                ps.setInt(3, roomId);
                ps.setInt(4, dormId);
                record = ps.executeUpdate();
                ps.close();
                ps = connect.prepareStatement(
                        "INSERT INTO recordproblem(problemPast, problemCurrent, problemNow, Cause_causeId, Cause_expense_expensesId, Cause_Problem_problemId, Cause_status_statusId)"
                                + "VALUES (?, ?, ?, (SELECT MAX(causeId) FROM cause), (SELECT MAX(expensesId) FROM expense), ?, ?)");
                ps.setInt(1, 00);
                ps.setInt(2, 00);
                ps.setInt(3, 1);
                ps.setInt(4, problemId);
                ps.setInt(5, 1);
                record = ps.executeUpdate();
                ps.close();
            }
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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getDormId() {
        return dormId;
    }

    public void setDormId(int dormId) {
        this.dormId = dormId;
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

    public ArrayList<Problem> getList() {
        return list;
    }

    public void setList(ArrayList<Problem> list) {
        this.list = list;
    }   
    
    public static ReportProblem getReportProblem(long userId){      
        ReportProblem rp = new ReportProblem(userId);
        return rp;
    }
}
    


