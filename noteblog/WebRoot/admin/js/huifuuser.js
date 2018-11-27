
      



          
          
 /*用户-删除*/
 function member_del(obj,id){
	
     layer.confirm('确认要恢复吗？',function(index){
         //发异步删除数据
         $(obj).parents("tr").remove();
 		var  user_id=id;
		console.log(user_id);
		
		
  	console.log(user_id+1111111111111111111);
		$.post(
		"huifuUser.do",
		{"user_id":user_id},
		function(data)
		{
			  window.parent.location.reload();
			
		}
	
	);
          
		
       

         layer.msg('已恢复!',{icon:1,time:1000});
       
     });
 }

    
        

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 