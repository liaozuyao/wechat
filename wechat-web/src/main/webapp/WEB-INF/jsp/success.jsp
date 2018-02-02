<%--
  Created by IntelliJ IDEA.
  User: liaozuyao
  Date: 2018/1/30
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <a href="<%=basePath%>allQuestionByAdmin">所有问题</a>
            <a href="<%=basePath%>allChangeListByAdmin">所有变更单</a>
            <a href="<%=basePath%>addCompanyByAdmin">添加公司</a>
            <a href="<%=basePath%>getAllCompanyByAdmin">所有公司</a>
        </div>
    </div>
</div>
</body>
</html>
