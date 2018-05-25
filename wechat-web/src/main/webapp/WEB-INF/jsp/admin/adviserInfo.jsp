<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>static/layui/css/layui.css" media="all">
    <script src="<%=basePath%>static/jquery/jQuery.js"></script>
    <script src="<%=basePath%>static/layui/layui.js"></script>
    <script>
        var json = JSON.parse(localStorage.getItem("temp"));
        $(document).ready(function () {
            $("#name").text(json.name);
            $("#phone").text(json.phone);
            $("#mail").text(json.mail);
            if(json.type == 7){
                $("#type").text('实施');
            } else {
                $("#type").text('开发');
            }
        })
    </script>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px;">
    <legend><i id="back-icon" style="margin-left: -15px" class="layui-icon">&#xe65c;</i>&nbsp;&nbsp;顾问详细信息</legend>
</fieldset>
<br>
<div class="layui-form-item">
    <label style="margin-top: -9px;" class="layui-form-label">姓名：</label>
    <div class="layui-input-block">
        <h6 id="name"></h6>
    </div>
</div>
<div class="layui-form-item">
    <label style="margin-top: -9px;" class="layui-form-label">电话：</label>
    <div class="layui-input-block">
        <h6 id="phone"></h6>
    </div>
</div>
<div class="layui-form-item">
    <label style="margin-top: -9px;" class="layui-form-label">邮箱：</label>
    <div class="layui-input-block">
        <h6 id="mail"></h6>
    </div>
</div>
<div class="layui-form-item">
    <label style="margin-top: -9px;" class="layui-form-label">实施/开发：</label>
    <div class="layui-input-block">
        <h6 id="type"></h6>
    </div>
</div>
</body>
<script>
    $("#back-icon").click(function () {
        window.history.go(-1);
    })
</script>
</html>
