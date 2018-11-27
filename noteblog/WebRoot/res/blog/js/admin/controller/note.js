layui.use(['element', 'form', 'layer'], function () {
    var form = layui.form;
    var element = layui.element;
    var layer = layui.layer;
    element.render();
    form.render();
    
   

    //监听提交
    form.on('submit(formDemo)', function (data) {
        
    	/*NoteBlog 撰写笔记
    	 * 编辑器内容获取不到内容!!!
    	 */
        
        var title = JSON.stringify(data.field);
        layer.msg(title);
        //alert(editor.txt.html());
        return false;
    });

    form.on('checkbox(tags)', function (data) {
        console.log(data.elem.title); //得到checkbox原始DOM对象
        console.log(data.elem.checked); //是否被选中，true或者false
        console.log(data.value); //复选框value值，也可以通过data.elem.value得到
        var checkedLength = $("div.tags ").find("input[lay-filter=tags]:checked").length;
        if (checkedLength > 4) {
            layer.open({
                title: '提示信息'
                , content: '最多4个，勾选多了也没用哦，请取消多余的！'
            });
        }
    });
});

/*调用wangEditor编辑器*/
var E = window.wangEditor;
var editor = new E('#note-editor');
editor.create();

$(function () {
    $(".form-tags>span.label.label-info").remove()
})



