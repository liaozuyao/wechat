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
    <title>新建变更单</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap-theme.css">
    <link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap-responsive.css">
    <script type="text/javascript" src="<%=basePath%>bootstrap/js/bootstrap.js"></script>
    <script src="<%=basePath%>/bootstrap/js/jQuery.js"></script>
    <style>
        body {
            background-color: #C6E2FF;
        }
        h3{
            color: #642EFE;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div id="top">
                <h3>
                    新建变更单
                </h3>
            </div>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" maxlength="400" id="title" placeholder="请输入变更单标题（必填）"/>
        </div>
        <div class="form-group ">
            <select class="form-control" id="changeItem">
                <option value="0">-请选择变更项（必填）-</option>
                <c:forEach var="items" items="${changeItem}">
                    <option value="${items.id}">${items.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <select class="form-control" id="changeClass">
                <option value="0">-请选择变更分类-</option>
                <c:forEach var="items" items="${changeClass}">
                    <option value="${items.id}">${items.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <select class="form-control" id="changeCompany">
                <option value="0">-变更申请人单位-</option>
                <option value="1">科伦集团</option>
                <option value="2">科伦药业</option>
            </select>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="changeApplicant" placeholder="申请变更人"/>
        </div>
        <div class="form-group">
            <form id="postForm" enctype="multipart/form-data" method="post">
                <label for="files">附件：</label><input id="files" type="file" name="file" value="选择文件" onchange="fileUpload()"/>
            </form>
            <p class="help-block" id="fileName">
            </p>
        </div>
        <div class="form-group">
            <textarea id="changeReason" placeholder="变更原因" class="form-control" rows="8"></textarea>
        </div>
        <div class="form-group">
            <textarea id="changeContent" placeholder="变更内容（必填）" class="form-control" rows="8"></textarea>
        </div>
        <button type="submit" class="btn btn-default" onclick="changeListCommit()">提交</button>
        <button id="back" type="button" class="btn btn-default">返回</button>
        <button id="myChangeList" type="button" class="btn btn-default">我的提交</button>
        <%--<%--%>
            <%--Long id = null;--%>
            <%--User user = (User)request.getSession().getAttribute("user");--%>
            <%--if(user == null){--%>
                <%--response.sendRedirect("/WeChat/wxLogin");--%>
            <%--} else {--%>
                <%--id = user.getId();--%>
            <%--}--%>
        <%--%>--%>
    </div>
</div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#back").click(function () {
            if(window.history.length>1){
                window.history.back();
            }else{
                window.location.href="<%=basePath%>"
            }
        })

        $("#myChangeList").click(function () {
            var id = $("#changeApplicant").val();
            window.location.href="<%=basePath%>getChangeListByUserId?userId="+1;
        })
    })

    function fileUpload() {
        var filename = $("#files").val();
        console.log(filename);
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

    function changeListCommit() {
        var a = new Array();
        a = document.getElementsByClassName("test");
        var file = new String();
        for (var i = 0; i < a.length; i++) {
            file += a[i].innerHTML+",";
        }
        file = file.substring(0,file.length-1);
        var title = $("#title").val();
        var changeItem = $("#changeItem").val();
        var changeClass = $("#changeClass").val();
        var companyId = $("#changeCompany").val();
        var changeApplicant = $("#changeApplicant").val();
        var files = file;
        var changeReason = $("#changeReason").val();
        var changeContent = $("#changeContent").val();
        $.post("<%=basePath%>insertChangeList",{
            'title':title,
            'changeItem':changeItem,
            'changeClass':changeClass,
            'companyId':companyId,
            'changeApplicant':changeApplicant,
            'files':files,
            'changeReason':changeReason,
            'changeContent':changeContent,
            'userId':1
                <%--'userId':<%=id%>--%>
        }, function (data) {
            if(data.code == 200){
                alert(data.msg);
            } else {
                alert(data.msg);
            }
        })
    }
</script>
</body>
</html>
