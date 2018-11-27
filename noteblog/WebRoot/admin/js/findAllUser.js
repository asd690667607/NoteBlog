   $(document).ready(function() {
	   console.log(222);
      $.ajax({
      url : "http://localhost:8080/noteblog/admin/findAllUser.do",//请求地址
      dataType : "json",//数据格式 
      type : "post",//请求方式
      async : false,//是否异步请求
      success : function(data) {   //如何发送成功
    	  console.log(data.length);
      for(var i=0;i<data.length;i++){    //遍历data数组
             var ls = data[i];
             console.log("ddddddddd");
           
             $("#usershuju").append(`
           <tr> 
       <input id="user_password" type="hidden" value=${ls.user_password}>${ls.user_password}</input>
         <td>
         <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
       </td>
       <td id="user_id">${ls.user_id}</td>
       
       <td id="user_name">${ls.user_name}</td>
       <td id="user_nickname">${ls.user_nickname}</td>
       <td id="user_weixin">${ls.user_weixin}</td>
       <td id="user_email">${ls.user_email}</td>
       <td id="user_address">${ls.user_address}</td>
       <td id="user_company">${ls.user_company}</td>
       <td class="td-status">
         <span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span></td>
       <td class="td-manage" > 
         <a title="删除" onclick="member_del(this,${ls.user_id}+'')" >
           <i class="layui-icon">&#xe640;</i>
         </a>
       </td>
         
       </tr>
     
         `);
             
             
         }
     }, 
 })
 })