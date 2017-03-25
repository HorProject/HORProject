<%-- 
    Document   : ReportProblem
    Created on : Mar 25, 2017, 10:42:22 AM
    Author     : Poppular
--%>
<%@page import="Model.ReportProblem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% ReportProblem reportP = (ReportProblem)request.getAttribute("message"); %>
        <h1>Report Problem</h1>
        <div>
            <ol>
            <%for(int i = 0; i< reportP.getProblemName().size(); i++) {%>             
                <li><%= reportP.getProblemName().get(i) %><button type="button">report</button></li>           
            <% } %>
            </ol>
        </div>
    </body>
</html>
