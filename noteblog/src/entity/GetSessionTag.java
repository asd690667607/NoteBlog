package entity;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import util.CookieUtils;

/** 自定义标签 */
public class GetSessionTag extends SimpleTagSupport {

	/** 实现具体的 标签功能 */
	@Override
	public void doTag() throws JspException, IOException {
		//pageContext:通过它获取其它内置对象
		PageContext pageContext = (PageContext) this.getJspContext();
		
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		// 先通过Cookie找到sessionId,在到Map里面查找session -->
		Cookie cookie = CookieUtils.findCookie("sessionId", request);
		String sessionId = null;
		if (cookie != null) {
			sessionId = cookie.getValue();
		}
		HttpSession session = SessionContext.get(sessionId);
		ServletContext application = pageContext.getServletContext();
		application.setAttribute("mysession", session);
		System.out.println(sessionId+" --->GetSessionTag doTag():"+session);
	}

}
