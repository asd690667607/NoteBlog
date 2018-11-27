 //id绑定点击事件
 $('#awardCode').on('click', function(){
    layer.open({
      title:"",//标题
      type: 1, //基本层类型
      area: ['250px', '250px'],//页面大小
      shadeClose:true, //点击遮罩关闭,x按钮
      content: '\<\div style="padding:40px;" align="center"><\img src="img/alipayimg.jpg">\<br><p style="text-align:center"><span style="color:red;">谢谢支持</span></p><\/div>'
    });
  });