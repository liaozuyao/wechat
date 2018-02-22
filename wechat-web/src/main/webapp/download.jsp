<%--
  Created by IntelliJ IDEA.
  User: liaozuyao
  Date: 2018/2/22
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + "/";
%>
<html>
<head>
    <title>Title</title>
    <script src="<%=basePath%>wechat/static/jquery/jQuery.js"></script>
</head>
<body>
<a href="<%=basePath%>czyl/file/文档.docx">文档.docx</a>
<a href="<%=basePath%>czyl/file/imgs.jpg">imgs.jpg</a>
<a href="<%=basePath%>czyl/file/foot.wxml">foot.wxml</a>
<a href="<%=basePath%>czyl/file/pdf.pdf">pdf.pdf</a>
<a href="<%=basePath%>czyl/file/apache-tomcat-9.0.4.zip">apache-tomcat-9.0.4.zip</a>
<button id="download" onclick="downloaded()">下载</button>
</body>
<script>
    function downloaded(){
        var ua = navigator.userAgent.toLowerCase();
        console.log(ua);
        if(ua.match(/MicroMessenger/i)=="micromessenger") {
            alert("是");

        } else {
            //location.href="http://emoji.adline.com.cn/"
            alert("否")
        }
    }
</script>
</html>
