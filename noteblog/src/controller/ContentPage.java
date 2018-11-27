package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;

import bean.Blog;
import bean.Comment;
import bean.Praise;
import bean.User;
import mapper.BlogDao;
import net.sf.json.JSONObject;
import service.BlogService;
import service.CommentService;
import service.PraiseService;

@Controller
public class ContentPage {

	@Autowired
	private CommentService commentservice;
	@Autowired
	private BlogService blogservice;
	@Autowired
	private PraiseService praiseService;
	// 查询博客的所有评论，并返回到客户端
	@RequestMapping("/commentList")
	@ResponseBody
	public List<Comment> listAllComment(HttpSession session) {

		System.out.println("获得了commentList请求");
		Blog currentBlog = (Blog) session.getAttribute("currentBlog");
		List<Comment> commentList = commentservice.findAllCommentByBlogId(currentBlog.getBlog_id());
		return commentList;
	}

	// {"c_time":c_time,"blog_id":blog_id,"c_userId":c_userId,"c_content":c_content}

	// 接受客户端传递过来的评论内容和时间，插入数据库
	@RequestMapping("/commentInsert")
	@ResponseBody
	public String commentInsert(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("数据编码修改异常");
			e.printStackTrace();
		}
		String comment_content = request.getParameter("comment_content");
		String comment_time = request.getParameter("comment_time");
		HttpSession session = request.getSession();

		// 获取，博客详情页面对应的主页博客
		Blog currentBlog = (Blog) session.getAttribute("currentBlog");
		// 获取已登录用户对象
		User userObj = (User) session.getAttribute("userObj");

		System.out.println("");
		/*
		 * 这里需要拦截，判断用户是否已登录；或者在点击博客详情页面 发表按钮时，拦截，提示需要登录
		 * 
		 */
		// 先处理一下，可以用拦截器，取代解决
		if (userObj == null) {
			// 这里可能有问题，可以在ajax中success:中跳转
			// 不可以在这里重定向，return "redirect:login.html";这样的方式会被ajax接收，无法重定向
			return "请登录";

		} else {

			int blog_id = currentBlog.getBlog_id();
			String user_email = userObj.getUser_email();
			// 评论内容插入数据库
			Comment comment = new Comment();
			comment.setBlog_id(blog_id);
			comment.setComment_content(comment_content);
			comment.setComment_time(comment_time);
			comment.setUser_email(user_email);
			int isOk = commentservice.insertComment(comment);
			if (isOk == 1) {
				System.out.println("。。。。。。。。。。。数据插入成功。。。。。。。。。。。。。。。。。。");
			} else {
				// 这里进一步处理，判断是否插入成功，失败则发送信息给管理员
				System.out.println("。。。。。。。。。。。数据插入失败。。。。。。。。。。。。。。。。。。");
			}
			/*
			 * String cd="aaaaa"; String ab="{\"ab\":\"dd\"}"; JSONObject
			 * jsonObj = JSONObject.fromObject(ab);
			 */
			// String jsonab = jsonObj.toString();*/
			return user_email;
		}
	}

	// 文章详情页面，右侧栏推荐文章获取 ，通过blog_title模糊查询，最终获取blog_id,blog_title
	@RequestMapping("/findBlogIdAndTitleByTitle")
	@ResponseBody
	public Map<Integer, String> findBlogIdAndTitleByTitle(HttpSession session) {
		Blog currentBlog = (Blog) session.getAttribute("currentBlog");
		// 对数据库获取的数据进行处理，获取blog_id,blog_title即可
		List<Blog> blogs = blogservice.findBlogByTitle(currentBlog.getBlog_title());
		Map<Integer, String> blogMap = new HashMap<Integer, String>();
		for (Blog blog : blogs) {
			blogMap.put(blog.getBlog_id(), blog.getBlog_title());
		}
		return blogMap;
	}

	// 文章详情页面 ，右侧栏 推荐文章 点击获取详情内容 ，即Blog
	@RequestMapping("/findSimiBlogContentById")
	@ResponseBody
	public Blog findSimiBlogContentById(int blog_id,HttpSession session) {
		Blog simiBlogs = blogservice.findBlogById(blog_id);
		
		Blog currentBlog = blogservice.findBlogById(blog_id);
		session.setAttribute("currentBlog", currentBlog);

		return simiBlogs;
	}
	
	
	// 点赞，记录入数据库；两种状态:"已赞"，"赞"
	@RequestMapping("/getPraise")
	@ResponseBody
	public String updatePraise(HttpSession session) {
		Blog currentBlog = (Blog) session.getAttribute("currentBlog");
		User user = (User) session.getAttribute("userObj");
		
		if (user != null) {
			Praise praise=new Praise();
			praise.setPs_user_email(user.getUser_email());
			praise.setPs_blog_id(currentBlog.getBlog_id());
			praise.setPs_status("已赞");
			praiseService.insertPraise(praise);
			return "已赞";
		}
		return "请登录";
	}
	//判断是否已点赞,写到这里发现可以不用ps_status字段的，即可以优化，只需要记录user_email和blog_id即可
	//时间关系，就不改了
	//如果增加取消点赞功能，或许会用到；不过，取消点赞也可以用删除操作，仍然不需要ps_status字段
	@RequestMapping("/judgePraise")
	@ResponseBody
	public String judgePraise(HttpSession session){
		Blog currentBlog = (Blog) session.getAttribute("currentBlog");
		User user = (User) session.getAttribute("userObj");
		if(user!=null){
			Praise praise = praiseService.findPraiseByEmail(user.getUser_email());
			if(currentBlog.getBlog_id()==praise.getPs_blog_id()){
				return "已赞";
			}
		}
		return "赞";
	}
	
	
	//新增
	@RequestMapping("/tanchuang")
	@ResponseBody
	public void tanchuang(int blog_id,HttpServletResponse response,HttpSession session){
		System.out.println("****************----------"+blog_id);
		Blog currentBlog = blogservice.findBlogById(blog_id);
		session.setAttribute("currentBlog", currentBlog);
		try {
			response.sendRedirect("http://localhost:8080/noteblog/blog.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
