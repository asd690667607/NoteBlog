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
    	  document.getElementById('user_nickname').value=data.user_nickname;
    	  document.getElementById('user_name').value=data.user_name;
    	  document.getElementById('user_address').value=data.user_address;
    	  document.getElementById('user_company').value=data.user_company;
    	  document.getElementById('user_job').value=data.user_job;
    	  document.getElementById('user_weixin').value=data.user_weixin;
    	  
     }, 
 })
 })