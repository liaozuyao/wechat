<%--
  Created by IntelliJ IDEA.
  User: liaozuyao
  Date: 2017/11/11
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>上传文件</h2>
    <form action="upload" enctype="multipart/form-data" method="post">
        <table>
            <tr>
                <td>文件描述：</td>
                <td><input type="text" name="description"></td>
            </tr>
            <tr>
                <td>请选择文件：</td>
                <td><input type="file" name="file"></td>
            </tr>
            <tr>
                <td><input type="submit" value="上传"></td>
            </tr>
        </table>
    </form>
</body>
</html>
