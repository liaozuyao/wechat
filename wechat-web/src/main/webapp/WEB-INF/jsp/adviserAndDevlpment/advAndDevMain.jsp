<%--
  Created by IntelliJ IDEA.
  User: liaozuyao
  Date: 2018/2/14
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>实施开发相关操作</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>static/layui/css/layui.css" media="all">
    <script src="<%=basePath%>static/jquery/jQuery.js"></script>
    <script src="<%=basePath%>static/layui/layui.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px;">
    <legend>&nbsp;&nbsp;实施开发相关操作</legend>
</fieldset>
<br>
<br>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="addcompany" class="layui-btn">功能一</button>
        <button id="allcompany" class="layui-btn">功能二</button>
    </div>
</div>
<br>
<%--<div class="layui-form-item">--%>
    <%--<div class="layui-input-block">--%>
        <%--<button id="addmodel" class="layui-btn">添加模块</button>--%>
        <%--<button id="allmodel" class="layui-btn">所有模块</button>--%>
    <%--</div>--%>
<%--</div>--%>
<br>
</body>
</html>
