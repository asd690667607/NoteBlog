layui.define(function(exports) {
						exports('article', function(page, next) {
							return nextPage(page, next)
						});
					});

var content="";
function nextPage(page, next) { //执行下一页的回调
    //模拟数据插入
    setTimeout(function () {
        var lis = [];
        for (var i = 0; i < 4; i++) {
            lis.push(content)
        }

        //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
        //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
        next(lis.join(''), page < 3); //假设总页数为 10
    }, 500);
}

//先解决其它问题，有空再来，搜layui框架，尝试能否解决分页正常加载


/*function nextShare(cover, page, next) { //执行下一页的回调
    //模拟数据插入
    setTimeout(function () {
        var lis = [];
        
        for (var i = 0; i < 8; i++) {
            lis.push(shares)
        }
        lis.push(shareEnds)
        list.push("");
        //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
        //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
        cover.slideUp();
        next(lis.join(''), page < 10); //假设总页数为 10
    }, 500);
}*/