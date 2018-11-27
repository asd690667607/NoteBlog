	
        	function updateUser(){
        	
        	 var user_email=	document.getElementById('user_email').innerText;
          	 var user_nickname= document.getElementById('user_nickname').value;
          	 var user_name= document.getElementById('user_name').value;
             var user_address =document.getElementById('user_address').value;
          	var user_company= document.getElementById('user_company').value;
          	var user_job =  document.getElementById('user_job').value;
          	var user_weixin=  document.getElementById('user_weixin').value;
        		
          	console.log(user_weixin);
        		$.post(
        		"http://localhost:8080/noteblog/updateUser.do?",
        		{"user_email":user_email,"user_nickname":user_nickname,"user_name":user_name,"user_address":user_address,"user_company":user_company,"user_job":user_job,"user_weixin":user_weixin},
        		function(data){
        			alert("更新成功");
        			window.location.href ="modified_data.html";
        		}
        	
        	);
        	}