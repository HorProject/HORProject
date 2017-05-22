/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import Model.*;
import java.sql.*;

public class Popular {

    private int popId;
    private double sumPoint;
    private int rateId;

    public Popular() {
        this.popId = popId;
        this.sumPoint = sumPoint;
        this.rateId = rateId;
    }

    public Popular(int popId, double sumPoint, int rateId) {
        this.popId = popId;
        this.sumPoint = sumPoint;
        this.rateId = rateId;
    }

    public int getPopId() {
        return popId;
    }

    public void setPopId(int popId) {
        this.popId = popId;
    }

    public double getSumPoint() {
        return sumPoint;
    }

    public void setSumPoint(double sumPoint) {
        this.sumPoint = sumPoint;
    }

    public int getRateId() {
        return rateId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    public static int sumRate(int dormId) {

        int score = 0;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "select rate.rate from rate where rate.Dormitory_dormId = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, dormId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                score += rs.getInt("rate");
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return score;
    }

    public static boolean ckBefore(int dormId) {

        int ck = 0;
        boolean check = false;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "SELECT `Dormitory_dormId` FROM `populardorm` WHERE `Dormitory_dormId` = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, dormId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ck = rs.getInt("Dormitory_dormId");
            }
            if (ck == 0) {
                check = false;
            }else {
                check = true;
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return check;
    }

    public static void insertorupdate(int dormId){
        
        boolean ck = Popular.ckBefore(dormId);
        int sumPoint = Popular.sumRate(dormId);
        if(ck){
            try{
                Connection con = ConnectionBuilder.getConnection();
                String sql = "UPDATE `populardorm` SET `sumPoint`= ? WHERE `Dormitory_dormId` = ?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setDouble(1,sumPoint);
                st.setInt(2, dormId);
                int ckeck = st.executeUpdate();
                if(ckeck > 0){
                    System.out.println("เปลี่ยนแปลงหอสำเร็จ");
                }
            }catch(SQLException s){
                s.printStackTrace();
            }
        }else{
            try{
                Connection con = ConnectionBuilder.getConnection();
                String sql = "INSERT INTO `populardorm`( `sumPoint`, `Dormitory_dormId`) VALUES (?,?)";
                PreparedStatement st = con.prepareStatement(sql);
                st.setDouble(1, sumPoint);
                st.setInt(2, dormId);
                int ckeck = st.executeUpdate();
                if(ckeck > 0){
                    System.out.println("เพิ่มหอสำเร็จ");
                }
            }catch(SQLException s){
                s.printStackTrace();
            }
        }
        
    }
    public static void main(String[] args) {
        Popular.insertorupdate(206);
        
    }
    
}
