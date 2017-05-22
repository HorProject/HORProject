package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.*;

public class Rate {

    private int rateId;
    private double rate;
    private Dormitory dorm;
    private Login userId;

    public Rate() {
    }

    public Rate(int rateId, double rate, Dormitory dorm, Login user) {
        this.rateId = rateId;
        this.rate = rate;
        this.dorm = dorm;
        this.userId = user;
    }

    public int getRateId() {
        return rateId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Dormitory getDorm() {
        return dorm;
    }

    public void setDorm(Dormitory dorm) {
        this.dorm = dorm;
    }

    public Login getUser() {
        return userId;
    }

    public void setUser(Login user) {
        this.userId = user;
    }

    public static int findDormId(int dormId) {

        if (dormId != 0) {
            try {
                Connection con = ConnectionBuilder.getConnection();
                String sql = "select dormId from dormitory where dormId = ?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setInt(1, dormId);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    dormId = rs.getInt("dormId");
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

        return dormId;

    }

    public static String getEmail(String username) {
        String email = "";
        //int userId = 0;
        if (username != null) {
            try {
                Connection con = ConnectionBuilder.getConnection();
                String sql1 = "select userEmail from user where lower(userFirstName)like ?";
                PreparedStatement st = con.prepareStatement(sql1);
                st.setString(1, username);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    email = rs.getString("userEmail");
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

        return email;

    }
    
    public static int findUserName(String email) {
        int userId = 0;
        if (email != null) {
            try {
                Connection con = ConnectionBuilder.getConnection();
                String sql = "select userId from user where lower(userEmail)like ?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1,email);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    userId = rs.getInt("userId");
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

        return userId;

    }
    

    public static boolean ckuserate(int userId, int dormId) {
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

    public static void insertRate(int rate, int userId, int dormId) {
        //System.out.println("ข้าอยู่ตรงนี้");
        if (rate != 0 && userId != 0 && dormId != 0) {
            try {
                Connection con = ConnectionBuilder.getConnection();
                PreparedStatement ps = con.prepareStatement("insert into rate(rate,User_userId,Dormitory_dormId) values (?,?,?)");
                ps.setInt(1, rate);
                ps.setInt(2,userId);
                ps.setInt(3,dormId);
                int ck = ps.executeUpdate();
                if (ck > 0) {
                    System.out.println("เพิ่มข้อมูลสำเร็จ");
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

    }
    
    

}
