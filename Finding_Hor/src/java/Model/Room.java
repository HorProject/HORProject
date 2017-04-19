package Model;
import Model.Dormitory;

public class Room {
    private int roomId;
    private int roomNo;
    private Dormitory dormId;

    public Room() {
    }

    public Room(int roomId, int roomNo, Dormitory dormId) {
        this.roomId = roomId;
        this.roomNo = roomNo;
        this.dormId = dormId;
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

    public Dormitory getDormId() {
        return dormId;
    }

    public void setDormId(Dormitory dormId) {
        this.dormId = dormId;
    }

    @Override
    public String toString() {
        return "Room{" + "roomId=" + roomId + ", roomNo=" + roomNo + ", dormId=" + dormId + '}';
    }
    
}
