<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Form</title>
        
    </head>
    <body>
        <h1>REGISTRATION FORM</h1>
        <hr>
        <div>
            <form action="RegisterServlet" method="POST">
                <p> <p>ชื่อ :<input type="text" name="firstname" required> <br>
                <p> <p>สกุล :<input type="text" name="lastname" required> <br>
                <p> <p>เพศ :     
                    <input type="radio" name="gender" value="M">ชาย   
                    <input type="radio" name="gender" value="F">หญิง<br>
                <p> <p>รหัสผ่าน : <input type="password" name="password" required><br>
                <p> <p>รหัสผ่านอีกครั้ง : <input type="password" name="repassword" required><br>
                <p> <p>Email : <input type="email" name="email" required><br>
                <p> <p>โทร : <input type="text" pattern=[0-9]{10} name="tel" required><br>
                <p> <p>ที่อยู่ : <textarea  placeholder="test" cols="50" name="address" > </textarea>
                <p><p>ลงทะเบียนในฐานะ : 
                    <input type="radio" name="type" value="admin">Admin   
                    <input type="radio" name="type" value="member">Member
                    <br>
                    <input type="submit" value="Register" > 
            </form>
        </div>
        <h2>${errtext}</h2>>
    </body>
</html>
