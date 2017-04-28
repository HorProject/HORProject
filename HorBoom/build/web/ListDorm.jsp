<%-- 
    Document   : ListDorm
    Created on : Apr 5, 2017, 10:16:06 PM
    Author     : BoomGDH559
--%>

<%@page import="Model.*"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                
        <%
            List<RoomType> room = (List) request.getAttribute("Price");
            if(room != null){
        %>
        <table>
            <%
                for(RoomType r : room ){
            %>
            <tr>
                <td>Dormitory Name</td>
                <td>Dormitory Type</td>
                <td>Dormitory Address</td>
            </tr>
            <tr>
                <td><%=r.getDorm().getDormName()%></td>
                <td><%=r.getDorm().getDormType()%></td>
                <td><%=r.getDorm().getDormAddress()%></td>
                <td><%=r.getPrice1()%></td>
            </tr>    
        </table>
            <%}}%>
    </body>
</html>
