<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>管理员相关操作</title>
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
    <legend><i class="layui-icon">&#xe65c;</i>&nbsp;&nbsp;管理员相关操作</legend>
</fieldset>
<br>
<br>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="addcompany" class="layui-btn">添加公司</button>
        <button id="allcompany" class="layui-btn">所有公司</button>
    </div>
</div>
<br>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="addmodel" class="layui-btn">添加模块</button>
        <button id="allmodel" class="layui-btn">所有模块</button>
    </div>
</div>
<br>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="addfield" class="layui-btn">添加领域</button>
        <button id="allfield" class="layui-btn">所有领域</button>
    </div>
</div>
<br>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="addaccount" class="layui-btn">添加账号</button>
    </div>
</div>
<br>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="addadviser" class="layui-btn">添加实施顾问或开发</button>
    </div>
</div>
</body>
<script type="text/javascript">
      $("#addcompany").click(function () {
          window.location="<%=basePath%>insertCompany.html";
      })
      $("#allcompany").click(function () {
          window.location="<%=basePath%>allCompany.html";
      })
      $("#addaccount").click(function () {
          window.location="<%=basePath%>insertAccount.html";
      })
      $("#addmodel").click(function () {
          window.location="<%=basePath%>addServiceModel.html";
      })
      $("#allmodel").click(function () {
          window.location="<%=basePath%>allServiceModel.html"
      })
      $("#addadviser").click(function () {
          window.location="<%=basePath%>insertAdviserOrDev.html";
      })
      $("#addfield").click(function () {
          window.location="<%=basePath%>addField.html"
      })
      $("#allfield").click(function () {
          window.location="<%=basePath%>allField.html";
      })
</script>
</html>
