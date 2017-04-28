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

public class Dormitory {

    private int dormId;
    private String dormName;
    private String dormType;
    private String dormAddress;
    private String countRoom;
    private String visitorNo;
      

    public Dormitory() {
    }

    public Dormitory(int dormId, String dormName, String dormType, String dormAddress, String countRoom) {
        this.dormId = dormId;
        this.dormName = dormName;
        this.dormType = dormType;
        this.dormAddress = dormAddress;
        this.countRoom = countRoom;
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
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

        }

        return d;
    }
    

}
