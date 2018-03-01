<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>管理员相关操作</title>
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
    <legend>&nbsp;&nbsp;管理员相关操作</legend>
</fieldset>


<div class="view-container" style="overflow:auto">
    <div class="my-car-thumbnail"><img src="<%=basePath%>static/img/banner-car.jpg"/></div>
    <div class="car-title">
    </div>
    <div class="grids-contant3">
        <div id="addcompany" class="grids-grid3">
            <div class="grids-grid3-cont">
                <div class="grids-grid-icon"><img src="<%=basePath%>static/img/icon-ax-3.png" alt=""></div>
                <p class="grids-grid-label">添加公司</p>
            </div>
        </div>
        <div id="allcompany" class="grids-grid3">
            <div class="grids-grid3-cont">
                <div class="grids-grid-icon"><img src="<%=basePath%>static/img/icon-ax-3.png" alt=""></div>
                <p class="grids-grid-label">所有公司</p>
            </div>
        </div>
        <div id="addmodel" class="grids-grid3">
            <div class="grids-grid3-cont">
                <div class="grids-grid-icon"><img src="<%=basePath%>static/img/icon-ax-3.png" alt=""></div>
                <p class="grids-grid-label">添加模块</p>
            </div>
        </div>
        <div id="allmodel" class="grids-grid3">
            <div class="grids-grid3-cont">
                <div class="grids-grid-icon"><img src="<%=basePath%>static/img/icon-ax-3.png" alt=""></div>
                <p class="grids-grid-label">所有模块</p>
            </div>
        </div>
        <div id="addfield" class="grids-grid3">
            <div class="grids-grid3-cont">
                <div class="grids-grid-icon"><img src="<%=basePath%>static/img/icon-ax-3.png" alt=""></div>
                <p class="grids-grid-label">添加领域</p>
            </div>
        </div>
        <div id="allfield" class="grids-grid3">
            <div class="grids-grid3-cont">
                <div class="grids-grid-icon"><img src="<%=basePath%>static/img/icon-ax-3.png" alt=""></div>
                <p class="grids-grid-label">所有领域</p>
            </div>
        </div>
        <div id="addaccount" class="grids-grid3">
            <div class="grids-grid3-cont">
                <div class="grids-grid-icon"><img src="<%=basePath%>static/img/icon-ax-3.png" alt=""></div>
                <p class="grids-grid-label">添加账号</p>
            </div>
        </div>
        <div id="addadviser" class="grids-grid3">
            <div class="grids-grid3-cont">
                <div class="grids-grid-icon"><img src="<%=basePath%>static/img/icon-ax-3.png" alt=""></div>
                <p class="grids-grid-label">添加开发或实施</p>
            </div>
        </div>
        <div id="alladviser" class="grids-grid3">
            <div class="grids-grid3-cont">
                <div class="grids-grid-icon"><img src="<%=basePath%>static/img/icon-ax-3.png" alt=""></div>
                <p class="grids-grid-label">所有开发或实施</p>
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
</body>
<script src="<%=basePath%>static/js/adminMain.js"></script>
</html>
