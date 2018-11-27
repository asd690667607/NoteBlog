package interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import bean.Admin;
import bean.User;

/**自定义拦截器 */
public class CheckLoginInterceptor implements HandlerInterceptor{
    //允许通过的请求
	private List<String> passed;
	
	public List<String> getPassed() {
		return passed;
	}

	public void setPassed(List<String> passed) {
		this.passed = passed;
	}

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		Admin admin=(Admin) request.getSession().getAttribute("AdminLogin");
		System.out.println("检查管理员登录"+admin);
		if(admin!=null){//已登录
			return true;
		}
		
//		//检查哪些请求是放行的请求
//		String path=request.getRequestURI();
//		path=path.substring(path.lastIndexOf("/")+1, path.lastIndexOf("."));
//		for(String str:passed){
//			if(path.equals(str)){
//				return true;
//			}
//		}
		
		response.sendRedirect("http://localhost:8080/noteblog/admin/login.html");
		return false;
	}

}
