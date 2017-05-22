/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Phanuphong
 */
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String userEmail = request.getParameter("email");
        String userPassword = request.getParameter("password");
        String userRepassword = request.getParameter("repassword");
        String userFirstName = request.getParameter("firstname");
        String userLastName = request.getParameter("lastname");
        String userGender = request.getParameter("gender");
        String userAddress = request.getParameter("address");
        String userTel = request.getParameter("tel");
        String userType = request.getParameter("type");
        String url = "/RegisterForm.jsp";
        boolean ck = Register.ckUser(userEmail);
        HttpSession session = request.getSession();
        Login lg;
        try {
            if(ck){
                Register.regUser(userFirstName, userLastName, userGender, userAddress, userTel, userEmail, userPassword, userType);
                lg = Login.logged(userEmail, userPassword);
                session.setAttribute("userType", lg.getUserType());
                session.setAttribute("firstname", lg.getUserFirstName());
                url = "/ShowDorm.jsp";

            } else {
                String error = "E-mail นี้ถูกใช้งานไปแล้ว";
                request.setAttribute("errtext", error);
                url = "/Login.jsp";

            }
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
