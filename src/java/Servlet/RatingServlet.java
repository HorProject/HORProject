/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BoomGDH559
 */
public class RatingServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int star = Integer.parseInt(request.getParameter("rate"));
        System.out.println("star : "+star);
        HttpSession session = request.getSession();
        String name = ((Login)session.getAttribute("user")).getUserFirstName();
        String type = ((Login)session.getAttribute("user")).getUserType();
        System.out.println("type : " + type);
        System.out.println("Name : " + name);
        String username = Rate.getEmail(name);
        int userId = Rate.findUserName(username);
        System.out.println("userId : " + userId);
        int dormId = Integer.parseInt((String) request.getParameter("dormId"));
        String uri = (String) request.getParameter("uri");
        //System.out.println("uri : "+uri);
        uri = (uri.substring(8,uri.length()))+"?"+request.getQueryString();
        System.out.println("uri : "+uri);
        //System.out.println("star :" + dormId);
        String text = "";
        //String url = "/DormitoryDetail.jsp";
        System.out.println("url : "+uri);
        boolean ck = Rate.ckuserate(userId, dormId);
        //System.out.println("ck : " + ck);
        Dormitory d = Dormitory.findById(dormId);
        try {
            
            if (type != null && (type.equals("member"))) {
                System.out.println("เข้า member");
                if (ck) {
                    Rate.insertRate(star, userId, dormId);
                    Popular.insertorupdate(dormId);
                    Dormitory.insertAndMath(dormId);
                    text = "กราบบบค่ะที่ให้คะแนนหอของฉัน";
                    System.out.println("สามารถ insert ได้");

                } else {
                    //url = "/DormitoryDetail.jsp";
                    text = "ใส่คะแนนไปแล้วค่าาา";
                }
            } else if (type != null && (type.equals("admin"))) {
                text = "คุณเป็น Admin ไม่สามารถให้คะแนนได้";
            }

        } catch (NullPointerException n) {
            System.out.println("เป็น null" + n.getMessage());
        }
        request.setAttribute("dormitory",d);
        //request.setAttribute("dormId",dormId);
        request.setAttribute("statustext", text);
        //System.out.println(url);
        getServletContext().getRequestDispatcher(uri).forward(request, response);

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
        processRequest(request, response);
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
        processRequest(request, response);
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
