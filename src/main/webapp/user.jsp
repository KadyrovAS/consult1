<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link href="css/user.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
    <div class="newUser"  align="center">
    <div class="logo">
         <img src="https:/progwards.ru/wp-content/uploads/2020/09/f.png">
    </div>
    <h1>Карточка нового пользователя</h1><br>
    <label for="login">Login:</label>
    <%= request.getAttribute("login")%>
    <form method = "post" action = "/sel" class="form">
        <label for="userName">Ваше имя</label>
        <input type="text" id="userName"><br>
        <label for="mentorType">Вы преподаватель</label> 
        <input type="checkbox" id="mentorType" name="mentorType"><br>
        <label for="userName">Ваш email</label>
        <input type="text" id="email" name="email"><br>
        <input type="submit"  value="Сохранить">
    </form>
    </div>

</body>
</html>