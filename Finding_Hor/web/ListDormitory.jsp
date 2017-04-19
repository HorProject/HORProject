<%-- 
    Document   : ListDormitory
    Created on : Mar 28, 2017, 9:10:18 PM
    Author     : PeGuS
--%>
<%@page import="Model.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dormitory</title>
        <style>
            #img1{
                text-align: center;
                display: block;
            }
            h1{
                font-family: Enjoy the Ride;
                text-align: center;
                font-size: 40pt;
                
            }
        </style>
    </head>
    <body style="margin: 50px; background-color: #f4f4f4;">
        <div id="img1">
            <img src="logo.png">
        </div>
        <div>
            <h1>Dormitory Listing</h1><hr>
        </div>
        <jsp:include page="SearchNameForm.jsp"/>
        <%
            List<Dormitory> cs = (List) request.getAttribute("dormitorys");
            if (cs != null) {%>
        <table class="table">
            <tr style="background-color: bisque"><td> Dormitory ID</td><td> Dormitory Name </td><td> Dormitory Address</td></tr>
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
</body>
</html>
