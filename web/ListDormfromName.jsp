<%-- 
    Document   : ListDormfromName
    Created on : Apr 21, 2017, 1:14:15 PM
    Author     : BoomGDH559
--%>

<%@page import="java.util.List"%>
<%@page import="Model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finding Dormitory</title>
        <link rel="stylesheet" href="CSS/Hor.css">
    </head>
    <body>
        <jsp:include page= "ShowDorm.jsp"/>
        <% String myURI = request.getRequestURI(); %> 
        
        <%
            List<Dormitory> cs = (List) request.getAttribute("dormitorys");
            if (cs != null) {
        %>
        <table class="table" style = "margin-left: 200px;">
            <tr>
                <td style="display:none"> Dormitory ID</td>
                <td></td>
                <td> Dormitory Name </td>
                <td> Dormitory Address</td>
                <td> Rating Popular</td>
            </tr>
            <%
                for (Dormitory d : cs) {
                    String link = "DormitoryDetailServlet?dormId=" + d.getDormId();
            %>
            
            <tr><td style="display:none"> <%=d.getDormId()%></td>
                <td><img src="images/<%=d.getDormName()%>.jpg" width = "220" height="140"></td>
                <td> <a href="<%=link%>"><%=d.getDormName()%></a> </td>
                <td><%=d.getDormAddress()%></td>
                <td><%=d.getPopPoint()%></td>
                <%}%>
                
        </table>
        <%} else {%>
        <h1 style='color:#373737'>${message}</h1>
        <%}%>
        <footer style = "background-color: #f8f8f8;">
            <hr>

            <div class="container-fluid">
                <div class="row text-right">
                    <div class="col-sm-12">
                        <h5>©COPYRIGHT 2017</h5>
                        <h5>
                            POWERED BY INT105-G2-PROJ12
                        </h5>
                        <br>
                    </div>

                </div>
            </div>
        </footer>
    </body>
</html>
