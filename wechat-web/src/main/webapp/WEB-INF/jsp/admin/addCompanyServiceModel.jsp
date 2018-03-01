<%--
  Created by IntelliJ IDEA.
  User: liaozuyao
  Date: 2018/3/1
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        $.ajax({
            url: '<%=basePath%>allCompany',
            type: 'GET',
            success: function (result) {
                console.log(result);
                if(result.code == 204){
                    alert(result.msg);
                    return;
                }
                if(result.code == 205){
                    alert(result.msg);
                    return;
                }
                var dom = document.getElementById("company");
                var info = "<option lay-verify='required' id='first' value='0'>请选择</option>";
                for (var i = 0; i < result.data.length; i++) {
                    info += "<option lay-verify='required' value=" + result.data[i].id + ">" + result.data[i].name + "</option>";
                }
                dom.innerHTML = null;
                dom.innerHTML = info;
            }
        })
        $.ajax({
            url: '<%=basePath%>getAllServiceName',
            type: 'GET',
            success: function (result) {
                var dom = document.getElementById("model");
                var info = "<option lay-verify='required' id='first' value='0'>请选择</option>";
                for (var i = 0; i < result.data.length; i++) {
                    info += "<option lay-verify='required' value=" + result.data[i].id + ">" + result.data[i].name + "</option>";
                }
                dom.innerHTML = null;
                dom.innerHTML = info;
            }
        })
    </script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px;">
    <legend><i id="back-icon" style="margin-left: -15px" class="layui-icon">&#xe65c;</i>&nbsp;&nbsp;公司详细信息</legend>
</fieldset>
<br>
<div class="layui-form-item">
    <label class="layui-form-label">公司名字</label>
    <div class="layui-input-block">
        <select style="margin-left: -5px" id="company" name="company" lay-verify="required" class="layui-input">
        </select>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">服务模块</label>
    <div class="layui-input-block">
        <select style="margin-left: -5px" id="model" name="model" lay-verify="required" class="layui-input">
        </select>
    </div>
</div>
<div class="layui-form-item">
    <form id="postForm" enctype="multipart/form-data" method="post">
        <label style="margin-left: -5px" class="layui-form-label">合同附件</label>
        <div class="layui-input-block">
            <input style="margin-top: 7px; margin-left: -5px" id="files" required lay-verify="required" type="file" name="file" value="选择文件"
                   autocomplete="off" onchange="fileUpload()"/>
        </div>
    </form>
    <p class="help-block" id="fileName">
    </p>
</div>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="commit" class="layui-btn">立即提交</button>
    </div>
</div>
</body>
<script>
    $("#commit").click(function () {
        var a = new Array();
        a = document.getElementsByClassName("test");
        var file = new String();
        for (var i = 0; i < a.length; i++) {
            file += a[i].innerHTML + ",";
        }
        var companyId = $("#company").val();
        var serviceId = $("#model").val();
        var enclosure = "";
        if(file.length == 0){
            enclosure = "";
        } else {
            file = file.substring(0, file.length - 1);
            enclosure = file;
        }
        $.post("<%=basePath%>insertCompanyModel",{
            'companyId' : companyId,
            'serviceId' : serviceId,
            'enclosure' : enclosure
        },function (data) {
            if(data.code == 200) {
                alert(data.msg);
            } else {
                alert(data.msg);
            }
        })
    })
    $("#back-icon").click(function () {

    })
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
                var info = "<a class='test'>" + data.data + "</a>&nbsp;";
                dom.innerHTML += info;
            },
        })
    }
</script>
</html>
