<%--
  Created by IntelliJ IDEA.
  User: liaozuyao
  Date: 2018/2/14
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>实施开发相关操作</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>static/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>static/css/ui.css">
    <script src="<%=basePath%>static/jquery/jQuery.js"></script>
    <script src="<%=basePath%>static/layui/layui.js"></script>
</head>
<body class="android" style="overflow:auto">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px;">
    <legend>&nbsp;&nbsp;实施开发相关操作</legend>
</fieldset>
<div class="view-container" style="overflow:auto">
    <div class="my-car-thumbnail"><img src="<%=basePath%>static/img/banner-car.jpg"/></div>
    <div class="car-title">
    </div>
    <div class="grids-contant3">
        <div id="updateAcc" class="grids-grid3">
            <div class="grids-grid3-cont">
                <div class="grids-grid-icon"><img src="<%=basePath%>static/img/icon-ax-3.png" alt=""></div>
                <p class="grids-grid-label">修改账号基础信息</p>
            </div>
        </div>
        <div id="updatepasswd" class="grids-grid3">
            <div class="grids-grid3-cont">
                <div class="grids-grid-icon"><img src="<%=basePath%>static/img/icon-ax-3.png" alt=""></div>
                <p class="grids-grid-label">修改账号密码</p>
            </div>
        </div>
        <div id="addquestion" class="grids-grid3">
            <div class="grids-grid3-cont">
                <div class="grids-grid-icon"><img src="<%=basePath%>static/img/icon-ax-3.png" alt=""></div>
                <p class="grids-grid-label">新建问题提交</p>
            </div>
        </div>
        <div id="allquestions" class="grids-grid3">
            <div class="grids-grid3-cont">
                <div class="grids-grid-icon"><img src="<%=basePath%>static/img/icon-ax-3.png" alt=""></div>
                <p class="grids-grid-label">提交问题查询</p>
            </div>
        </div>
        <div id="updateCompanyInfo" class="grids-grid3">
            <div class="grids-grid3-cont">
                <div class="grids-grid-icon"><img src="<%=basePath%>static/img/icon-ax-3.png" alt=""></div>
                <p class="grids-grid-label">完善公司信息资料</p>
            </div>
        </div>
    </div>
    <div class="devider b-line"></div>
    <div class="item-phone b-line">
        <a href="news-list.html" class="item-phone-lin ">
            <p class="item-phone-title"></p>
            <p class="item-phone-sub"></p>
        </a>
    </div>
</div>
</body>
</html>
