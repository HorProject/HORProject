package Model;
import Model.Room;

public class RoomType {
    private int typeId;
    private String typeName;
    private String price;
    private String roomTypecol;
    private Room roomId;
    private Room dormId;

    public RoomType() {
    }

    public RoomType(int typeId, String typeName, String price, String roomTypecol, Room roomId, Room dormId) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.price = price;
        this.roomTypecol = roomTypecol;
        this.roomId = roomId;
        this.dormId = dormId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRoomTypecol() {
        return roomTypecol;
    }

    public void setRoomTypecol(String roomTypecol) {
        this.roomTypecol = roomTypecol;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    public Room getDormId() {
        return dormId;
    }

    public void setDormId(Room dormId) {
        this.dormId = dormId;
    }

    @Override
    public String toString() {
        return "roomType{" + "typeId=" + typeId + ", typeName=" + typeName + ", price=" + price + ", roomTypecol=" + roomTypecol + ", roomId=" + roomId + ", dormId=" + dormId + '}';
    }
    
}

