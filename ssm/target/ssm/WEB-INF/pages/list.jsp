<%--
  Created by IntelliJ IDEA.
  User: wyk
  Date: 2020/7/18
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>查询到了所有账户</h3>
<c:forEach items="${list}" var="account">
    name:${account.name}<br>
    money:${account.money}
</c:forEach>
</body>
</html>
