<%--
  Created by IntelliJ IDEA.
  User: Hardy
  Date: 2022-03-17
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<font color="red">${message}</font>
<form action="login" method="post">
    用户名:<input type="text" name="username" value=""><br/>
    密码：<input type="text" name="password" value=""><br/>

    <input type="submit" value="登录">
</form>
</body>
</html>
