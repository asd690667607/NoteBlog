layui.use(['form', 'element'], function () {
    var form = layui.form
        , element = layui.element;

    element.render();


});

var E1 = window.wangEditor;
var editor1 = new E1('#website-editor');
editor1.create();
var editor2 = new E1('#blog-editor');
editor2.create();
var editor3 = new E1('#me-editor');
editor3.create();





