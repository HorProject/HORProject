package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.RoomType;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;

public class SerchPrice extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            int input1 = Integer.parseInt(request.getParameter("Price1"));
            int input2 = Integer.parseInt(request.getParameter("Price2"));
            List<RoomType> room = Model.RoomType.findByPrice(input1, input2);
            request.setAttribute("Price", room);
            request.setAttribute("Price1", input1);
            request.setAttribute("Price2", input2);
            String text = request.getParameter("message");
            String errtext = "";
            String url = "/DormitoryDetail.jsp";
            if (room == null) {
                errtext = "ไม่มีหอพักอยู่ในราคาช่วงนี้ กรุณาค้นหาใหม่";
                request.setAttribute("message",errtext);
            } else {
                request.setAttribute("message",text);
            }
            url = "/ListDormfromPrice.jsp";
            request.getServletContext().getRequestDispatcher(url).forward(request, response);

        } catch (Exception e) {
            String url = "/ShowDorm.jsp";
            request.getServletContext().getRequestDispatcher(url).forward(request, response);

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
