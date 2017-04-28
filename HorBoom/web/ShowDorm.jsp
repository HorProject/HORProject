<%-- 
    Document   : ShowRate
    Created on : Mar 18, 2017, 2:17:27 PM
    Author     : BoomGDH559
--%>

<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finding Dormitory</title>
        <link rel="shortcut icon" type="image/x-icon" href="logo.png" >
        <link rel="stylesheet" href="Hor.css">
        <script>
            function showhide(id) {
                var showhide = document.getElementById(id);
                if (showhide.style.display == 'none')
                    showhide.style.display = 'block';
                else
                    showhide.style.display = 'none';
            }
            function callShow(){
                window.location = "/ShowDorm.jsp";
            }
            function navswitch(){
                var selected_option_value = oForm.elements["country"].options[selected_index].value;
            }
            
            
        </script>
    </head>

    <!--
    <script type="text/javascript">
function show() {
    
  
    document.getElementById('Search').style.display = 'inline';
}
</script>
    -->
    <body onload="<%
         
          %>">
        <%
            if (session != null && session.getAttribute("firstname") != null ) {
                String name = (String) session.getAttribute("firstname");
                String userType = (String) session.getAttribute("userType");
                out.print("Hello, " + name + " Welcome to Profile");
                out.print("<br>user type: " + userType);
        %>

        <div id="Loginstatus">
            ${name}<br>
            ${position}
        </div>
        <div id = "LogoutButton">
            <a href="LogoutServlet">
                <input type="button" onClick="callShowDorm()" value="ออกจากระบบ">
            </a>
        </div>    
        
        <%
         }else{%>
         <a href="LoginServlet">เข้าสู่ระบบ</a>
         <%}%>       
         
        
        <div id = 'image'>
            <img src="logo.png">
        </div>
        <h1>Finding Dorm</h1>
        <hr>
        <div class ="Nav" >
            <ul>
                <li><a href="#SearchName" onclick = "showhide('SearchName')">ค้นหาด้วยชื่อ</a></li>
                <li><a href="#SearchPrice"onclick = "showhide('SearchPrice')"> ค้นหาด้วยราคา</a></li>
            </ul>
        </div>
        <div id = "SearchName" style="display: inline">
            <form method="post" action="SearchName" class="form" name="SearchName">
                Please enter Dormitory name : 
                <p><input type="text" name="dormname" /></p>
                <p><input type="submit" value="Search"/></p>
            </form>
        </div>
        <div id="SearchPrice" style="display: none">
            <form method="post" action="SerchPrice" name="searchForm">
                Min Price 
                <select id ="Max" name="Price1" >
                    <option value="500">500 บาท</option>
                    <option value="2000">2000 บาท</option>
                    <option value="4000">4000 บาท</option>
                </select> 
                Max Price 
                <select id ="Max" name ="Price2">
                    <option value="2000">2000 บาท</option>
                    <option value="4000">4000 บาท</option>
                    <option value="6000">6000 บาท</option>
                    <option value="6001">มากกว่า 6000 บาท</option>
                </select> 
                <br><input type="submit"name ="submit" value="Search">
            </form>
        </div>
        <hr>    
    </body>
</html>

