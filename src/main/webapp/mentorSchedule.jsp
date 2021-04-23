<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link href="css/mentorSchedule.css" rel="stylesheet" id="bootstrap-css">

</head>
<body>
<h1 align="center">Расписание преподавателя</h1>
<div align="center" class="frm">
<%= "Имя: " + request.getAttribute("userName")%>
<form>
<input type="hidden" id="login" name="login" value= "<%= request.getAttribute("login")%>">
<table border="1">
<tr>
    <td>День недели</td>
    <td>Начало</td>
    <td>Продолжительность</td>
</tr>
<%= request.getAttribute("comandLine")%>
</table>
</form>
</div>
</body>
</html>