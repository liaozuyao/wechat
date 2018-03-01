<%--
  Created by IntelliJ IDEA.
  User: liaozuyao
  Date: 2018/2/9
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>添加实施顾问或开发</title>
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
    <legend><i id="back-icon" style="margin-left: -15px" class="layui-icon">&#xe65c;</i>&nbsp;&nbsp;添加实施顾问或开发顾问</legend>
</fieldset>
<div class="layui-form-item">
    <label class="layui-form-label">名字</label>
    <div class="layui-input-block">
        <input style="margin-left: -5px" type="text" id="name" name="name" required lay-verify="required" placeholder="请输入名字(必填)" autocomplete="off"
               class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">联系电话</label>
    <div class="layui-input-block">
        <input style="margin-left: -5px" type="text" id="phone" maxlength="11" name="phone" required lay-verify="required" placeholder="请输入联系电话(必填)" autocomplete="off"
               class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">邮箱</label>
    <div class="layui-input-block">
        <input style="margin-left: -5px" type="email" id="email" name="email" required lay-verify="required" placeholder="请输入邮箱(必填)" autocomplete="off"
               class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">实施/开发</label>
    <div class="layui-input-block">
        <select style="margin-left: -5px" id="type" name="type" lay-verify="required" class="layui-input">
            <option lay-verify="required" value="9">请选择(必填)</option>
            <option lay-verify="required" value="7">实施</option>
            <option lay-verify="required" value="8">开发</option>
        </select>
    </div>
</div>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="commitAdvDev" class="layui-btn">立即提交</button>
        <button id="reset" class="layui-btn layui-btn-primary">清空</button>
    </div>
</div>
</body>
<script src="<%=basePath%>static/js/addAdviser.js"></script>
</html>
