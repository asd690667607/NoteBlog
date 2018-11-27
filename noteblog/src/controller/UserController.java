package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.User;
import service.UserService;

import util.MD5Util;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	/**注册页面邮箱验证 */
	@RequestMapping("/email")
	@ResponseBody
	public void checkEmail(String user_email,HttpServletResponse response)
	throws Exception{
		response.setCharacterEncoding("utf8");
		PrintWriter out = response.getWriter();
		User user = userService.findUserByEmail(user_email);
		User deleteUser=userService.findDeleteUserByEmail(user_email);
		System.out.println("非法用户"+deleteUser);
		System.out.println(user);
		if(user==null){
			if(deleteUser!=null){
				//此邮箱非法
				System.out.println("邮箱非法");
				out.println(0);
			return;
			}
				//邮箱可以使用
		  System.out.println("邮箱可以使用");
			out.println(1);
			return;
			
		}System.out.println("邮箱被占用");
		out.println(2);
		out.close();
	}
	
	/**注册页面 验证码 验证 */
	@RequestMapping("/verifyCode")
	public void verifyCode(String verifyCode,HttpSession session,HttpServletResponse response)
	throws Exception{
		response.setCharacterEncoding("utf8");
		PrintWriter out = response.getWriter();
		//从服务器session里面获取验证码
		String number = (String) session.getAttribute("number");
		//比较验证码
		if(verifyCode.equals(number)){
			//验证码输入正确
			out.println(1);
		}else{
			out.println(0);
		}
		out.close();
	}
	
	/**注册 功能实现:插入数据到数据库 */
	@RequestMapping("/regist")
	public String regist(User user,HttpServletRequest request,HttpSession session){
		int result=userService.insertUser(user);
		if(result==1){
			session.setAttribute("user", user);
			return "redirect:http://localhost:8080/noteblog/verify.html";
		}
		else
		{
		return "redirect:http://localhost:8080/noteblog/regist.html";
		}
	}
	

	/**邮箱 验证码 验证 */
	@RequestMapping("/emailVerify")
	public String emailVerify(String emailVerifyCode,HttpSession session){
		User user=(User) session.getAttribute("user");
		System.out.println("-----------?>>"+user.getEmailVerifyCode());
		if(user.getEmailVerifyCode().equals(emailVerifyCode)){
			return "redirect:http://localhost:8080/noteblog/login.html";
		}
		else{
		return "redirect:http://localhost:8080/noteblog/verify.html";}
	}
	
	/**用户登录操作 */
	@RequestMapping("/login")
	public String login(User user,HttpSession session) throws Exception{
		User u = userService.findUserByEmail(user.getUser_email());
	System.out.println(u+"2111111111111111111111111111");
		if(u!=null){
			String pwd=user.getUser_password();
			//加密处理
			pwd=MD5Util.encode(pwd);
			if(pwd.equals(u.getUser_password())){
				//登录成功
				session.setAttribute("userObj", u);
				session.setAttribute("uId", u.getUser_id());
				session.setAttribute("Login", "t");
				return "redirect:http://localhost:8080/noteblog/index.html";
			}
		}
		return "redirect:http://localhost:8080/noteblog/login.html";
	}
	@RequestMapping("/checkedLogin")
	public void checkedLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
	PrintWriter out = response.getWriter();
	 String obj = (String) request.getSession().getAttribute("Login");
	 if(obj!=null&&obj.equals("t")){
		 System.out.println("成功");
		 out.print(1);
	 }else{
		 System.out.println("失败");
		 out.print(0);
	 }
	 }
	/** 功能实现:更新用户信息 */
	@RequestMapping("/updateUser")
	@ResponseBody
	public String updateUser(HttpServletRequest request,HttpSession session,HttpServletResponse response)throws ServletException, IOException{
         User user = new User();
        Integer user_id = (Integer) request.getSession().getAttribute("uId");
         user.setUser_id(user_id);
         user.setUser_nickname( request.getParameter("user_nickname")) ;
         user.setUser_name(request.getParameter("user_name"));
         user.setUser_address(request.getParameter("user_address"));
         user.setUser_company(request.getParameter("user_company"));
         user.setUser_job(request.getParameter("user_job"));
         user.setUser_weixin(request.getParameter("user_weixin"));
         System.out.println("48564641657456489");
		int result=userService.updateUser(user);
		
		if(result==1){
			
			System.out.println("3333333333");
			
			return "redirect:http://localhost:8080/noteblog/modified_data.html";
		}
		else
		{
		return "redirect:http://localhost:8080/noteblog/modified_data.html";
		}
	}
	//查找用户
	@RequestMapping("/findUserByEmail")
	 @ResponseBody
	    public User findUserByEmail(HttpSession session,HttpServletRequest request){
		    User u=null;
		    User user=null;
		    if(session.getAttribute("userObj")!=null){
		     u = (User) request.getSession().getAttribute("userObj");
		    System.out.println(u+"444444444");
		    String userEmail = u.getUser_email();
		    user = userService.findUserByEmail(userEmail);
		    }
		    System.out.println(user+"contorller++++++++++");
		    return user;
	    }
	@RequestMapping("admin/findAllUser")
	 @ResponseBody
	    public List<User> findAllUser(){
		System.out.println("1122334455");
		    return userService.findAllUser();
	    }
	
	@RequestMapping("admin/findAllDeleteUser")
	 @ResponseBody
	    public List<User> findAllDeleteUser(){

		    return userService.findAllDeleteUser();
	    }
	@RequestMapping("admin/deleteUser")
	public void deleteUser(int user_id,HttpSession session){
		User deleteuser = userService.findUserById(user_id);
		System.out.println(user_id+"3333333333333333333333");
		session.setAttribute("deleteuser", deleteuser);
		System.out.println("被删除的用户信息"+deleteuser);
		userService.insertDeleteUser(deleteuser);
		userService.deleteUser(user_id);
	}
	
	@RequestMapping("admin/huifuUser")
	public void huifuUser(int user_id,HttpSession session){
		User huifuuser = userService.findDeleteUserById(user_id);
		System.out.println(user_id+"3333333333333333333333");
		session.setAttribute("huifuuser", huifuuser);
		System.out.println("被删除的用户信息"+huifuuser);
		userService.addUser(huifuuser);
		userService.huifuUser(user_id);
	}
	/** 功能实现:更新用户密码 */
	@RequestMapping("/updateaUser")
	@ResponseBody
	public String updateaUser(HttpServletRequest request,HttpSession session,HttpServletResponse response)throws ServletException, IOException{
         User user = new User();
        Integer user_id = (Integer) request.getSession().getAttribute("uId");
         user.setUser_id(user_id);
         user.setUser_password(request.getParameter("user_password")) ;
         System.out.println("48564641657456489");
		int result=userService.updateaUser(user);
		
		if(result==1){
			
			System.out.println("3333333333");
			
			return "redirect:http://localhost:8080/noteblog/information.html";
		}
		else
		{
		return "redirect:http://localhost:8080/noteblog/information.html";
		}
	}
	
}
