<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link href="css/user.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<h1 align="center">Запись на консультацию</h1>
<br>
<div align="center" width=30%>
<%= "Имя студента: " + request.getAttribute("userName")%>
<br>
<form method="post" action="planForStudent">
<input type="hidden" id="login" name="login" value= "<%= request.getAttribute("login")%>">
<label for="mentor">Выберите преподавателя: </label>
<select name="mentor">
    <%=  request.getAttribute("mentorNames")%>
</select>
<br>
<input type="submit" name="button" value="Выбрать">
</form>
</div>
</body>
</html>