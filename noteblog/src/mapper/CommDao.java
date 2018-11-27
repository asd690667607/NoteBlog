package mapper;

import java.util.List;

import bean.Comment;

public interface CommDao {
	
	
	//通过blog_id查找当前文章下的所有评论
	List<Comment> findCommByBlogid(int blog_id);
    //通过user_id查找此用户评论的内容
	List<Comment> findCommByUserid(int c_userId);
	
	
	
}
