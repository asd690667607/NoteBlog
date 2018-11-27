 $(function(){  
      $('#ntext').bind('keypress',function(event){  
         if(event.keyCode == "13"){
        	 
        	 findNoteByntext();
        	
         }  
     });  
  });  


 

	 function findNoteByntext(){
		var ntext=document.getElementById("ntext").value;
		
		if(ntext==""){
				
				window.location.href="http://localhost:8080/noteblog/note.html";
				return;
			}
		$.post(
				"http://localhost:8080/noteblog/findNoteByntext.do" ,
				 { "ntext": ntext },
				 function(data){   //如何发送成功
			    	  console.log(data.length);
			          for(var i=data.length-1;i>=0;i--){    //遍历data数组
			                 var ls = data[i];
			                 console.log("ddddddddd");
			                 if(ls.note_title==null){
			                	 
			                	 ls.note_title="";
			                 }
			                 $("#timeline111").append(`
			                		 <li class="layui-timeline-item" >
			                 <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
			                 
			                 <div class="layui-timeline-content layui-text">
			                     <h3 class="layui-timeline-title" id=noteTime><p>${ls.note_time}</p></h3>
			                     <div class="timeline-body">
			                         <p>${ls.note_title}</p>
			                         <p>${ls.note_content}</p>
			                         <hr>
			                     </div>
			                 </div>
			             </li>`);
			                 
			             }
			         } );
		}
	


