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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <jsp:include page="ShowDorm.jsp"/>
        <%
            RoomType r = (RoomType) request.getAttribute("Price");
            //Customer c = Customer.findById(3) ;
            if (r != null) {
        %>
        <table>
            <tr>
                <td>Dorm Name</td>
                <td><%=r.getDorm().getDormName()%></td>
            </tr>
            <tr>
                <td>Dorm Type</td>
                <td><%=r.getDorm().getDormType()%></td>
            </tr>
            <tr>
                <td>Dorm Count Room</td>
                <td><%=r.getDorm().getCountRoom()%></td>
            </tr>
        </table>
    </body>
</html>
