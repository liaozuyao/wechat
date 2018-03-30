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
    <link rel="stylesheet" href="<%=basePath%>static/css/ui.css">
    <script src="<%=basePath%>static/jquery/jQuery.js"></script>
    <script src="<%=basePath%>static/layui/layui.js"></script>
    <script>
        $.ajax({
            url :'<%=basePath%>getAllAdviser',
            type : 'get',
            success : function(result){
                if(result.code == 205){
                    alert(result.msg);
                    window.location = "<%=basePath%>index.html";
                    return;
                }
                if(result.code == 204){
                    alert(result.msg);
                    window.location = "<%=basePath%>index.html";
                    return;
                }
                $("#tbody").empty();
                for(var i = 0; i<result.data.length; i++){
                    info += "<tr id=" + result.data[i].id + "><td>" + result.data[i].name + "</td><td>" +
                        "<a onclick='getDetails(this.id)' class='detail' id=" + result.data[i].id + " style='color:blue' href='#'>查看</a>&nbsp;&nbsp;" +
                        //                        "<a onclick='getDelete(this.id)' class='delete' id=" + result.data[i].id + " style='margin-left: 20px; color:red' href='#'>删除</a>" +
                        "</td></tr>";
                }
                $("#tbody").append(info);
            }
        })
    </script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px;">
    <legend><i id="back-icon" style="margin-left: -15px" class="layui-icon">&#xe65c;</i>&nbsp;&nbsp;所有顾问</legend>
</fieldset>
<table class="layui-table" lay-even lay-skin="nob">
    <thead>
    <tr>
        <th>顾问姓名</th>
        <th>开发/实施</th>
    </tr>
    </thead>
    <tbody id="tbody">
    </tbody>
</table>
</body>
<script>
    $("#back-icon").click(function () {
        window.history.go(-1);
    })
</script>
</html>
