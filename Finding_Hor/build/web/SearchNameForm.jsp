<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="SearchName" method="post" class="form">
    Please enter Dormitory name : 
    <input type="text" name="dormname" 
           value="<%= (request.getParameter("dormname") == null ? "" : request.getParameter("dormname"))%>" />
    <input type="submit" value="Search" />
</form>
<hr>
<br>
