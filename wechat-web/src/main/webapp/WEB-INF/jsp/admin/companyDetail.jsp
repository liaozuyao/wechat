<%--
  Created by IntelliJ IDEA.
  User: liaozuyao
  Date: 2018/3/1
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>公司详细信息</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>static/layui/css/layui.css" media="all">
    <script src="<%=basePath%>static/jquery/jQuery.js"></script>
    <script src="<%=basePath%>static/layui/layui.js"></script>
    <script>
        var json = JSON.parse(localStorage.getItem("temp"));
        console.log(json);
        $(document).ready(function () {
            $("#name").text(json.name);
            $("#code").text(json.code);
            $("#phone").text(json.contactPhone);
            $("#mail").text(json.contactMail);
            var newTime = new Date(json.createTime);
            $("#createtime").text(newTime.toLocaleString());
        })
    </script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px;">
    <legend><i id="back-icon" style="margin-left: -15px" class="layui-icon">&#xe65c;</i>&nbsp;&nbsp;公司详细信息</legend>
</fieldset>
<br>
<div class="layui-form-item">
    <label style="margin-top: -9px;" class="layui-form-label">公司名字</label>
    <div class="layui-input-block">
        <h6 id="name"></h6>
    </div>
</div>
<div class="layui-form-item">
    <label style="margin-top: -9px;" class="layui-form-label">税号</label>
    <div class="layui-input-block">
        <h6 id="code"></h6>
    </div>
</div>
<div class="layui-form-item">
    <label style="margin-top: -9px;" class="layui-form-label">联系电话</label>
    <div class="layui-input-block">
        <h6 id="phone"></h6>
    </div>
</div>
<div class="layui-form-item">
    <label style="margin-top: -9px;" class="layui-form-label">联系邮箱</label>
    <div class="layui-input-block">
        <h6 id="mail"></h6>
    </div>
</div>
<div class="layui-form-item">
    <label style="margin-top: -9px;" class="layui-form-label">创建时间</label>
    <div class="layui-input-block">
        <h6 id="createtime"></h6>
    </div>
</div>
<%--<div class="layui-form-item">--%>
    <%--<div class="layui-input-block">--%>
        <%--<button id="addserviceModel" class="layui-btn">添加服务模块</button>--%>
        <%--<button id="allserviceModel" class="layui-btn">所有服务模块</button>--%>
    <%--</div>--%>
<%--</div>--%>
</body>
</html>
