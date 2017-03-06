package helpdesk;

//import java.sql.*;
import helpdesk.problem.Problem;
public class Room {
    private static String hName;
    private String room;
    private Problem[] problem;

    public Room(String room, String hName) {
        this.room = room;
        Room.hName = hName;
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc?useUnicode=true&characterEncoding=UTF-8","smit","admin");
//        PreparedStatement ps = connect.prepareStatement("SELECT * FROM user");
//        ResultSet result = ps.executeQuery();
//        while() {}
//        ps.close();
//        connect.close();
    }
    
    public int getFloor(){
        int floor = Integer.parseInt(room.substring(0,2));
        return floor;
    }

    public int getRoom() {
        return Integer.parseInt(room);
    }
    
    public int getNowP(int count){
        return problem[count].getNowP();
    }
    public int getYearP(int count){
        return problem[count].getYearP();
    }
    public int getLastYearP(int count) {
        return problem[count].getLastYearP();
    }
    public String getProblemStatus(int count){
        return problem[count].getProblemStatus();
    }
}
