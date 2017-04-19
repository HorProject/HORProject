package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dormitory {
    private int dormId;
    private String dormName;
    private String dormType;
    private String dormAddress;
    private String countRoom;
    private String facilityDormId;
    private String facilityRoomId;
    private String visitorNo;

    public Dormitory() {
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

    public String getFacilityDormId() {
        return facilityDormId;
    }

    public void setFacilityDormId(String facilityDormId) {
        this.facilityDormId = facilityDormId;
    }

    public String getFacilityRoomId() {
        return facilityRoomId;
    }

    public void setFacilityRoomId(String facilityRoomId) {
        this.facilityRoomId = facilityRoomId;
    }

    public String getVisitorNo() {
        return visitorNo;
    }

    public void setVisitorNo(String visitorNo) {
        this.visitorNo = visitorNo;
    }

    private static void getDormitory(ResultSet rs, Dormitory d) throws SQLException {
        d.setDormId(rs.getInt("dormId"));
        d.setDormName(rs.getString("dormName"));
        d.setDormType(rs.getString("dormType"));
        d.setDormAddress(rs.getString("dormAddress"));
        d.setCountRoom(rs.getString("countRoom"));
        d.setFacilityDormId(rs.getString("facilityDormId"));
        d.setFacilityRoomId(rs.getString("facilityRoomId"));
        d.setVisitorNo(rs.getString("visitorNo"));
        }
    
     public static List<Dormitory> findByName(String name) {
        Dormitory d = null;
        List<Dormitory> dormitorys = null;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sqlCmd = "select * from dormitory where lower(dormName) like ?";
            PreparedStatement stm = con.prepareStatement(sqlCmd);
            stm.setString(1, name.toLowerCase() + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                d = new Dormitory();
                getDormitory(rs, d);
                if (dormitorys == null) {
                    dormitorys = new ArrayList<Dormitory>();
                }
                dormitorys.add(d);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return dormitorys;
    }
     
    public static Dormitory OpenDetail(String name){
        Dormitory d = null;
        try{
            Connection con = ConnectionBuilder.getConnection();
            String sqlCmd = "select * from dormitory where lower(dormName) like ?";
            PreparedStatement stm = con.prepareStatement(sqlCmd);
            stm.setString(1, name.toLowerCase());
                ResultSet rs = stm.executeQuery();
                if (rs.next()) {
                d = new Dormitory();
                getDormitory(rs, d);
            }   
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return d;
    }
    
     public static void main(String[] args) {
        List<Dormitory> d = findByName("A");
        for(Dormitory dd : d)
             System.out.println(dd.dormName);
    }
    
    
}
