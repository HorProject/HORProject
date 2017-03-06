package helpdesk;

//import java.sql.*;
import helpdesk.problem.ProblemName;
public class ShowListP implements ProblemName{
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
    //        while() {}
            Room r = new Room(room, hName);
            for (int i = 0; i < 27; i++) {
                if(r.getNowP(i) > 0){
                    System.out.println(PROBLEMNAME[i]);
                }
            }
        }
        else {
    //        PreparedStatement ps = connect.prepareStatement("SELECT * FROM user");
    //        ResultSet result = ps.executeQuery();
        }
//        ps.close();
//        connect.close();
    }
}
