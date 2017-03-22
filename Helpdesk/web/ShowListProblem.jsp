<%-- 
    Document   : ShowListProblem
    Created on : Mar 22, 2017, 9:27:21 PM
    Author     : User
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Problem"%>
<%@page import="Model.ListProblem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% ListProblem d = (ListProblem)request.getAttribute("message"); %>
        <% ArrayList<Problem> list = d.getList(); %>
        <h1>List Problem</h1>
        <% for(int i = 0; i < list.size(); i++){ %>
        <div>list[i]</div>
        <% } %>
    </body>
</html>
