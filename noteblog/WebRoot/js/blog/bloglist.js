
/*
 * 主页面的搜索功能
*/

//键盘回车事件
function getSearch(evt){
	
		//回车事件监听和判断
        evt = (evt) ? evt : ((window.event) ? window.event : "")
        keyCode = evt.keyCode ? evt.keyCode : (evt.which ? evt.which : evt.charCode);
        if (keyCode == 13) {
        	var content=$("#blogSearch").val();
        	 submitSearch(content);
        	 //清空输入框中的内容
        	 $("#blogSearch").val('');
        }
}  
	/*if (window.event){
            keyPressed = window.event.keyCode; // IE
           }
        else{
            keyPressed = e.which; // Firefox
          }
        if (keyPressed == 13) {
        	var content=$("#blogSearch").val();
        	$("#blogSearch").val('');
            submitSearch(content);
        }*/
	
function submitSearch(content){
		$.ajax({
			type : "post",
			url : "http://localhost:8080/noteblog/findBlogByTitle.do",
			data:"blog_title="+content,
			datatype : "json",
			success : function(data) {
				//清空博客列表
				$("#article-list").empty();
				
				var msg = eval(data); //为什么这里需要这样处理才能执行each()方法，而在简单的页面测试时却不需要？
				var str = " ";
					
					var blogtag = '';
					var tagstr='';
					var strArray=[];
					
					$.each(msg, function(i, n) {
						tagstr=n.blog_tag;
						strArray = tagstr.split(',');
						
						blogtag='';
						
						for (var i = 0; i < strArray.length; i++) {
							blogtag +="<span class=\"layui-badge-rim\"><i class=\"fa fa-tag\"></i>"+ strArray[i] +"</span>\n"; 
						}
					
					
					str = "<div class=\"layui-collapse layui-panel layui-article animated flipInX\">\n" +
					"<div class=\"layui-colla-item\">\n" +
					"<div class=\"layui-colla-content layui-show layui-article\">\n" +
					"<fieldset class=\"layui-elem-field layui-field-title\">\n" +
					"<legend class=\"center-to-head \"><a href='blog.html'>" + n.blog_title + "</a></legend>\n" +
					"<div class=\"layui-field-box\">\n" + n.blog_summary +
					"<a class=\"loading\" href=\"middBlog.do?bId="+ n.blog_id +"\"> 阅读全文<i\n" +
					"class=\"fa fa-angle-double-right\"></i> </a>\n" +
					"</div>\n" +
					"<div class=\"operation\">\n" +
					"<div class=\"tags\">\n" +
					blogtag+
					"</div>\n" +
					"<div class=\"info\">\n" +
					"<span class=\"views\"><i class=\"fa fa-eye\"></i>" + n.blog_praise + "</span>\n" +
					"<span class=\"datetime\"><i class=\"fa fa-clock-o\"></i>" + n.blog_time + "</span>\n" +
					"</div>\n" +
					"</div>\n" +
					"</fieldset>\n" +
					"</div>\n" +
					"</div>\n" +
					"</div>";
					
					$("#article-list").append(str);
		
				});
			}
		});
		
	}

/*
 * 主页 文章类型检索，点击事件触发执行
 */

$(".blogClass").click(function(){
	var blog_class=$(this).html();
	$.ajax({
		type : "post",
		url : "http://localhost:8080/noteblog/findBlogByClass.do",
		data:"blog_class="+blog_class,
		datatype : "json",
		success : function(data) {
			//清空博客列表
			$("#article-list").empty();
			var msg = eval(data); //为什么这里需要这样处理才能执行each()方法，而在test.jsp中却不需要？
			var str = " ";
				
				var blogtag = '';
				var tagstr='';
				var strArray=[];
				
				$.each(msg, function(i, n) {
					tagstr=n.blog_tag;
					strArray = tagstr.split(',');
					
					blogtag='';
					
					for (var i = 0; i < strArray.length; i++) {
						blogtag +="<span class=\"layui-badge-rim\"><i class=\"fa fa-tag\"></i>"+ strArray[i] +"</span>\n"; 
					}
				
				str = "<div class=\"layui-collapse layui-panel layui-article animated flipInX\">\n" +
				"<div class=\"layui-colla-item\">\n" +
				"<div class=\"layui-colla-content layui-show layui-article\">\n" +
				"<fieldset class=\"layui-elem-field layui-field-title\">\n" +
				"<legend class=\"center-to-head \"><a href='blog.html'>" + n.blog_title + "</a></legend>\n" +
				"<div class=\"layui-field-box\">\n" + n.blog_summary +
				"<a class=\"loading\" href=\"middBlog.do?bId="+ n.blog_id +"\"> 阅读全文<i\n" +
				"class=\"fa fa-angle-double-right\"></i> </a>\n" +
				"</div>\n" +
				"<div class=\"operation\">\n" +
				"<div class=\"tags\">\n" +
				blogtag+
				"</div>\n" +
				"<div class=\"info\">\n" +
				"<span class=\"views\"><i class=\"fa fa-eye\"></i>" + n.blog_praise + "</span>\n" +
				"<span class=\"datetime\"><i class=\"fa fa-clock-o\"></i>" + n.blog_time + "</span>\n" +
				"</div>\n" +
				"</div>\n" +
				"</fieldset>\n" +
				"</div>\n" +
				"</div>\n" +
				"</div>";
				
				$("#article-list").append(str);
			});
		}
	});
});


