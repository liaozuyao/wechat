<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>全部领域</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>static/layui/css/layui.css" media="all">
    <script src="<%=basePath%>static/jquery/jQuery.js"></script>
    <script src="<%=basePath%>static/layui/layui.js"></script>
    <script src="<%=basePath%>static/js/allField.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px;">
    <legend><i id="back-icon" style="margin-left: -15px" class="layui-icon">&#xe65c;</i>&nbsp;&nbsp;全部领域</legend>
</fieldset>
<table class="layui-table" lay-even lay-skin="nob">
    <thead>
    <tr>
        <th>领域</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody id="tbody">
    </tbody>
</table>
<script type="text/javascript">
$(".update").click(function () {
    console.log("asdasdsad");
    console.log($("#update").attr());
})
$("#back-icon").click(function () {
    window.history.go(-1);
})
</script>
</body>
</html>
