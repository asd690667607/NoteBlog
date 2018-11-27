package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.Blog;
import mapper.BlogDao;

@Service
public class BlogServiceImpl implements BlogService{

	@Autowired
	private BlogDao blogdao;
	

	public Blog findBlogById(int blog_id) {
        return blogdao.findBlogById(blog_id);
	}

	public int saveBlog(Blog blog) {
		return blogdao.saveBlog(blog);
	}

	public int deleteBlogById(int blogId) {
		 return blogdao.deleteBlogById(blogId);
	}

	public List<Blog> findAllBlog() {
		List<Blog> newAllBlog = new ArrayList<Blog>();
		List<Blog> allBlog = blogdao.findAllBlog();
		for (int i = allBlog.size() - 1; i >= 0; i--) {
			newAllBlog.add(allBlog.get(i));
		}
		return newAllBlog;
	}


	public List<Blog> findBlogByTitle(String blog_title) {

		return blogdao.findBlogByTitle(blog_title);
	}

	public List<Blog> findBlogByClass(String blog_class) {

		return blogdao.findBlogByClass(blog_class);
	}

	public Map<Integer, String> findBlogIdAndTitle() {

		// 对数据库获取的数据进行处理，获取blog_id,blog_title即可
		List<Blog> blogList = blogdao.findBlogByPraise();
		Map<Integer, String> blogMap = new HashMap<Integer, String>();
		for (Blog blog : blogList) {
			blogMap.put(blog.getBlog_id(), blog.getBlog_title());
		}
		return blogMap;
	}

	public int updatePraiseById(int blog_id) {
		
		return blogdao.updatePraiseById(blog_id);
	}
	public List<Blog> findAllblogs(int user_id) {
		return blogdao.findAllblogs(user_id);
	}
}
