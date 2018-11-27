<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="bean.*,java.util.*"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>个人中心</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"
			name="viewport">
		<meta name="renderer" content="webkit">
		<meta name="baidu-site-verification" content="R9XA5lWxu2" />
		<meta name="author" content="">
		<meta name="keywords"
			content="科技资讯,商业评论,明星公司,动态,宏观,趋势,创业,精选,有料,干货,有用,细节,内幕">
		<meta name="description"
			content="聚合优质的创新信息与人群，捕获精选|深度|犀利的商业科技资讯。在虎嗅，不错过互联网的每个重要时刻。">
		<meta name="base-static-url" content="https://statics.huxiu.com/www">
		<link rel="stylesheet" type="text/css"
			href="https://static.huxiucdn.com/common/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css"
			href="https://static.huxiucdn.com/www/css/build.css?v=201809281423">
		<link rel="stylesheet" type="text/css"
			href="https://static.huxiucdn.com/www/css/phoneCheck.css?v=201807171852">
		<link rel="stylesheet" type="text/css"
			href="https://static.huxiucdn.com/www/css/interact_msg.css?v=2018011111143">
		<link rel="stylesheet" type="text/css"
			href="https://static.huxiucdn.com/www/css/right.css">
		<link rel="stylesheet" type="text/css"
			href="https://static.huxiucdn.com/www/css/login.css?v=201807021800">
		<link rel="stylesheet" type="text/css"
			href="https://static.huxiucdn.com/www/css/vip-icon.css?v=201704281052">
		<link rel="stylesheet" type="text/css"
			href="https://static.huxiucdn.com/common/nanoscroller.css">
		<link rel="stylesheet" type="text/css"
			href="https://static.huxiucdn.com/www/css/cy.css?v=201805031715">
		<link rel="stylesheet" type="text/css"
			href="https://static.huxiucdn.com/www/css/o.css?v=201809111518">
		<link rel="stylesheet" type="text/css"
			href="https://static.huxiucdn.com/www/css/video.css?v=201807171852">
		<link rel="stylesheet" type="text/css"
			href="https://static.huxiucdn.com/www/css/comment_yh.css?v=201801171652">
		<!--赞赏样式-->
		<link rel="stylesheet" type="text/css"
			href="https://static.huxiucdn.com/www/css/reward.css?v=201802061800">
		<!--个人中心样式-->
		<link rel="stylesheet" type="text/css"
			href="https://static.huxiucdn.com/www/css/per_center.css?v=201807171852">
		<!--文章列表样式-->
		<link rel="stylesheet" type="text/css"
			href="https://static.huxiucdn.com/www/css/article_list_yh.css?v=201802061107">
		<!--文章详情页-->
		<link rel="stylesheet" type="text/css"
			href="https://static.huxiucdn.com/www/css/article_detail_yh.css?v=201808031444">
		<!--弹层-->
		<link rel="stylesheet" type="text/css"
			href="https://static.huxiucdn.com/www/css/modal.css?v=201808071954">
		<!--[if lt IE 9]>
    <script src="https://static.huxiucdn.com/common/html5shiv/html5shiv.min.js"></script>
    <script src="https://static.huxiucdn.com/common/respond/respond.min.js"></script>
    <![endif]-->
		<link rel="apple-touch-icon" sizes="76x76"
			href="https://static.huxiucdn.com/common/image/apple-touch-icon-76x76.png" />
		<link rel="apple-touch-icon" sizes="120x120"
			href="https://static.huxiucdn.com/common/image/apple-touch-icon-120x120.png" />
		<link rel="apple-touch-icon" sizes="152x152"
			href="https://static.huxiucdn.com/common/image/apple-touch-icon-152x152.png" />
		<link rel="apple-touch-icon" sizes="180x180"
			href="https://static.huxiucdn.com/common/image/apple-touch-icon-180x180.png" />
		<script type="text/javascript">
        var uid='2385634';
        var username='沧海辽望C4hLq';
        var is_vip='';
        var huxiu_hash_code='0332eef7faf98e1acb95328d256221d6';
        var aid=0;

        var itemId = '-1';
        var signAna = '310ddb478becba52eba311274a3592492da8bb70';
        var signTime = '1539070886';
        var productId = '15';
        var channel = 'huxiu';
        var refer = 'https://www.huxiu.com/member/2385634/moment.html';

        var order_api_host = 'https://order-api.huxiu.com';

        var relatedArticle = '';
        var url=window.location.href;
        var str1=new RegExp('rec=man');
        var str2=new RegExp('rec=sim');
        if(str1.test(url)){
            relatedArticle = 'manual';
        } else if (str2.test(url)) {
            relatedArticle = 'similar';
        }
        
        var cookiepre='HUXIU_016a_';
        var _hmt = _hmt || [];
        _hmt.push(['_setAccount', '324368ef52596457d064ca5db8c6618e']);
        var isLogin = "isLogin";
        _hmt.push(['_setCustomVar', 1, 'login', isLogin, 2]);

        var comment_api_url = "https://comment-api.huxiu.com";
        var huxiu_url = "https://www.huxiu.com";
    </script>

		<script type='text/javascript'>
        !function(e,t,n,g,i){e[i]=e[i]||function(){(e[i].q=e[i].q||[]).push(arguments)},n=t.createElement("script"),tag=t.getElementsByTagName("script")[0],n.async=1,n.src=('https:'==document.location.protocol?'https://':'http://')+g,tag.parentNode.insertBefore(n,tag)}(window,document,"script","assets.growingio.com/2.1/gio.js","gio");
        gio('init', 'b6a739d69e7ea5b6', {});
        gio('setUserId', '2385634');
        gio('send');
    </script>

	</head>
	<!--PC系统级 提示信息-->
	<div class="message-prompt"></div>
	<body>
		<script type="text/javascript">
    function checkinput(){
        var input = $("#search-input").val();
        if(input ==  null || input == ''){
            return false;
        }
        return true;
    }
