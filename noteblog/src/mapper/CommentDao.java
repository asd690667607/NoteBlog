package mapper;

import java.util.List;

import bean.Comment;

public interface CommentDao {

	//通过blog_id获取数据库blog_comment所有信息
	List<Comment> findAllCommentByBlogId(int blog_id);
	
	//插入comment信息到数据库
	int insertComment(Comment comment);
	List<Comment> findAllComment(String user_email);
	void deleteCommentById(int comment_id);
}
