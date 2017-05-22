<%@page import="Model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javax.servlet.http.HttpUtils.*" %> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Libre+Franklin:100,300,400" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Rubik:300,400,500" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <title>Finding Dormitory</title>
        <link rel="stylesheet" href=CSS/"Hor.css">
        <link rel="stylesheet" href="CSS/StarRate.css">
        <link rel="stylesheet" href="CSS/popupcss.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="scripts/jquery-3.2.1.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="ShowDorm.jsp"/>
        <%
            Dormitory d = (Dormitory)request.getAttribute("dormitory");
            //Customer c = Customer.findById(3) ;
            if (d != null) {
                if (session != null && (request.getParameter("dormId") != null)) {
        %>
        <div class="detail" style = "border-style: solid; border-width: 1px; width: 1440px; margin-left: 50px; margin-top: 20px; min-height: 587px;color: #8e8d7b;">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12" style ="padding : 20px;">

                        <div class="col-md-5">
                            <img src="images/<%=d.getDormName()%>.jpg" style =" width: 400px; height : 550px;">
                        </div>

                        <div class="col-md-7">
                            <ul>
                                <li><%=d.getDormName()%></li>
                                <li><%=d.getDormAddress()%></li>
                                <li><%=d.getCountRoom()%></li>
                                <li>สิ่งอำนวยความสะดวก</li>
                                <li style="list-style-type : none;"><span class="glyphicon glyphicon-ok"> เครื่องปรับอากาศ</li>
                                <li style="list-style-type : none;"><span class="glyphicon glyphicon-ok"> เครื่องทำนํ้าอุ่น</li>
                                <li style="list-style-type : none;"><span class="glyphicon glyphicon-ok"> เฟอร์นิเจอร์</li>
                                <li style="list-style-type : none;"><span class="glyphicon glyphicon-remove"> Wifi</li>
                            </ul>

                            <%if (((String) ((Login) session.getAttribute("user")).getUserFirstName() != null)) {%>
                            <fieldset style="margin-top: 20px">
                                <legend><h3>นัดหมายหอพัก</h3></legend>
                                <c:if test="${paired == true}">
                                    <c:if test="${checkBook != true}">
                                        <h2  style="border-style: solid;border-width: 1px; padding: 5px;">${showBook}</h2>
                                        <p>Status : <span class="label label-warning">Warning</span></p>
                                        <h2>${message}</h2>  
                                        <form id="meeting" action="editMeeting?dormId=<%=d.getDormId()%>" method="POST">
                                            <h2>${uri}</h2>
                                            <button  id="updatebook" onclick="createDate(2)" class="btn btn-default">แก้ไขหมายการจอง : </button><br>
                                        </form>

                                        <form id="meeting" action="delMeeting?dormId=<%=d.getDormId()%>" method="POST">
                                            <h2>${uri}</h2>
                                            <button  id="deletebook" onclick="createDate(3)" value="" class="btn btn-default">ลบการจอง : </button>

                                        </form>
                                        <br>

                                    </c:if>
                                </c:if>
                                <c:if test="${paired != true}">
                                    <c:if test="${checkBook == true}">
                                        <h2  style="border-style: solid;border-width: 1px; padding: 5px;">${showBook}</h2>
                                        <form id="meeting" action="insertMeeting?dormId=<%=d.getDormId()%>" method="POST">
                                            <h2>${uri}</h2>
                                            <button  id="booking" onclick="createDate(1)" class="btn btn-default">นัดหมายการจองกับหอพัก</button>
                                        </form>
                                        <br>

                                    </c:if>
                                </c:if>
                            </fieldset>        
                                <%}%>

                                <fieldset style="margin-top: 20px">
                                <legend><h3>ให้คะแนนหอพัก</h3></legend>
                                <button id="myBtn" class="btn btn-default" data-toggle="modal" data-target=".bs-example-modal-lg">ให้คะแนนหอ</button>
                                <%if (((String) ((Login) session.getAttribute("user")).getUserFirstName() != null) && (request.getParameter("dormId") != null)) {%>
                                <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                                    <div class="modal-dialog modal-lg" role="document">
                                        <div class="modal-content">
                                            <div class="container-fluid">
                                                <span class="close">&times;</span>
                                                <h1 id="ratetopic">Rating Dormitory</h1>
                                                <h2 id="ratehead1"><%=d.getDormName()%></h2>
                                                <hr id="line" size="4">
                                                <form id="sendStar" action="RatingServlet?dormId=<%=d.getDormId()%>" method="post">
                                                    <input type="hidden" name="uri" value="<%=request.getRequestURI()%>">
                                                    <div class="rate" style="margin-left : 250px;">
                                                        <input type="radio" onclick="sendStar()" id="star5" name="rate" value="5" />
                                                        <label for="star5" title="ยอดเยี่ยม">5 stars</label>
                                                        <input type="radio" onclick="sendStar()" id="star4" name="rate" value="4"/>
                                                        <label for="star4" title="ดีมาก">4 stars</label>
                                                        <input type="radio" onclick="sendStar()"  id="star3" name="rate" value="3"/>
                                                        <label for="star3" title="ดี">3 stars</label>
                                                        <input type="radio" onclick="sendStar()"  id="star2" name="rate" value="2"/>
                                                        <label for="star2" title="พอใจ">2 stars</label>
                                                        <input type="radio" onclick="sendStar()"  id="star1" name="rate"/>
                                                        <label for="star1" title="ควรปรับปรุง">1 star</label>
                                                    </div>

                                                </form> 
                                
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <h2>${statustext}</h2>                    
                                <%} else {%> 
                                <div id="myModal" class="modal">
                                    <div class="modal-content" style="height: 72%;">
                                        <span class="close">&times;</span>
                                        <h2 id="ratehead1" style="font-size: 32pt;word-spacing: 50px">คุณยังไม่ได้เข้าสู่ระบบ</h2>
                                        <h3 style="text-align: center;margin-top: -40px;">กรุณา Login เข้าสู่ระบบเพื่อให้คะแนนหอพัก</h3>
                                        <hr id="line" size="2">
                                        <button type="button"><a href="LoginServlet?dormId=<%=d.getDormId()%>" style="text-decoration: none">Login</a></button>
                                        <%%>
                                    </div>
                                </div>
                                <h2 id="ratehead1" class="status" on >${statustext}</h2>    
                                <%}%>  

                                <h1 style ="text-align: left;color: #c0b283;letter-spacing: 9px;">หอนี้ได้คะแนน <%=d.getPopPoint()%> / 5 </h1>
                                <p style="color:#373737;letter-spacing: 7px;">จากคนทั้งหมด <%=Dormitory.numCount(d.getDormId())%> คน</p>
                        </div>
                        </fieldset>

                    </div>
                </div>
            </div>
        </div>


        <%}%>

        <%}%>

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

        <script src="scripts/popup&booking.js"></script>
    </body>
</html>
