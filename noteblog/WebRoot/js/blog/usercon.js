	
        	function insertusercon(){
          	 var content= document.getElementById('content').value;
          	 var contact= document.getElementById('contact').value;
        		$.post(
        		"http://localhost:8080/noteblog/insertBack.do",
        		{"content":content,"contact":contact},
        		function(data){
        			alert("反馈成功");
        		}
        	
        	);
        	}