	
        	function loginAdmin(){
        		
        		$.post(
        		"http://localhost:8080/noteblog/admin/adminislogin.do?",
        		
        		function(data)
        		{
        		 
        			if(data==0){
        				window.location.href="http://localhost:8080/noteblog/admin/index.html";
        			}
        			if(data==1){
        				window.location.href="http://localhost:8080/noteblog/admin/login.html";
        				
        			}
        		}
        	
        	);
        	}