/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var modal = document.getElementById('myModal');

var btn = document.getElementById("myBtn");

var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
btn.onclick = function () {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function () {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

function sendStar() {
    document.getElementById("sendStar").submit(); //ไว้ส่งค่าดาว
}

function createDate(num) {
    if (num == 1) {
        document.getElementById("meeting").innerHTML = '<p>กำหนดวันนัดหมายเป็น</p><input type="date" name="date" required><br><br><select id="hour" name="hour"><option selected disabled required> ชั่วโมง </option><option value="08">8</option><option value="09">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option></select> : <select id="min" name="min"><option disabled selected required> นาที </option><option value="00">00</option><option value="15">15</option><option value="30">30</option><option value="45">45</option></select><br><br><input type="submit" name="submit"  class="btn btn-default" value="ยืนยัน" >';
        
    } else if (num == 2) {
        document.getElementById("meeting").innerHTML = '<p>แก้ไขวันจองเป็น</p><input type="date" name="date" required><br><br><select id="hour" name="hour"><option selected disabled required> ชั่วโมง </option><option value="08">8</option><option value="09">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option></select> : <select id="min" name="min"><option disabled selected required> นาที </option><option value="00">00</option><option value="15">15</option><option value="30">30</option><option value="45">45</option></select><br><br><input type="submit" name="submit"  class="btn btn-default" value="ยืนยัน" >';
        
    } else {document.getElementById("meeting").submit();
        alert("ลบอยู่");
        document.getElementById("meeting").submit();
        
    }
}



/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */











