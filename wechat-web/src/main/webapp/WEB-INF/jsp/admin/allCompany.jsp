<%--
  Created by IntelliJ IDEA.
  User: liaozuyao
  Date: 2018/2/9
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>全部公司</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>static/layui/css/layui.css" media="all">
    <script src="<%=basePath%>static/jquery/jQuery.js"></script>
    <script src="<%=basePath%>static/layui/layui.js"></script>
    <script>
        $.ajax({
            url : '<%=basePath%>allCompany',
            type : 'GET',
            success : function (result) {
                var dom = document.getElementById("tbody");
                var info = "";
                for(var i = 0; i<result.data.length; i++){
                    info += "<tr id=" + result.data[i].id + "><td>" + result.data[i].name + "</td><td>" +
                        "<a class='detail' id=" + result.data[i].id + " style='margin-left:-25px; color:blue' href='#'>查看</a>&nbsp;&nbsp;" +
                        "<a class='delete' id=" + result.data[i].id + " style='margin-left: 20px; color:red' href='#'>删除</a></td></tr>";
                }
                dom.innerHTML = null;
                dom.innerHTML = info;
            }
        })
    </script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px;">
    <legend><i id="back-icon" style="margin-left: -15px" class="layui-icon">&#xe65c;</i>&nbsp;&nbsp;所有公司</legend>
</fieldset>
<table class="layui-table" lay-even lay-skin="nob">
    <thead>
    <tr>
        <th>公司名字</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody id="tbody">
    </tbody>
</table>
</body>
</html>
