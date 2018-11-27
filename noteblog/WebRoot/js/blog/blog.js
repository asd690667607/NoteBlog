function addComment() {
	//此处不可以删除！解决这个问题，我靠，好难呐！！！
	//获取输入的评论的内容
	var content = window.frames['LAY_layedit_1'].document.getElementsByTagName("body")[0].innerHTML;
	function getTime() {
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		var day = date.getDate();
		var hour = date.getHours();
		var minute = date.getMinutes();
		var second = date.getSeconds();
		var time = year + "-" + month + "-" + day + " " + hour + ((minute < 10) ? ":0" : ":") + minute + ((second < 10) ? ":0" : " ");
		return time;
	}

	function commentInsert() {
		var comment_content = content;
		var comment_time = getTime();
		var commentStr='';
		$.ajax({
			type : "post",
			url : "http://localhost:8080/noteblog/commentInsert.do",
			data : "comment_content=" + comment_content + "&" + "comment_time=" + comment_time,
			datatype : "text",
			success : function(data) {
				//eval函数问题，使用注意，
				/*msg = eval(data);*/
				//var msg = eval("("+data+")")

				if(data=="请登录"){
					alert("请登录");
				}else{
					commentStr = '<div class="layui-row comment-block">' +
					'<div class="layui-row">' +
					'<div class="layui-col-md1 layui-col-xs1 comment-avatar">' +
					'<img class="layui-circle" src="//avatar.ithome.com/avatars/001/24/27/40_60.jpg">' +
					'</div>' +
					'<div class="layui-col-md10 layui-col-xs8">' +
					'<i class="fa fa-user-o"></i> <span class="comment-user">' + data + '</span><br/>' +
					'<i class="fa fa-clock-o"></i> <span class="comment-datetime">' + comment_time + '</span>' +
					'</div>' +
					'</div>' +
					'<div class="layui-row comment-block-content">' +
					comment_content +
					'</div>' +
					/*'<div class="layui-row" style="text-align: right;">' +
					'<a href="javascript:void(0);"> <i class="fa fa-comment"></i> 回复</a>' +
					'</div>' +*/
					'<hr>' +
					'</div>';

				$("#showComment").prepend(commentStr);
				}
			}
		});
	}

	commentInsert();
	window.frames['LAY_layedit_1'].document.getElementsByTagName("body")[0].innerHTML = "";

}

/*
 * 博客详情页面  推荐文章 点击 局部刷新显示 文章详情
 */
function findSimilarBlog(blog_id) {

	/*获取blog所有信息，并输出到页面；即获取博客详情内容 */
	$.ajax({
		type : "post",
		url : "http://localhost:8080/noteblog/findSimiBlogContentById.do",
		data : "blog_id=" + blog_id,
		datatype : "json",
		success : function(data) {

			//清空原本内容
			$("#blog-title-top").empty()
			$("#blog-title").empty()
			$("#blog-time").empty()
			$("#blog-praise").empty()
			$("#blog-content").empty()
			msg = eval(data);
			/*window.location.href='http://localhost:8888/noteblog/test.html?';*/

			/*
			 * 动态输出部分还有很多要改，分开动态输出，数据获取还要以集合形式，获取多个表信息
			 * 如果执行不了，那么在增加一个本页面的新表解决
			 * 比如要加用户名
			 */
			$("#blog-title-top").append(msg.blog_title);
			$("#blog-title").append(msg.blog_title);
			$("#blog-time").append(msg.blog_time);
			$("#blog-praise").append(msg.blog_praise);
			$("#blog-content").append(msg.blog_content);
			
			getNewComment();
		}
	});
	
	function getNewComment(){
		$.ajax({
			type : "post",
			url : "http://localhost:8080/noteblog/commentList.do",
			datatype : "json",
			success : function(data) {
				msg = eval(data);
				var commentList = "";
				
				$("#showComment").empty();

				$.each(msg, function(i, n) {
					//已成功
					commentList = '<div class="layui-row comment-block">' +
						'<div class="layui-row">' +
						'<div class="layui-col-md1 layui-col-xs1 comment-avatar">' +
						'<img class="layui-circle" src="//avatar.ithome.com/avatars/001/24/27/40_60.jpg">' +
						'</div>' +
						'<div class="layui-col-md10 layui-col-xs8">' +
						'<i class="fa fa-user-o"></i> <span class="comment-user">' + n.user_email + '</span><br/>' +
						'<i class="fa fa-clock-o"></i> <span class="comment-datetime">' + n.comment_time + '</span>' +
						'</div>' +
						'</div>' +
						'<div class="layui-row comment-block-content">' +
						n.comment_content +
						'</div>' +
						/*'<div class="layui-row" style="text-align: right;">' +
						'<a href="javascript:void(0);"> <i class="fa fa-comment"></i> 回复</a>' +
						'</div>' +*/
						'<hr>' +
						'</div>';

					$("#showComment").prepend(commentList);

				});
			}
		});
	}
	
}


