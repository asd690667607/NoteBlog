	
        	function updateAdmin(){
        		var  admin_name=document.getElementById('admin_name').value
        		var  admin_nickname=document.getElementById('admin_nickname').value
        		var  admin_password=document.getElementById('admin_password').value
        		$.post(
        		"http://localhost:8080/noteblog/admin/updateAdmin.do?",
        		{"admin_name":admin_name,"admin_nickname":admin_nickname,"admin_password":admin_password},
        		function(data)
        		{
        			alert(data+1111);
        			console.log("返回值"+data);
        			if(data==1)
        			{
        			alert("更新成功");
        			window.parent.location.reload();
        			}
        		}
        	
        	);
        	}