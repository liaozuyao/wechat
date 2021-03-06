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
    <legend><i id="back-icon" style="margin-left: -15px" class="layui-icon">&#xe65c;</i>&nbsp;&nbsp;添加问题领域</legend>
</fieldset>
<div class="layui-form-item">
    <label class="layui-form-label">问题领域</label>
    <div class="layui-input-block">
        <input style="margin-left: -5px" type="text" id="name" name="name" required lay-verify="required" placeholder="请输入问题领域" autocomplete="off"
               class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="commitField" class="layui-btn">立即提交</button>
        <button id="reset" class="layui-btn layui-btn-primary">清空</button>
    </div>
</div>
</body>
<script type="text/javascript">
    $("#back-icon").click(function () {
        window.history.go(-1);
    })
    $("#reset").click(function(){
        $("#name").val("");
    })
    $("#commitField").click(function () {
        var name = $("#name").val();
        $.post("<%=basePath%>insertField", {
            'name' : name
        }, function (data) {
            if(data.code == 200){
                alert(data.msg);
            } else {
                alert(data.msg);
            }
        })
    })
</script>
</html>
