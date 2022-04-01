<%--
  Created by IntelliJ IDEA.
  User: Hardy
  Date: 2022-03-17
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="response" method="post">
    用户名:<input type="text" name="name" value=""><br/>
    密码：<input type="text" name="pwd" value=""><br/>
    爱好：<input type="checkbox" name="fav" value="1"> c
            <input type="checkbox" name="fav" value="2"> java
            <input type="checkbox" name="fav" value="3"> php
    <input type="submit" value="登录">
</form>
</body>
</html>
