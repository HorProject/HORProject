<%-- 
    Document   : ListDorm
    Created on : Apr 5, 2017, 9:42:56 PM
    Author     : BoomGDH559
--%>

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
        <jsp:include page="ShowDorm.jsp"/>
        <%
            Dormitory d = (Dormitory) request.getAttribute("dormitory");
            //Customer c = Customer.findById(3) ;
            if (d != null) {
        %>
        <table>
            <tr>
                <td>Dorm Name</td>
                <td><%=d.getDormName()%></td>
            </tr>
            <tr>
                <td>Dorm Type</td>
                <td><%=d.getDormType()%></td>
            </tr>
            <tr>
                <td>Dorm Address</td>
                <td><%=d.getDormAddress()%></td>
            </tr>
            <tr>
                <td>Dorm Count Room</td>
                <td><%=d.getCountRoom()%></td>
            </tr>
            <tr>
                <td>Dorm Visitor No</td>
                <td><%=d.getVisitorNo()%></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
