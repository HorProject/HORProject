
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finding Dormitory</title>
        <link rel="shortcut icon" type="image/x-icon" href="img/logo.png" >
        <link rel="stylesheet" href="CSS/Hor.css">
        <link href="https://fonts.googleapis.com/css?family=Libre+Franklin:100,300,400" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Rubik:300,400,500" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
       <script>
            function showhide(id) {
                var showhide = document.getElementById(id);
                if (showhide.style.display === 'none')
                    showhide.style.display = 'block';
                else
                    showhide.style.display = 'none';
            }
            function callShow() {
                window.location = "ShowDorm.jsp?null";
            }
        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="scripts/jquery-3.2.1.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <script>
            function showhide(id) {
                var showhide = document.getElementById(id);
                if (showhide.style.display == 'none')
                    showhide.style.display = 'block';
                else
                    showhide.style.display = 'none';
            }
            function gotoHome() {
                window.location = "ShowDorm.jsp?null";
            }
            function sendDormId(id){
                document.getElementById('dormForm'+id).submit();
            }
        </script>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <img src="img/favicon_1.png" alt="" onclick="gotoHome()" style ="margin-top: 5px;">
                </div>

                <form class="navbar-form navbar-left" style="margin-left : 565px;">
                    <div class="form-group">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#">HOME</a></li>
                            <li><a href="#">APPOINTMENT</a></li>
                        </ul>
                    </div>
                </form>



                <form class="navbar-form navbar-right">
                    <div style = "row">
                        <div class="col-md-7">
                            <%
                                if (session != null && ((Login)session.getAttribute("user")) != null) {

                                    String name = (String)((Login) session.getAttribute("user")).getUserFirstName();
                                    String userType = (String)((Login) session.getAttribute("user")).getUserType();
                                    out.print("Hello, " + name);
                                    out.print("<br>user type: " + userType);
                            %>

                        </div>
                        <div class = "col-md-5">
                            <div id = "LogoutButton">
                                <a href="LogoutServlet">
                                    <botton id="logoutbtn" class="btn btn-default" type="button" onClick="callShowDorm()" style="margin-top : 5px;">LOGOUT</botton>
                                </a>
                            </div>    
                            <%
                            } else {%>
                            <button id="loginbtn" type="button" class="btn btn-default" onclick="" style="margin-top : 5px;"><a href="LoginServlet" style="text-decoration: none;color : black;">LOGIN</a></button>
                            <%}%>
                        </div>
                    </div>
                </form>
            </div>
        </nav>



        <div id = 'image'>
            <img src="img/logo.png" onclick="gotoHome()">
        </div>
        <h1>Finding Dorm</h1>
        <hr>
        
        
        <div class="container">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#home">ค้นหาด้วยชื่อ</a></li>
                <li><a data-toggle="tab" href="#menu1">ค้นหาด้วยราคา</a></li>
            </ul>
            <div class="tab-content">
                <div id="home" class="tab-pane fade in active">
                    <div id = "SearchName" style="display: inline"><br><br>
                        <form method="post" action="SearchName" class="form" name="SearchName">
                            Please enter Dormitory name : 
                            <input type="text" name="dormname">
                            <button type="submit" class="btn btn-default">
                                <span class="glyphicon glyphicon-search"></span>
                                <input type="submit" hidden>
                            </button>
                        </form>
                    </div>
                </div><br>
                <div id="menu1" class="tab-pane fade">
                    <div id="SearchPrice">
                        <form method="post" action="SerchPrice" name="searchForm">


                            Min Price 
                            <select id ="Max" name="Price1" class="btn btn-default dropdown-toggle">
                                <option value="500">500 บาท</option>
                                <option value="2000">2000 บาท</option>
                                <option value="4000">4000 บาท</option>
                            </select> 
                            Max Price 
                            <select id ="Max" name ="Price2" class="btn btn-default dropdown-toggle">
                                <option value="2000">2000 บาท</option>
                                <option value="4000">4000 บาท</option>
                                <option value="6000">6000 บาท</option>
                                <option value="6001">มากกว่า 6000 บาท</option>
                            </select> 
                            <button type="submit" class="btn btn-default">
                                <span class="glyphicon glyphicon-search"></span>
                                <input type="submit" hidden>
                            </button>
                        </form><br>
                    </div>

                    
                </div>


            </div>

        </div>
        <hr>
        
        
        
        
        <% String uri = request.getRequestURI(); 
           uri = (uri.substring(8,uri.length()))+"?"+request.getQueryString();
           //out.print("URI ="+uri);
           if(uri.equalsIgnoreCase("/ShowDorm.jsp?null")||uri.equalsIgnoreCase("/LogoutServlet?null")||uri.equalsIgnoreCase("/?null")||uri.equalsIgnoreCase("/ListDormfromName.jsp?dormId=null")){
               List<Dormitory> d = Dormitory.sortByPoppoint();
               if(d != null){   
        %> 
        <table  class="table" style = "margin-left: 200px;">
            <tr>
                <td style="display:none"> Dormitory ID</td>
                <td></td>
                <td> Dormitory Name </td>
                <td> Dormitory Address</td>
                <td> Rating Popular</td>
            </tr>
            <%
                for (Dormitory dorm : d) {
                    String link = "DormitoryDetailServlet?dormId=" + dorm.getDormId();
            %>
            <form action="DormitoryDetailServlet" id="dormForm<%=dorm.getDormId()%>">
                <tr><td style="display:none"> <%=dorm.getDormId()%></td>
                    <td><img src="images/<%=dorm.getDormName()%>.jpg" width = "220" height="140"></td>
                    <td> <a href="<%=link%>" onclick="sendDormId(<%=dorm.getDormId()%>)"><%=dorm.getDormName()%></a> </td>
                    <td><%=dorm.getDormAddress()%></td>
                    <td><%=dorm.getPopPoint()%></td></tr>
                <input type="hidden" value="<%=dorm.getDormId()%>" name="dormId">
            </form>
                <%}%>
            <%}else{%>
                
            <%}%>
        </table>
        <footer style = "background-color: #f8f8f8;">
            <hr>

            <div class="container-fluid">
                <div class="row text-right">
                    <div class="col-sm-12">
                        <h5>©COPYRIGHT 2017</h5>
                        <h5>
                            POWERED BY INT105-G2-PROJ12
                        </h5>
                        <br>
                    </div>

                </div>
            </div>
        </footer>
        <%}%>

    </body>
</html>

