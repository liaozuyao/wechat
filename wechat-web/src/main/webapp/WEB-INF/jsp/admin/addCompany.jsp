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
    <title>添加公司</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap-theme.css">
    <link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap-responsive.css">
    <script type="text/javascript" src="<%=basePath%>bootstrap/js/bootstrap.js"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <style>
    </style>
</head>
<body>
<br>
<br>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" action="<%=basePath%>insertCompany" method="get">
                <div class="form-group">
                    <label for="name">公司名字</label>
                    <input class="form-control" id="name" type="text" />
                </div>
                <button type="button" class="btn btn-default">提交</button>
            </form>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(".btn-default").click(function () {
        var name = $("#name").val();
        $.get("<%=basePath%>insertCompany",{
            name : name
        }, function (data) {
            if(data.code == 200){
                alert(data.msg);
            } else {
                alert(data.msg);
            }
        })
    })
</script>
</html>
