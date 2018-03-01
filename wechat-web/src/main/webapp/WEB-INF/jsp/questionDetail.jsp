<%--
  Created by IntelliJ IDEA.
  User: liaozuyao
  Date: 2018/2/23
  Time: 16:25
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
    <title>问题详情</title>
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
            $("#title").text(json.title);
            $("#describe").text(json.describe);
            $("#field").text(json.field);
            $("#urgent").text(json.urgent);
            fileArr  = json.file.split(",");
            if(fileArr.length >= 1){
                var dom = document.getElementById("files");
                var info = "";
                for(var i = 0; i<fileArr.length; i++) {
                    info += "<a href='http://172.16.61.242:8080/czyl/file/" + fileArr[i] + "'>"+fileArr[i]+"</a>,";
                }
                info = info.substring(0, info.length-1);
                dom.innerHTML = info;
            } else {
                $("#files").text();
            }
            $("#status").text(json.status);
            $("#adviser").text(json.adviser);
            $("#hopetime").text(json.hopeTime);
            $("#createtime").text(json.createTime);
        })
    </script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px;">
    <legend><i id="back-icon" style="margin-left: -15px" class="layui-icon">&#xe65c;</i>&nbsp;&nbsp;问题详情</legend>
</fieldset>
<br>
<div class="layui-form-item">
    <label style="margin-top: -9px;" class="layui-form-label">标题</label>
    <div class="layui-input-block">
        <h6 id="title"></h6>
    </div>
</div>
<div class="layui-form-item">
    <label style="margin-top: -9px;" class="layui-form-label">描述</label>
    <div class="layui-input-block">
        <h6 id="describe"></h6>
    </div>
</div>
<div class="layui-form-item">
    <label style="margin-top: -9px;" class="layui-form-label">领域</label>
    <div class="layui-input-block">
        <h6 id="field"></h6>
    </div>
</div>
<div class="layui-form-item">
    <label style="margin-top: -9px;" class="layui-form-label">紧急度</label>
    <div class="layui-input-block">
        <h6 id="urgent"></h6>
    </div>
</div>
<div class="layui-form-item">
    <label style="margin-top: -9px;" class="layui-form-label">附件</label>
    <div class="layui-input-block">
        <h6 id="files"></h6>
    </div>
</div>
<div class="layui-form-item">
    <label style="margin-top: -9px;" class="layui-form-label">状态</label>
    <div class="layui-input-block">
        <h6 id="status"></h6>
    </div>
</div>
<div class="layui-form-item">
    <label style="margin-top: -9px;" class="layui-form-label">处理顾问</label>
    <div class="layui-input-block">
        <h6 id="adviser"></h6>
    </div>
</div>
<div class="layui-form-item">
    <label style="margin-top: -9px;" class="layui-form-label">提交时间</label>
    <div class="layui-input-block">
        <h6 id="createtime"></h6>
    </div>
</div>
<div class="layui-form-item">
    <label style="margin-top: -9px;" class="layui-form-label">期望解决时间</label>
    <div class="layui-input-block">
        <h6 id="hopetime"></h6>
    </div>
</div>
</body>
<script>

</script>
</html>
