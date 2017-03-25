<%-- 
    Document   : ShowListStatus
    Created on : Mar 25, 2017, 11:04:45 AM
    Author     : User
--%>

<%@page import="Model.ListProblem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Status</title>
    </head>
    <body>
        <% ListProblem listS = (ListProblem)request.getAttribute("message"); %>
        <table>
            <% if(listS.getStatus().equalsIgnoreCase("student")) { %>
                <tr>
                    <th></th>
                    <th>problem name</th>
                    <th>status</th>
                </tr>
                <% for(int i = 0; i < listS.getList().size(); i++) { %>
                    <tr>
                        <td><%= (i+1) %></td>
                        <td><%= listS.getList().get(i).getName() %></td>
                        <td><%= listS.getList().get(i).getStatus() %></td>
                    </tr>
                <% } %>
            <% } else { %>
                <tr>
                    <th></th>
                    <th>problem name</th>
                    <th>room</th>
                    <th>status</th>
                </tr>
                <% for(int i = 0; i < listS.getList().size(); i++){ %>
                    <tr>
                        <td><%= (i+1) %></td>
                        <td><%= listS.getList().get(i).getName() %></td>
                        <td><%= listS.getList().get(i).getRoom() %></td>
                        <td><%= listS.getList().get(i).getStatus() %></td>
                    </tr>
                <% } %>
            <% } %>
        </table>
    </body>
</html>
