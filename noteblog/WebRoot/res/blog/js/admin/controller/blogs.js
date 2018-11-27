layui.use(['table', 'form', 'element'], function () {
    var table = layui.table
        , form = layui.form
        , element = layui.element;

    element.render();
    table.render({
        elem: '#blogs-table'
        , height: 'full-300'
        , url: 'http://localhost:8080/demo/table'
        , cellMinWidth: 90
        , limit: 30
        , cols: [[
            {type: 'numbers'}
            , {type: 'checkbox'}
            , {field: 'id', title: 'ID', width: 100, sort: true}
            , {field: 'username', title: '用户名', templet: '#usernameTpl'}
            , {field: 'city', title: '城市'}
            , {field: 'wealth', title: '财富', minWidth: 120, sort: true}
            , {field: 'sex', title: '性别', width: 85, templet: '#switchTpl'}
            , {field: 'lock', title: '是否锁定', width: 120, templet: '#checkboxTpl'}
        ]]
        , page: true
    });

    //监听性别操作
    form.on('switch(sexDemo)', function (obj) {
        layer.tips(this.value + ' ' + this.name + '：' + obj.elem.checked, obj.othis);
    });

    //监听锁定操作
    form.on('checkbox(lockDemo)', function (obj) {
        layer.tips(this.value + ' ' + this.name + '：' + obj.elem.checked, obj.othis);
    });

    $(window).resize(function () {
        table.reload('blogs-table', {
            url: 'http://localhost:8080/demo/table'
            , where: {} //设定异步数据接口的额外参数
            , height: 'full-300'
            , cellMinWidth: 90
            , cols: [[
                {type: 'numbers'}
                , {type: 'checkbox'}
                , {field: 'id', title: 'ID', width: 100, unresize: true, sort: true}
                , {field: 'username', title: '用户名', templet: '#usernameTpl'}
                , {field: 'city', title: '城市'}
                , {field: 'wealth', title: '财富', minWidth: 120, sort: true}
                , {field: 'sex', title: '性别', width: 85, templet: '#switchTpl', unresize: true}
                , {field: 'lock', title: '是否锁定', width: 120, templet: '#checkboxTpl', unresize: true}
            ]]
        });
    })

});







