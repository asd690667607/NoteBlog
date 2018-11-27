   $(document).ready(function() {
	   console.log(222);
      $.ajax({
      url : "http://localhost:8080/noteblog/findUserByEmail.do",//请求地址
      dataType : "json",//数据格式 
      type : "post",//请求方式
      async : false,//是否异步请求
      success : function(data) {   //如何发送成功
    	  console.log(data+111111111);
    	  document.getElementById('user_email').innerText=data.user_email;
    	  document.getElementById('oldpassword').value=data.user_password;
    
     }, 
 })
 })