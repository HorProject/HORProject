/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.*;
import Model.Validation;
import Model.bookingMeeting;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BoomGDH559
 */
@WebServlet(name = "DormitoryDetailServlet", urlPatterns = {"/DormitoryDetailServlet"})
public class DormitoryDetailServlet extends HttpServlet {

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

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        long uid = 0;
        HttpSession session = request.getSession();
        String message = "";
        String target = "";
        String price = "";
        String show = "";
        String dormId = request.getParameter("dormId");
        System.out.println(dormId);
        System.out.println("===============1");
        if (session.getAttribute("user") != null) {
            uid = ((Login)session.getAttribute("user")).getUserId();
            System.out.println("===============2");
            if (dormId.equals("null")) {
                System.out.println("===============3");
                target = "/ListDormfromName.jsp";
                message = "กรุณาค้นหาหอ";
            } else {
                int cid = Integer.parseInt(request.getParameter("dormId"));
                //System.out.println("เข้าแล้วจ้าาาา");
                Dormitory dorm = Dormitory.findById(cid);
                price = dorm.getDormName();
                //System.out.println("price : " + price);
                boolean ckShow = Validation.ckShowMeeting(cid, uid);
                //System.out.println("uid : " + uid);
                //System.out.println("dormId : " + cid);
                boolean ck = true;
                target = "/DormitoryDetail.jsp";
                if (cid != 0 && uid != 0) {
                    Dormitory d = Dormitory.OpenDetail(price);
                    if (d == null) {
                        message = " Dormitory " + cid + " does not exist !!!";
                    } else {
                        request.setAttribute("dormitory", d);
                    }
                    ckShow = Validation.ckShowMeeting(cid, uid);
                    if (ckShow) {
                        show = bookingMeeting.showMeeting(cid, uid);
                    } else {
                        show = bookingMeeting.showMeeting(cid, uid);
                    }
                    ck = Validation.ckMeeting(cid, uid);
                }

                request.setAttribute("showBook", show);
                request.setAttribute("checkBook", ckShow);
                request.setAttribute("paired", ck);
                request.setAttribute("message", message);

            }
        } else {
            message = " ไป Login ก่อน";
            System.out.println("ตอนนี้อยู่นี่");

            if (price == null) {
                target = "/ListDormfromPrice.jsp";
            } else {
                target = "/ListDormfromName.jsp";
            }
            if (dormId != null) {
                target = "/LoginServlet?dormId="+dormId;
                session.setAttribute("dormId", dormId);
                //System.out.println("เช็คๆ");
            } else {
                int cid = Integer.parseInt(request.getParameter("dormId"));
                session.setAttribute("dormId",cid);
                price = (String) request.getAttribute("dormName");
                System.out.println("price : " + price);
                
                boolean ck = true;
                target = "/DormitoryDetail.jsp";
                Dormitory d = Dormitory.findById(cid);
                if (d == null) {
                    message = " Dormitory " + cid + " does not exist !!!";
                } else {
                    request.setAttribute("dormitory", d);
                }
            }
            request.setAttribute("showBook", show);
            request.setAttribute("message", message);
        }
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
