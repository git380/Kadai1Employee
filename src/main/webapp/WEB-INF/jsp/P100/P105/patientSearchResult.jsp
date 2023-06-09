<%@ page import="P100.P105.model.PatientSearch" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>検索結果</title>
</head>
<body>
<h1>検索結果</h1>
<% List<PatientSearch> patients = (List<PatientSearch>) request.getAttribute("patients"); %>
<% if (patients != null && !patients.isEmpty()) { %>
<table>
    <tr>
        <th>患者ID</th>
        <th>姓</th>
        <th>名</th>
        <th>保険名</th>
        <th>保険有効期限</th>
        <th>指示</th>
    </tr>
    <% for (PatientSearch patient : patients) { %>
    <% String aaa = patient.getPatid(); %>
    <tr>
        <td><%= aaa %></td>
        <td><%= patient.getPatfname() %></td>
        <td><%= patient.getPatlname() %></td>
        <td><%= patient.getHokenmei() %></td>
        <td><%= patient.getHokenexp() %></td>
        <td>
            <form action="/Kadai1Employee/TreatmentSelectionServlet" method="get">
                <input type="hidden" name="patId" value="${aaa}">
                <input type="submit" value="指示">
            </form>
        </td>
    </tr>
    <% } %>
</table>
<% } else { %>
<p>該当する患者は見つかりませんでした。</p>
<% } %>
</body>
</html>