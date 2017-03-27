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
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link href="https://fonts.googleapis.com/css?family=Itim|Sriracha" rel="stylesheet">
    </head>
    <body class="font-siracha">
        <% ListProblem listP = (ListProblem)request.getAttribute("message"); %>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1>List Problem</h1>
                </div>
            </div>
            <div class="row">
                <table class="table table-hover table-condensed table-responsive">
                    <% int count = 1;
                    if(listP.getStatus().equalsIgnoreCase("student")) { %>
                        <thead>
                            <tr>
                                <th class="text-center">#</th>
                                <th>problem name</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for(int i = 0; i < listP.getList().size(); i++) {
                                if(listP.getList().get(i).getStatusId() != 3) { %>
                                    <tr>
                                        <td class="text-center"><%= count++ %></td>
                                        <td class="font-itim"><%= listP.getList().get(i).getName() %></td>
                                    </tr>
                                <% }
                            } %>
                        </tbody>
                    <% } else { %>
                        <thead>
                            <tr>
                                <th class="test-center">#</th>
                                <th>problem name</th>
                                <th>room</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for(int i = 0; i < listP.getList().size(); i++) {
                                if(listP.getList().get(i).getStatusId() != 3) { %>
                                    <tr>
                                        <td class="text-center"><%= count++ %></td>
                                        <td class="font-itim"><%= listP.getList().get(i).getName() %></td>
                                        <td><%= listP.getList().get(i).getRoom() %></td>
                                    </tr>
                                <% }
                            } %>
                        </tbody>
                    <% } %>
                </table>
            </div>
            <div class="row">
                <div class="col-md-12 text-right">
                    <a href="#" target="_self">
                        <button class="btn btn-lg btn-default" id="back">กลับสู่เมนูหลัก</button>
                    </a>
                </div>
            </div>
        </div>
    </body>
</html>
