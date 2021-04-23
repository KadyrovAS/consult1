<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link href="css/user.css" rel="stylesheet" id="bootstrap-css">
<style>
    .frm {
    border: 4px double blue;
    width: 20%;
    padding: 10px;
    }

    .radiobutton {
    padding: 5px;
    }
    .user {
    padding: 5px;
    }
    .buttons {
    padding: 10px;
    }
</style>
</head>
<body>

    <h1 align="center">Карточка пользователя</h1>
    <div align="center">
    <form method = "post" action = "plan" class="frm" >
        <%= "Логин: " + request.getAttribute("login")%>
        <input type="hidden" id="login" name="login" value= "<%= request.getAttribute("login")%>">
        <br>
        <div align="left" class="user">
        <label for="userName">Имя:</label>
        <input type="text" id="userName" name="userName" value= "<%= request.getAttribute("userName")%>">
        </div>
        <br>
        <div class="radiobutton" align="left">
        <input type="radio" id="isMentor" name="isMentor" value="mentor" class="field"
        <%= request.getAttribute("isMentor") == "mentor" ? "checked" : ""%>>
        <label> Преподаватель</label>
        <br>
        <input type="radio" id="isMentor" name="isMentor" value="student" class="field"
        <%= request.getAttribute("isMentor") == "student" ? "checked" : ""%>>
        <label> Студент</label>
        <div>
        <br>
        <label for="email">Ваш email</label>
        <input type="text" id="email" name="email" value=<%= request.getAttribute("email")%>>
        <br>
        <div align="center" class="buttons">
        <input type="submit" name="button" value="Сохранить">
        <input type="submit" name="button" value="Консультации">
        <div>
    </form>
    </div>
</body>
</html>