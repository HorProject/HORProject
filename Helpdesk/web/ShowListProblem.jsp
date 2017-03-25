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
        <title>Show List Problem</title>
    </head>
    <body>
        <% ListProblem listP = (ListProblem)request.getAttribute("message"); %>
        <h1>List Problem</h1>
        <table>
            <% if(listP.getStatus().equalsIgnoreCase("student")) { %>
                <tr>
                    <th></th>
                    <th>problem name</th>
                </tr>
                <% for(int i = 0; i < listP.getList().size(); i++) { %>
                    <% if(listP.getList().get(i).getStatusId() != 3) { %>
                    <tr>
                        <td> <%= (i+1) %> </td>
                        <td> <%= listP.getList().get(i).getName() %> </td>
                    </tr>
                    <% } %>
                <% } %>
            <% } else { %>
                <tr>
                    <th></th>
                    <th>problem name</th>
                    <th>room</th>
                </tr>
                <% for(int i = 0; i < listP.getList().size(); i++){ %>
                    <% if(listP.getList().get(i).getStatusId() != 3) { %>
                        <tr>
                            <td> <%= (i+1) %> </td>
                            <td> <%= listP.getList().get(i).getName() %> </td>
                            <td> <%= listP.getList().get(i).getRoom() %> </td>
                        </tr>
                    <% } %>
                <% } %>
            <% } %>
        </table>
    </body>
</html>
