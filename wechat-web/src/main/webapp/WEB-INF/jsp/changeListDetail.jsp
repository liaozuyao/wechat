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
    <title>变更单详情</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes"/>

    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
    <style>
        body {
            background-color: #40E0D0;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <br>
            <br>
            <dl>
                <dt>
                    变更单号
                </dt>
                <dd>
                    ${changeList.id}
                </dd>
                <dt>
                    变更申请人
                </dt>
                <dd>
                    ${changeList.changeApplicant}
                </dd>
                <dt>
                    变更标题
                </dt>
                <dd>
                    ${changeList.title}
                </dd>
                <dt>
                    紧急分类
                </dt>
                <dd>
                    <c:choose>
                        <c:when test="${changeList.changeClass == 9}">
                            标准
                        </c:when>
                        <c:when test="${changeList.changeClass == 10}">
                            一般
                        </c:when>
                        <c:when test="${changeList.changeClass == 11}">
                            紧急
                        </c:when>
                    </c:choose>
                </dd>
            </dl>
            <button id="changeListBack" type="button" class="btn btn-default">返回</button>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $("#changeListBack").click(function () {
            history.back(-1);
        })
    })
</script>
</html>