</script>
		<div id="login-reg-warp" class="login-reg-warp-modal">

		</div>
		<div class="search-box" id="search-box">
			<i class="icon icon-search-close js-show-search-box"></i>

			<div class="search-content">

				<div class="search-input">
					<form role="search" method="get" action="/search.html"
						onsubmit="return checkinput()">
						<button type="submit"></button>

					</form>
				</div>
				<div class="search-history hide" id="history">

					<ul class="transition" id="history_ul">
					</ul>
					<div class="pull-right empty-history js-empty-history">
						清空历史
					</div>
				</div>
				<div class="search-history search-hot">

					<ul>
						<li class="transition">
							<a href="/search.html?s=饿了么">饿了么</a>
						</li>
						<li class="transition">
							<a href="/search.html?s=餐饮业">餐饮业</a>
						</li>
						<li class="transition">
							<a href="/search.html?s=宏观经济">宏观经济</a>
						</li>
						<li class="transition">
							<a href="/search.html?s=美团">美团</a>
						</li>
						<li class="transition">
							<a href="/search.html?s=公众号">公众号</a>
						</li>
						<li class="transition">
							<a href="/search.html?s=杰夫·贝索斯">杰夫·贝索斯</a>
						</li>
						<li class="transition">
							<a href="/search.html?s=头条">头条</a>
						</li>
						<li class="transition">
							<a href="/search.html?s=人物">人物</a>
						</li>
						<li class="transition">
							<a href="/search.html?s=国庆档">国庆档</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!--[if lt IE 9]>
    <style type="text/css">
        .search-box{
            background-color: #fff !important;
        }
        header .header-column{
            background-color: #fff !important;
        }
        header .navbar-right,header .navbar-left{
            margin-top: -15px;
        }
        .icon-search{
            position: relative;
            top: 18px;
        }
        body{
            border: none;
        }
        .praise-box-add,.icon-like-prompt,.icon-no-like-prompt{
            display: none;
        }
    </style>

