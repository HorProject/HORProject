/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.*;

/**
 *
 * @author Phanuphong
 */
public class editMeeting extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String text = "";
        String numDorm = request.getParameter("dormId");
        String target = "/DormitoryDetailServlet?dormId=" + numDorm;
        if (((String) ((Login) (session.getAttribute("user"))).getUserType()).equals("member")) {
            //System.out.println("NumDorm : "+numDorm);
            String wantee = request.getParameter("date") + " " + (request.getParameter("hour") + ":" + request.getParameter("min") + ":00");
            //System.out.println("Wantee : "+wantee);
            long userId = (long) ((Login) session.getAttribute("user")).getUserId();
            text = "แก้ไขเรียบร้อย";
            //System.out.println("userId : "+userId);
//        String uri = (String) request.getParameter("uri");
//        System.out.println("uri : "+uri);
//        uri = (uri.substring(8, uri.length())) + "?" + request.getQueryString();
//        
//        uri = (uri.substring(0, uri.indexOf("%") + 32));

            bookingMeeting.editMeeting(wantee, Integer.parseInt(numDorm), userId);

            //getServletContext().getRequestDispatcher("/Failure.jsp").forward(request, response); 
        } else {
            text = "คุณเป็น Admin ไม่สามารถนัดหมายได้";

        }
        request.setAttribute("message", text);
        getServletContext().getRequestDispatcher(target).forward(request, response);
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
