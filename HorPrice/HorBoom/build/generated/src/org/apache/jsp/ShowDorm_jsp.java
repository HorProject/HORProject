package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import Model.RoomType;

public final class ShowDorm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Finding Dorm</title>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background-color: #f4f4f4;\n");
      out.write("                color:#373737;\n");
      out.write("            }\n");
      out.write("            table{\n");
      out.write("                border-spacing: 50px 0;\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            #Detail{\n");
      out.write("                font-weight: 200px;\n");
      out.write("            }\n");
      out.write("            #image{\n");
      out.write("                text-align: center;\n");
      out.write("                display: block;\n");
      out.write("                margin-top: 10px;\n");
      out.write("            }\n");
      out.write("            h1{\n");
      out.write("                text-align: center;\n");
      out.write("                font-family: Enjoy the Ride;\n");
      out.write("                font-size: 40pt;\n");
      out.write("            }\n");
      out.write("            #Search{\n");
      out.write("                text-align: center;\n");
      out.write("                display: block;\n");
      out.write("                font-variant: initial;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id = 'image'>\n");
      out.write("        <img src=\"logo.png\">\n");
      out.write("        </div>\n");
      out.write("        <h1>Finding Dorm</h1>\n");
      out.write("        <hr>\n");
      out.write("        <div id = 'Search'>\n");
      out.write("        <form method=\"post\" action=\"SerchPrice\" name=\"searchForm\">\n");
      out.write("            Finding from price | กรุณากรอกเฉพาะตัวเลขเท่านั้น<br><div><br></div>\n");
      out.write("            Min Price <input type =\"text\" name = \"Price1\" pattern=\"[0-9].{0,}\" value='");
      out.print( (request.getParameter("Price1") == null ? "" : request.getParameter("Price1")));
      out.write("' /> \n");
      out.write("            Max Price <input type =\"text\" name = \"Price2\" pattern=\"[0-9].{1,}\" value='");
      out.print( (request.getParameter("Price2") == null ? "" : request.getParameter("Price2")));
      out.write("' />\n");
      out.write("            <br><input type=\"submit\"name =\"submit\" value=\"Search\">\n");
      out.write("        </form>\n");
      out.write("        </div>    \n");
      out.write("        <hr>    \n");
      out.write("        \n");
      out.write("        ");

            List<RoomType> room = (List)request.getAttribute("Price");
            if(room != null){
        
      out.write("\n");
      out.write("        <table>\n");
      out.write("            <tr id = 'Topic'>\n");
      out.write("                <td>Dormitory Name</td>\n");
      out.write("                <td>Dormitory Type</td>\n");
      out.write("                <td>Dormitory Address</td>\n");
      out.write("                <td>Dormitory Count Room</td>\n");
      out.write("                <td>Dormitory Visitor No</td>\n");
      out.write("                <td>Dormitory Price</td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                for(RoomType r : room ){
                    
            
      out.write("\n");
      out.write("            \n");
      out.write("            <tr id = 'Detail'>\n");
      out.write("                <td>");
      out.print(r.getDorm().getDormName());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(r.getDorm().getDormType());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(r.getDorm().getDormAddress());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(r.getDorm().getCountRoom());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(r.getDorm().getVisitorNo());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(r.getPrice1()+" บาท");
      out.write("</td>\n");
      out.write("            </tr>    \n");
      out.write("            ");
}
      out.write("</table>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
