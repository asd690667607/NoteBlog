layui.use(['element', 'form'], function () {
    var form = layui.form;
    var element = layui.element;
    element.render();
    form.render();

    //监听提交
    form.on('submit(formDemo)', function (data) {
        layer.msg(JSON.stringify(data.field));
        return false;
    });
})