//获取点赞，
function getPraise() {
	
	var isPraise=$("#changePraise").html();
	if(isPraise=="已赞"){
		alert("已经赞过了");
	}
	
	if (isPraise == "赞") {
		$.ajax({
			type : "post",
			url : "http://localhost:8080/noteblog/getPraise.do",
			datatype : "text",
			success : function(data) {
				if(data=="已赞"){
					$("#changePraise").html("已赞");
				}
				if(data=="请登录"){
					alert("请登录");
				}
			}
		});
	}
}


$(function() {
	
	/*
	 * 判断已登录用户是否已经对该篇文章点赞
	 */
	$.ajax({
		type : "post",
		url : "http://localhost:8080/noteblog/judgePraise.do",
		datatype : "text",
		success : function(data) {
			if(data=="已赞"){
				$("#changePraise").html("已赞");
			}
		}
	});
	
	
	
	

	/*获取blog所有信息，并输出到页面；即获取博客详情内容 */
	$.ajax({
		type : "post",
		url : "http://localhost:8080/noteblog/blog.do",
		datatype : "json",
		success : function(data) {
			msg = eval(data);
			/*window.location.href='http://localhost:8888/noteblog/test.html?';*/

			/*
			 * 动态输出部分还有很多要改，分开动态输出，数据获取还要以集合形式，获取多个表信息
			 * 如果执行不了，那么在增加一个本页面的新表解决
			 * 比如要加用户名
			 */
			$("#blog-title-top").append(msg.blog_title);
			$("#blog-title").append(msg.blog_title);
			$("#blog-time").append(msg.blog_time);
			$("#blog-username").append(msg.blog_summary);
			$("#blog-praise").append(msg.blog_praise);
			$("#blog-content").append(msg.blog_content);
			var strtag = '';
			var str = msg.blog_tag;
			var strArray = str.split(',');
			for (var i = 0; i < strArray.length; i++) {
				strtag = '<span>' + strArray[i] + '</span>';
				$("#blog-tag").append(strtag);
			}
		}
	});


	//获取用户名，单独发一个请求有些不好，最好能和上面的合并；现在加有些麻烦



	/* 获取所有评论信息，用户名（邮箱）*/
	$.ajax({
		type : "post",
		url : "http://localhost:8080/noteblog/commentList.do",
		datatype : "json",
		success : function(data) {
			msg = eval(data);
			var commentList = "";
			$.each(msg, function(i, n) {
				//已成功
				commentList = '<div class="layui-row comment-block">' +
					'<div class="layui-row">' +
					'<div class="layui-col-md1 layui-col-xs1 comment-avatar">' +
					'<img class="layui-circle" src="//avatar.ithome.com/avatars/001/24/27/40_60.jpg">' +
					'</div>' +
					'<div class="layui-col-md10 layui-col-xs8">' +
					'<i class="fa fa-user-o"></i> <span class="comment-user">' + n.user_email + '</span><br/>' +
					'<i class="fa fa-clock-o"></i> <span class="comment-datetime">' + n.comment_time + '</span>' +
					'</div>' +
					'</div>' +
					'<div class="layui-row comment-block-content">' +
					n.comment_content +
					'</div>' +
					/*'<div class="layui-row" style="text-align: right;">' +
					'<a href="javascript:void(0);"> <i class="fa fa-comment"></i> 回复</a>' +
					'</div>' +*/
					'<hr>' +
					'</div>';

				$("#showComment").prepend(commentList);

			});

		}
	});


	/*
	 * 博客详情页 右侧栏  相似文章 显示板块
	 */
	$.ajax({
		type : "post",
		url : "http://localhost:8080/noteblog/findBlogIdAndTitleByTitle.do",
		datatype : "json",
		success : function(data) {
			//var msg = eval(data); //为什么这里不需要也可以。。。以前遇到过一个不执行这句解析不了数据；抽时间在查查资料
			var str = " ";
			var num = 0; //循环次数判断
			$.each(data, function(i, n) {
				num = num + 1;
				if (num < 16) {
					str = '<p onclick="findSimilarBlog(' + i + ')">' + n +
						'</p>';
					/*str='<p class="findReconmmendBlog">'+n+
						'<span style="float: right;" hidden class="recommendBlogId">'+ 
						 i+
						'</span></p>';*/
					$("#similarBlog").append(str);
				}
			});

		}
	});


});