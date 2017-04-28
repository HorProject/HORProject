/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.Dormitory;
import Model.Validation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BoomGDH559
 */
@WebServlet(name = "SearchName", urlPatterns = {"/SearchName"})
public class SearchName extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            String cid = request.getParameter("dormname");
            List<Dormitory> dormitorys = Dormitory.findByName(cid);
            String errtext = "";
            String target = "/DormitoryDetail.jsp";
            boolean val = Validation.checkForm(cid);
            System.out.println(cid +"Test");
            if (val == false) {
                if (cid == null || cid == "") {
                    errtext = " ไม่มีหอพักชื่อพบที่ท่านต้องการ ";
                    request.setAttribute("message", errtext);
                }
                if (cid != null) {
                    if (dormitorys == null || cid == "") {
                        errtext = " ไม่มีหอพักชื่อ " + cid   + " ที่ท่านต้องการ ";
                        request.setAttribute("message", errtext);
                    } else {
                        target = "/ListDormfromName.jsp";
                        request.setAttribute("dormitorys", dormitorys);
                    }
                }
            }

            target = "/ListDormfromName.jsp";
            getServletContext().getRequestDispatcher(target).forward(request, response);
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
