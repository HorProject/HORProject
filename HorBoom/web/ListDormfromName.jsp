<%-- 
    Document   : ListDormfromName
    Created on : Apr 21, 2017, 1:14:15 PM
    Author     : BoomGDH559
--%>

<%@page import="java.util.List"%>
<%@page import="Model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finding Dormitory</title>
        <link rel="stylesheet" href="Hor.css">
    </head>
    <body>
        <jsp:include page= "ShowDorm.jsp"/>
        <%
            List<Dormitory> cs = (List) request.getAttribute("dormitorys");
            if (cs != null) {%>
        <table class="table">
            <tr><td> Dormitory ID</td><td> Dormitory Name </td><td> Dormitory Address</td></tr>
            <%
                for (Dormitory d : cs) {
                    String link = "DormitoryDetailServlet?dormname=" + d.getDormName() + "&from=";
            %>
            <tr><td> <%=d.getDormId()%></td>
                <td> <a href="<%=link%>"><%=d.getDormName()%></a> </td>
                <td><%=d.getDormAddress()%></td></tr>
                <%}%>
        </table>
        <hr/>
        <%} else {%>
        <h1 style='color:red'><%=request.getAttribute("message")%></h1>
        <%}%>
    </body>
</html>
