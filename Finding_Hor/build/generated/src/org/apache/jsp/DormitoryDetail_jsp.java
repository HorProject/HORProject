package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.*;

public final class DormitoryDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\n");
      out.write("        <title>Dormitory Detail</title>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"margin: 50px\">\n");
      out.write("        <h1>Dormitory Detail ::</h1><hr>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "SearchNameForm.jsp", out, false);
      out.write("\n");
      out.write("        ");

            Dormitory d = (Dormitory) request.getAttribute("Dormitory");
            if (d != null) {
        
      out.write("\n");
      out.write("        <table style=\"border: brown 1px solid;background-color: antiquewhite;color: brown\">\n");
      out.write("            <tr>\n");
      out.write("                <td>Dormitory Id: </td>\n");
      out.write("                <td><input style=\"width: 100px\" type=\"text\" name=\"dormName\" value=\"");
      out.print(d.getDormId());
      out.write("\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Dormitory Name: </td>\n");
      out.write("                <td><input style=\"width: 150px\" type=\"text\" name=\"dormName\" value=\"");
      out.print(d.getDormName());
      out.write("\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Dormitory Address : </td>\n");
      out.write("                <td><textarea rows=\"3\" style=\"width:200px\">");
      out.print(d.getDormAddress());
      out.write("</textarea></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Count room: </td>\n");
      out.write("                <td><input style=\"width: 50px\" type=\"text\" name=\"dormName\" value=\"");
      out.print(d.getCountRoom());
      out.write("\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Facility dorm id: </td>\n");
      out.write("                <td><input style=\"width: 250px\" type=\"text\" name=\"dormName\" value=\"");
      out.print(d.getFacilityDormId());
      out.write("\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Facility room id: </td>\n");
      out.write("                <td><input style=\"width: 100px\" type=\"text\" name=\"dormName\" value=\"");
      out.print(d.getFacilityRoomId());
      out.write("\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Visitor no: </td>\n");
      out.write("                <td><input style=\"width: 100px\" type=\"text\" name=\"dormName\" value=\"");
      out.print(d.getVisitorNo());
      out.write("\"></td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("                ");
if (request.getParameter("from")!=null) {
      out.write("\n");
      out.write("                <br><hr>\n");
      out.write("                <a href=\"javascript:history.back()\"><input type=\"button\" value=\" [ back ] \"/></a>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("        ");
} else {
      out.write("\n");
      out.write("            <hr>\n");
      out.write("            <h3 style=\"color:red\">");
      out.print(request.getAttribute("message"));
      out.write("</h3>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
