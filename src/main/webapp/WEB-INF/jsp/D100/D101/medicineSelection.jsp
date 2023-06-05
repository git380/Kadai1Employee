<%@ page import="D100.D101.model.Medicine" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Medicine Selection</title>
</head>
<body>
<h1>Medicine Selection</h1>
<form action="MedicineConfirmationServlet" method="post">
  <table>
    <tr>
      <th>Medicine</th>
      <th>Quantity</th>
    </tr>
    <% List<Medicine> medicines = (List<Medicine>) request.getAttribute("medicines");
      for (Medicine medicine : medicines) { %>
    <tr>
      <td><%= medicine.getMedicineName() %></td>
      <td>
        <input type="number" name="<%= medicine.getMedicineId() %>_quantity" min="0" max="9999" required>
        <%= medicine.getUnit() %>
      </td>
    </tr>
    <% } %>
  </table>
  <br>
  <input type="submit" value="Confirm">
</form>
</body>
</html>
