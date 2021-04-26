<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link href="css/error.css" rel="stylesheet">
</head>
<body>
    <div class="error"  align="center">
    <div class="logo">
         <img src="https:/progwards.ru/wp-content/uploads/2020/09/f.png">
    </div>
    <form method = "post" action = "<%= request.getAttribute("endpoint")%>" class="form">
        <input type="hidden" id="login" name="login" value= "<%= request.getAttribute("login")%>">
        <input type="text" disabled id="message" name="message" value= "<%= request.getAttribute("messageText")%>">
        <br>
        <br>
        <div align="center">
        <input type="submit" value="ok" id="button">
        </div>
    </form>
    </div>

</body>
</html>