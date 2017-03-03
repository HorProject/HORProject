package helpdesk;

import helpdesk.problem.Problem;
//import java.sql.*;
public class ShowListP {
    private String room;
    private int status;
    private String hName;

    public ShowListP(String room, int status, String hName) {
        this.room = room;
        this.status = status;
        this.hName = hName;
    }
    
    public void showList() throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc?useUnicode=true&characterEncoding=UTF-8","smit","admin");
        if (status == 1) {
    //        PreparedStatement ps = connect.prepareStatement("SELECT * FROM user");
    //        ResultSet result = ps.executeQuery();
            Problem[] p = new Problem[27];
    //        while() {}
            Room r = new Room(room, p);
            System.out.println();
        }
        else {
    //        PreparedStatement ps = connect.prepareStatement("SELECT * FROM user");
    //        ResultSet result = ps.executeQuery();
        }
//        ps.close();
//        connect.close();
    }
}
