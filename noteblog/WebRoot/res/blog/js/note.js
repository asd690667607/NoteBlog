layui.define(function (exports) {
    exports('note', function (cover, page, next) {
        return nextShare(cover, page, next)
    });
});

var shares = "";
var shareEnds = "        <li class=\"layui-timeline-item layui-note-cover\">\n" +
    "            <i class=\"layui-icon layui-timeline-axis\">&#xe63f;</i>\n" +
    "            <div class=\"layui-timeline-content layui-text\">\n" +
    "                <h3 class=\"layui-timeline-title\">到底了</h3>\n" +
    "            </div>\n" +
    "        </li>";

function nextShare(cover, page, next) { //执行下一页的回调
    //模拟数据插入
    setTimeout(function () {
        var lis = [];
        for (var i = 0; i < 8; i++) {
            lis.push(shares)
        }
        lis.push(shareEnds)

        //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
        //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
        cover.slideUp();
        next(lis.join(''), page < 2); //假设总页数为 10
    }, 500);
    
}