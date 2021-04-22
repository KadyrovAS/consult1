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
    <form method = "post" action = "/index.jsp" class="form">
        <input type="text" disabled id="message" name="message" value= "<%= request.getAttribute("messageText")%>">
        <br>
        <br>
        <input type="submit" value="ok">
    </form>
    </div>

</body>
</html>