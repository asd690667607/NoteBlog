<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="bean.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>NoteBlog个人博文管理</title>
    <link rel="stylesheet" href="res/layui/css/layui.css">
    <link rel="stylesheet" href="plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/plugins/animate/animate.min.css">
    <link rel="stylesheet" href="res/blog/css/admin.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
	
    <div class="layui-header">
        <div class="layui-logo"><span><i class="layui-icon">&#xe628;</i>NoteBlog</span> 个人博客发表<br></div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left layui-hide layui-show-sm-inline-block">
            <li class="layui-nav-item"><a href="index.html" target="_blank"><i class="fa fa-home"></i> 前台首页</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
        	
            <li class="layui-nav-item layui-hide-xs layui-hide-sm layui-show-md-block">
                <a href="javascript:;" id="auser_name">
                    <img src="res/blog/img/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
                    <%
                      String username=(String)session.getAttribute("user_name");
                      String useremail=(String)session.getAttribute("user_email");
                    %>
                    <%=username%>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="comment.do?user_email=<%=useremail%>"><i class="fa fa-user"></i> 个人中心</a></dd>
                    <hr>
                    <dd><a href="index.html"><i class="fa fa-sign-out"></i> 退了</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item layui-hide-lg layui-hide-md layui-show-sm-block">
                <a href="javascript:leftMenu();" style="font-size: 18px;"><i class="fa fa-navicon"></i> </a>
            </li>
        </ul>
    </div>

    <div id="left-menu" class="layui-side layui-bg-black animated">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="">
                <li class="layui-nav-item layui-show-xs-block layui-hide">
                    <a href="javascript:;">
                        <img src="res/blog/img/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
                        秦始皇
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="#profile"><i class="fa fa-user"></i> 我的资料</a></dd>
                       
                        <dd class="layui-hide-lg layui-hide-md layui-hide-sm layui-show-xs-block"><a href="index.html"
                                                                                                     target="_blank"><i
                                class="fa fa-home"></i> 前台首页</a></dd>
                        <dd><a href=""><i class="fa fa-sign-out"></i> 退了</a></dd>
                    </dl>
                </li>
                
                <li class="layui-nav-item">
                    <a class="" href="article_center.jsp"><i class="fa fa-keyboard-o"></i> 发布内容</a>
                    <dl class="layui-nav-child">
                        <dd><a class="" href="#blog"><i class="fa fa-book"></i> 发布博文</a></dd>
                    </dl>
                </li>
                </ul>
        </div>
    </div>

    <div id="admin-body" class="layui-body">
        <!-- 内容主体区域 -->
    </div>

    <div class="layui-footer" align="center"  style="color: #1E9FFF;">
        <!-- 底部固定区域 -->
        © NoteBlog.com - NoteBlog个人博客发布系统
    </div>
    
</div>
<script src="plugins/jquery/jquery-2.1.4.min.js"></script>
<script src="res/layui/layui.js"></script>
<script src="plugins/spa/vipspa.min.js"></script>
<script src="res/blog/js/admin/spa.config.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });

    function leftMenu() {
        var $leftMenu = $("#left-menu");
        var left = $leftMenu.css("left");
        if (left === "-200px") {
            $leftMenu.animate({
                left: 0
            })
        } else {
            $leftMenu.animate({
                left: "-200px"
            })
        }
    }

    $(function () {
        var hash = location.hash;
        var $layuiThis = $("li.layui-nav-item a[href=" + hash + "]");
        if ($layuiThis !== undefined && $layuiThis.length === 1) {
            $layuiThis.addClass("layui-this").css("color", "#ffffff");
            $layuiThis.parents("li.layui-nav-item").addClass("layui-nav-itemed");
        }
        $("li.layui-nav-item").click(function () {
            $(this).siblings("li").removeClass("layui-nav-itemed");
        })

        $(window).resize(function () {
            if (document.getElementsByTagName("body")[0].offsetWidth > 768) {
                $("#left-menu").addClass("slideOutLeft").css("left", 0)
            }
            else {
                $("#left-menu").css("left", "-200px")
            }
        })
    })
</script>
</body>
</html>