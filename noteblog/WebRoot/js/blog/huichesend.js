 
$(function(){  
      $('#huichesend').bind('keypress',function(event){  
         if(event.keyCode == "13"){
        	 insertNote();
       
         }  
     });  
  });  
function insertNote(){
		var note_content=document.getElementById("huichesend").value;
		if(note_content==""){
				alert("数据不能为空");
				return;
			}
		$.post(
				"http://localhost:8080/noteblog/insertNote.do" ,
				 { "note_content": note_content },
				 function(data){ 
					
						
					  if(data==1){ 
						  window.parent.location.reload();
						
					  }else{ 
						  alert("笔记添加失败");
					  }
				  } );
		}
	




