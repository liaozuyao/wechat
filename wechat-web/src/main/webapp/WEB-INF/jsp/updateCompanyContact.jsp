<%--  Created by IntelliJ IDEA.
  User: liaozuyao
  Date: 2018/2/18
  Time: 23:06
  To change this template use File | Settings | File Templates.
  更新公司联系人信息
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>更新账号基础信息</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>static/layui/css/layui.css" media="all">
    <script src="<%=basePath%>static/jquery/jQuery.js"></script>
    <script src="<%=basePath%>static/layui/layui.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px;">
    <legend><i id="back-icon" style="margin-left: -15px" class="layui-icon">&#xe65c;</i>&nbsp;&nbsp;更新账号基础信息</legend>
</fieldset>
<br>
<div class="layui-form-item">
    <label style="margin-left: -12px" class="layui-form-label">名字</label>
    <div class="layui-input-block">
        <c:choose>
            <c:when test="${info.name.equals(null)}">
                <input style="margin-left: -12px" type="text" id="name" name="name" required lay-verify="required" placeholder="请输入名字(必填)" autocomplete="off"
                       class="layui-input" >
            </c:when>
            <c:otherwise>
                <input style="margin-left: -12px" type="text" id="name" name="name" required lay-verify="required" placeholder="请输入名字(必填)" autocomplete="off"
                       class="layui-input" value="${info.name}">
            </c:otherwise>
        </c:choose>
    </div>
</div>
<br>
<div class="layui-form-item">
    <label style="margin-left: -12px" class="layui-form-label">电话</label>
    <div class="layui-input-block">
        <c:choose>
            <c:when test="${info.phone.equals(null)}">
                <input style="margin-left: -12px" type="text" id="phone" name="phone" maxlength="11" required lay-verify="required" placeholder="请输入电话(必填)" autocomplete="off"
                       class="layui-input">
            </c:when>
            <c:otherwise>
                <input style="margin-left: -12px" type="text" id="phone" name="phone" maxlength="11" required lay-verify="required" placeholder="请输入电话(必填)" autocomplete="off"
                       class="layui-input" value="${info.phone}">
            </c:otherwise>
        </c:choose>
    </div>
</div>
<br>
<div class="layui-form-item">
    <label style="margin-left: -12px" class="layui-form-label">邮箱</label>
    <div class="layui-input-block">
        <c:choose>
            <c:when test="${info.mail.equals(null)}">
                <input style="margin-left: -12px" type="text" id="mail" name="mail" required lay-verify="required" placeholder="请输入邮箱(必填)" autocomplete="off"
                       class="layui-input">
            </c:when>
            <c:otherwise>
                <input style="margin-left: -12px" type="text" id="mail" name="mail" required lay-verify="required" placeholder="请输入邮箱(必填)" autocomplete="off"
                       class="layui-input" value="${info.mail}">
            </c:otherwise>
        </c:choose>
    </div>
</div>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button id="updateInfo" class="layui-btn">立即提交</button>
        <button id="reset" class="layui-btn layui-btn-primary">清空</button>
    </div>
</div>
</body>
<script src="<%=basePath%>static/js/updateCompanyContact.js">
</script>
</html>
