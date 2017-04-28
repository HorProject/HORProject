/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;

public class ConnectionBuilder {

    public static Connection getConnection() {

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://10.4.56.26:3306/Finding?characterEncoding=UTF-8","Boom","GDH559");
            /*
            PreparedStatement state = con.prepareStatement("SELECT * FROM dormitory d join room r on d.dormId=r.Dormitory_dormId "
                    + "join roomtype t on t.room_roomId=r.roomId where t.price > 1000");
            ResultSet result = state.executeQuery();
            while(result.next()){
                System.out.println(result.getString("dormName")+" "+result.getNString("dormType")+" "+result.getNString("dormAddress")+" "
                +result.getNString("countRoom")+" "+result.getNString("price")+" บาท");
            }
            */
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return con;

    }
    /*
    public static void main(String[] args) throws SQLException {
        Connection con = ConnectionBuilder.getConnection();
        PreparedStatement state = con.prepareStatement("SELECT * FROM dormitory d join room r on d.dormId=r.dormitory_dormId "
                    + "join roomtype t on t.room_roomId=r.roomId where t.price > 1000");
            ResultSet result = state.executeQuery();
            while(result.next()){
                System.out.println(result.getString("dormName")+" "+result.getNString("dormType")+" "+result.getNString("dormAddress")+" "
                +result.getNString("countRoom")+" "+result.getNString("price")+" บาท");
            }
    }
    */
    
    
    

}
