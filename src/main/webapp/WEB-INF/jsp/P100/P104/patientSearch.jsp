<%@ page import="P100.P104.model.PatientExpiration" %>
<%@ page import="java.util.List" %>
<%@ page import="P100.P104.model.PatientExpiration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>保険証期限確認結果</title>
</head>
<body>
<h1>保険証期限確認結果</h1>
<h3>現在<br>${date}</h3>
<h2>有効期限が切れた患者</h2>
<% List<PatientExpiration> expiredPatients = (List<PatientExpiration>) request.getAttribute("expiredPatients"); %>
<% if (expiredPatients != null && !expiredPatients.isEmpty()) { %>
<table>
    <tr>
        <th>患者ID</th>
        <th>姓</th>
        <th>名</th>
        <th>保険証記号番号</th>
        <th>有効期限</th>
    </tr>
    <% for (PatientExpiration patient : expiredPatients) { %>
    <tr>
        <td><%= patient.getPatid() %>
        </td>
        <td><%= patient.getPatfname() %>
        </td>
        <td><%= patient.getPatlname() %>
        </td>
        <td><%= patient.getHokenmei() %>
        </td>
        <td><%= patient.getHokenexp() %>
        </td>
    </tr>
    <% } %>
</table>
<% } else { %>
<p>保険証期限が過ぎた患者は見つかりませんでした。</p>
<% } %>
</body>
</html>
