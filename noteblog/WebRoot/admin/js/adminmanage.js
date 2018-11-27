   $(document).ready(function() {
	   console.log(222);
      $.ajax({
      url : "http://localhost:8080/noteblog/findAdminByName.do",//请求地址
      dataType : "json",//数据格式 
      type : "post",//请求方式
      async : false,//是否异步请求
      success : function(data) {   //如何发送成功
    	  console.log(data.admin_nickname+111111111);
    	  
    	  document.getElementById('admin_name').innerHTML=data.admin_name;
    	  document.getElementById('admin_nickname').innerHTML=data.admin_nickname;
    	  document.getElementById('admin_password').innerHTML=data.admin_password;
     }, 
 })
 })