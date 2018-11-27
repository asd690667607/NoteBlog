package bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

//主页博文列表显示，实体类，属性与数据库字段对应

public class Blogs {

	Blog blog=new Blog();
	private String user_name;
	
	public Blogs() {
	}

	public Blogs(Blog blog, String userName) {
		super();
		this.blog = blog;
		user_name = userName;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String userName) {
		user_name = userName;
	}

	@Override
	public String toString() {
		return "Blogs [blog=" + blog + ", user_name=" + user_name + "]";
	}
    
}
