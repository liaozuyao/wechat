<%--
  Created by IntelliJ IDEA.
  User: liaozuyao
  Date: 2018/2/15
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>提交问题</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>static/layui/css/layui.css" media="all">
    <script src="<%=basePath%>static/jquery/jQuery.js"></script>
    <script src="<%=basePath%>static/layui/layui.js"></script>
    <script src="<%=basePath%>static/js/addQuestion.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px;">
    <legend><i id="back-icon" style="margin-left: -15px" class="layui-icon">&#xe65c;</i>&nbsp;&nbsp;提交相关问题</legend>
</fieldset>
<br>
<div class="layui-form-item">
    <label class="layui-form-label">标题</label>
    <div class="layui-input-block">
        <input type="text" id="title" name="title" required lay-verify="required" placeholder="请输入标题(必填)" autocomplete="off"
               class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">问题节点</label>
    <div class="layui-input-block">
        <select id="field" name="field" lay-verify="required" class="layui-input">
        </select>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">紧急度</label>
    <div class="layui-input-block">
        <select id="urgent" name="urgent" lay-verify="required" class="layui-input">
        </select>
    </div>
</div>
<div class="layui-form-item layui-form-text">
    <label class="layui-form-label">详细描述</label>
    <div class="layui-input-block">
        <textarea id="desc" name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">解决时间</label>
    <div class="layui-input-block">
        <input type="text" id="hopetime" name="hopetime" required lay-verify="required" placeholder="请选择(必填)" autocomplete="off"
               class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">选择顾问</label>
    <div class="layui-input-block">
        <select id="adviser" name="adviser" lay-verify="required" class="layui-input">
        </select>
    </div>
</div>
<div class="layui-form-item">
    <form id="postForm" enctype="multipart/form-data" method="post">
        <label class="layui-form-label">选择文件</label>
            <div class="layui-input-block">
                <input id="files" required lay-verify="required" type="file" name="file" value="选择文件"
                       autocomplete="off" onchange="fileUpload()"/>
            </div>
    </form>
    <p class="help-block" id="fileName">
    </p>
</div>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="commitQuestion" class="layui-btn">立即提交</button>
        <button id="reset" class="layui-btn layui-btn-primary">清空</button>
    </div>
</div>
</body>
<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#hopetime' //指定元素
        });
        $("#commitQuestion").click(function () {
            var a = new Array();
            a = document.getElementsByClassName("test");
            var file = new String();
            for (var i = 0; i < a.length; i++) {
                file += a[i].innerHTML + ",";
            }
            var title = $("#title").val();
            var fieldId = $("#field").val();
            var urgent = $("#urgent").val();
            var describe = $("#desc").val();
            var hopeTime = $("#hopetime").val();
            var adviser = $("#adviser").val();
            var files = "";
            if(file.length == 0){
                files = "";
            } else {
                file = file.substring(0, file.length - 1);
                files = file;
            }
            $.post("<%=basePath%>insertQuestion", {
                'title' : title,
                'fieldId' : fieldId,
                'urgent' : urgent,
                'files' : files,
                'describe' : describe,
                'hopeTime' : hopeTime,
                'adviser' : adviser
            }, function (data) {
                if(data.code == 200){
                    alert(data.msg);
                    window.location = "<%=basePath%>allQuestion.html";
                } else {
                    alert(data.msg);
                }
            })
        })
        $("#back-icon").click(function () {
            window.location = "<%=basePath%>customerMain.html"
        })
    });

    function fileUpload() {
        var filename = $("#files").val();
        $.ajax({
            url: "<%=basePath%>upload",
            type: "POST",
            data: new FormData($('#postForm')[0]),
            processData: false,
            contentType: false,
            success: function (data) {
                var dom = document.getElementById("fileName");
                var info = "<a class='test'>" + data.data + "</a>&nbsp;<br>";
                dom.innerHTML += info;
            },
        })
    }
</script>
</html>