<![endif]-->
		<header id="top" role="banner" class="transition">
		<div class="container">
			<div class="navbar-header transition">
				<a href="/" title="首页"> </a>
			</div>
			<ul class="nav navbar-nav navbar-left">
				<li class="nav-news js-show-menu">
					<!--header-column3-->
					<ul class="header-column header-column1 header-column-zx menu-box"
						onmouseover="isOut=false" onmouseout="isOut=true">

					</ul>

				</li>


				<li class="nav-news js-show-menu">
					<ul class="vip-menu menu-box header-column "
						onmouseover="isOut=false" onmouseout="isOut=true">
						<!--                 -->
						<!--                    <li><a href="/vipColumn/contentList/-->
						<?//=$cval['id']?>
						<!--">-->
						<?//=$cval['name']?>
						<!--</a></li>-->
						<!--                 -->
					</ul>


				</li>
				<li class="nav-news">
					<a href="http://localhost:8080/noteblog/index.html" target="_blank">返回首页</a>
				</li>
			</ul>

			<ul class="nav navbar-nav navbar-right transition">
				<li class="app-guide js-app-guide">
					<div class="app-guide-box">
						<img
							src="https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=773579743,2271149885&fm=27&gp=0.jpg">
						<div class="app-guide-title">

						</div>
					</div>

				</li>

				<li class="user-head js-show-menu">
					<div class="header-column header-column-user menu-box"
						onmouseover="isOut=false" onmouseout="isOut=true">
					</div>
					<a class="avatar transition"> <span class="icon-s"></span> <img
							src="https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=773579743,2271149885&fm=27&gp=0.jpg"><span
						class="caret"></span> <em class="message-num nums"></em> </a>
				</li>
				
			</ul>
		</div>
		</header>
		<div class="placeholder-height"></div>
		<script type="text/javascript">
    var page = 'member';
