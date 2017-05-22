package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.ConnectionBuilder;

public class Register {

    private int userId;
    private String userFirstName, userLastName, userAddress, userTel, userEmail, password, userType;
    private String userGender;

    public Register() {
    }

    public Register(int userId, String userFirstName, String userLastName, String userAdd, String userTel, String userEmail, String password, String userType, String userGender) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userAddress = userAdd;
        this.userTel = userTel;
        this.userEmail = userEmail;
        this.password = password;
        this.userType = userType;
        this.userGender = userGender;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserAdd() {
        return userAddress;
    }

    public void setUserAdd(String userAdd) {
        this.userAddress = userAdd;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public static void regUser(String userFirstName, String userLastName, String userGender, String userAddress, String userTel, String userEmail, String userPassword, String userType) {
        try {
            Connection con = ConnectionBuilder.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into user(userFirstName,userLastName,userGender,userAdd,userTel,userEmail,password,userType) values (?,?,?,?,?,?,?,?)");
            ps.setString(1, userFirstName);
            ps.setString(2, userLastName);
            ps.setString(3, userGender);
            ps.setString(4, userAddress);
            ps.setString(5, userTel);
            ps.setString(6, userEmail);
            ps.setString(7, userPassword);
            ps.setString(8, userType);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
           
    }
    public static boolean ckUser(String email) throws SQLException {
        boolean result = true;
        Connection con = ConnectionBuilder.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select user.userEmail from user where user.userEmail=\'" + email + "\'");
        while (rs.next()) {
            if (rs.getString("user.userEmail").equals(email)) {
                result = false;
                break;
            }
        }
        con.close();
        return result;
    }
//    public static boolean ckUser(String user){
//        boolean result = true;
//        try {
//            Connection con = ConnectionBuilder.getConnection();
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("select user.userEmail from user where user.userEmail=\'"+userEmail+"\'");
//            System.out.println(">>>");
//            
//            while(rs.next()){
//                if(rs.getString("user.userEmail").equals(userEmail)){
//                    result = false;
//                    break;
//                }
//            }
//            con.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return result;
//    
//    }

    
}
