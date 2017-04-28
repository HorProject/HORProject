/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BoomGDH559
 */
public class Login {

    private long userId;
    private String userFirstName, userLastName, userAdd, userTel, userEmail, password, userType;
    private String userGender;

    public Login() {
    }

    public Login(long userId, String userFirstName, String userLastName, String userAdd, String userTel, String userEmail, String password, String userType, String userGender) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userAdd = userAdd;
        this.userTel = userTel;
        this.userEmail = userEmail;
        this.password = password;
        this.userType = userType;
        this.userGender = userGender;
    }

    public Login(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.password = userPassword;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
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
        return userAdd;
    }

    public void setUserAdd(String userAdd) {
        this.userAdd = userAdd;
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

    public static Login getLogin() {
        Login log = new Login();
        return log;
    }

    public static Login findByName(String userEmail, String password) {
        Login l = null;
//        List<Login> log = null;
        if (userEmail != null && password != null) {
            try {
                Connection con = ConnectionBuilder.getConnection();
                PreparedStatement state = con.prepareStatement("select * from user where lower(userEmail) = ? and lower(password) = ?");
                state.setString(1, userEmail);
                state.setString(2, password);
                ResultSet result = state.executeQuery();
                while (result.next()) {
                    l = new Login();
                    l.setUserId(result.getLong("userId"));
                    l.setUserFirstName(result.getString("userFirstName"));
                    l.setUserLastName(result.getString("userLastName"));
                    l.setUserGender(result.getString("userGender"));
                    l.setUserTel(result.getString("userTel"));
                    l.setUserAdd(result.getString("userAdd"));
                    l.setUserType(result.getString("userType"));
                    l.setUserEmail(result.getString("userEmail"));
//                    if (log == null) {
//                        log = new ArrayList<Login>();
//                    }
//                    log.add(l);

                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

        }

        return l;
    }

    public static boolean checkUser(String userEmail, String password) {
        boolean check = false;
        Login l = Login.findByName(userEmail, password);
        if (l != null) {
            try {
                Connection con = ConnectionBuilder.getConnection();
                String sql = "SELECT * FROM `user` WHERE userEmail = ? and password = ?";
                PreparedStatement state = con.prepareStatement(sql);
                state.setString(1, userEmail);
                state.setString(2, password);
                ResultSet result = state.executeQuery();
                while (result.next()) {
                    l = new Login();
                    l.setUserId(result.getLong("userId"));
                    l.setUserFirstName(result.getString("userFirstName"));
                    l.setUserLastName(result.getString("userLastName"));
                    l.setUserGender(result.getString("userGender"));
                    l.setUserTel(result.getString("userTel"));
                    l.setUserAdd(result.getString("userAdd"));
                    l.setUserType(result.getString("userType"));
                    l.setUserEmail(result.getString("userEmail"));
                }
                check = true;

            } catch (Exception e) {
                check = false;

            }

        }else{
            check = false;
        }

        return check;

    }

   
    
}
