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
    <input type="hidden" name="oldhokenexp" value="${hokenexp}">

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
           const submitButton = document.querySelector('input[type=submit]');
           const checkboxes = document.querySelectorAll('input[type=checkbox]');
           submitButton.disabled = Array.from(checkboxes).every(checkbox => !checkbox.checked);
         ">変更する<br>

    <label for="hokenexp">有効期限:</label>
    <input type="hidden" id="hihokenexp" name="hokenexp" value="${hokenexp}">
    <input type="hidden" id="noChange" name="noChange" value="0">
    <input type="date" id="hokenexp" name="hokenexp" value="${hokenexp}">
    <input type="checkbox" id="expcheckbox" name="checkbox"
           onchange="
           document.getElementById('hihokenexp').disabled = this.checked;
           document.getElementById('noChange').disabled = this.checked;
           document.getElementById('hokenexp').disabled = !this.checked;
           const submitButton = document.querySelector('input[type=submit]');
           const checkboxes = document.querySelectorAll('input[type=checkbox]');
           submitButton.disabled = Array.from(checkboxes).every(checkbox => !checkbox.checked);
         ">変更する<br>

    <input type="submit" value="変更" disabled>
</form>

<script>
    document.getElementById('hokenmei').disabled = true;
    document.getElementById('hokenexp').disabled = true;
    const checkboxes = document.querySelectorAll('input[type=checkbox]');
    const submitButton = document.querySelector('input[type=submit]');
    Array.from(checkboxes).forEach(checkbox => {
        checkbox.addEventListener('change', () => {
            submitButton.disabled = Array.from(checkboxes).every(checkbox => !checkbox.checked);
        });
    });
</script>
</body>
</html>
