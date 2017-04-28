<%-- 
    Document   : DormitoryDetail
    Created on : Mar 28, 2017, 9:09:29 PM
    Author     : PeGuS
--%>

<%@page import="Model.Dormitory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Dormitory Detail</title>
    </head>
    <body style="margin: 50px; background-color: #f4f4f4;">
        <img src="C:\Users\PeGuS\Documents\NetBeansProjects\Finding_Hor\web\Slide1.png"> <h1>Dormitory Detail ::</h1><hr>
        <jsp:include page="ShowDorm.jsp"/>
        <%
            Dormitory d = (Dormitory) request.getAttribute("dormitory");
            if (d != null) {
        %>
        <table style="border: brown 1px solid;background-color: antiquewhite;color: brown">
            <tr>
                <td>Dormitory Id: </td>
                <td><input style="width: 100px" type="text" name="dormName" value="<%=d.getDormId()%>"></td>
            </tr>
            <tr>
                <td>Dormitory Name: </td>
                <td><input style="width: 250px" type="text" name="dormName" value="<%=d.getDormName()%>"></td>
            </tr>
            <tr>
                <td>Dormitory Address : </td>
                <td><textarea rows="3" style="width:200px"><%=d.getDormAddress()%></textarea></td>
            </tr>
            <tr>
            <tr>
                <td>Count room: </td>
                <td><input style="width: 50px" type="text" name="dormName" value="<%=d.getCountRoom()%>"></td>
            </tr>
            <tr>
                <td>Visitor no: </td>
                <td><textarea rows="15" style="width: 200px"><%=d.getVisitorNo()%></textarea></td>
            </tr>
        </table>
                <%if (request.getParameter("from")!=null) {%>
                <br><hr>
                <a href="javascript:history.back()"><input type="button" value=" [ back ] "/></a>
                <%}%>
        <%} else {%>
            <hr>
            <h3 style="color:red"><%=request.getAttribute("message")%></h3>
        <%}%>
    </body>
</html>