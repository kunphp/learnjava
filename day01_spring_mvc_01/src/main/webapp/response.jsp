<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/1
  Time: 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="js/jquery.min.js"></script>

    <script>
        // 页面加载，绑定单击事件
        $(function(){
            $("#btn").click(function () {
                var data = {name:"ming",age:"15"};
                $.ajax({
                    url:"ajax",
                    type:"post",
                    contentType: "application/json;charset=UTF-8",
                    data:JSON.stringify(data),
                    success:function (data) {
                        console.log(data);
                        alert(data.address);
                    }
                })
            });
        });

    </script>

</head>
<body>
    <button id="btn">发送ajax的请求</button>
</body>
</html>
