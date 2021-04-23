<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link href="css/mentorSchedule.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<h1 align="center">Расписание преподавателя</h1>
<%= "Имя: " + request.getAttribute("userName")%>
<form>
<input type="hidden" id="login" name="login" value= "<%= request.getAttribute("login")%>">
<table border="1">
<tr>
    <td>День недели</td>
    <td>Начало</td>
    <td>Продолжительность</td>
</tr>
<tr>
<td>
<select>
<option value="1">Понедельник</option>
<option value="2">Вторник</option>
<option value="3" selected>Среда</option>
<option value="4">Четверг</option>
<option value="5">Пятница</option>
<option value="6">Суббота</option>
<option value="7">Воскресенье</option>
</select>
</td>
<td>
</td>
<td>
</td>
</tr>
<%= request.getAttribute("tableLine")%>
</table>
</form>
</body>
</html>