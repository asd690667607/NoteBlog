package mapper;

import java.util.List;

import bean.Blog;

public interface BlogDao {

	//获取数据库所有blog_list表的信息
	
	List<Blog> findAllBlog();
	
	//通过博客id获得Blog
	Blog findBlogById(int blog_id);
	
	int saveBlog(Blog blog);
	
	//通过blog_id删除条目
	int deleteBlogById(int blog_id);

	//通过文章标题搜索文章
	List<Blog> findBlogByTitle(String blog_title);
	
	//通过文章类型查找文章
	List<Blog> findBlogByClass(String blog_class);
	
	//通过点赞获取Blog,并以点赞从大到小排序
	List<Blog> findBlogByPraise();
	
	//用户点赞，更新点赞
	int updatePraiseById(int blog_id);
	List<Blog> findAllblogs(int user_id);
	
}
