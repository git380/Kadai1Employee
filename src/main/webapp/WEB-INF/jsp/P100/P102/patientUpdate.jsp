<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>患者保険情報変更</title>
</head>
<body>
<h1>患者保険情報変更</h1>
<form action="PatientUpdateServlet" method="post">
    <input type="hidden" name="patId" value="${patId}">
    <input type="hidden" name="patFname" value="${patFname}">
    <input type="hidden" name="patLname" value="${patLname}">
    <input type="hidden" name="olhrzdhdhokenexp" value="${hokenexp}">

    患者ID: ${patId}<br>
    姓: ${patFname}<br>
    名: ${patLname}<br>

    <label for="hokenmei">保険証記号番号:</label>
    <input type="hidden" id="hihokenmei" name="hokenmei" value="${hokenmei}">
    <input type="text" id="hokenmei" name="hokenmei" value="${hokenmei}">
    <input type="checkbox" id="meicheckbox" name="checkbox"
           onchange="
           document.getElementById('hihokenmei').disabled = this.checked;
           document.getElementById('hokenmei').disabled = !this.checked;
         ">変更する<br>

    <label for="hokenexp">有効期限:</label>
    <input type="date" id="hokenexp" name="hokenexp" value="${hokenexp}"><br>

    <input type="submit" value="変更">
</form>
<script>
    document.getElementById('hokenmei').disabled = true;
</script>
</body>
</html>