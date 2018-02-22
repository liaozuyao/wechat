<%--
  Created by IntelliJ IDEA.
  User: liaozuyao
  Date: 2018/2/19
  Time: 11:41
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
    <title>修改密码</title>
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
    <legend><i id="back-icon" style="margin-left: -15px" class="layui-icon">&#xe65c;</i>&nbsp;&nbsp;修改密码</legend>
</fieldset>
<br>
<div class="layui-form-item">
    <label class="layui-form-label">新密码</label>
    <div class="layui-input-block">
        <input type="password" id="password" name="password" required lay-verify="required" placeholder="请输入新密码(必填)" autocomplete="off"
               class="layui-input">
    </div>
</div>
<br>
<div class="layui-form-item">
    <label class="layui-form-label">再次输入</label>
    <div class="layui-input-block">
        <input type="password" id="confirmpassword" name="curfirmpassword" required lay-verify="required" placeholder="请再次输入密码(必填)" autocomplete="off"
               class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="updatepasswd" class="layui-btn">立即提交</button>
        <button id="reset" class="layui-btn layui-btn-primary">清空</button>
    </div>
</div>
</body>
<script src="<%=basePath%>updateAccPassword.js"></script>
</html>
