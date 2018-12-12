<%--
  Created by IntelliJ IDEA.
  User: crowndint
  Date: 2018/8/25
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    ${loginMsg} <br/>

 <form action="/user/login" method="post"">
    姓名: <input type="text" name="username" /><br/>
    密码: <input type="password" name="password" /><br/>
    <input type="submit" value="登录" />
 </form>


</body>
</html>
