             CheckedLogin();
        	function CheckedLogin(){
            	
				$.post("http://localhost:8080/noteblog/checkedLogin.do",
						function (data){
					
								if(data==1){
									document.getElementById("registerid").style.display="none";
									document.getElementById("loginid").style.display="none";
									document.getElementById("loginid2").style.display="none";
									document.getElementById("note001").style.display="block";
							    	document.getElementById("UserSystem").style.display="block";
								    document.getElementById("UserSystem2").style.display="block";
								    document.getElementById("note001").style.display="block";
								    
								}
							    else{
									document.getElementById("UserSystem").style.display="none";	
									document.getElementById("UserSystem2").style.display="none";
									 document.getElementById("note001").style.display="none";
									}

							});

            	}
        