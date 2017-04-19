<%-- 
    Document   : ShowRate
    Created on : Mar 18, 2017, 2:17:27 PM
    Author     : BoomGDH559
--%>

<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.RoomType"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finding Dorm</title>
        <style>
            body{
                background-color: #f4f4f4;
                color:#373737;
            }
            table{
                border-spacing: 50px 0;
                
            }
            #Detail{
                font-weight: 200px;
            }
            #image{
                text-align: center;
                display: block;
                margin-top: 10px;
            }
            h1{
                text-align: center;
                font-family: Enjoy the Ride;
                font-size: 40pt;
            }
            #Search{
                text-align: center;
                display: block;
                font-variant: initial;
            }
        </style>
    </head>
    <body>
        <div id = 'image'>
        <img src="logo.png">
        </div>
        <h1>Finding Dorm</h1>
        <hr>
        <div id = 'Search'>
        <form method="post" action="SerchPrice" name="searchForm">
            Finding from price | กรุณากรอกเฉพาะตัวเลขเท่านั้น<br><div><br></div>
            Min Price <input type ="text" name = "Price1" pattern="[0-9].{0,}" value='<%= (request.getParameter("Price1") == null ? "" : request.getParameter("Price1"))%>' /> 
            Max Price <input type ="text" name = "Price2" pattern="[0-9].{1,}" value='<%= (request.getParameter("Price2") == null ? "" : request.getParameter("Price2"))%>' />
            <br><input type="submit"name ="submit" value="Search">
        </form>
        </div>    
        <hr>    
        
        <%
            List<RoomType> room = (List)request.getAttribute("Price");
            if(room != null){
        %>
        <table>
            <tr id = 'Topic'>
                <td>Dormitory Name</td>
                <td>Dormitory Type</td>
                <td>Dormitory Address</td>
                <td>Dormitory Count Room</td>
                <td>Dormitory Visitor No</td>
                <td>Dormitory Price</td>
            </tr>
            <%
                for(RoomType r : room ){
                    
            %>
            
            <tr id ="Detail">
                <td><%=r.getDorm().getDormName()%></td>
                <td><%=r.getDorm().getDormType()%></td>
                <td><%=r.getDorm().getDormAddress()%></td>
                <td><%=r.getDorm().getCountRoom()%></td>
                <td><%=r.getDorm().getVisitorNo()%></td>
                <td><%=r.getPrice1()+" บาท"%></td>
            </tr>    
            <%}%></table>
            <%}%>
        
    </body>
</html>
