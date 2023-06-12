<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>パスワードの変更</title>
</head>
<body>
<h1>パスワードの変更</h1>
<form action="PwChangeServlet" method="post">
  <input type="hidden" name="emprole" value="${emprole}">
  <label>新しいパスワードを入力してください</label><br>
  パスワード:<input type="password" name="empPasswd1" required><br>
  パスワード:<input type="password" name="empPasswd2" required><br>
  <input type="submit" value="変更" disabled>
</form>

<script>
  const inputs = document.querySelectorAll('input[type=password]');
  const submitButton = document.querySelector('input[type=submit]');
  Array.from(inputs).forEach(input => {
    input.addEventListener('change', () => {
      submitButton.disabled = Array.from(inputs).some(input => !input.value) || inputs[0].value !== inputs[1].value;
    });
  });
</script>
</body>
</html>