</script>

		<div class="container per_center per_center_body" id="per_center">
			<div class="user-info-warp">
				<div class="user-head-box">
					<div class="user-face">
						<a href="/user/setting/account.html" target="_blank"> <img
								src="https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=773579743,2271149885&fm=27&gp=0.jpg">
						</a>
					</div>
					<%
                       User user=(User)session.getAttribute("user");
				    %>
                    <!-- 用户名 -->
                     <%=user.getUser_nickname()%>
					<div class="user-name">
						<a href="/user/setting/account.html" target="_blank"> </a>
						<a href="/vip" target="_blank"></a>
					</div>
					<div class="user-one">
						<span class="show-span show-yijuhua"> <span
							class="show-span js-edit-one"></span> </span>
						<span class="hide-edit hide"> <input class=""
								maxlength="15" value="" id="yijuhua" placeholder="">
							<br /> </span>
						<span class="hide-edit js-save-one hide"></span>
						<span class="hide-edit hide js-edit-one">&nbsp;&nbsp;</span>
					</div>
				</div>
				
				<div class="user-info-box new-user-info-box">
					<div class="clearfix">
						<div class="col-lg-5">
							<div class="user-info">
								<i class="icon icon-user-point"></i> 公司：
								<span class="c2"><%=user.getUser_company()%></span>
							</div>
							<div class="user-info">
								<i class="icon icon-user-point"></i> 职业：
								<span class="c2"><%=user.getUser_job() %></span>
							</div>
							<div class="user-info">
								<i class="icon icon-user-point"></i> 邮箱：
								<span class="c2"><%=user.getUser_email() %> </span>
							</div>
						</div>
						<div class="col-lg-7">
							<div class="user-info">
								<i class="icon icon-user-point"></i> 姓名：
								<span class="c2"><%=user.getUser_name()%> </span>
							</div>
							<div class="user-info">
								<i class="icon icon-user-point"></i> 微信：
								<span class="c2"><%=user.getUser_weixin() %> </span>
							</div>
							<div class="user-info wallet" id="my-wallet-flag">
								<div class="clearfix">
								</div>
							</div>
						</div>
					</div>
					<div class="btn-box new-edit-btn">
						<a href="information.html" class="btn-user-new-edit pull-right">
							<img
								src="https://static.huxiucdn.com/www/image/reward/user_info_editIcon.png"
								alt="">修改资料 </a>
						<!--                -->
						<!--                    <a href="javascript:" class="btn btn-user-edit pull-right b-f60 js-apply-active pull-right" data-mobile="-->
						<?//= !empty($_H['userinfo']['mobile']) ? $_H['userinfo']['mobile'] : (!empty($_H['userinfo']['phone']) ? $_H['userinfo']['phone'] : '') ?>
						<!--" data-email="-->
						<?//= $_H['userinfo']['email'] ?>
						<!--">申请FM门票</a>-->
						<!--                -->
					</div>
					<div class="more-user-info-box grade-warp more-myself-warp">
					</div>
				</div>
			</div>
			<div id="user_menu" name="user_menu"></div>
			<div class="user-menu-warp">
				<div class="menu-warp">
					<ul>
						<li class="">
							<li class="">
								<a href="http://localhost:8080/noteblog/comment.do?user_email=<%=user.getUser_email() %>">我的评论</a>
							</li>
							<li class="">
								<a href="http://localhost:8080/noteblog/list.do?user_id=<%=user.getUser_id() %>">我的博客</a>
							</li>
							<li class="">
								<a href="http://localhost:8080/noteblog/article_center.do">博客发表</a>
							</li>
					</ul>
				</div>

				<div class="user-content-warp">
					<div class="message-box">
						<%
        List<Comment> comments=(List<Comment>)session.getAttribute("comments");
        for (Comment comment : comments) {
         %>
						<ul>
							<li type="comment" pid="1260180">
								<div class="message-title pl-member-yh-title-div">
									<div><%=comment.getComment_content() %></div>
								</div>
								<div class="message-time pl-member-yh-div">
									<span class="pl-member-yh-origin">评论时间：</span>
									<span class="pl-member-yh-time"><%=comment.getComment_time() %></span>
						
									<a class="pl-member-tit" href="/article/266168.html"
										target="_blank"><%=comment.getBlog_id() %></a>
								</div>
								<div class="pull-right message-delete hide">
									<input type="submit" value="删除"  
										style="width: 50px; height: 30px"
										onclick="javascript:location.href='http://localhost:8080/noteblog/delete.do?comment_id=<%=comment.getComment_id() %>&user_email=<%=user.getUser_email()%>'">
								</div>




								</script>



							</li>
						</ul>
						<%} %>



					</div>
				</div>
				<footer class="footer">
				<div class="modal-backdrop fade in js-modal-backdrop"></div>
				<div class="feedback-box" onmouseover="is_feedback=false"
					onmouseout="is_feedback=true">

					<div class="close-box pull-right js-feedback-close"
						data-show="true">
						<i class="icon icon-close"></i>
					</div>
					<div class="will-choose">
						*
					</div>
					<textarea id="content" class="form-control"
						placeholder="请输入反馈，我们将为您不断改进"></textarea>
					<input class="form-control" id="contact" placeholder="请输入手机/邮箱">
					<a class="btn btn-article pull-left js-feedback-submit transition" onclick="insertusercon();">提交</a><span
						class="will-choose-error">请输入反馈信息</span>
				</div>

				<div class="go-top-box js-go-top-box">

					<div class="go-top transition js-show-feedback-box">
						<div class="go-hover transition">
							用户反馈
						</div>
						<i class="icon-footer-right i-reply"></i>
					</div>

					<div class="go-top app-feedback js-app-feedback transition">
						<div class="app-footer-guide">
							<img
								src="img/qun.png">
							<span style="color: #333; line-height: 2;">微信扫一扫</span>
						</div>
						<i class="icon-footer-right i-qr"></i>
					</div>

					<div class="go-top go-footer js-go-top transition" id="go-top-btn">
						<div class="go-hover transition">
							回到顶部
						</div>
						<i class="icon-footer-right i-top"></i>
					</div>

				</div>

				<div class="container copy-right">
					<div class="footer-tag-list">
						<a href="/about.html" target="_blank" class="transition">关于我们</a>
						<a href="/joinus.html" target="_blank" class="transition">加入我们</a>
						<a href="/links" target="_blank" class="transition">合作伙伴</a>
						<a href="/contact.html" target="_blank" class="transition">广告及服务</a>
						<a href="/help" target="_blank" class="transition">常见问题解答</a>
						<a href="/tags/10340.html" target="_blank" class="transition">防网络诈骗专题</a>
					</div>
					<span>Copyright © <a href="https://www.huxiu.com"></a> <a
						href="http://www.miitbeian.gov.cn/" target="_blank">京ICP备12013432号-1</a>
						&nbsp;<a
						href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11010102001402"
						target="_blank"><i class="i-wj"></i>京公网安备 11010102001402号</a>&nbsp;&nbsp;&nbsp;<em
						class="bull-right">本站由</em><i class="icon-aliyun"
						style="width: 70px; background-size: 100%; left: 7px;"></i><em
						class="bull-em">提供计算与安全服务</em> </span>
					<div class="footer-icon-list pull-right">
						<ul>
							<a><li class="Qr-code-footer">
									<div class="app-qrcode">
										<img
											src="img/tel.png">
									</div>
									<i class="icon icon-footer icon-footer-wx"></i>
								</li> </a>
							<a><li class="Qr-code-footer">
									<div class="app-qrcode">
										<img
											src="img/zhi.png">
									</div>
									<i class="icon icon-footer icon-footer-ios"></i>
								</li> </a>
							<a><li class="Qr-code-footer">
									<div class="app-qrcode">
										<img
											src="img/qq.png">
									</div>
									<i class="icon icon-footer icon-footer-android"></i>
								</li> </a>
						</ul>
					</div>
				</div>
				</footer>
				<!-- 背景动画 -->
				<canvas id="c_n9" width="1920" height="990"
					style="position: fixed; top: 0px; left: 0px; z-index: -1; opacity: 0.5;"></canvas>
				<script src="js/canvas-nest.min.js"></script>

				<script type="text/javascript"
					src="https://static.huxiucdn.com/common/jquery/jquery-1.11.1.min.js"></script>
				<script type="text/javascript"
					src="https://static.huxiucdn.com/www/js/jquery.detection.js"></script>
				<script type="text/javascript"
					src="https://static.huxiucdn.com/common/sea/sea.js?v=201806251433"></script>
				<script type="text/javascript">
    var base_static_url = $('meta[name="base-static-url"]').attr('content');
    seajs.config({
        base: (!!base_static_url) ? base_static_url + '/static_2015/js/' : '/static_2015/js/',
        comboSyntax: ['??', ','],
        alias: {
            'jquery': 'jquery-1.11.1.min',
            'bootstrap': 'bootstrap.min',
            'sea_combo_flush': 'sea_combo_flush.js',
            'cookie': 'jquery.cookie',
            's_css': 'seajs_css'
        },
        'map': [
            [/^(.*\.(?:css|js))(.*)$/i, '$1?v=201809281530']
        ],
        charset: 'utf-8'
    });
    seajs.use(['init']);
