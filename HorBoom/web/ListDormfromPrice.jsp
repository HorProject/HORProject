<%-- 
    Document   : ListDormfromPrice
    Created on : Apr 21, 2017, 1:11:16 PM
    Author     : BoomGDH559
--%>

<%@page import="java.util.*"%>
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
            List<RoomType> room = (List) request.getAttribute("Price");
            if (room != null) {
        %>
        <table>
            <tr id = 'Topic'>
                <td>Dormitory Name</td>
                <td>Dormitory Type</td>
                <td>Dormitory Address</td>
                <td>Dormitory Price</td>
            </tr>
            <%
                for (RoomType r : room) {
                    String link = "DormitoryDetailServlet?dormname=" + r.getDorm().getDormName() + "&from=";
            %>

            <tr id ="Detail">
                <td><a href="<%=link%>"><%=r.getDorm().getDormName()%></td>
                <td><%=r.getDorm().getDormType()%></td>
                <td><%=r.getDorm().getDormAddress()%></td>
                <td><%=r.getPrice1() + " บาท"%></td>
            </tr>    
            <%}%></table>
            <%} else {%>
        <h2><%=request.getAttribute("message")%></h2>
        <%}%>
    </body>
</html>
