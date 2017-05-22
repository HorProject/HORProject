package Servlet;

import Model.Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);

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
         String email = request.getParameter("userEmail");
        String pass = request.getParameter("password");
        HttpSession session = request.getSession();
        Login user = null;
        String dormId = request.getParameter("dormId")+"";
        if (email.length() > 0 && pass.length() > 0) {
            user = Login.logged(email, pass);
            if(user != null) {
                session.setAttribute("user", user);
                if (dormId != null) {
                    response.sendRedirect(request.getContextPath() + "/DormitoryDetailServlet?dormId="+dormId);
                }else if(dormId == null){
                response.sendRedirect(request.getContextPath() + "/ShowDorm.jsp");
                }
            } else if(user == null){
                request.setAttribute("errtext", "ชื่อผู้ใช้งานหรือ รหัสผ่านผิด");
            } 
        } else {
            request.setAttribute("errtext", "กรุณากรอกข้อมูลให้ถูกต้อง");
        }
        if(user == null) {
            processRequest(request, response);
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
