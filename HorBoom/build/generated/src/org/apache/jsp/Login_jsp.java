package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.Login;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("        <!--link rel=\"stylesheet\" href=\"C:\\Users\\PeGuS\\Documents\\HORProject\\testhtml\\bootflat.github.io-master\\bootflat\\css\\bootflat.css\"!-->\r\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"favicon.png\" >\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\r\n");
      out.write("\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <title>Finding Hor</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <!--nav class=\"navbar navbar-default navbar-fixed-top\" role=\"navigation\" style=\"background-color: #968048;\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                        <a class=\"navbar-brand\" href=\"#\">HOR Project</a>\r\n");
      out.write("                        <div style=\"text-align: right;\">\r\n");
      out.write("                                <ul class=\"nav navbar-nav\">\r\n");
      out.write("                                        <li class=\"active\">\r\n");
      out.write("                                                <a href=\"#\">Home</a>\r\n");
      out.write("                                        </li>\r\n");
      out.write("                                        <li>\r\n");
      out.write("                                                <a href=\"#\">Link</a>\r\n");
      out.write("                                        </li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                </div>\r\n");
      out.write("        </nav!-->\r\n");
      out.write("\r\n");
      out.write("        <nav class=\"navbar navbar-default navbar-fixed-top\" role=\"navigation\" style=\"background-color: #968048;\">\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                <div class=\"navbar-header\">\r\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\"  style=\"color: DarkGray;\">HOR Project</a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <ul class=\"nav navbar-nav\" style=\"text-align: right;\">\r\n");
      out.write("                    <li class=\"active\"><a href=\"#\" style=\"color: DarkGray;\">Home</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-8\" style=\"padding-left: 0px;\">\r\n");
      out.write("                    <img src=\"dorm.jpg\" alt=\"\" width=\"1011px;\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-4\">\r\n");
      out.write("                    <div class=\"login\">\r\n");
      out.write("                        <div style=\"text-align: center;\">\r\n");
      out.write("                            <img src=\"hor_logo.png\" alt=\"\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div id = \"Login\">\r\n");
      out.write("                            <form  action=\"LoginServlet\" name=\"LoginForm\" id=\"form\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("                                    <label for=\"exampleInputEmail1\">Login</label>\r\n");
      out.write("                                    <input type=\"email\" name = \"userEmail\" class=\"form-control\" placeholder=\"Email\">\r\n");
      out.write("                                    <label for=\"exampleInputPassword1\">Password</label>\r\n");
      out.write("                                    <input type=\"password\" name = \"password\" class=\"form-control\" placeholder=\"Password\">\r\n");
      out.write("                                <!--div class=\"checkbox\">\r\n");
      out.write("                                        <label style=\"text-align: left; float: left;\">\r\n");
      out.write("                                                <input type=\"checkbox\" value=\"\">\r\n");
      out.write("                                                Remember password\r\n");
      out.write("                                        </label>\r\n");
      out.write("                                </div!-->\t\t\r\n");
      out.write("                                <div style=\"text-align: right;\">\r\n");
      out.write("                                    <button class=\"btn-link\">Create account</button> |\r\n");
      out.write("                                    <button class=\"btn-link\">Forgetten password</button>\r\n");
      out.write("                                    <button type=\"submit\" name=\"submit\" class=\"btn btn-default\">Login</button>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!--div id = \"Login\">\r\n");
      out.write("                            <form action=\"LoginServlet\" name=\"LoginForm\" id=\"form\" method=\"post\">\r\n");
      out.write("                                <input type=\"email\" name=\"userEmail\" placeholder=\"E-mail\">\r\n");
      out.write("                                <input type=\"password\" name=\"password\" placeholder=\"Password\">\r\n");
      out.write("                                <input type=\"submit\" name=\"submit\">\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div!-->\r\n");
      out.write("                        <h2 style = \"text-align: right\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errtext}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <footer>\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                <div class=\"row text-left\">\r\n");
      out.write("                    <div class=\"col-sm-6\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"footerf\">\r\n");
      out.write("                            <h5>&copy;COPYRIGHT 2017</h5>\r\n");
      out.write("                            <h5>\r\n");
      out.write("                                SUPPORT BY INT105-G2-PROJ12\r\n");
      out.write("                            </h5>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-sm-6\">\r\n");
      out.write("                        <div class=\"footerl\">\t\r\n");
      out.write("                            <h4 style=\"color: DarkGray;\">นโยบายส่วนตัว | เกี่ยวกับเรา</h4>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </footer> \r\n");
      out.write("    </body>\r\n");
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
