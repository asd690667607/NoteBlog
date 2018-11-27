layui.use(['element', 'form', 'layer'], function () {
    var form = layui.form;
    var element = layui.element;
    var layer = layui.layer;
    element.render();
    form.render();

    //监听提交
    form.on('submit(formDemo)', function (data) {
    	 
    	var dd= JSON.stringify(data.field);
    	//alert(JSON.stringify(data.field));
    	var obj2 = JSON.parse(dd);
    	console.log(obj2);
    	var text= he.getHtml();
    	obj2.editor=text;
    	//layer.msg(text);
    	$.ajax( {
			type : 'post',
			url : 'http://localhost:8080/noteblog/addBlog.do',
			data : obj2,
			dataType : "json",
			success : function(data){
				if (data == "1") {
					layer.msg("博文提交成功!!");
					/*页面重新加载!!*/
					location.reload(true);
					//window.location.href='http://localhost:8080/noteblog/article_center.jsp';
				} else {
					layer.msg("博文提交失败!!");
				}
			}
		});
    	
    	
    	
    	//发布文章的按钮
        //layer.msg(JSON.stringify(data.field));
    	//layer.msg("提交成功!!!");
        return false;
    });

    form.on('checkbox(tags)', function (data) {
        console.log(data.elem.title); //得到checkbox原始DOM对象
        console.log(data.elem.checked); //是否被选中，true或者false
        console.log(data.value); //复选框value值，也可以通过data.elem.value得到
        var checkedLength = $("div.tags").find("input[lay-filter=tags]:checked").length;
        if (checkedLength > 4) {
            layer.open({
                title: '提示信息'
                , content: '最多4个，勾选多了也没用哦，请取消多余的！'
            });
        }
    });
});


$(function () {
    $('#tags').tagsInput({
        defaultText: "点我新增标签",
        width: "auto",
        minChars: 1,
        onChange: function (a) {
        }
    });
    
    
    
    
//
//    KindEditor.create('#editor', {
//        width: "auto",
//        minHeight: 300,
//        items: [
//            'source', 'preview', 'undo', 'redo', 'code', 'cut', 'copy', 'paste',
//            'plainpaste', 'wordpaste', 'justifyleft', 'justifycenter', 'justifyright',
//            'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
//            'superscript', 'clearhtml', 'quickformat', 'selectall', 'fullscreen', '/',
//            'formatblock', 'fontname', 'fontsize', 'forecolor', 'hilitecolor', 'bold',
//            'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', 'image', 'graft',
//            'flash', 'insertfile', 'table', 'hr', 'emoticons', 'pagebreak',
//            'link', 'unlink', 'about'
//        ],
//        uploadJson: 'php/qiniu/upload_json.php',
//        dialogOffset: 0, //对话框距离页面顶部的位置，默认为0居中，
//        allowImageUpload: true,
//        allowMediaUpload: true,
//        themeType: 'black',
//        fixToolBar: true,
//        autoHeightMode: true,
//        filePostName: 'uploadFile',//指定上传文件form名称，默认imgFile
//        resizeType: 1,//可以改变高度
//        afterBlur: function () {
//            //失去焦点的时候保存下草稿防止操作失误不小心
//        },
//        //错误处理 handler
//        errorMsgHandler: function (message, type) {
//            try {
//                JDialog.msg({type: type, content: message, timer: 2000});
//            } catch (Error) {
//                alert(message);
//            }
//        }
//    });
    $(".form-tags>span.label.label-info").remove()
});






