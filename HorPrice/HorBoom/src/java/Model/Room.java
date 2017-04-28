/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author BoomGDH559
 */
public class Room extends Dormitory {
    
    private int roomId;
    private int roomNo;
    private Dormitory dorm;

    public Room() {
    }

    public Room(int roomId, int roomNo, Dormitory dorm) {
        this.roomId = roomId;
        this.roomNo = roomNo;
        this.dorm = dorm;
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

    public Dormitory getDorm() {
        return dorm;
    }

    public void setDorm(Dormitory dorm) {
        this.dorm = dorm;
    }
    
    

}

