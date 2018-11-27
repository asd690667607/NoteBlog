
//JQuery 预编译
$(function(){
	
	//Email 验证
	$("#txtEmail").blur(function(){
		//获取Email
		var user_email=$("#txtEmail").val();
		//异步发送 AJAX请求,判断Email
		$.post(
				"http://localhost:8080/noteblog/email.do" ,
				"user_email="+user_email,
				function(data) {
					 if(data==0){
						alert("您属于非法用户,无法登录");
						}
					
				}
				);
		
	});
	


	

	
	
});
