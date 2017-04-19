package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.*;
import java.util.*;

public final class ListDormitory_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Dormitory</title>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"margin: 50px; background-color: #f4f4f4;\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-xs-12\">\n");
      out.write("                    <img src=\"logo.png\">                \n");
      out.write("                    <div>\n");
      out.write("                        <h1>Dormitory Listing ::: </h1><hr>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                \n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "SearchNameForm.jsp", out, false);
      out.write("\n");
      out.write("                ");

                    List<Dormitory> cs = (List) request.getAttribute("dormitorys");
                    if (cs != null) {
      out.write("\n");
      out.write("                <table class=\"table\">\n");
      out.write("                    <tr style=\"background-color: bisque\"><td> Dormitory ID</td><td> Dormitory Name </td><td> Dormitory Address</td></tr>\n");
      out.write("                    ");

                        for (Dormitory d : cs) {
                            String link = "DormitoryDetailServlet?dormname=" + d.getDormName()+ "&from=";
                    
      out.write("\n");
      out.write("                    <tr><td> ");
      out.print(d.getDormId());
      out.write("</td>\n");
      out.write("                        <td> <a href=\"");
      out.print(link);
      out.write('"');
      out.write('>');
      out.print(d.getDormName());
      out.write("</a> </td>\n");
      out.write("                        <td>");
      out.print(d.getDormAddress());
      out.write("</td></tr>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                </table>\n");
      out.write("                <hr/>\n");
      out.write("                ");
} else {
      out.write("\n");
      out.write("                <h1 style='color:red'>");
      out.print(request.getAttribute("message"));
      out.write("</h1>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </di1v>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("</body>\n");
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
