<%-- 
    Document   : Login
    Created on : Apr 25, 2017, 9:46:31 PM
    Author     : BoomGDH559
--%>

<%@page import="Model.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!--link rel="stylesheet" href="C:\Users\PeGuS\Documents\HORProject\testhtml\bootflat.github.io-master\bootflat\css\bootflat.css"!-->
        <link rel="shortcut icon" type="image/x-icon" href="favicon.png" >
        <link rel="stylesheet" href="style.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <title>Finding Hor</title>
    </head>
    <body>

        <!--nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="background-color: #968048;">
                <div class="container">
                        <a class="navbar-brand" href="#">HOR Project</a>
                        <div style="text-align: right;">
                                <ul class="nav navbar-nav">
                                        <li class="active">
                                                <a href="#">Home</a>
                                        </li>
                                        <li>
                                                <a href="#">Link</a>
                                        </li>
                                </ul>
                        </div>
                </div>
        </nav!-->

        <nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="background-color: #968048;">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"  style="color: DarkGray;">HOR Project</a>
                </div>
                <ul class="nav navbar-nav" style="text-align: right;">
                    <li class="active"><a href="#" style="color: DarkGray;">Home</a></li>
                </ul>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-8" style="padding-left: 0px;">
                    <img src="dorm.jpg" alt="" width="1011px;">
                </div>
                <div class="col-md-4">
                    <div class="login">
                        <div style="text-align: center;">
                            <img src="hor_logo.png" alt="">
                        </div>
                        <div id = "Login">
                            <form  action="LoginServlet" name="LoginForm" id="form" method="post">

                                    <label for="exampleInputEmail1">Login</label>
                                    <input type="email" name = "userEmail" class="form-control" placeholder="Email">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input type="password" name = "password" class="form-control" placeholder="Password">
                                <!--div class="checkbox">
                                        <label style="text-align: left; float: left;">
                                                <input type="checkbox" value="">
                                                Remember password
                                        </label>
                                </div!-->		
                                <div style="text-align: right;">
                                    <button class="btn-link">Create account</button> |
                                    <button class="btn-link">Forgetten password</button>
                                    <button type="submit" name="submit" class="btn btn-default">Login</button>
                                </div>
                            </form>
                        </div>
                        <!--div id = "Login">
                            <form action="LoginServlet" name="LoginForm" id="form" method="post">
                                <input type="email" name="userEmail" placeholder="E-mail">
                                <input type="password" name="password" placeholder="Password">
                                <input type="submit" name="submit">
                            </form>
                        </div!-->
                        <h2 style = "text-align: right">${errtext}</h2>
                    </div>
                </div>
            </div>
        </div>
        <footer>
            <div class="container-fluid">
                <div class="row text-left">
                    <div class="col-sm-6">

                        <div class="footerf">
                            <h5>&copy;COPYRIGHT 2017</h5>
                            <h5>
                                SUPPORT BY INT105-G2-PROJ12
                            </h5>
                        </div>

                    </div>
                    <div class="col-sm-6">
                        <div class="footerl">	
                            <h4 style="color: DarkGray;">นโยบายส่วนตัว | เกี่ยวกับเรา</h4>
                        </div>
                    </div>
                </div>
            </div>
        </footer> 
    </body>
</html>