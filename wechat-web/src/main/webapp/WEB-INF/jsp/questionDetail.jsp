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
    <title>问题详细</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
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
        .span12{
            float: none;
            display: block;
            margin-left: auto;
            margin-right: auto;
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
                    单号
                </dt>
                <dd>
                    ${questionDetails.id}
                </dd>
                <dt>
                    问题标题
                </dt>
                <dd>
                    ${questionDetails.title}
                </dd>
                <dt>
                    所属领域
                </dt>
                <dd>
                    ${questionDetails.field}
                </dd>
                <dt>
                    问题节点
                </dt>
                <dd>
                    ${questionDetails.node}
                </dd>
                <c:choose>
                    <c:when test="${questionDetails.event !=null}">
                        <dt>
                            事件类型
                        </dt>
                        <dd>
                                ${questionDetails.event}
                        </dd>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${questionDetails.influence !=null}">
                        <dt>
                            影响范围
                        </dt>
                        <dd>
                                ${questionDetails.influence}
                        </dd>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${questionDetails.urgent !=null}">
                        <dt>
                            紧急度
                        </dt>
                        <dd>
                                ${questionDetails.urgent}
                        </dd>
                    </c:when>
                </c:choose>
                <dt>
                    详细描述
                </dt>
                <dd>
                    ${questionDetails.describe}
                </dd>
                <dt>
                    状态
                </dt>
                <dd>
                    ${questionDetails.status}
                </dd>
            </dl>
            <button id="questionBack" type="button" class="btn btn-default">返回</button>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $("#questionBack").click(function () {
            history.back(-1);
        })
    })
</script>
</html>
