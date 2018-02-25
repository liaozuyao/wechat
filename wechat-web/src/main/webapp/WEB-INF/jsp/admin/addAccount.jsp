<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script type="text/javascript">
        $.ajax({
            url : '<%=basePath%>allCompany',
            type : 'GET',
            success : function (result) {
                var dom = document.getElementById("company");
                var info = "";
                for(var i = 0;i<result.data.length; i++){
                    info += "<option value="+ result.data[i].id +">"+result.data[i].name+"</option>";
                }
                dom.innerHTML = null;
                dom.innerHTML = info;
            }
        })
    </script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px;">
    <legend><i id="back-icon" style="margin-left: -15px" class="layui-icon">&#xe65c;</i>&nbsp;&nbsp;添加公司联系人账号</legend>
</fieldset>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">请选择公司</label>
        <div class="layui-input-block">
            <select id="company" name="company" lay-verify="required" onchange="reload();">
                <option id="first" value='0'>请选择</option>
            </select>
        </div>
    </div>
</form>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button style="margin-left: 30px;" id="commit" class="layui-btn">立即提交</button>
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
                    $("#commit").attr('disabled',"true");
                } else {
                    alert(data.msg);
                }
            })
        })
    });

    function reload() {
            alert("123123");
    }

</script>
</html>
