<%--
  Created by IntelliJ IDEA.
  User: liaozuyao
  Date: 2018/2/18
  Time: 22:53
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
    <title>主页</title>
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
    <legend>&nbsp;&nbsp;主页</legend>
</fieldset>
<br>
<br>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="updateAcc" class="layui-btn">修改账号基础信息</button>
        <button id="updatepasswd" class="layui-btn">修改账号密码</button>
    </div>
</div>
<br>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="addquestion" class="layui-btn">新建问题提交</button>
        <button id="allquestions" class="layui-btn">提交问题查询</button>
    </div>
</div>
<br>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="updateCompanyInfo" class="layui-btn">完善公司信息资料</button>
    </div>
</div>
</body>
<script src="<%=basePath%>static/js/clientMain.js"></script>
</html>
