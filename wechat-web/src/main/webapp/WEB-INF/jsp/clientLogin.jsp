<%--
  Created by IntelliJ IDEA.
  User: liaozuyao
  Date: 2018/2/15
  Time: 23:41
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
    <title>客户登录</title>
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
    <legend>&nbsp;&nbsp;客户服务登录</legend>
</fieldset>
</br>
</br>
</br>
</br>
</br>
</br>
<div class="layui-form-item">
    <label class="layui-form-label">账号</label>
    <div class="layui-input-block">
        <input type="text" id="name" name="name" required lay-verify="required" placeholder="请输入账号(必填)" autocomplete="off"
               class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">密码</label>
    <div class="layui-input-block">
        <input type="password" id="password" name="password" required lay-verify="required" placeholder="请输入密码(必填)" autocomplete="off"
               class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="customerLogin" class="layui-btn">立即提交</button>
        <button id="reset" class="layui-btn layui-btn-primary">清空</button>
    </div>
</div>
</body>
<script src=<%=basePath%>static/js/clientLogin.js></script>
</html>
