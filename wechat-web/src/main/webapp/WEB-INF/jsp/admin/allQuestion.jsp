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
    <title>所有提问</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes"/>
    <style>
    </style>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <br>
            <br>
            <div class="form-group">
                <input type="text" class="form-control" id="vange" placeholder="搜索服务单"/>
            </div>
            <table class="table nofollow">
                <thead>
                <tr>
                    <th>
                        单号
                    </th>
                    <th>
                        提交人
                    </th>
                    <th>
                        标题
                    </th>
                    <th>
                        状态
                    </th>
                    <th>
                        提交时间
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${questionList}" var="items">
                    <tr id="${items.id}" class="questionList">
                        <td>
                                ${items.id}
                        </td>
                        <td>
                                ${items.userId}
                        </td>
                        <td>
                                ${items.title}
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${items.status == 12}">
                                    未处理
                                </c:when>
                                <c:when test="${items.status == 13}">
                                    处理中
                                </c:when>
                                <c:when test="${items.status == 14}">
                                    已提供解决方案
                                </c:when>
                                <c:when test="${items.status == 15}">
                                    已退回
                                </c:when>
                                <c:when test="${items.status == 16}">
                                    已关闭
                                </c:when>
                                <c:when test="${items.status == 17}">
                                    提交用友
                                </c:when>
                                <c:when test="${items.status == 18}">
                                    用友已处理
                                </c:when>
                            </c:choose>
                        </td>
                        <td>
                                ${items.strTime}
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-md-12 column">
            <ul class="pagination pull-right">
                <li>
                    <a href="<%=basePath%>allQuestionByAdmin?pn=1">首页</a>
                </li>
                <%
                    Integer pageNum = (Integer) request.getAttribute("pageNum");
                    for (int i = 1; i <= pageNum; i++){
                        %>
                        <li>
                            <a href="<%=basePath%>allQuestionByAdmin?pn=<%=i%>"><%=i%></a>
                        </li>
                    <%
                    }
                %>
                <li>
                    <a href="<%=basePath%>allQuestionByAdmin?pn=${pageNum}">尾页</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(".questionList").click(function () {
        var id = $(this).attr("id");
        $.get("<%=basePath%>getQuestionDetail", {
            id : id
        }, function (data) {
            if(data.code == 200){
                window.location.href = "<%=basePath%>questionDetailByAdmin";
            } else {

            }
        })
    })
</script>
</body>
</html>
