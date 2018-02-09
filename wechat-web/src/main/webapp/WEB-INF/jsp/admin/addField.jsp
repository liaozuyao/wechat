<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>添加领域</title>
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
    <legend><i class="layui-icon">&#xe65c;</i>&nbsp;&nbsp;添加问题领域</legend>
</fieldset>
<div class="layui-form-item">
    <label class="layui-form-label">问题领域</label>
    <div class="layui-input-block">
        <input type="text" id="name" name="name" required lay-verify="required" placeholder="请输入问题领域" autocomplete="off"
               class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="commitCompany" class="layui-btn">立即提交</button>
        <button id="back" class="layui-btn layui-btn-primary">返回</button>
    </div>
</div>
</body>
</html>
