<%-- 
    Document   : Login
    Created on : Apr 25, 2017, 9:46:31 PM
    Author     : BoomGDH559
--%>

<%@page import="Model.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finding Dormitory</title>
        <link rel="stylesheet" href="Hor.css">
        
    </head>
    <body>
        <div id = 'image'>
            <img src="logo.png">
        </div>
        <h1>Finding Dorm</h1>
        <hr>
        <div id = "Login">
        <form action="LoginServlet" name="LoginForm" id="form" method="post">
            <input type="email" name="userEmail" placeholder="E-mail">
            <input type="password" name="password" placeholder="Password">
            <input type="submit" name="submit">
        </form>
        </div>
        <h2>${errtext}</h2>
    </body>
</html>
