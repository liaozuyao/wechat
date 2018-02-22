<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta charset="utf-8">
    <title>修改公司信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>static/layui/css/layui.css" media="all">
    <script src="<%=basePath%>static/jquery/jQuery.js"></script>
    <script src="<%=basePath%>static/layui/layui.js"></script>
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px;">
    <legend><i id="back-icon" style="margin-left: -15px" class="layui-icon">&#xe65c;</i>&nbsp;&nbsp;修改完善公司信息</legend>
</fieldset>
<br>
<div class="layui-form-item">
    <label class="layui-form-label">公司名字</label>
    <div class="layui-input-block">
        <c:choose>
            <c:when test="${company.name.equals(null)}">
                <input type="text" id="name" name="name" required lay-verify="required" placeholder="请输入公司名字(必填)" autocomplete="off"
                       class="layui-input">
            </c:when>
            <c:otherwise>
                <input type="text" id="name" name="name" required lay-verify="required" placeholder="请输入公司名字(必填)" autocomplete="off"
                       class="layui-input" value="${company.name}">
            </c:otherwise>
        </c:choose>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">公司税号</label>
    <div class="layui-input-block">
        <c:choose>
            <c:when test="${company.code.equals(null)}">
                <input type="text" id="code" name="code" required lay-verify="required" placeholder="请输入公司税号(必填)" autocomplete="off"
                       class="layui-input">
            </c:when>
            <c:otherwise>
                <input type="text" id="code" name="code" required lay-verify="required" placeholder="请输入公司税号(必填)" autocomplete="off"
                       class="layui-input" value="${company.code}">
            </c:otherwise>
        </c:choose>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">联系电话</label>
    <div class="layui-input-block">
        <c:choose>
            <c:when test="${company.contactPhone.equals(null)}">
                <input type="tel" id="contactphone" name="contactphone" required lay-verify="required"
                       placeholder="请输入联系电话(必填)" autocomplete="off" class="layui-input">
            </c:when>
            <c:otherwise>
                <input type="tel" id="contactphone" name="contactphone" required lay-verify="required"
                       placeholder="请输入联系电话(必填)" autocomplete="off" class="layui-input" value="${company.contactPhone}">
            </c:otherwise>
        </c:choose>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">联系邮箱</label>
    <div class="layui-input-block">
        <c:choose>
            <c:when test="${company.contactMail.equals(null)}">
                <input type="email" id="contactmail" name="contactmail" required lay-verify="required" placeholder="请输入联系邮箱(必填)"
                       autocomplete="off" class="layui-input">
            </c:when>
            <c:otherwise>
                <input type="email" id="contactmail" name="contactmail" required lay-verify="required" placeholder="请输入联系邮箱(必填)"
                       autocomplete="off" class="layui-input" value="${company.contactMail}">
            </c:otherwise>
        </c:choose>
    </div>
</div>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="commitInfo" class="layui-btn">立即提交</button>
        <button id="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
</div>
<script src="<%=basePath%>static/js/updateCompany.js"></script>
</body>
</html>