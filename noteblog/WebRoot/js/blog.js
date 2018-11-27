

$(function() {
	$.ajax({
		type : "post",
		
		url : "http://localhost:8080/noteblog/blog.html",
		datatype : "json",
		success : function(data) {
			
			$("#blog_hello").html(data);
			alert("提交成功");
		}
	});
});