//动态生成的html标签，绑定事件,可行方式；改变加载顺序；即页面预加载问题；
//在页面加载完后执行
/*$(document).click(".recommendBlogId",function(){
	alert("点击成功");
	var vl=$(this).html();
	alert(vl);
});*/

//动态生成的html标签，绑定事件,不可行方式
/*$(".recommendBlogId").click(function(){
	alert("点击成功");
	alert($(this).html());
});*/


/*
 * 主页面的博客列表
 */

$(function() {
	
	/*function getBlog(blogId){
		alert("点击事件触发");
		$.ajax({
			type : "get",
			url : "http://localhost:8888/noteblog/blog.do?blog_id="+blogId,
			datatype : "json",
			success : function(data) {
				alert("返回接收成功");
				var msg = eval(data); 
				window.location.href='localhost:8888/noteblog/test.html';
				alert("跳转页面");
//				$("#kkk").html(msg.blog_content);
			}
		});
	}*/
	
	$.ajax({
		type : "post",
		url : "http://localhost:8080/noteblog/blogs.do",
		datatype : "json",
		success : function(data) {
			var msg = eval(data); //为什么这里需要这样处理才能执行each()方法，而在test.jsp中却不需要？
			/*var lis = new Array();*/
			var str = " ";
				
				var blogtag = '';
				var tagstr='';
				var strArray=[];
				
				$.each(msg, function(i, n) {
					tagstr=n.blog_tag;
					strArray = tagstr.split(',');
					
					blogtag='';
					
					for (var i = 0; i < strArray.length; i++) {
						blogtag +="<span class=\"layui-badge-rim\"><i class=\"fa fa-tag\"></i>"+ strArray[i] +"</span>\n"; 
					}
				
				str = "<div class=\"layui-collapse layui-panel layui-article animated flipInX\">\n" +
					"<div class=\"layui-colla-item\">\n" +
					"<div class=\"layui-colla-content layui-show layui-article\">\n" +
					"<fieldset class=\"layui-elem-field layui-field-title\">\n" +
					"<legend class=\"center-to-head \"><a href='blog.html'>" + n.blog_title + "</a></legend>\n" +
					"<div class=\"layui-field-box\">\n" + n.blog_summary +
					"<a class=\"loading\" href=\"middBlog.do?bId="+ n.blog_id +"\"> 阅读全文<i\n" +
					"class=\"fa fa-angle-double-right\"></i> </a>\n" +
					"</div>\n" +
					"<div class=\"operation\">\n" +
					"<div class=\"tags\">\n" +
					blogtag+
					"</div>\n" +
					"<div class=\"info\">\n" +
					"<span class=\"views\"><i class=\"fa fa-eye\"></i>" + n.blog_praise + "</span>\n" +
					"<span class=\"datetime\"><i class=\"fa fa-clock-o\"></i>" + n.blog_time + "</span>\n" +
					"</div>\n" +
					"</div>\n" +
					"</fieldset>\n" +
					"</div>\n" +
					"</div>\n" +
					"</div>";
				
				/*
				 * 这里可以进行优化，做到下拉列表显示到指定记录时，在加载更多
				 * 实质就是实现了分页显示
				 */
				/*lis.push(str);*/
				
				$("#article-list").append(str);
				
				/*if (i==msg.length-1) {

						layui.define(function(exports) {
						exports('article', function(page, next) {
							return nextPage(page, next)
						});
					});

					function nextPage(page, next) { //执行下一页的回调
						setTimeout(function() {
						next(lis.join(''), page < 1);
						}, 500);
					}
					lis.splice(0, lis.length);
				}*/
			
			});
			/*$("#article-list").html(str);*/
		}
	});
	
	
	/*
	 * 主页 右侧栏  园主推荐文章 显示板块  点击跳转方式主页的全文阅读一样
	 */
	$.ajax({
		type : "post",
		url : "http://localhost:8080/noteblog/findBlogIdAndTitleByPraise.do",
		datatype : "json",
		success : function(data) {
			//var msg = eval(data); //为什么这里不需要也可以。。。以前遇到过一个不执行这句解析不了数据；抽时间在查查资料
			var str = " ";
			var num=0;//循环次数判断
			$.each(data, function(i, n) {
				num=num +1;
				if(num<16){
					str='<p><a href="middBlog.do?bId='+ i +'">'+ n +'</a>'+
						'</p>';
					/*str='<p class="findReconmmendBlog">'+n+
						'<span style="float: right;" hidden class="recommendBlogId">'+ 
						 i+
						'</span></p>';*/
					$("#recommendBlog").append(str);
				}
			});
			
		}
	});
	
	

/*$(".findReconmmendBlog").click(function(){
	var recommendBlog=$(this).html();
	
	$.ajax({
		type : "post",
		url : "http://localhost:8888/noteblog/recommendBlog.do",
		data:"recommendBlog="+recommendBlog,
		datatype : "json",
		success : function(data) {
			//清空博客列表
			$("#article-list").empty();
			var msg = eval(data); //为什么这里需要这样处理才能执行each()方法，而在test.jsp中却不需要？
			var str = " ";
			$.each(msg, function(i, n) {
				
			});
		}
	});
	
});*/
	
	
});


