package service;

import java.util.List;
import java.util.Map;

import bean.Blog;

public interface BlogService {
	
	//获取数据库所有blog信息
	List<Blog> findAllBlog();
	
	//通过博客id获得Blog
	Blog findBlogById(int blog_id);
	//通过blog_id删除条目
	int deleteBlogById(int blog_id);
	//插入博客
	int saveBlog(Blog blog);

	
	//通过文章标题搜索文章,模糊查询
	List<Blog> findBlogByTitle(String blog_title);
	
	//通过文章类型查找文章
	List<Blog> findBlogByClass(String blog_class);
	
	//通过点赞数量查询数据库并排序
	Map<Integer, String> findBlogIdAndTitle();
	
	//用户点赞，更新点赞
	int updatePraiseById(int blog_id);
	List<Blog> findAllblogs(int user_id);
	
}
