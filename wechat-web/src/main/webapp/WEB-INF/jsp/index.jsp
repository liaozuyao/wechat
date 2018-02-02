<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML><html>
<head>
    <title>Creativs</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="bootstrap/css/reset.css">
    <link rel="stylesheet" type="text/css" href="bootstrap/css/main.css">

    <script type="text/javascript" src="bootstrap/js/jQuery.js"></script>
    <script type="text/javascript" src="bootstrap/js/main.js"></script>
</head>
<body>

<!--  start header  -->
<header>
    <div class="wrapper">
        <a href="<%=basePath%>index.html">">
            <img src="<%=basePath%>bootstrap/img/logo.png" class="logo"/>
        </a>

        <nav>
            <ul>
                <li><a href="<%=basePath%>addChangeList">新建变更单</a></li>
                <li><a href="<%=basePath%>addQuestion">新建问题提交</a></li>
                <li><a href="<%=basePath%>about.html">关于我们</a></li>
            </ul>
        </nav>
    </div>
</header>
<!--  end header  -->


<!--  start hero section  -->
<section class="hero">

    <h2 class="caption">About creativs.</h2>
    <div class="about_video show_video">
        <a href="" class="close_video">Close</a>
    </div>

</section>
<!--  end hero section  -->


<!--  start services section  -->
<section class="services_home">
    <div class="wrapper">
        <ul>
            <li>
                <h1>Rnim minim veniaisi</h1>
                <p>Aute irure dolor in reprehenderit intor voluptate velit esse cillum dolore euro fugiat nulla pariatur
                    excepteur sintary occaecat cupidatat proident.</p>
            </li>
            <li>
                <h1>Integer rhoncus libero</h1>
                <p>Aute irure dolor in reprehenderit intor voluptate velit esse cillum dolore euro fugiat nulla pariatur
                    excepteur sintary occaecat cupidatat proident.</p>
            </li>
            <li>
                <h1>magna vitae diaculis</h1>
                <p>Aute irure dolor in reprehenderit intor voluptate velit esse cillum dolore euro fugiat nulla pariatur
                    excepteur sintary occaecat cupidatat proident.</p>
            </li>
        </ul>
    </div>
</section>
<!--  end services section  -->

<!--  start clients section  -->
<section class="clients">
    <div class="wrapper">
        <ul>
            <li><img src="<%=basePath%>bootstrap/img/google.png" alt="" title=""></li>
            <li><img src="<%=basePath%>bootstrap/img/facebook.png" alt="" title=""></li>
            <li><img src="<%=basePath%>bootstrap/img/yahoo.png" alt="" title=""></li>
            <li><img src="<%=basePath%>bootstrap/img/paypal.png" alt="" title=""></li>
        </ul>
    </div>
</section>
<!--  end clients section  -->


<!--  start footer  -->
<footer>
    <div class="wrapper">
        <p class="copyrights">Copyright © 2017-2018, Pixelhint All Rights Reserved.More Templates</p>

        <ul class="social">
            <li>
                <a href="#/pixelhint" target="_blank"><img src="<%=basePath%>bootstrap/img/fb_icon.png" alt="" title=""></a>
            </li>
            <li>
                <a href="#/pixelhint" target="_blank"><img src="<%=basePath%>bootstrap/img/twitter_icon.png" alt=""
                                                           title=""></a>
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

