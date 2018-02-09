<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta charset="utf-8">
    <title>修改公司信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>static/layui/css/layui.css" media="all">
    <script src="<%=basePath%>static/jquery/jQuery.js"></script>
    <script src="<%=basePath%>static/layui/layui.js"></script>
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px;">
    <legend><i class="layui-icon">&#xe65c;</i>&nbsp;&nbsp;修改公司信息</legend>
</fieldset>

<div class="layui-form-item">
    <label class="layui-form-label">公司名字</label>
    <div class="layui-input-block">
        <input type="text" id="name" name="name" required lay-verify="required" placeholder="请输入公司名字" autocomplete="off"
               class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">公司税号</label>
    <div class="layui-input-block">
        <input type="text" id="code" name="code" required lay-verify="required" placeholder="请输入公司税号" autocomplete="off"
               class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">联系人名字</label>
    <div class="layui-input-block">
        <input type="text" id="contactname" name="contactname" required lay-verify="required" placeholder="请输入客户联系人名字"
               autocomplete="off" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">联系人电话</label>
    <div class="layui-input-block">
        <input type="tel" id="contactphone" name="contactphone" maxlength="11" required lay-verify="required"
               placeholder="请输入客户联系人电话" autocomplete="off" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">联系人邮箱</label>
    <div class="layui-input-block">
        <input type="email" id="contactmail" name="contactmail" required lay-verify="required" placeholder="请输入客户联系人邮箱"
               autocomplete="off" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="commitInfo" class="layui-btn">立即提交</button>
        <button id="back" class="layui-btn layui-btn-primary">返回</button>
    </div>
</div>
<script>
    $("#commitInfo").click(function () {
        var name = $("#name").val();
        var code = $("#code").val();
        var contactName = $("#contactname").val();
        var contactPhone = $("#contactphone").val();
        var contactMail = $("#contactmail").val();
        $.post("<%=basePath%>updateComanyInfo", {
            'name': name,
            'code': code,
            'contactName': contactName,
            'contactPhone': contactPhone,
            'contactMail': contactMail
        }, function (data) {
            if (data.code == 200) {
                alert(data.msg);
                window.location.reload();
            } else {
                alert(data.msg);
            }
        })
    })

</script>
</body>
</html>