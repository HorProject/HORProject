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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.text.DecimalFormat;
import Model.*;

public class Dormitory {

    private int dormId;
    private String dormName;
    private String dormType;
    private String dormAddress;
    private String countRoom;
    private String visitorNo;
    private Double popPoint;
    private int sumPoint;

    public Dormitory() {
    }

    public Dormitory(int dormId, String dormName, String dormType, String dormAddress, String countRoom,double popPoint,int sumPoint) {
        this.dormId = dormId;
        this.dormName = dormName;
        this.dormType = dormType;
        this.dormAddress = dormAddress;
        this.countRoom = countRoom;
        this.popPoint = popPoint;
        this.sumPoint = sumPoint;
    }
    
    public int getSumPoint() {
        return sumPoint;
    }

    public void setSumPoint(int sumPoint) {
        this.sumPoint = sumPoint;
    }

    public Double getPopPoint() {
        return popPoint;
    }

    public void setPopPoint(Double popPoint) {
        this.popPoint = popPoint;
    }
    
    public int getDormId() {
        return dormId;
    }

    public void setDormId(int dormId) {
        this.dormId = dormId;
    }

    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName;
    }

    public String getDormType() {
        return dormType;
    }

    public void setDormType(String dormType) {
        this.dormType = dormType;
    }

    public String getDormAddress() {
        return dormAddress;
    }

    public void setDormAddress(String dormAddress) {
        this.dormAddress = dormAddress;
    }

    public String getCountRoom() {
        return countRoom;
    }

    public void setCountRoom(String countRoom) {
        this.countRoom = countRoom;
    }

    public String getVisitorNo() {
        return visitorNo;
    }

    public void setVisitorNo(String visitorNo) {
        this.visitorNo = visitorNo;
    }

    public Dormitory getDormitory() {

        Dormitory dorm = new Dormitory();
        return dorm;

    }

    public static Dormitory findById(int dormId) {
        Dormitory dorm = new Dormitory();
        if (dormId != 0) {
            try {
                Connection con = ConnectionBuilder.getConnection();
                PreparedStatement state = con.prepareStatement("select * from dormitory where dormId = ?");
                state.setInt(1, dormId);
                ResultSet result = state.executeQuery();
                while (result.next()) {
                    dorm.setDormId(result.getInt("dormId"));
                    dorm.setDormName(result.getString("dormName"));
                    dorm.setDormAddress(result.getString("dormAddress"));
                    dorm.setDormType(result.getString("dormType"));
                    dorm.setCountRoom(result.getString("countRoom"));
                    dorm.setVisitorNo(result.getString("visitorNo"));
                    dorm.setPopPoint(result.getDouble("popPoint"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
        return dorm;
    }

    public static List<Dormitory> findByName(String dormName) {
        Dormitory d = null;
        List<Dormitory> dorm = null;
        if (dormName != null || !(dormName.equalsIgnoreCase("%"))) {
            try {
                if(dormName.equals("%")){
                    dormName = dormName.replace("%","\\%");
                }
                Connection con = ConnectionBuilder.getConnection();
                PreparedStatement state = con.prepareStatement("SELECT * FROM `dormitory` WHERE lower(`dormName`) like ?");
                state.setString(1,"%"+dormName+"%");
                ResultSet result = state.executeQuery();
                while (result.next()) {
                    d = new Dormitory();
                    d.setDormId(result.getInt("dormId"));
                    d.setDormName(result.getString("dormName"));
                    d.setDormAddress(result.getString("dormAddress"));
                    d.setDormType(result.getString("dormType"));
                    d.setCountRoom(result.getString("countRoom"));
                    d.setVisitorNo(result.getString("visitorNo"));
                    d.setPopPoint(result.getDouble("popPoint"));
                    
                    if (dorm == null) {
                        dorm = new ArrayList<Dormitory>();
                    }
                    dorm.add(d);

                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

        }

        return dorm;
    }
    
    public static List<Dormitory> sortByPoppoint() {
        Dormitory d = null;
        List<Dormitory> dorm = null;
            try {
                Connection con = ConnectionBuilder.getConnection();
                PreparedStatement state = con.prepareStatement("SELECT d.* FROM dormitory d join populardorm p on d.dormId=p.Dormitory_dormId ORDER by d.popPoint DESC");
                ResultSet result = state.executeQuery();
                while (result.next()) {
                    d = new Dormitory();
                    d.setDormId(result.getInt("dormId"));
                    d.setDormName(result.getString("dormName"));
                    d.setDormAddress(result.getString("dormAddress"));
                    d.setDormType(result.getString("dormType"));
                    d.setCountRoom(result.getString("countRoom"));
                    d.setVisitorNo(result.getString("visitorNo"));
                    d.setPopPoint(result.getDouble("popPoint"));
                    
                    if (dorm == null) {
                        dorm = new ArrayList<Dormitory>();
                    }
                    dorm.add(d);

                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        return dorm;
    }
    
    public static int numCount(int dormId){
        int count = 0;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "SELECT `rate` FROM `rate` WHERE `Dormitory_dormId` = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, dormId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                count++;
            }
        }catch(SQLException s){
            s.printStackTrace();
        }  
        return count;
    }

    public static double sumPoint(int dormId) {

        double sum = 0;
        if (dormId != 0) {
            try {
                Connection con = ConnectionBuilder.getConnection();
                String sql1 = "SELECT `sumPoint` FROM `populardorm` WHERE `Dormitory_dormId` = ?";
                PreparedStatement st = con.prepareStatement(sql1);
                st.setInt(1, dormId);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    sum = rs.getDouble("sumPoint");
                }
            }catch(SQLException s){
                s.printStackTrace();
            }

        }
        return sum;
    }

    public static void insertAndMath(int dormId) {
        double sum = Dormitory.sumPoint(dormId);
        int count = Dormitory.numCount(dormId);
        String math = "";
        double avg = 0;
        try {
            DecimalFormat df = new DecimalFormat("#.##");
            math = df.format(sum/count);
            avg = Double.parseDouble(math);
            Connection con = ConnectionBuilder.getConnection();
            String sql = "UPDATE `dormitory` SET `popPoint`= ? WHERE `dormId` = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setDouble(1, avg);
            st.setInt(2, dormId);
            int ck = st.executeUpdate();
            if (ck > 0) {
                System.out.println("เปลี่ยนแปลงข้อมูลเรียบร้อย");
            }
        } catch (SQLException s) {
            System.out.println("Error ค่ะ" + s.getMessage());
            s.printStackTrace();
        }

    }

    public static Dormitory OpenDetail(String dormName) {
        Dormitory d = null;
        if (dormName != null) {
            try {
                Connection con = ConnectionBuilder.getConnection();
                PreparedStatement state = con.prepareStatement("select * from dormitory where lower(dormName)like ?");
                state.setString(1, dormName + "%");
                ResultSet result = state.executeQuery();
                while (result.next()) {
                    d = new Dormitory();
                    d.setDormId(result.getInt("dormId"));
                    d.setDormName(result.getString("dormName"));
                    d.setDormAddress(result.getString("dormAddress"));
                    d.setDormType(result.getString("dormType"));
                    d.setCountRoom(result.getString("countRoom"));
                    d.setVisitorNo(result.getString("visitorNo"));
                    d.setPopPoint(result.getDouble("popPoint"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

        }

        return d;
    }

    public static void main(String[] args) {
        List<Dormitory> dorm = Dormitory.findByName("55 Home");
        for(Dormitory d:dorm){
            System.out.println(d.getPopPoint());
        }
    }

}
