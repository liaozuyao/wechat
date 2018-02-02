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
    <title>提交的问题</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
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
            <br>
            <%--<div class="form-group ">--%>
                <%--<select class="form-control" id="fields" onchange="getQuestionByFields(this.value)">--%>
                    <%--<option value="0">-请选择所属领域-</option>--%>
                    <%--<c:forEach var="items" items="${fielsName}">--%>
                        <%--<option value="${items.id}">${items.name}</option>--%>
                    <%--</c:forEach>--%>
                <%--</select>--%>
            <%--</div>--%>
            <%--<div class="form-group ">--%>
                <%--<select class="form-control" id="nodes" onchange="getQuestionByNode(this.value)">--%>
                    <%--<option value="0">-请选择问题节点-</option>--%>
                    <%--<c:forEach var="items" items="${nodeName}">--%>
                        <%--<option value="${items.id}">${items.name}</option>--%>
                    <%--</c:forEach>--%>
                <%--</select>--%>
            <%--</div>--%>
            <%--<div class="form-group ">--%>
                <%--<select class="form-control" id="status" onchange="getQuestionByStatus(this.value)">--%>
                    <%--<option value="0">-请选择单据状态-</option>--%>
                    <%--<c:forEach var="items" items="${status}">--%>
                        <%--<option value="${items.id}">${items.name}</option>--%>
                    <%--</c:forEach>--%>
                <%--</select>--%>
            <%--</div>--%>
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
                <c:forEach items="${questionByUserId}" var="items">
                    <tr id="${items.id}" class="questionList" onclick="getDetails(this.id)">
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
            <button id="questionBack" type="button" class="btn btn-default">返回</button>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    function getQuestionByFields(value){
        console.log(value+"field");
        $.get("<%=basePath%>getQuestionByFieldId", {
            'fieldId':value
        }, function (data) {
            if(data.code == 200){
                console.log("success");
            }
        })
    }
    
    function getQuestionByNode(value) {
        console.log(value+"node");
        $.get("<%=basePath%>getQuestionByNodeId", {
            'nodeId':value
        }, function (data) {
            if(data.code == 200){
                console.log("success");
            }
        })
    }
    
    function getQuestionByStatus(value) {
        console.log(value+"status");
        $.get("<%=basePath%>getQuestionByStatus", {
            'status':value
        }, function (data) {
            if(data.code == 200){
                console.log("success");
            }
        })
    }
    function getDetails(id) {
        console.log(id);
        $.get("<%=basePath%>getQuestionDetail", {
            'id': id
        }, function (data) {
            if (data.code == 200) {
                console.log(data);
                window.location.href = "<%=basePath%>questionDetails";
            }
        })
    }

    $(document).ready(function () {
        $("#questionBack").click(function () {
            if (window.history.length > 1) {
                window.location.href = "<%=basePath%>addQuestion";
            } else {
                window.location.href = "<%=basePath%>"
            }
        })
    })

    $("#vange").keydown(function () {
        var vange = $("#vange").val();
        if(event.keyCode == "13"){
            $.get("<%=basePath%>getVange",{
                'vange': vange
            }, function (data) {
                if(data.code == 200){

                }
            })
        }
    })
</script>
</html>
