//整个注册页面 js验证  JQuery+AJAX

//定义变量  json字符串
var check={
	"checkEmail":false ,	
	"checkNickName":false ,	
	"checkPassword":false ,	
	"checkRePassword":false ,	
	"checkVerifyCode":false 
};



//JQuery 预编译
$(function(){
	
	//Email 验证
	$("#txtEmail").blur(function(){
		//获取Email
		var user_email=$("#txtEmail").val();
		//判断输入框Email是否为空
		if(user_email==""){
			$("#user_email\\.info").html("Email不能为空");
			return ;
		}else{
			$("#user_email\\.info").html(""); 
		}
		//Email 正则表达式验证
		var reg=new RegExp("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$");
		if(user_email.match(reg)!=null){
			$("#user_email\\.info").html("Email格式正确"); 
			check.checkEmail=true;
		}else{
			$("#user_email\\.info").html("Email格式不正确"); 
			return ;
		}
		//异步发送 AJAX请求,判断Email是否被注册
		$.post(
				"http://localhost:8080/noteblog/email.do" ,
				"user_email="+user_email,
				function(data) {
					
					if(data==1){
						$("#user_email\\.info").html("邮箱可以使用");
						check.checkEmail=true;
					}
					else if(data==0){
							$("#user_email\\.info").html("您是非法用户,无法注册");
							check.checkEmail=false;
						}
					else{
						$("#user_email\\.info").html("邮箱被占用");
						check.checkEmail=false;
					
					}
				}
				);
		
	});
	
	//昵称 验证
	$("#txtNickName").blur(function(){
		//获取NickName
		var user_nickname=$("#txtNickName").val();
		//判断输入框NickName是否为空
		if(user_nickname==""){
			$("#user_nickname\\.info").html("昵称不能为空");
			return ;
		}else{
			$("#user_nickname\\.info").html(""); 
		}
		//NickName 正则表达式验证
		var reg=new RegExp("^[a-z0-9\u4e00-\u9fa5]{4,20}$");
		if(user_nickname.match(reg)!=null){//nickname.info
			$("#user_nickname\\.info").html("昵称格式正确"); 
			check.checkNickName=true;
		}else{
			$("#user_nickname\\.info").html("昵称可以由小写英文字母、中文、数字组成，长度4－20个字符"); 
		}
		
	});
	
	//密码 验证
	$("#txtPassword").blur(function(){
		//获取password
		var user_password=$("#txtPassword").val();
		//判断输入框password是否为空
		if(user_password==""){
			$("#user_password\\.info").html("密码不能为空");
			return ;
		}else{
			$("#user_password\\.info").html(""); 
		}
		//password 正则表达式验证
		var reg=new RegExp("^[a-zA-Z0-9]{6,20}$");
		if(user_password.match(reg)!=null){
			$("#user_password\\.info").html("密码格式正确"); 
			check.checkPassword=true;
		}else{
			$("#user_password\\.info").html("密码可以由大小写英文字母、数字组成，长度6－20位"); 
		}
		
	});
	
	//重复输入密码 验证
	$("#txtRepeatPass").blur(function(){
		//获取password
		var user_password=$("#txtPassword").val();
		var repassword=$("#txtRepeatPass").val();
		//判断输入框repassword是否为空
		if(repassword==""){
			$("#password1\\.info").html("不能为空");
			return ;
		}else{
			$("#password1\\.info").html(""); 
		}
		//判断密码是否一致
		if(user_password==repassword){
			$("#password1\\.info").html("两次密码一致"); 
			check.checkRePassword=true;
		}else{
			$("#password1\\.info").html("密码不一致,重新输入"); 
		}
		
	});
	
	//验证码 验证
	$("#txtVerifyCode").blur(function(){
		//获取输入的验证码
		var verifyCode=$("#txtVerifyCode").val();
		//异步发送AJAX请求
		$.get("/noteblog/verifyCode.do?verifyCode="+verifyCode, function(data){
			if(data ==1){
				$("#number\\.info").html(""); 
				check.checkVerifyCode=true;
			}else{
				$("#number\\.info").html("验证码输入错误"); 
			}
			
	    });
		
	});
	
	
	//注册 按钮处理:只有当所有数据全部通过验证 才允许提交数据
	//true:代表数据提交,false:阻止表单提交
	$("#f").click(function(){
		if(check.checkEmail && check.checkNickName && check.checkPassword
				&& check.checkRePassword && check.checkVerifyCode){
			return true; //数据提交
		}
		  return false;  //数据不去提交
	});
	
	
});
