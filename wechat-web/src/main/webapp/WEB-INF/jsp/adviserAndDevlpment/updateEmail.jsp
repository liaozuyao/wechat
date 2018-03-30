<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>修改邮箱</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>static/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>static/css/ui.css">
    <script src="<%=basePath%>static/jquery/jQuery.js"></script>
    <script src="<%=basePath%>static/layui/layui.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px;">
    <legend><i id="back-icon" style="margin-left: -15px" class="layui-icon">&#xe65c;</i>&nbsp;&nbsp;修改邮箱</legend>
</fieldset>
<br>
<div class="layui-form-item">
    <label style="margin-left: 10px" class="layui-form-label">新邮箱</label>
    <div class="layui-input-block">
        <input style="margin-left: -15px" type="email" id="email" name="email" required lay-verify="required" placeholder="请输入新邮箱(必填)" autocomplete="off"
               class="layui-input">
    </div>
</div>
<br>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="updateEmail" class="layui-btn">立即提交</button>
        <button id="reset" class="layui-btn layui-btn-primary">清空</button>
    </div>
</div>
<script src="<%=basePath%>static/js/updateEmail.js"></script>
</body>
</html>
