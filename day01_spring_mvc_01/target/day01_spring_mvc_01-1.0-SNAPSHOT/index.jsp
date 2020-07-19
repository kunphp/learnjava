<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script>
        $("#btn").click(function () {
            $.ajax({
                url:"ajax",
                type:"post",
                dataType:"json",
                data:{name:"ming",age:"15"},
                success:function (data) {
                    console.log(data);
                    alert(data.address);
                }
            })
        });
    </script>
</head>
<body>
<h2>首页</h2>
<a href="hello">欢迎页</a>
<a href="params">参数页</a>
<a href="forwardorredirect">重定向页</a>
<form action="file1" enctype="multipart/form-data" method="post">
    <input type="file" name="file" />上传文件
    <input type="submit" value="submit" />
</form>
<form action="file2" enctype="multipart/form-data" method="post">
    <input type="file" name="file" />上传文件
    <input type="submit" value="submit" />
</form>
<form action="file3" enctype="multipart/form-data" method="post">
    <input type="file" name="file" />上传文件
    <input type="submit" value="submit" />
</form>
<button id="btn">ajax</button>
</body>
</html>
