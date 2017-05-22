package Model;

import static Model.ConnectionBuilder.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

public class bookingMeeting {

    private Date meetinDatetime;
    private int dormId;

    public bookingMeeting() {
    }

    public bookingMeeting(Date meetinDatetime, int dormId) {
        this.meetinDatetime = meetinDatetime;
        this.dormId = dormId;
    }

    public Date getMeetinDatetime() {
        return meetinDatetime;
    }

    public void setMeetinDatetime(Date meetinDatetime) {
        this.meetinDatetime = meetinDatetime;
    }

    public int getDormId() {
        return dormId;
    }

    public void setDormId(int dormId) {
        this.dormId = dormId;
    }

    public static void regMeeting(String wantee, int dormId, long User_userId) {
        try {
            Connection con = ConnectionBuilder.getConnection();
            java.sql.Timestamp sqlDate = java.sql.Timestamp.valueOf(wantee);
            PreparedStatement ps = con.prepareStatement("insert into meetingdorm (meetingDateTime,dormitory_dormId,User_userId) values (?,?,?)");
            ps.setInt(2, dormId);
            ps.setTimestamp(1, sqlDate);
            ps.setLong(3, User_userId);
            ps.execute();
            System.out.println(ps);
            System.out.println("=========================");
            System.out.print("Insert Meeting already!!");
            getConnection().close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void delMeeting(String wantee,int dormId, long User_userId) {
        try {
            Connection con = ConnectionBuilder.getConnection();
            Statement s = con.createStatement();
            String sql = "DELETE FROM meetingdorm WHERE dormitory_dormId = \'"+dormId+"\' AND User_userId=\'"+User_userId+"\'";
            s.execute(sql);
            System.out.print("Deleted suscessful");
            getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(bookingMeeting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      

    public static void editMeeting(String wantee, int dormId, long User_userId) {
        try {
            Connection con = ConnectionBuilder.getConnection();
            Statement s = con.createStatement();
            String sql = "DELETE FROM meetingdorm WHERE dormitory_dormId = \'"+dormId+"\' AND User_userId=\'"+User_userId+"\'";
            s.execute(sql);
            System.out.print("Deleted suscessful");
            java.sql.Timestamp sqlDate = java.sql.Timestamp.valueOf(wantee);
            PreparedStatement ps = con.prepareStatement("insert into meetingdorm (meetingDateTime,dormitory_dormId,User_userId) values (?,?,?)");
            ps.setInt(2, dormId);
            ps.setTimestamp(1, sqlDate);
            ps.setLong(3, User_userId);
            ps.execute();
            System.out.println(ps);
            System.out.println("=========================");
            System.out.print("Insert Meeting already!!");
            getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(bookingMeeting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String showMeeting(int dormId, long userId) {
        String show = "ไม่มีรายการนัดหมาย";
        Connection con = ConnectionBuilder.getConnection();
        Statement st = null;
        Statement st2 = null;
        String sql = "SELECT * FROM meetingdorm WHERE meetingdorm.dormitory_dormId=\'" + dormId + "\' AND meetingdorm.User_userId=\'" + userId + "\'";
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int numDorm = rs.getInt("dormitory_dormId");
                String sql2 = "SELECT dormitory.dormName FROM dormitory WHERE dormitory.dormId=\'" + numDorm + "/'";
                st2 = con.createStatement();
                ResultSet rs2 = st2.executeQuery(sql2);
                while (rs2.next()) {
                    System.out.println("outputDate");
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    String date = df.format(rs.getTimestamp("meetingDatetime"));
                    String time = date.substring(date.indexOf(" "),date.length());
                    date = date.substring(0,date.indexOf(" "));
                    show = "คุณมีการจองหอ \"" + rs2.getString("dormName") + "\nในวันที่ " +date+" และเวลาดังนี้ "+time;
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(bookingMeeting.class.getName()).log(Level.SEVERE, null, ex);
        }
        return show;
    }
    
    
    
    
    


    

}
