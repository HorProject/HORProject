<%-- 
    Document   : ListDormfromPrice
    Created on : Apr 21, 2017, 1:11:16 PM
    Author     : BoomGDH559
--%>

<%@page import="java.util.*"%>
<%@page import="Model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finding Dormitory</title>
        <link rel="stylesheet" href="CSS/Hor.css">
        <link rel="stylesheet" href="CSS/StarRate.css">
    </head>
    <body>
        <jsp:include page= "ShowDorm.jsp"/>
        <%
            List<RoomType> room = (List) request.getAttribute("Price");
            if (room != null) {
        %>
        <table class="table" style = "margin-left: 250px;">
            <tr id = 'Topic'>
                <td style="display:none;">Dormitory Id</td>
                <td></td>
                <td>Dormitory Name</td>
                <td>Dormitory Type</td>
                <td>Dormitory Address</td>
                <td>Dormitory Price</td>
            </tr>
            <%
                for (RoomType r : room) {
                    String link = "DormitoryDetailServlet?dormId=" +r.getDorm().getDormId();
            %>

            <tr id ="Detail">
                <td style="display:none;"><%=r.getDorm().getDormId()%></td>
                <td><img src="images/<%=r.getDorm().getDormId()%>.jpg" width = "220" height="140"></td>
                <td><a href="<%=link%>"><%=r.getDorm().getDormName()%></a></td>
                <td><%=r.getDorm().getDormType()%></td>
                <td><%=r.getDorm().getDormAddress()%></td>
                <td><%=r.getPrice1() + " บาท"%></td>
               
                
            </tr>    
            <%}%>
            <%} else {%>
            <h2>${message}</h2>
            <%}%>
        </table>
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
