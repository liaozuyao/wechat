<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Creativs</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>bootstrap/css/reset.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>bootstrap/css/main.css">
</head>
<body>

<!--  start header  -->
<header>
    <div class="wrapper">
        <a href="<%=basePath%>index.html">
            <img src="<%=basePath%>bootstrap/img/logo.png" class="logo"/>
        </a>

        <nav>
            <ul>
                <li><a href="<%=basePath%>addChangeList">新建变更单</a></li>
                <li><a href="<%=basePath%>addQuestion">新建问题提交</a></li>
                <li><a href="<%=basePath%>about.html">关于我们</a></li>
                <li><a href="<%=basePath%>admin.html">管理员登录</a></li>
            </ul>
        </nav>
    </div>
</header>
<!--  start about section  -->
<section class="about clearfix">
    <div class="wrapper">
        <p class="intro">       本公司主要从事销售软件、开发；电子计算机软件、硬件及外部设备的技术开发、技术咨询、技术转让、技术服务、技术培训（不含学历培训和职业培训）；
            信息系统集成服务；信息技术咨询服务；数据处理和存储服务；销售打印纸和计算机耗材。（依法须经批准的项目，经相关部门批准后方可开展经营活动）。</p>

        <div class="columns clearfix">
            <div class="col_1 col_left">
                <h2>相关产品</h2>
                <p>Pellentesque habitant morbi tristique senectus et netus et nibh malesuada fames ac turpis egestas.
                    Nullam uam mi vel ornare tristique, urna mi tempus quam, euismod ligula ipsum vulputate tellus.
                    Quisque dictum tortor at purus faucibus tincidunt.</p>
            </div>
            <div class="col_1 col_right">
                <h2>联系我们</h2>
                <p>Pellentesque habitant morbi tristique senectus et netus et nibh malesuada fames ac turpis egestas.
                    Nullam uam mi vel ornare tristique, urna mi tempus quam, euismod ligula ipsum vulputate tellus.
                    Quisque dictum tortor at purus faucibus tincidunt.</p>
            </div>
        </div>
    </div>
</section>
<!--  end about section  -->

<!--  start call to action section  -->
<section class="cta">
    <h4>Geady to talk business!</h4>
    <a href="#" class="cta_btn">Get In Touch <img src="<%=basePath%>bootstrap/img/cta_arrow.png" alt="" title=""
                                                  class="cta_arrow"/></a>
</section>
<!--  end call to action section  -->
<!--  start footer  -->
<footer>
    <div class="wrapper">
        <p class="copyrights" style="background-color: #dddddd">Copyright © 2017-2018, Pixelhint All Rights</p>
        <ul class="social">
            <li>
                <a href="#/pixelhint" target="_blank"><img src="<%=basePath%>bootstrap/img/fb_icon.png" alt="" title=""></a>
            </li>
            <li>
                <a href="#/pixelhint" target="_blank"><img src="<%=basePath%>bootstrap/img/twitter_icon.png" alt=""
            </li>
            <li>
                <a href="#" target="_blank"><img src="<%=basePath%>bootstrap/img/google_icon.png" alt="" title=""></a>
            </li>
            <li>
                <a href="#" target="_blank"><img src="<%=basePath%>bootstrap/img/rss_icon.png" alt="" title=""></a>
            </li>
        </ul>
    </div>
</footer>
<!--  end footer  -->

</body>
</html>