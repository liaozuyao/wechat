<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
    <style type="text/css">
        body {
            background-image: url("<%=basePath %>static/img/u4.png") ;
            background-repeat: repeat;
            background-size:100%;
            height: 100%;
        }
    </style>
</head>
<body>
<div class="col-md-12" style="padding: 0 0;margin: 0 0;height: 100%;position: absolute;">
    <div class="" style="background-color: #ffffff;width: 550px; margin: 0 auto; height: 380px;top: calc((100% - 380px) / 2);position: relative;padding: 50px 60px;">
        <div class="col-md-12" style="padding: 10px 0;border-bottom: 2px #f2f2f2 solid;">
            <img src="<%=basePath %>static/img/u26.png"><img src="<%=basePath %>static/img/0001.png" style="margin-left: 10px;">
            <span style="font-size: 12px; bottom: 15px;position: absolute;right: 0;color: #999999;font-family: '微软雅黑';">管理员登录</span>
        </div>
        <div class="col-md-12 center" style="padding: 10px 0;margin-top: 40px;">
            <div style="margin: 0 auto;width: 80%;">
                <form>
                    <div class="form-group">
                        <input type="text" class="form-control" id="username" placeholder="用户名" style="border-radius: 0;" name="userName">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="password" placeholder="密码" style="border-radius: 0;" name="password">
                    </div>
                    <div class="form-group">
                        <%--<span style="color: #E8202C;font-size: 12px;">账号密码错误请重新输入</span>--%>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-6 pull-right" style="height: 40px;">
                            <input type="button" class="btn" value="登录" style="width: 132px;height: 40px;float: right;background-color: rgba(32, 160, 255, 1);color: #ffffff;">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="" style="width: 550px; margin: 0 auto; height: auto;position: absolute;top:calc((100% - 380px) / 2 + 380px);left: calc((100% - 550px) / 2)">
        <img src="<%=basePath %>static/img/u40.png" style="width: 100%;">
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $(".btn").click(function () {
            var username = $("#username").val();
            var password = $("#password").val();
            if(username == "" || password == ""){
                alert("请正确填写");
            } else {
                $.post("<%=basePath %>loginAdmin",{
                    userName : username,
                    password : password
                }, function (data) {
                    if(data.code == 200){
                        window.location.href ="<%=basePath%>goSuccess";
                    } else {
                        alert(data.msg);
                    }
                })
            }
        })
    })
</script>
</html>
