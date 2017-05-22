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
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="assets/css/fontface-thaisansneue.css">
        <link href="https://fonts.googleapis.com/css?family=Libre+Franklin:100,300,400" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Rubik:300,400,500" rel="stylesheet">
        <!-- CUSTOM CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="bootstrap-material-design-master/dist/css/bootstrap-material-design.css">
        <!-- CSS -->
        <link rel="stylesheet" href="CSS/styleLogin.css">
        <title>Finding Hor</title>

    </head>

    <body>


        <div class="container-fluid">
            <div class="login">
                <div style="text-align: center;">
                    <img src="img/hor_logo.png" alt="">
                </div>
            </div>
        </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3 col-xs-12">
                        <div class="jumbotron">
                            <form id="Loginform" method="post">
                            <div class="container-fluid">
                                <c:if test="${not empty errtext}">
                                <div class="alert alert-dismissible alert-danger">
                                    ${errtext}
                                </div>
                                </c:if>
                                <div class="form-group label-floating">
                                    <label for="111" class="control-label">Email</label>
                                    <input type="email" name="userEmail" class="form-control" id="111">
                                </div>
                                <div class="form-group label-floating">
                                    <label for="112" class="control-label">Password</label>
                                    <input type="password" name="password" class="form-control" id="112">
                                </div>
                               <div class="row">
                                    <div class="col-xs-6 text-left">
					<a id="loginbtn" class="btn btn-primary btn-lg waves-effect waves-light">Create Account</a>
                                    </div>
                                    <div class="col-xs-6 text-right">
                                    <button type="submit" name="submit" id="loginbtn" class="btn btn-primary btn-lg waves-effect waves-light">Login</button>
                                    </div>
				</div>
                            </div>
                        </form>          
                        </div>
                    </div>
                </div>
            </form>  

            <div class="row">
                <div class="col-md-5">
                    <div class="card-block">

                    </div>
                </div>
            </div>
        </div>






        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="bootstrap-material-design-master/jquery-3.2.1.min.js"></script>
        <script src="bootstrap-material-design-master/dist/js/material.min.js"></script>
        <script>
            $.material.init()
        </script>
    </body>

</html>
