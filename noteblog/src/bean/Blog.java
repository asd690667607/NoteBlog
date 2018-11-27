package bean;


//主页博文列表显示，实体类，属性与数据库字段对应

public class Blog {
	private int blog_id;
	private String blog_title;
	private String blog_class;
	private String blog_summary;
	private String blog_content;
	private String blog_tag;
	private int blog_praise;
	private String blog_time;
	private int user_id;
	public Blog() {
	}
	public Blog(int blog_id, String blog_title, String blog_class, String blog_summary, String blog_content,
			String blog_tag, int blog_praise, String blog_time, int user_id) {
		super();
		this.blog_id = blog_id;
		this.blog_title = blog_title;
		this.blog_class = blog_class;
		this.blog_summary = blog_summary;
		this.blog_content = blog_content;
		this.blog_tag = blog_tag;
		this.blog_praise = blog_praise;
		this.blog_time = blog_time;
		this.user_id = user_id;
	}
	public int getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}
	public String getBlog_title() {
		return blog_title;
	}
	public void setBlog_title(String blog_title) {
		this.blog_title = blog_title;
	}
	public String getBlog_class() {
		return blog_class;
	}
	public void setBlog_class(String blog_class) {
		this.blog_class = blog_class;
	}
	public String getBlog_summary() {
		return blog_summary;
	}
	public void setBlog_summary(String blog_summary) {
		this.blog_summary = blog_summary;
	}
	public String getBlog_content() {
		return blog_content;
	}
	public void setBlog_content(String blog_content) {
		this.blog_content = blog_content;
	}
	public String getBlog_tag() {
		return blog_tag;
	}
	public void setBlog_tag(String blog_tag) {
		this.blog_tag = blog_tag;
	}
	public int getBlog_praise() {
		return blog_praise;
	}
	public void setBlog_praise(int blog_praise) {
		this.blog_praise = blog_praise;
	}
	public String getBlog_time() {
		return blog_time;
	}
	public void setBlog_time(String blog_time) {
		this.blog_time = blog_time;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Blog [blog_id=" + blog_id + ", blog_title=" + blog_title + ", blog_class=" + blog_class
				+ ", blog_summary=" + blog_summary + ", blog_content=" + blog_content + ", blog_tag=" + blog_tag
				+ ", blog_praise=" + blog_praise + ", blog_time=" + blog_time + ", user_id=" + user_id + "]";
	}
	
}
