
        	function updateaUser(){
        		
        	 var user_password=document.getElementById("password2").value;
        	 var user_password1=document.getElementById("password1").value;
        
          	console.log(user_password);
        		$.post(
        		"http://localhost:8080/noteblog/updateaUser.do?",
        		{"user_password":user_password},
        		function(data){
        			alert("更新成功");
        			window.location.href ="information.html";
        		}
        	
        	);
        	}