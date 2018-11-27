package controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;

import bean.Blog;
import bean.User;
import service.BlogService;
import service.UserService;

/**
 *主页中的请求控制
 */
@Controller
public class MainPage {
	//Blog类型，客户端和服务器端传递数据的中间临时变量,这样并不好，先临时使用，到时回过头来优化
	//使用sessio解决
	//private static Blog middBlogVar=null;
	
	@Autowired
	private BlogService blogservice;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/blogs")
	@ResponseBody
	public List<Blog> showBlogs(){
		//这里是否需要调用json格式处理，待确定；网上显示没用
		List<Blog> blogs = blogservice.findAllBlog();
		System.out.println("MMMMMMMM---------------------->>>>>>>"+blogs);
		return blogs;
	}
	//middBlog请求作为中间请求，获取客户端传递的值，并处理，存放于session中
	@RequestMapping("/middBlog")
	public String findBlog(HttpServletRequest request){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("数据转换编码报错：");
			e.printStackTrace();
		}
		String bId = request.getParameter("bId");
		int blogId = Integer.parseInt(bId);
		HttpSession session = request.getSession();
		Blog currentBlog= blogservice.findBlogById(blogId);
		System.out.println("------------>>currentBlog------->"+currentBlog);
		session.setAttribute("currentBlog", currentBlog);
		return "redirect:blog.html";
	}
	//获取，blog的所有字段信息
	@RequestMapping("/blog")
	@ResponseBody
	public Blog testBlog(HttpSession session){
		//这里是否需要调用json格式处理，待确定；网上显示没用
		Blog currentBlog = (Blog) session.getAttribute("currentBlog");
			//为了解决文章详情页面，标题下方用户昵称的显示，将用户昵称存入blog_summary中，携带过去
			//主要是因为，刚开始建表时，没考虑到；为了方便，使用返回数据中没用到的String类型字段携带过去
			int user_id = currentBlog.getUser_id();
			System.out.println("****************>>currentBlog------->" + currentBlog);
			User blogUser = userService.findUserById(user_id);
			if (blogUser!=null) {
			System.out.println("*********搜索空内容************可能是因为这里报空了" + blogUser);
			String user_nickname = blogUser.getUser_email();
			currentBlog.setBlog_summary(user_nickname);
		}
		return currentBlog;
	}
	
	//主页搜索，关键字模糊查询显示博客列表
	@RequestMapping("/findBlogByTitle")
	@ResponseBody
	public List<Blog> findBlogByTitle(String blog_title) {
		
		return blogservice.findBlogByTitle(blog_title);
	}
	
	//主页分类显示博客文章
	@RequestMapping("/findBlogByClass")
	@ResponseBody
	public List<Blog> findBlogByClass(String blog_class){
		 
		return blogservice.findBlogByClass(blog_class);
	}
	
	
	//主页 园主推荐文章  以点赞榜为基准,获取blog_id,blog_title
	@RequestMapping("/findBlogIdAndTitleByPraise")
	@ResponseBody
	public Map<Integer, String> findBlogIdAndTitleByPraise(){
		
		return blogservice.findBlogIdAndTitle();
	}
	
}

	
	

