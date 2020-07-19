<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<a href="account/list">查询所有</a>
<form action="account/save" method="post">
    name:<input name="name" type="text"><br>
    money:<input name="money" type="number"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
