<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link href="css/newUser.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
    <div class="newUser">
    <form method = "post" action = "/sel">
        <label>Карточка пользователя</label><br>
        <label>Логин:</label>
        <label for="userName">Ваше имя</label>
        <input type="text" id="userName"><br>
        <label for="mentorType">Вы преподаватель</label> 
        <input type="checkbox" id="mentorType" name="mentorType"><br>
        <label for="userName">Ваш email</label>
        <input type="text" id="email" name="email"><br>
        <input type="submit"  value="Ok">
    </form>
    </div>
    <div class="logo">
        <img src="https:/progwards.ru/wp-content/uploads/2020/09/f.png">
    </div>
</body>
</html>