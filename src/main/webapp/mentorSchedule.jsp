<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link href="css/mentorSchedule.css" rel="stylesheet" id="bootstrap-css">

</head>
<body>
<h1 align="center">Расписание преподавателя</h1>
<div align="center" class="frm">
<%= "Имя: " + request.getAttribute("userName")%>

<form method="post" action="mentorScheduleSave">
<input type="hidden" id="login" name="login" value= "<%= request.getAttribute("login")%>">
<br>
<table border="1">
<tr>
    <td>День недели</td>
    <td>Начало (чч:мм)</td>
    <td>Продолжительность (мин)</td>
</tr>
<%= request.getAttribute("tableLine")%>
</table>
<br>
<input type="submit" name = "button" value ="Сохранить">
</form>
</div>
</body>
</html>