<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link href="css/index.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>

<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Ties -->

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="https://progwards.ru/wp-content/uploads/2020/09/f.png" id="icon" alt="User Icon" />
    </div>

    <!-- Login Form -->
    <form method="post" action="sel">
      <input type="text" id="login" class="fadeIn second" name="login" placeholder="login">
      <input type="password" id="password" class="fadeIn third" name="password" placeholder="password">
      <div>
      <input type="submit" class="fadeIn fourth" value="Log In" name="button" id="loginButton">
      <input type="submit" class="fadeIn fifth" value="Cancel" name="button" id="cancelButton">
      </div>
    </form>
  </div>
</div>
</body>
</html>
