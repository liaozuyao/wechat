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
    <title>全部公司</title>
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
            <table class="table nofollow">
                <thead>
                <tr>
                    <th>
                        编号
                    </th>
                    <th>
                        公司名字
                    </th>
                    <th>
                        修改时间
                    </th>
                    <th>
                        是否删除
                    </th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${allCompany}" var="items">
                    <tr id="${items.id}" class="companyList">
                        <td>
                                ${items.id}
                        </td>
                        <td>
                                ${items.comName}
                        </td>
                        <td>
                                ${items.strTime}
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${items.isDelete == 1}">
                                    是
                                </c:when>
                                <c:when test="${items.isDelete == 0}">
                                    否
                                </c:when>
                            </c:choose>
                        </td>
                        <td>
                            <button id="${items.id}" type="button" class="btn btn-danger">删除</button>
                            &nbsp;
                            <button id="${items.id}" type="button" class="btn btn-success">恢复</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-md-12 column">
            <ul class="pagination pull-right">
                <li>
                    <a href="<%=basePath%>getAllCompanyByAdmin?pn=1">首页</a>
                </li>
                <%
                    Integer pageNum = (Integer) request.getAttribute("pageNum");
                    for (int i = 1; i <= pageNum; i++){
                %>
                <li>
                    <a href="<%=basePath%>getAllCompanyByAdmin?pn=<%=i%>"><%=i%></a>
                </li>
                <%
                    }
                %>
                <li>
                    <a href="<%=basePath%>getAllCompanyByAdmin?pn=${pageNum}">尾页</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(".btn-danger").click(function () {
        var id = $(this).attr("id");
        $.post("<%=basePath%>CompanyChangeStatusByAdmin",{
            id : id,
            isDel : 1
        }, function (data) {
            if(data.code == 200){
                location.reload();
            } else {
                location.reload();
            }
        })
    })

    $(".btn-success").click(function () {
        var id = $(this).attr("id");
        $.post("<%=basePath%>CompanyChangeStatusByAdmin", {
            id : id,
            isDel : 0
        }, function (data) {
            if(data.code == 200){
                location.reload();
            } else {
                location.reload();
            }
        })
    })
</script>
</body>
</html>
