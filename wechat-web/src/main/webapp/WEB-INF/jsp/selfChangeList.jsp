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
    <title>我的变更单</title>
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
    <script src="https://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/js/bootstrap-select.js"></script>
    <link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap.css">
    <link href="https://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/css/bootstrap-select.css" rel="stylesheet">
    <style>
        body {
            background-color: #40E0D0;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <br>
            <div class="form-group">
                <input type="text" class="form-control" id="vange" placeholder="搜索服务单"/>
            </div>
            <table class="table nofollow">
                <thead>
                <tr>
                    <th>
                        变更单号
                    </th>
                    <th>
                        变更申请人
                    </th>
                    <th>
                        标题
                    </th>
                    <th>
                        紧急分类
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${changeListByUserId}" var="items">
                    <tr id="${items.id}" class="changeList" onclick="getChangeListDetail(this.id)">
                        <td>
                                ${items.id}
                        </td>
                        <td>
                                ${items.changeApplicant}
                        </td>
                        <td>
                                ${items.title}
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${items.changeClass == 9}">
                                    标准
                                </c:when>
                                <c:when test="${items.changeClass == 10}">
                                    一般
                                </c:when>
                                <c:when test="${items.changeClass == 11}">
                                    紧急
                                </c:when>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <button id="questionBack" type="button" class="btn btn-default">返回</button>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $("#questionBack").click(function () {
            if (window.history.length > 1) {
                window.location.href = "<%=basePath%>addChangeList";
            } else {
                window.location.href = "<%=basePath%>"
            }
        })
    })

    function getChangeListDetail(id) {
        $.get("<%=basePath%>getChangeListDetail", {
            'id':id
        }, function (data) {
            if(data.code == 200){
                window.location.href = "<%=basePath%>getChangeListDetails";
            }
        })
    }
</script>
</html>
