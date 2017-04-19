/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomType {

    private int typeId;
    private int price1, price2;
    private Dormitory dorm;
    private Room room;

    public RoomType() {
    }

    public RoomType(int price1, int price2) {
        this.price1 = price1;
        this.price2 = price2;
    }

    public RoomType(int typeId, int price, Dormitory dorm, Room room) {
        this.typeId = typeId;
        this.price1 = price;
        this.dorm = dorm;
        this.room = room;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getPrice1() {
        return price1;
    }

    public void setPrice1(int price1) {
        this.price1 = price1;
    }

    public int getPrice2() {
        return price2;
    }

    public void setPrice2(int price2) {
        this.price2 = price2;
    }

    public Dormitory getDorm() {
        return dorm;
    }

    public void setDorm(Dormitory dorm) {
        this.dorm = dorm;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    
        public static List<RoomType> findByPrice(int price1, int price2) {
        List<RoomType> room = null;
        try {
            Connection con = ConnectionBuilder.getConnection();
            PreparedStatement state = con.prepareStatement("SELECT d.*,t.price FROM dormitory d join room r on d.dormId=r.dormitory_dormId join roomtype t on t.room_roomId=r.roomId where t.price between ? and ?");
            state.setInt(1, price1);
            state.setInt(2, price2);
            ResultSet result = state.executeQuery();
            while (result.next()) {
                if (room == null) {
                    room = new ArrayList<RoomType>();
                }
                RoomType r = new RoomType();
                r.setDorm(Dormitory.findById(result.getInt("dormId")));
                r.setPrice1(result.getInt("price"));
                r.setPrice2(result.getInt("price"));
                room.add(r);

            }

        } catch (SQLException e) {
            System.out.println("กรุณาใส่ข้อมูลเฉพาะตัวเลขเท่านั้น");
        }
        return room;
    }
    
    

}
