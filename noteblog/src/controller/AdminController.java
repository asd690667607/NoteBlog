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

import bean.Admin;
import bean.Note;
import bean.User;


import service.AdminService;
import util.MD5Util;

@Controller
public class AdminController {
	@Autowired
  private AdminService adminService;
	
	@RequestMapping("/adminlogin")
	public String login(Admin admin,HttpSession session) throws Exception{
		Admin ad = adminService.findAdminByName(admin.getAdmin_name());
	System.out.println(ad+"管理员信息111111111111");
		if(ad!=null){
			String pwd=admin.getAdmin_password();
			if(pwd.equals(ad.getAdmin_password())){
				//登录成功
				session.setAttribute("adminId", ad.getAdmin_id());
				session.setAttribute("admin_name", ad.getAdmin_name());
				session.setAttribute("adminLogin", "ttt");
				session.setAttribute("AdminLogin", ad);
				return "redirect:/admin/index.html";
			}
		}
		return "redirect:/admin/login.html";
	}
	
	
	
	
	
	
	
	@RequestMapping("/admin/adminislogin")
	@ResponseBody
	public void adminislogin(HttpSession session,HttpServletResponse response) throws Exception{
		Admin ad = (Admin) session.getAttribute("AdminLogin");
		PrintWriter out = response.getWriter();
	System.out.println(ad+"管理员信息111111111111");
		if(ad!=null){
			out.print(0);
			
		}
		else{
		System.out.println("重定向到登录页面");
		out.print(1);
		}
	}
	
	
	
	
	@RequestMapping("/findAdminByName")
	 @ResponseBody
	    public Admin findAdminByName(HttpSession session,HttpServletRequest request){
		    Admin admin=null;
		    if(session.getAttribute("admin_name")!=null){
		    String admin_name=(String) session.getAttribute("admin_name"); 
		    System.out.println(admin_name+"444444444");
		     admin=adminService.findAdminByName(admin_name);
		    }
		    System.out.println(admin+"contorller++++++++++");
		    return admin;
	    }
	/** 功能实现:更新管理员信息 */
	@RequestMapping("/admin/updateAdmin")
	public void updateAdmin(HttpServletRequest request,HttpSession session,HttpServletResponse response)throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		Admin admin = new Admin();
		String admin_name=request.getParameter("admin_name");
		System.out.println(admin_name+"5555555555555555555");
		String admin_nickname=request.getParameter("admin_nickname");
		String admin_password=request.getParameter("admin_password");
		admin.setAdmin_name(admin_name);
		admin.setAdmin_nickname(admin_nickname);
		admin.setAdmin_password(admin_password);
		int result=adminService.updateAdmin(admin);
		if(result==1){
			System.out.println("3333333333");
			out.print(1);
			response.sendRedirect("http://localhost:8080/noteblog/admin/index.html");
		}
		else
		{
			out.print(0);
		}
	}
	
}