</script>
				<script type="text/javascript"
					src="https://static.huxiucdn.com/common/sea/seajs_css.js?v=201803270940"></script>

				<script
					src="https://res.wx.qq.com/connect/zh_CN/htmledition/js/wxLogin.js"></script>

				<!--[if lt IE 10]>
<script type="text/javascript">

    if( !('placeholder' in document.createElement('input')) ){
        $('input[placeholder],textarea[placeholder]').each(function(){
            var that = $(this),
                text= that.attr('placeholder');
            if(that.val()===""){
                that.val(text).addClass('placeholder');
            }
            that.focus(function(){
                if(that.val()===text){
                    that.val("").removeClass('placeholder');
                }
            })
                .blur(function(){
                    if(that.val()===""){
                        that.val(text).addClass('placeholder');
                    }
                })
                .closest('form').submit(function(){
                    if(that.val() === text){
                        that.val('');
                    }
                });
        });
    }

    function hasClass(element, className) {
        var reg = new RegExp('(\\s|^)'+className+'(\\s|$)');
        return element.className.match(reg);
    }
    function addClass(element, className) {
        if (!this.hasClass(element, className))
        {
            element.className += " "+className;
        }
    }
    function removeClass(element, className) {
        if (hasClass(element, className)) {
            var reg = new RegExp('(\\s|^)'+className+'(\\s|$)');
            element.className = element.className.replace(reg,' ');
        }
    }
    var search = document.getElementById('search-box');
    addClass(search, 'search-box-last');
    addClass(search, 'hide');
</script>
<![endif]-->



				<script type="text/javascript">
    (function(){
        var bp = document.createElement('script');
        var curProtocol = window.location.protocol.split(':')[0];
        if (curProtocol === 'https') {
            bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
        }
        else {
            bp.src = 'http://push.zhanzhang.baidu.com/push.js';
        }
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(bp, s);
    })();

</script>

				<script type="text/javascript">
    //文章内容页里有序列表样式
    var ol = $('ol');
    ol.each(function(){
        var t = $(this);
        if(t.find('span.text-remarks').length>0){
            var remarkColor = t.find('span.text-remarks').css("color");
            t.css({
                'color': remarkColor
            })
        }
        if(t.find('span.text-hxzhu').length>0){
            var hxzhuColor = t.find('span.text-hxzhu').css("color");
            t.css({
                'color': hxzhuColor
            });
        }
    });

</script>
<script type="text/javascript" src="js/blog/usercon.js"></script>
	</body>
</html>
