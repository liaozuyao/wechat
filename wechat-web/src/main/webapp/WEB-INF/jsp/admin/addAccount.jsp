<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>添加公司联系人账号</title>
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
    <legend><i class="layui-icon">&#xe65c;</i>&nbsp;&nbsp;添加公司联系人账号</legend>
</fieldset>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">请选择公司</label>
        <div class="layui-input-block">
            <select id="company" name="city" lay-verify="required">
                <option value=""></option>
                <c:forEach items="${companies}" var="items">
                    <option value="${items.id}">${items.name}</option>
                </c:forEach>
            </select>
        </div>
    </div>
</form>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="commit" class="layui-btn">立即提交</button>
        <button id="back" class="layui-btn layui-btn-primary">返回</button>
    </div>
</div>
<div class="layui-form-item" id="accDiv" style="text-align: center">
</div>
</body>
<script>
    layui.use('form', function(){
        $("#commit").click(function () {
            var id = $("#company").val();
            $.post("<%=basePath%>insertAccount", {
                'companyId' : id
            }, function (data) {
                if(data.code == 200){
                    var dom = document.getElementById("accDiv");
                    dom.innerHTML = null;
                    var info = "<span>账号："+data.msg+"</span>";
                    dom.innerHTML +=info;
                } else {
                    alert(data.msg);
                }
            })
        })
    });
</script>
</html>
