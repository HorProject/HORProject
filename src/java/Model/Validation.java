/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Model.*;
/**
 *
 * @author BoomGDH559
 */
public class Validation {

    public static boolean checkForm(String dormName) {
        boolean ck = false;
        if (dormName.length() == 0) {
            ck = true;
        }
        return ck;
    }

    public static boolean checkUser(String userEmail, String password) {
        boolean check = false;
        Login l = Login.logged(userEmail, password);
        if (l != null) {
            try {
                Connection con = ConnectionBuilder.getConnection();
                String sql = "SELECT * FROM `user` WHERE userEmail = ? and password = ?";
                PreparedStatement state = con.prepareStatement(sql);
                state.setString(1, userEmail);
                state.setString(2, password);
                ResultSet result = state.executeQuery();
                while (result.next()) {
                    l = new Login();
                    l.setUserId(result.getLong("userId"));
                    l.setUserFirstName(result.getString("userFirstName"));
                    l.setUserLastName(result.getString("userLastName"));
                    l.setUserGender(result.getString("userGender"));
                    l.setUserTel(result.getString("userTel"));
                    l.setUserAdd(result.getString("userAdd"));
                    l.setUserType(result.getString("userType"));
                    l.setUserEmail(result.getString("userEmail"));
                }
                check = true;

            } catch (Exception e) {
                check = false;

            }

        } else {
            check = false;
        }

        return check;

    }

    public static boolean ckuserate(long userId, int dormId) {
        boolean ck = true;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "SELECT rate.User_userId FROM ((rate INNER JOIN dormitory ON rate.Dormitory_dormId = dormitory.dormId) "
                    + "INNER JOIN user ON rate.User_userId = user.userId) where rate.Dormitory_dormId = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, dormId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (rs.getLong("User_userId") == userId) {
                    ck = false;
                }

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return ck;
    }

    public static boolean ckUser(String email) throws SQLException {
        boolean result = true;
        Connection con = ConnectionBuilder.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select user.userEmail from user where user.userEmail=\'" + email + "\'");
        while (rs.next()) {
            if (rs.getString("user.userEmail").equals(email)) {
                result = false;
                break;
            }
        }
        con.close();
        return result;
    }

    public static boolean ckMeeting(int dormId, long userId) {
        boolean ck = true;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "select * from meetingdorm where dormitory_dormId= ? and `User_userId`= ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, dormId);
            st.setLong(2, userId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                ck = true;
            } else {
                ck = false;
            }
            //getConnection().close();
        } catch (SQLException s) {
            s.printStackTrace();
        }

        return ck;
    }

    public static void main(String[] args) {
        String show = bookingMeeting.showMeeting(202, 106);
        boolean ck = Validation.ckShowMeeting(202, 106);
        if (ck) {
            System.out.println("show not booked : " + show);
        } else {
            System.out.println("show booked : " + show);
        }
    }

    public static boolean ckShowMeeting(int dormId, long userId) {
        boolean ck = true;
        String show = bookingMeeting.showMeeting(dormId, userId);
        if (show.equalsIgnoreCase("ไม่มีรายการนัดหมาย")) {
            ck = true;
        } else {
            ck = false;
        }
        return ck;

    }
}
