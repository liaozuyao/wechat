<%--
  Created by IntelliJ IDEA.
  User: liaozuyao
  Date: 2018/2/18
  Time: 23:11
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
    <title>已提交的问题</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>static/layui/css/layui.css" media="all">
    <script src="<%=basePath%>static/jquery/jQuery.js"></script>
    <script src="<%=basePath%>static/layui/layui.js"></script>
    <script>
        $.ajax({
            url : '<%=basePath%>getQuestionByCompanyId',
            type : 'GET',
            success : function (result) {
                if(result.code == 205){
                    alert(result.msg);
                    window.location = "<%=basePath%>customerLogin.html"
                }
                console.log(result.data)
                if(result.data.length == 0){
                    alert("当前无数据");
                    window.location = "<%=basePath%>customerMain.html"
                }
                var dom = document.getElementById("tbody");
                var info = "";
                for(var i = 0; i<result.data.length; i++){
                    var str = "";
                    switch (result.data[i].status){
                        case 0:
                            str = "已提交";
                            break;
                        case 1:
                            str = "受理";
                            break;
                        case 2:
                            str = "处理中";
                            break;
                        case 3:
                            str = "问题解决";
                            break;
                        default:
                            break;
                    }
                    info += "<tr id=" + result.data[i].id + " onclick=getDetails(this.id)><td>" + result.data[i].title + "</td><td>" + result.data[i].describe + "</td>" +
                        "<td>" + str + "</td></tr>";
                }
                dom.innerHTML = null;
                dom.innerHTML = info;
            }
        })
    </script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px;">
    <legend><i id="back-icon" style="margin-left: -15px" class="layui-icon">&#xe65c;</i>&nbsp;&nbsp;已提交的问题</legend>
</fieldset>
<table class="layui-table" lay-even lay-skin="nob">
    <thead>
    <tr>
        <th>标题</th>
        <th>紧急度</th>
        <th>状态</th>
    </tr>
    </thead>
    <tbody id="tbody">
    </tbody>
</table>
</body>
<script type="text/javascript">
    $("#back-icon").click(function () {
        window.location = "<%=basePath%>customerMain.html"
    })
    function getDetails(id) {
        $.get("<%=basePath%>questionDetails",{
            'id' : id
        },function (data) {
            if(data.code == 200){
                localStorage.setItem("temp", JSON.stringify(data.data));
                window.location = "<%=basePath%>questionDetail.html";
            } else {
                alert(data.msg);
            }
        })
    }
</script>
</html>
