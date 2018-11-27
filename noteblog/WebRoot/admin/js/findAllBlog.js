  $(document).ready(function() {
	   console.log(222);
      $.ajax({
      url : "http://localhost:8080/noteblog/admin/allBlogs.do",//请求地址
      dataType : "json",//数据格式 
      type : "post",//请求方式
      async : false,//是否异步请求
      success : function(data) {   //如何发送成功
    	var count=data.length;
    	console.log(count);
    	var ele=window.document .getElementById ("blog_count");
        ele.innerHTML=count;
      for(var i=data.length-1;i>=0;i--){    //遍历data数组
             var ls = data[i];
             console.log(ls);
        $("#blogshuju").append(`
        <tr>
       <td >${ls.blog.blog_id}</td>
       <td >${ls.blog.blog_title}</td>
       <td >${ls.blog.blog_summary}</td>
       <td >${ls.user_name}</td>
       <td >${ls.blog.blog_praise}</td>
       <td >${ls.blog.blog_tag}</td>
       <td >${ls.blog.blog_time}</td>

       <td class="td-manage">
         <a title="查看"  onclick="x_admin_show('详情页面','http://localhost:8080/noteblog/tanchuang.do?blog_id=${ls.blog.blog_id}')" href="javascript:;">
           <i class="layui-icon">&#xe63c;</i>
         </a>
         <a title="删除" onclick="member_del(this,${ls.blog.blog_id}+'')"  href="javascript:;">
           <i class="layui-icon">&#xe640;</i>
         </a>
       </td>
       </tr>
         `);
         }
     }, 
 })
 })
 
 
 
 /*用户-删除*/
      function member_del(obj,id){
	   $.ajax({
		    type: "POST",
		    url: "http://localhost:8080/noteblog/admin/deleteBlog.do", 
		    data: {"blog_id":id},
		    dataType:"json"
		  });
	   layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              $(obj).parents("tr").remove();
              layer.msg('已删除!',{icon:1,time:1000});
          });
      }
 
 
 
 
 
 
 
 
 
 