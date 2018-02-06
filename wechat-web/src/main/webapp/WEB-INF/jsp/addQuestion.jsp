<%@ page import="com.czyl.entity.User" %>
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
    <title>新建问题提交</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes"/>
    <link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap-theme.css">
    <link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap-responsive.css">
    <script type="text/javascript" src="<%=basePath%>bootstrap/js/bootstrap.js"></script>
    <script src="<%=basePath%>/bootstrap/js/jQuery.js"></script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div id="top">
                <h3>
                    新建问题提交
                </h3>
            </div>
        </div>

        <div class="form-group">
            <input type="text" class="form-control" maxlength="400" id="title" placeholder="请输入你的问题（必填）"/>
            <span id="titlepro"></span>
        </div>
        <div class="form-group ">
            <select class="form-control" id="fields" onchange="getNodes(this.value)">
                <option value="0">-请选择所属领域(必填)-</option>
                <c:forEach var="items" items="${fields}">
                    <option value="${items.id}">${items.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <select class="form-control" id="urgent">
                <option value="0">-请选择紧急度-</option>
                <c:forEach var="items" items="${urgent}">
                    <option value="${items.id}">${items.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <form id="postForm" enctype="multipart/form-data" method="post">
                <label for="files">附件：</label><input id="files" type="file" name="file" value="选择文件"
                                                     onchange="fileUpload()"/>
            </form>
            <p class="help-block" id="fileName">
            </p>
        </div>
        <div class="form-group">
            <textarea id="describe" placeholder="更详细的描述（必填）" class="form-control" rows="8"></textarea>
        </div>
        <span id="describepro"></span>
        <button type="submit" class="btn btn-default" onclick="getCommit()">提交</button>
        <button id="questionBack" type="button" class="btn btn-default">返回</button>
        <button id="myQuestion" type="button" class="btn btn-default">我的提交</button>
        <%--<%--%>
            <%--Long id = null;--%>
            <%--User user = (User) request.getSession().getAttribute("user");--%>
            <%--if (user != null) {--%>
                <%--id = user.getId();--%>
            <%--} else {--%>
                <%--response.sendRedirect("/WeChat/wxLogin");--%>
            <%--}--%>
        <%--%>--%>
    </div>
</div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#questionBack").click(function () {
            if (window.history.length > 1) {
                window.history.back();
            } else {
                window.location.href = "<%=basePath%>"
            }
        })

        $("#myQuestion").click(function () {
            window.location.href = "<%=basePath%>getQuestionById?userId=" +1;
        })
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
                var info = "<a class='test'>" + data.data + "</a>&nbsp;&nbsp;&nbsp;";
                dom.innerHTML += info;
            },
        })
    }

    <%--function getNodes(value) {--%>
        <%--var dom = document.getElementById("nodes");--%>
        <%--$.ajax({--%>
            <%--url: "<%=basePath%>selected",--%>
            <%--data: "parentId=" + value,--%>
            <%--type: "GET",--%>
            <%--success: function (result) {--%>
                <%--var info = "";--%>
                <%--for (var i = 0; i < result.data.length; i++) {--%>
                    <%--info += "<option value=" + result.data[i].id + ">" + result.data[i].name + "</option>"--%>
                <%--}--%>
                <%--dom.innerHTML = null;--%>
                <%--dom.innerHTML = info;--%>
            <%--}--%>
        <%--});--%>
    <%--}--%>

    function getCommit() {
        var a = new Array();
        a = document.getElementsByClassName("test");
        var file = new String();
        for (var i = 0; i < a.length; i++) {
            file += a[i].innerHTML + ",";
        }
        file = file.substring(0, file.length - 1);
        var title = $("#title").val();
        var field = $("#fields").val();
        var urgent = $("#urgent").val();
        var files = file;
        var describe = $("#describe").val();
        $.post("<%=basePath%>insertQuestion", {
            'title': title,
            'fieldId': field,
            'urgent': urgent,
            'file': files,
            'describe': describe
        }, function (data) {
            if (data.code == 200) {
                alert(data.msg);
            } else {
                alert(data.msg);
            }
        })
    }
</script>
<style>
    /*#fields{*/
    /*width: 50%;*/
    /*}*/
    /*#fields:hover{*/
    /*transition: 1s;*/
    /*width: 100%;*/
    /*}*/
    body {
        background-color: #C6E2FF;
    }

    #titlepro{
        color: #FF0000;
    }

    #describepro{
        color: #FF0000;
    }

    h3{
        color: #642EFE;
    }
    /*body:hover{*/
    /*background-color: #46a546;*/
    /*transition: 4s;*/
    /*}*/
</style>
</body>
</html>
